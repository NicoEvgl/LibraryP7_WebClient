package com.nicoe.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    /**
     * Display home page.
     * @param model
     * @param userInSessionId
     * @param httpSession
     * @return home
     */
    @GetMapping({"/home", "/"})
    public String displayHomePage(Model model , @SessionAttribute(value = "userInSessionId", required = false) Integer userInSessionId, HttpSession httpSession){
        if(userInSessionId == null){
            httpSession.invalidate();
        }
        model.addAttribute("userInSessionId", userInSessionId);
        return "home";
    }
}
