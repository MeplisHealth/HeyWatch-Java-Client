package com.heywatch.client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	HeyWatchJAXRSClient client = new HeyWatchJAXRSClient("username", "password");
    	client.getDownloads();
    }
    
}
