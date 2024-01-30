package com.MEC.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserRegister {

    private final UserRepository userRepository;
    @Autowired
    public UserRegister(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Widok
    @GetMapping("/view")
    public String showView(Model model){
        model.addAttribute("user", new User());
        return "View";
    }

    //Rejestracja usera
    @PostMapping("/registeruser")
    public String registerUser(@ModelAttribute("user") User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "redirect:/login";
    }

    //Forma rejestracyjna
    @GetMapping("/registerForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "Register";
    }
}