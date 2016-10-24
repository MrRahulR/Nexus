package org.eclipse.jdt.internal.jarinjarloader;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;

public final class b
  extends URLConnection
{
  private ClassLoader a;
  
  public b(URL paramURL, ClassLoader paramClassLoader)
  {
    super(paramURL);
    this.a = paramClassLoader;
  }
  
  public final void connect() {}
  
	public final InputStream getInputStream() throws MalformedURLException,
			UnsupportedEncodingException
  {
    Object localObject = URLDecoder.decode(this.url.getFile(), "UTF-8");
    if ((localObject = this.a.getResourceAsStream((String)localObject)) == null) {
      throw new MalformedURLException("Could not open InputStream for URL '" + this.url + "'");
    }
    return (InputStream)localObject;
  }
}
