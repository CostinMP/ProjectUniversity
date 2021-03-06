package university.service.user;

import org.springframework.stereotype.Service;
import university.enitity.MyUser;

import java.util.List;


@Service

public interface UserService {

    MyUser findUserByEmail(String email);

    MyUser findUserByUserName(String userName);

    MyUser findUserByRandomToken(String randomToken);


    boolean findUserByUserNameAndPassword(String userName, String password);

    List<MyUser> findAll();

    void deleteById(long id);

    MyUser saveUser(MyUser u);


}
