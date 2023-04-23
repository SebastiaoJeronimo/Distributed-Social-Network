package sd2223.trab1.server.soap;

import java.util.List;
import java.util.logging.Logger;

import jakarta.jws.WebService;
import sd2223.trab1.server.sharedServiceLogic.sharedUsers;
import sd2223.trab1.api.User;
import sd2223.trab1.api.absctractServiceAPI.Result;
import sd2223.trab1.api.absctractServiceAPI.Users;
import sd2223.trab1.api.soap.UsersException;
import sd2223.trab1.api.soap.UsersService;


@WebService(serviceName = UsersService.NAME, targetNamespace = UsersService.NAMESPACE, endpointInterface = UsersService.INTERFACE)
public class SoapUsersWebService extends SoapWebServices<UsersException> implements UsersService {


    final Users impl;

    public SoapUsersWebService() { //VER ESTE PARAMETRO COM ATENCAO
        super((result) -> new UsersException(result.error().toString()));
        this.impl = new sharedUsers();
    }

    @Override
    public String createUser(User user) throws UsersException {
        return super.fromJavaResult(impl.createUser(user));
    }

    @Override
    public User getUser(String name, String pwd) throws UsersException {
        return super.fromJavaResult(impl.getUser(name, pwd));
    }

    @Override
    public User updateUser(String name, String pwd, User user) throws UsersException {
        return super.fromJavaResult(impl.updateUser(name, pwd, user));
    }

    @Override
    public User deleteUser(String name, String pwd) throws UsersException {
        // throw new RuntimeException("Not Implemented...");
        return super.fromJavaResult(impl.deleteUser(name, pwd));
    }

    @Override
    public List<User> searchUsers(String pattern) throws UsersException {
        // throw new RuntimeException("Not Implemented...");
        return super.fromJavaResult(impl.searchUsers(pattern));
    }

}