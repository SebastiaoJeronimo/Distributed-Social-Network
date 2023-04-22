package sd2223.trab1.api.absctractServiceAPI;

import java.util.List;

import sd2223.trab1.api.Message;
//TO MAKE THIS CLASS FOLLOW THE SOAP OR REST API INTERFACE PUT THE RETURN IN THE RESULT BRACKETS
//import aula5.api.User;

public interface Feeds {

	Result<Long> postMessage(String user, String pwd, Message msg);
	
	Result<Void> removeFromPersonalFeed(String user, long mid, String pwd);
	
	Result<Message>  getMessage(String user, long mid);
	
	Result<List<Message>> getMessages(String user, long time);
	
	Result<Void> subUser(String user, String userSub, String pwd);	

    Result<Void> unsubscribeUser(String user, String userSub, String pwd);

    Result<List<String>> listSubs(String user);
	
	//Result<Void> verifyPassword( String name, String pwd);
    //this method is not in the soap/rest interface this code is from the lab 5 but updated
}