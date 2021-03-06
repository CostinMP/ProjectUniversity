package university.service.user.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import university.enitity.MyUser;
import university.enitity.Role;
import university.repository.RoleRepository;
import university.repository.UserRepository;
import university.service.email.BodyBuilderService;
import university.service.email.EmailSender;
import university.service.token.RandomTokenService;
import university.service.user.UserService;

import java.util.List;
import java.util.Optional;

@Service

public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    BodyBuilderService bodyBuilderService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    private RandomTokenService randomTokenService;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public MyUser findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public MyUser findUserByUserName(String userName) {
        return userRepository.findByUsernameIgnoreCase(userName);
    }

    public MyUser findUserByRandomToken(String randomToken) {
        return userRepository.findByRandomToken(randomToken);
    }

    public boolean findUserByUserNameAndPassword(String userName, String password) {
        final Optional<MyUser> myUser = Optional.ofNullable(userRepository.findByUsernameIgnoreCase(userName));
        return myUser.filter(user -> BCrypt.checkpw(password, user.getPassword())).isPresent();
    }

    public List<MyUser> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    public MyUser saveUser(MyUser u) {
        MyUser user = new MyUser(u);
        user.setPassword(new BCryptPasswordEncoder().encode(u.getPassword()));
        user.setRandomToken(randomTokenService.randomToken(u));
        emailSender.sendEmail(user.getEmail(), "Activate your Account", bodyBuilderService.emailBody(user));
        u.getRoles().forEach(role -> {
            final Role roleByName = roleRepository.findByName(role.getName());
            if (roleByName == null)
                user.getRoles().add(roleRepository.save(role));
            else {
                role.setId(roleByName.getId());
            }
        });
        return userRepository.save(user);
    }


}

