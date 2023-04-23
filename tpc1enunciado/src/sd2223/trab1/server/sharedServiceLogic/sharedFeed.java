package sd2223.trab1.server.sharedServiceLogic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import sd2223.trab1.api.absctractServiceAPI.Result;
import sd2223.trab1.api.Message;
import sd2223.trab1.api.absctractServiceAPI.Feeds;

public class sharedFeed implements Feeds {


	private static Logger Log = Logger.getLogger(sharedFeed.class.getName());

    @Override
    public Result<Long> postMessage(String user, String pwd, Message msg) {
        if(user == null || pwd == null || msg == null)
            return Result.error(Result.ErrorCode.BAD_REQUEST);
    }

    @Override
    public Result<Void> removeFromPersonalFeed(String user, long mid, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFromPersonalFeed'");
    }

    @Override
    public Result<Message> getMessage(String user, long mid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessage'");
    }

    @Override
    public Result<List<Message>> getMessages(String user, long time) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMessages'");
    }

    @Override
    public Result<Void> subUser(String user, String userSub, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subUser'");
    }

    @Override
    public Result<Void> unsubscribeUser(String user, String userSub, String pwd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'unsubscribeUser'");
    }

    @Override
    public Result<List<String>> listSubs(String user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listSubs'");
    }

}