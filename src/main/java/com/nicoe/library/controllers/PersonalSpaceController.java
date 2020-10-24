package com.nicoe.library.controllers;

import com.nicoe.library.beans.Copy;
import com.nicoe.library.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/personalSpace")
    public ModelAndView personalSpace(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        List<Copy> copies = libraryProxy.findLoansByUserId(user.getId());

        model.addAttribute("dayDate", Date.valueOf(LocalDate.now()));
        model.addAttribute("user", user);
        model.addAttribute("copies", copies);
        return new ModelAndView("personalSpace");
    }
}
