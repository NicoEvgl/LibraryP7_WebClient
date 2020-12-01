package com.nicoe.library.controllers;

import com.nicoe.library.beans.Copy;
import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

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

    /**
     * Display
     * @param userInSessionPseudo
     * @param model
     * @return
     */
    @GetMapping("/personalSpace/{userInSessionPseudo}")
    public String personalSpace(@PathVariable@SessionAttribute("userInSessionPseudo") String userInSessionPseudo, Model model){
        if (userInSessionPseudo == null){
            return "redirect:/home";
        }
        User userInSession = libraryProxy.findUserByPseudo(userInSessionPseudo);
        List<Copy> copies = libraryProxy.consultMyLoans(userInSession.getUserId());

        model.addAttribute("dayDate", Date.valueOf(LocalDate.now()));
        model.addAttribute("copies", copies);
        model.addAttribute("userInSession", userInSession);
        model.addAttribute("userInSessionPseudo", userInSessionPseudo);
        return "personalSpace";
    }
}
