package sd2223.trab1.client.rest;

import java.net.URI;
import java.util.List;

import sd2223.trab1.api.Message;
import sd2223.trab1.api.User;
import sd2223.trab1.api.absctractServiceAPI.Feeds;
import sd2223.trab1.api.absctractServiceAPI.Result;
import sd2223.trab1.api.absctractServiceAPI.Users;
import sd2223.trab1.api.rest.FeedsService;
import sd2223.trab1.api.rest.UsersService;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


public class RestFeedClient extends RestClient implements Feeds {

	final WebTarget target;
	
	public RestFeedClient( URI serverURI ) {
		super( serverURI );
		target = client.target( serverURI ).path( UsersService.PATH );
	}

    private Result<Long> clt_postMessage(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }

    private Result<Long> clt_removeFromPersonalFeed(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }

    private Result<Long> clt_getMessage(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }
    private Result<Long> clt_getMessages(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }
    private Result<Long> clt_subUser(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }
    private Result<Long> clt_unsubscribeUser(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }
    private Result<Long> clt_listSubs(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }


    @Override
    public Result<Long> postMessage(String user, String pwd, Message msg) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'postMessage'");
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