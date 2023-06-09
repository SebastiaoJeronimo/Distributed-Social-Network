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

    //DONE
    private Result<Long> clt_postMessage(String user, String pwd, Message msg){
        Response r  = target.path( user )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .post(Entity.entity(msg, MediaType.APPLICATION_JSON));
        return super.toJavaResult(r, Long.class);
    }

    //DONE
    private Result<Void> clt_removeFromPersonalFeed(String user, long mid, String pwd){
        Response r  = target.path( user )
                            .path(Long.toString(mid))
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .delete();
        return super.toJavaResult(r, Void.class);
    }

    private Result<Message> clt_getMessage(String user, long mid){
        Response r  = target.path( user )
                            .path(Long.toString(mid))
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .get();
        return super.toJavaResult(r, Message.class);
    }

    private Result<List<Message>> clt_getMessages(String user, long time){
        Response r  = target.path(user)
                      .queryParam(FeedsService.TIME, time)
                      .request()
                      .accept(MediaType.APPLICATION_JSON)
                      .get();
        return super.toJavaResult(r, new GenericType<List<Message>>() {});
    }

    private Result<Void> clt_subUser(String user, String userSub, String pwd){
        Response r  = target.path("sub")
                            .path( user )
                            .path( userSub )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .post(null);
        
                            return super.toJavaResult(r,Void.class);
    }

    private  Result<Void> clt_unsubscribeUser(String user, String userSub, String pwd){
        Response r  = target.path("sub")
                            .path( user )
                            .path( userSub )
                            .queryParam(FeedsService.PWD, pwd)
                            .request()
                            .delete();
        return super.toJavaResult(r, Void.class);
    }

    private Result<List<String>> clt_listSubs(String user){
        Response r  = target.path( "sub/list" )
                            .path( user)
                            .request()
                            .accept(MediaType.APPLICATION_JSON)
                            .get();
        
        return super.toJavaResult(r, new GenericType<List<String>> () {});
    }


    @Override
    public Result<Long> postMessage(String user, String pwd, Message msg) {
        return super.reTry(() -> clt_postMessage(user, pwd, msg)); 
    }

    @Override
    public Result<Void> removeFromPersonalFeed(String user, long mid, String pwd) {
        return super.reTry(() -> clt_removeFromPersonalFeed(user, mid, pwd)); 
    }

    @Override
    public Result<Message> getMessage(String user, long mid) {
        return super.reTry(() -> clt_getMessage(user, mid)); 
    }

    @Override
    public Result<List<Message>> getMessages(String user, long time) {
        return super.reTry(() -> clt_getMessages(user, time));
    }

    @Override
    public Result<Void> subUser(String user, String userSub, String pwd) {
       return super.reTry(() -> clt_subUser(user, userSub, pwd));
    }

    @Override
    public Result<Void> unsubscribeUser(String user, String userSub, String pwd) {
        return super.reTry(() -> clt_unsubscribeUser(user, userSub, pwd));
    }

    @Override
    public Result<List<String>> listSubs(String user) {
        return super.reTry(() -> clt_listSubs(user));
    }
	
}	