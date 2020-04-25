package com.johndoe.utils.test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.johndoe.utils.ResourceLoader;


/**
 * 
 * @author John Doe
 *
 */

public class ResourceLoaderTest {
	public static final String SUCCESS = "success";
	
	@Before
    public void init() throws IOException {
       ResourceLoader.getInstance();
    }
	
	@Test
	public void getPropertyValueTest() throws IOException {
		assertTrue(ResourceLoader.getInstance().getPropertyValue(SUCCESS) != null);
	}
	
	
}
