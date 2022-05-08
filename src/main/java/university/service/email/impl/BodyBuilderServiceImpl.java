package university.service.email.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import university.enitity.MyUser;
import university.service.email.BodyBuilderService;
import university.service.token.RandomTokenService;

@Service

public class BodyBuilderServiceImpl implements BodyBuilderService {

    @Autowired
    RandomTokenService randomTokenService;


    @Override
    public String emailBody(MyUser myUser) {
        return "Hello," +
                "In order to activate your account please access the following link:\n" +
                "http://localhost:8080/activation/" + myUser.getRandomToken();
    }
}
