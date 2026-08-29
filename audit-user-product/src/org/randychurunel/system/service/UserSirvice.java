package org.randychurunel.system.service;
import org.randychurunel.system.model.User;
import org.randychurunel.system.repository.UserRepo;
public class UserSirvice {
    private UserRepo userRepo = new UserRepo();
    
    public UserStatus createUser(String user, String name, String lastName,
            String email, String password){
        try {
            User newUser = new User(name,lastName,email,password,user);
            userRepo.create(newUser);
            return UserStatus.USER_CREATE;
        } catch (Exception e) {
            return UserStatus.ERROR_USER_CREATE;
        }
    }
}