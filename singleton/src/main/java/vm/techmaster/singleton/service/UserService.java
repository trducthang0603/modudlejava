package vm.techmaster.singleton.service;

import org.springframework.stereotype.Component;
import vm.techmaster.singleton.model.UserModel;

@Component
public class UserService {
    public UserModel getUserByUsername(String username){
        return new UserModel(username);
    }
}
