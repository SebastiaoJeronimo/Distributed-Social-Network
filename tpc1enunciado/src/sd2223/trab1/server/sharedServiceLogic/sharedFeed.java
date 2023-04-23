package sd2223.trab1.server.sharedServiceLogic;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import sd2223.trab1.api.Message;
import sd2223.trab1.api.absctractServiceAPI.Result; 
import sd2223.trab1.api.absctractServiceAPI.Result.ErrorCode;
import sd2223.trab1.api.absctractServiceAPI.Feeds;

public class sharedFeed implements Feeds {

	private long seqMes = 1;
	
	private final Map<String,Message> users = new HashMap<>();

	private final Map<String, Map<String, Set<String>>> subscriptions = new ConcurrentHashMap<>(); 

	private static Logger Log = Logger.getLogger(sharedFeed.class.getName());

	@Override
	public Result<Long> postMessage(String user, String pwd, Message msg) {
		Log.info("postMessage : user = " + user + "; pwd = " + pwd + "; msg = " + msg);

		return Result.ok(msg.getId());
	}

	@Override
	public Result<Void> removeFromPersonalFeed(String user, long mid, String pwd) {
		// TODO Auto-generated method stub
		return Result.ok();
	}

	@Override
	public Result<Message> getMessage(String user, long mid) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
	}

	@Override
	public Result<List<Message>> getMessages(String user, long time) {
		// TODO Auto-generated method stub

		List<Message> list = new LinkedList<>();
		
		return Result.ok(list);
	}

	@Override
	public Result<Void> subUser(String user, String userSub, String pwd) {
		// TODO Auto-generated method stub
		Log.info("unsubscribeUser : user = " + user + "; userSub = " + userSub + "; pwd = " + pwd);

		if (user == null || userSub == null || pwd == null) {
            return Result.error(Result.ErrorCode.BAD_REQUEST);
        }
		Result result = validateUser(user, pwd);

		if(!result.isOK())
		return Result.error(result.error());

		return Result.ok();
			
	}

	@Override
	public Result<Void> unsubscribeUser(String user, String userSub, String pwd) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'unsubscribeUser'");
	}

	@Override
	public Result<List<String>> listSubs(String user) {
		// TODO Auto-generated method stub

		Log.info("listSubs : user = " + user);
	
		
		Map<String, Set<String>> subs = subscriptions.get(user);
	
		if (subs == null) {
			Log.info("User does not exist");
			return Result.error(ErrorCode.NOT_FOUND);
		}
	
		// Convert all the sets of subscribers into a single list
		List<String> allSubs = subs.values().stream()
				.flatMap(Collection::stream).collect(Collectors.toList());
	
		return Result.ok(allSubs);
	}


	private Result<Void> validateUser(String user, String pwd) {
		
        return Result.ok();
    }
	


	
}
