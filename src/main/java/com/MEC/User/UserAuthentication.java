package com.MEC.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserAuthentication {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/authenticateUser")
    public String authenticateUser(User user, Model model) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String login = user.getLogin();
        String password = user.getPassword();

        Optional<User> optionalUser = userRepository.findByLogin(login);

        if (optionalUser.isPresent()) {
            User dbUser = optionalUser.get();

            if (bCryptPasswordEncoder.matches(password, dbUser.getPassword())) {
                // Poprawne logowanie, przekierowanie na odpowiedni widok
                return "redirect:/view";
            } else {
                // Błędne hasło
                model.addAttribute("errorMessage", "Błędne hasło.");
            }
        } else {
            // Konto o podanym loginie nie zostało znalezione
            model.addAttribute("errorMessage", "Konto o podanym loginie nie zostało znalezione.");
        }
        // Przekierowanie na stronę logowania z odpowiednim komunikatem
        return "redirect:/login";
    }

}

