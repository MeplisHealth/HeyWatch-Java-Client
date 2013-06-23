package com.heywatch.client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	HeyWatchJAXRSClient client = new HeyWatchJAXRSClient("meplis", "meplisheywatch");
    	client.getDownloads();
    }
    
}
