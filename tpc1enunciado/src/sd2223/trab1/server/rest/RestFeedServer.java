package sd2223.trab1.server.rest;

import java.net.InetAddress;
import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.logging.Logger;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import sd2223.trab1.utilities.*;

public class RestUserServer {

	private static Logger Log = Logger.getLogger(RestUserServer.class.getName());

	static {
		System.setProperty("java.net.preferIPv4Stack", "true");
	}

	public static final int PORT = 8080;
	public static final String SERVICE = "UsersService";
	private static final String SERVER_URI_FMT = "http://%s:%s/rest";

	public static void main(String[] args) {
		try {

			String serviceDomain = args[0]

			ResourceConfig config = new ResourceConfig();
			config.register(new RestFeedResources());
			// config.register(CustomLoggingFilter.class);

			String ip = InetAddress.getLocalHost().getHostAddress();
			String serverURI = String.format(SERVER_URI_FMT, ip, PORT);

			Discovery discovery = Discovery.getInstance();
			discovery.announce(serviceDomain, SERVICE, serverURI);

			JdkHttpServerFactory.createHttpServer(URI.create(serverURI.replace(ip, "0.0.0.0")), config);

			Log.info(String.format("%s Server ready @ %s\n", SERVICE, serverURI));

			// More code can be executed here...
		} catch (Exception e) {
			Log.severe(e.getMessage());
		}
	}
}
