package university.service.token;

import university.enitity.MyUser;

public interface RandomTokenService {

    String randomToken(MyUser user);
}
