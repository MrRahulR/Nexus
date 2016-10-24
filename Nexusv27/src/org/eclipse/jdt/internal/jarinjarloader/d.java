package org.eclipse.jdt.internal.jarinjarloader;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public final class d implements URLStreamHandlerFactory {
	private ClassLoader a;

	public d(ClassLoader paramClassLoader) {
		this.a = paramClassLoader;
	}

	public final URLStreamHandler createURLStreamHandler(String paramString) {
		if ("rsrc".equals(paramString)) {
			return new c(this.a);
		}
		return null;
	}
}
