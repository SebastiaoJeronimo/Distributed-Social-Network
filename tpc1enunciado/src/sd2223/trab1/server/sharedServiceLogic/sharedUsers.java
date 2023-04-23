package sd2223.trab1.server.sharedServiceLogic;

import java.util.ArrayList;	
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import sd2223.trab1.api.User;
import sd2223.trab1.api.absctractServiceAPI.Result;
import sd2223.trab1.api.absctractServiceAPI.Result.ErrorCode;
import sd2223.trab1.api.absctractServiceAPI.Users;
import java.util.concurrent.ConcurrentHashMap;

public class sharedUsers implements Users {
	private final Map<String,User> users = new ConcurrentHashMap<>();

	private static Logger Log = Logger.getLogger(sharedUsers.class.getName());

	public sharedUsers(){
	}

	@Override
	public Result<String> createUser(User user) {
		Log.info("createUser : " + user);
		
		// Check if user data is valid
		if(user.getName() == null || user.getPwd() == null || user.getDisplayName() == null || user.getDomain() == null) {
			Log.info("User object invalid.");
			return Result.error( ErrorCode.BAD_REQUEST);
		}
		
		// Insert user, checking if name already exists
		if( users.putIfAbsent(user.getName(), user) != null ) {
			Log.info("User already exists.");
			return Result.error( ErrorCode.CONFLICT);
		}

		users.put(user.getName(), user);
		return Result.ok(user.getName() + "@" + user.getDomain());
	}

	@Override
	public Result<User> getUser(String name, String pwd) {
		Log.info("getUser : user = " + name + "; pwd = " + pwd);
		
		// Check if user is valid
		if(name == null || pwd == null) {
			Log.info("Name or Password null.");
			return Result.error( ErrorCode.BAD_REQUEST);
		}
		
		User user = users.get(name);			
		// Check if user exists 
		if( user == null ) {
			Log.info("User does not exist.");
			return Result.error( ErrorCode.NOT_FOUND);
		}
		
		//Check if the password is correct
		if( !user.getPwd().equals( pwd)) {
			Log.info("Password is incorrect.");
			return Result.error( ErrorCode.FORBIDDEN);
		}
		
		return Result.ok(user);
	}

	@Override
	public Result<User> updateUser(String name, String pwd, User user) {

		Log.info("updateUser : user = " + name + "; pwd = " + pwd + " ; user = " + user);

		Result<User> result = getUser(name, pwd);

		if(!result.isOK())
			return Result.error(result.error());

		if(!user.getName().equals(name))
			return Result.error( ErrorCode.BAD_REQUEST);

		User useraux = (User) result.value();
		
		
		String newPwd = user.getPwd();

		if (newPwd != null) {
            useraux.setPwd(newPwd);
        }

        String newDisplayName = user.getDisplayName();

        if (newDisplayName != null) {
            useraux.setDisplayName(newDisplayName);
        }

        String newDomain = user.getDomain();

        if (newDomain != null) {
            useraux.setDomain(newDomain);
        }

        return Result.ok(useraux);
	}

	@Override
	public Result<User> deleteUser(String name, String pwd) {

		Log.info("deleteUser : user = " + name + "; pwd = " + pwd);

		Result<User> result = getUser(name, pwd);

		if(!result.isOK())
			return Result.error(result.error());
		
		users.remove(name);

		return Result.ok();
	}

	@Override
	public Result<List<User>> searchUsers(String pattern) {

		Log.info("searchUsers : pattern = " + pattern);

		if(pattern==null){
			Log.info("pattern is null");
			return Result.error( ErrorCode.BAD_REQUEST);
		}

		if(pattern.equals("")){
			Log.info("pattern is empty");
			return Result.ok((List<User>) users.values());
		}
		
		List<User> usersList = new ArrayList<>();

		for(User user : users.values()){
			if(user.getName().contains(pattern)){
				usersList.add(user);
			}	
		}
	return Result.ok(usersList);
}

}

