package org.joolzminer.examples.patterns.files;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = super.read();
		if (c == -1) {
			return c;
		} else {
			return Character.toLowerCase(c);
		}
	}

	@Override
	public int read(byte[] b) throws IOException {
		int numBytesRead = super.read(b);
		if (numBytesRead > 1) {
			for (int i = 0; i < b.length; i++) {
				b[i] = (byte) Character.toLowerCase((char)b[i]);
			}
		}
		return numBytesRead;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int numBytesRead = super.read(b, off, len);
		if (numBytesRead > 1) {
			for (int i = 0; i < b.length; i++) {
				b[i] = (byte) Character.toLowerCase((char)b[i]);
			}
		}
		return numBytesRead;
	}
}
