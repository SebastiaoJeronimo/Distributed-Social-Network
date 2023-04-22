package sd2223.trab1.client;

import java.net.URI;
import sd2223.trab1.api.abstractServiceAPI.java.Feeds;
import sd2223.trab1.clients.rest.RestFeedClient;
import sd2223.trab1.clients.soap.SoapFeedsClient;

public class FeedsClientFactory {

    private static final String REST = "/rest";
	private static final String SOAP = "/soap";
    private static final String FEEDS = "feeds.";


	public static Feeds get(URI serverURI) {
		var uriString = serverURI.toString();

		if (uriString.endsWith(REST))
			return new RestFeedClient(serverURI);
		else if (uriString.endsWith(SOAP))
			return new SoapFeedsClient(serverURI);
		else
			throw new RuntimeException("Unknown service type..." + uriString);
	}


    
}
