package com.MEC.Ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {


        @GetMapping("/html")
        public String showHtmlPage(Model model) {
            model.addAttribute("initialData", "Initial Value");
            return "View";
        }
    }
