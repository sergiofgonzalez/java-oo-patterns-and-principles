package org.joolzminer.examples.patterns.files.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.joolzminer.examples.patterns.files.LowerCaseInputStream;
import org.junit.Test;

public class LowerCaseInputStreamTest {

	@Test
	public void testNoLowerCase() throws FileNotFoundException, IOException {
		/* Arrange */
		int c;
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("./README.md")))) {
			while ((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
		} 		
	}
	
}
