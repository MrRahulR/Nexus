package org.eclipse.jdt.internal.jarinjarloader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class JarRsrcLoader {

	public static void main(String[] paramArrayOfString) throws
			Exception {

		Object localObject1 = a();
		//System.err.println("Here");

		Object localObject2 = Thread.currentThread().getContextClassLoader();

		URL.setURLStreamHandlerFactory(new d((ClassLoader) localObject2));

		//System.err.println(((a) localObject1).b.length);

		URL[] localObject3 = new URL[((a) localObject1).b.length];

		for (int i = 0; i < ((a) localObject1).b.length; i++) {

			//System.err.println(i);

			String rsrcPath = ((a) localObject1).b[i];

			if (rsrcPath.endsWith("/")) {
				localObject3[i] = new URL("rsrc:" + rsrcPath);
				//System.err.println(rsrcPath);
			}

			else {
				localObject3[i] = new URL("jar:rsrc:" + rsrcPath + "!/");
				//System.err.println(rsrcPath);
			}
		}
		//System.err.println(Arrays.toString(localObject3));

		ClassLoader jceClassLoader = new URLClassLoader(localObject3, null);
		Thread.currentThread().setContextClassLoader(jceClassLoader);

		Object locaObject4 = Class.forName(((a) localObject1).a, true,
				jceClassLoader);

		Method main = ((Class) locaObject4).getMethod("main", new Class[]{paramArrayOfString.getClass()});
		main.invoke((Object)null, new Object[]{paramArrayOfString});

		
	}

	private static a a() throws IOException {

		Enumeration localEnumeration = Thread.currentThread()
				.getContextClassLoader().getResources("META-INF/MANIFEST.MF");

		while (localEnumeration.hasMoreElements())
			try {

				URL url = (URL) localEnumeration.nextElement();
				InputStream is = url.openStream();

				/*
				 * BufferedReader bf = new BufferedReader( new
				 * InputStreamReader(is)); StringBuilder out = new
				 * StringBuilder();
				 * 
				 * String line;
				 * 
				 * while ((line = bf.readLine()) != null) { out.append(line); }
				 * 
				 * System.out.println(out.toString());
				 * 
				 * bf.close();
				 */

				if (is == null) {
					//System.out.println("IS IS NULL");
				}
				if (is != null) {

					a result = new a();
					Manifest manifest = new Manifest(is);

					Attributes attr = manifest.getMainAttributes();

					//System.err.println("attr.size()" + attr.size());

					result.a = attr.getValue("Rsrc-Main-Class");
					String rsrcCP = attr.getValue("Rsrc-Class-Path");

					//System.out.println(result.a + "====" + rsrcCP);

					if (rsrcCP == null)
						rsrcCP = "";
					result.b = a(rsrcCP);

					if ((result.a != null) && !result.a.trim().equals(""))
						return result;

				}

			} catch (Exception localException) {
			}
		System.err
				.println("Missing attributes for JarRsrcLoader in Manifest (Rsrc-Main-Class, Rsrc-Class-Path)");
		return ((a) null);
	}

	private static String[] a(String paramString) {
		if (paramString == null)
			return null;
		ArrayList localArrayList = new ArrayList();
		int j;
		for (int i = 0; i < paramString.length(); i = j + 1) {
			if ((j = paramString.indexOf(32, i)) == -1)
				j = paramString.length();
			if (j <= i)
				continue;
			localArrayList.add(paramString.substring(i, j));
		}
		return ((String[]) localArrayList.toArray(new String[localArrayList
				.size()]));
	}
}