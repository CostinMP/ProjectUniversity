package university.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import university.enitity.MyUser;
import university.service.user.UserService;

@Controller
@RequestMapping(value = "/register")

public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping
    public String registerUser(@ModelAttribute("user") @RequestBody MyUser user) {
        if (user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())) {
            userService.saveUser(user);
            return "register-success";
        } else {
            return "register";
        }
    }
    @GetMapping
    public String registerForm(Model model) {
        MyUser user = new MyUser();
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        model.addAttribute("user", user);

        return "register";
    }
}
