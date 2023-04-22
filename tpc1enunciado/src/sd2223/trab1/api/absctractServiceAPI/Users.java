package sd2223.trab1.api.absctractServiceAPI;

import java.util.List;

import sd2223.trab1.api.User;

//import aula5.api.User;

public interface Users {

	Result<String> createUser(User user);
	
	Result<User> getUser(String name, String pwd);
	
	Result<User> updateUser(String name, String pwd, User user);
	
	Result<User> deleteUser(String name, String pwd);
	
	Result<List<User>> searchUsers(String pattern);	
	
	//Result<Void> verifyPassword( String name, String pwd);
    //this method is not in the soap/rest interface this code is from the lab 5 but updated
}
