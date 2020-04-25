package com.johndoe.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.util.ResourceUtils;

/**
 * This is a singleton class to load the properties file from resources
 * directory
 * 
 * @author John Doe
 *
 */
public class ResourceLoader {
	private final static String MOCK_FILE = "classpath:mocks.properties";

	private static ResourceLoader SINGLE_INSTANCE = null;
	private Properties properties = new Properties();

	private ResourceLoader() {
	}

	public static ResourceLoader getInstance() throws IOException {
		if (SINGLE_INSTANCE == null) {
			synchronized (ResourceLoader.class) {
				if (SINGLE_INSTANCE == null) {
					File file = ResourceUtils.getFile(MOCK_FILE);
		            InputStream inputStream = new FileInputStream(file);
					SINGLE_INSTANCE = new ResourceLoader();
					SINGLE_INSTANCE.properties.load(inputStream);
				}
			}
		}
		return SINGLE_INSTANCE;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return SINGLE_INSTANCE;
	}

	protected Object readResolve() {
		return SINGLE_INSTANCE;
	}

	public String getPropertyValue(String propertyKey) {
		if (propertyKey != null && !propertyKey.isEmpty()) {
			return properties.getProperty(propertyKey);
		}
		return null;
	}

	public Map<String, String> getProperties() {
		Map<String, String> propertyMap = new HashMap<String, String>();
		for (String propertyKey : properties.stringPropertyNames()) {
			propertyMap.put(propertyKey, properties.getProperty(propertyKey));
		}
		return propertyMap;
	}
}// end of the class
