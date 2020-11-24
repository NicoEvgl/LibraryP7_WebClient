package com.nicoe.library.controllers;

import com.nicoe.library.beans.Copy;
import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PersonalSpaceController {
    private final LibraryProxy libraryProxy;

    @Autowired
    public PersonalSpaceController(LibraryProxy libraryProxy){
        this.libraryProxy = libraryProxy;
    }

    @GetMapping("/personalSpace/{userInSessionUsername}")
    public String personalSpace(@PathVariable@SessionAttribute("userInSessionUsername") String userInSessionUsername, Model model){
        if (userInSessionUsername == null){
            return "redirect:/home";
        }
        User userInSession = libraryProxy.findUserByUsername(userInSessionUsername);
        List<Copy> copies = libraryProxy.findMyLoans(userInSession.getUsername());

        model.addAttribute("dayDate", Date.valueOf(LocalDate.now()));
        model.addAttribute("copies", copies);
        model.addAttribute("userInSession", userInSession);
        model.addAttribute("userInSessionId", userInSessionUsername);
        return "personalSpace";
    }
}
