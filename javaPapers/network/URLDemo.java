/*URL is a class in java that provides the mechanism
 to deal with Internet URLs. 
 The constructor of URL can throw a MalformedURLException.*/
//URL and its methods
import java.net.*;
class URLDemo
{
  public static void main(String args[])throws MalformedURLException
  {
    URL hp=new URL("http://www.hotmail.com:80/downloads");
    System.out.println("Protocol: "+hp.getProtocol());
    System.out.println("Host: "+hp.getHost());
    System.out.println("Port: "+hp.getPort());
    System.out.println("File: "+hp.getFile());
    
  }
}
