package org.eclipse.jdt.internal.jarinjarloader;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public final class c
  extends URLStreamHandler
{
  private ClassLoader a;
  
  public c(ClassLoader paramClassLoader)
  {
    this.a = paramClassLoader;
  }
  
  protected final URLConnection openConnection(URL paramURL)
  {
    return new b(paramURL, this.a);
  }
  
  protected final void parseURL(URL paramURL, String paramString, int paramInt1, int paramInt2)
  {
    if (paramString.startsWith("rsrc:")) {
      paramString = paramString.substring(5);
    } else if ((!paramURL.getFile().equals("./")) && (paramURL.getFile().endsWith("/"))) {
      paramString = paramURL.getFile() + paramString;
    } else {
      paramString = paramString;
    }
    setURL(paramURL, "rsrc", "", -1, null, null, paramString, null, null);
  }
}
