package com.nicoe.library.controllers;

import com.nicoe.library.beans.Copy;
import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CopyController {
    private final LibraryProxy libraryProxy;

    @Autowired
    public CopyController(LibraryProxy libraryProxy){
        this.libraryProxy = libraryProxy;
    }


    @GetMapping("/extend/{copyId}")
    public String extendLoan(Model model, @PathVariable Integer copyId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        libraryProxy.extendLoan(copyId);
        model.addAttribute("user", user);
        return "redirect:/personalSpace";
    }
}
