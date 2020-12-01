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

import java.util.List;


@Controller
public class CopyController {

    private final LibraryProxy libraryProxy;

    @Autowired
    public CopyController(LibraryProxy libraryProxy){
        this.libraryProxy = libraryProxy;
    }

    /**
     * Process to extend loan
     * @param model copy
     * @param copyId Integer copy ID
     * @param userInSessionPseudo find userInSession by Pseudo
     * @return personalSpace
     */
    @GetMapping("/extend/{copyId}")
    public String extendCopy(Model model, @PathVariable("copyId") Integer copyId, @SessionAttribute("userInSessionPseudo")String userInSessionPseudo){
        User userInSession = libraryProxy.findUserByPseudo(userInSessionPseudo);
        libraryProxy.extendLoan(copyId);
        List<Copy> copies = libraryProxy.consultMyLoans(userInSession.getUserId());
        model.addAttribute("copies", copies);
        model.addAttribute("userInSession", userInSession);
        model.addAttribute("userInSessionPseudo", userInSessionPseudo);
        return "redirect:/personalSpace";
    }
}
