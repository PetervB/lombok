/*
 * Copyright © 2010-2011 Reinier Zwitserloot, Roel Spilker and Robbert Jan Grootjans.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package lombok.javac.apt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.charset.CharsetDecoder;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;

// Weird SuppressWarnings, but javac doesn't understand 'all' and eclipse doesn't understand that this file contains deprecation references.
@SuppressWarnings({"all", "deprecation"})
class Javac6BaseFileObjectWrapper extends com.sun.tools.javac.util.BaseFileObject {
	private final LombokFileObject delegate;
	
	public Javac6BaseFileObjectWrapper(LombokFileObject delegate) {
		this.delegate = delegate;
	}
	
	@Override public boolean isNameCompatible(String simpleName, Kind kind) {
		return delegate.isNameCompatible(simpleName, kind);
	}
	
	@Override public URI toUri() {
		return delegate.toUri();
	}
	
	@Override public String getName() {
		return delegate.getName();
	}
	
	@Override public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return delegate.getCharContent(ignoreEncodingErrors);
	}
	
	@Override public InputStream openInputStream() throws IOException {
		return delegate.openInputStream();
	}
	
	@Override public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
		return delegate.openReader(ignoreEncodingErrors);
	}
	
	@Override public Writer openWriter() throws IOException {
		return delegate.openWriter();
	}
	
	@Override public OutputStream openOutputStream() throws IOException {
		return delegate.openOutputStream();
	}
	
	@Override public long getLastModified() {
		return delegate.getLastModified();
	}
	
	@Override public boolean delete() {
		return delegate.delete();
	}
	
	@Override public Kind getKind() {
		return delegate.getKind();
	}
	
	@Override public NestingKind getNestingKind() {
		return delegate.getNestingKind();
	}
	
	@Override public Modifier getAccessLevel() {
		return delegate.getAccessLevel();
	}
	
	protected CharsetDecoder getDecoder(boolean ignoreEncodingErrors) {
		return delegate.getDecoder(ignoreEncodingErrors);
	}
	
	@Override public boolean equals(Object obj) {
		if (!(obj instanceof Javac6BaseFileObjectWrapper)) {
			return false;
		}
		return delegate.equals(((Javac6BaseFileObjectWrapper)obj).delegate);
	}
	
	@Override public int hashCode() {
		return delegate.hashCode();
	}
}