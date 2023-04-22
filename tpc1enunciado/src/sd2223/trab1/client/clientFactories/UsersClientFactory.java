package sd2223.trab1.client;

import java.net.URI;

import sd2223.trab1.api.abstractServiceAPI.java.Users;
import sd2223.trab1.clients.rest.RestUsersClient;
import sd2223.trab1.clients.soap.SoapUsersClient;


public class UsersClientFactory {

	private static final String REST = "/rest";
	private static final String SOAP = "/soap";
    private static final String USERS = "users.";


	public static Users get(URI serverURI) {
		var uriString = serverURI.toString();

		if (uriString.endsWith(REST))
			return new RestUsersClient(serverURI);
		else if (uriString.endsWith(SOAP))
			return new SoapUsersClient(serverURI);
		else
			throw new RuntimeException("Unknown service type..." + uriString);
	}
}
