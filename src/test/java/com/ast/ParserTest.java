package com.ast;

import com.MParser;

import java.io.File;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

public class ParserTest {

	@Test
	public void testOne() throws Exception {
		URL dirURL = ParserTest.class.getClassLoader().getResource("sources");
//		System.err.println("url = " + dirURL);
		
		String[] testFiles = getTestSourceFiles(dirURL);
		for (String s : testFiles) {
			String filePath = "file:" + dirURL.getPath() + "/" + s;
			
			System.err.println("test file = " + filePath);
			InputStream is = new URL(filePath).openStream();
			
//			System.err.println("is = " + is);

			MParser fp = new MParser(is);
			fp.routine();
		}
	}
	
	private String[] getTestSourceFiles(URL dirURL) throws URISyntaxException {

		
		if (dirURL != null && dirURL.getProtocol().equals("file")) {
			
	        return new File(dirURL.toURI()).list();
		} 
		
		return new String[0];
	}
}
