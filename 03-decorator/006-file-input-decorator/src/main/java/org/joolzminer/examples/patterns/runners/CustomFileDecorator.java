package org.joolzminer.examples.patterns.runners;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.joolzminer.examples.patterns.files.LowerCaseInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFileDecorator {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFileDecorator.class);
	
	public static void main(String[] args) {
		
		/* Reading byte by byte */
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("./README.md")))) {
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char) c);
			}
			
		} catch (IOException e) {
			LOGGER.error("An exception was caught while processing the file: ", e);
		}
		printSeparator();
		
		/* Reading into a byte[] */
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("./README.md")))) {
			byte[] buffer = new byte[512];
			int numBytesRead;
			while ((numBytesRead = in.read(buffer)) != -1) {
				for (int i = 0; i < numBytesRead; i++) {
					System.out.print((char)buffer[i]);					
				}
			}			
		} catch (IOException e) {
			LOGGER.error("An exception was caught while processing the file: ", e);
		}
		printSeparator();
		
		/* Reading into a byte[] with offset and length */
		byte[] buffer = new byte[8192];
		int totalLen = 0;
		try (InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("./README.md")))) {
			int numBytesRead;
			int offset = 0;
			while ((numBytesRead = in.read(buffer, offset, 128)) != -1) {
				offset += numBytesRead;
				totalLen += numBytesRead;
			}						
		} catch (IOException e) {
			LOGGER.error("An exception was caught while processing the file: ", e);
		}
		for (int i = 0; i <= totalLen; i++) {
			System.out.print((char) buffer[i]);
		}
	}
	
	private static void printSeparator() {
		System.out.println("\n===========================================================================\n");
	}
}
