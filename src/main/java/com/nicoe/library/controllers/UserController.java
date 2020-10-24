package com.nicoe.library.controllers;

import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private final LibraryProxy libraryProxy;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(LibraryProxy libraryProxy) { this.libraryProxy = libraryProxy;}

    private void addUserInSession(User user, HttpSession httpSession) {
        httpSession.setAttribute("userInSessionId", user.getId());
        httpSession.setAttribute("userInSessionUsername", user.getUsername());
        httpSession.setAttribute("userInSessionEmail", user.getEmail());
    }

    /**
     * Display registration page.
     *
     * @param model
     * @return register
     */
    @GetMapping(value = "/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    /**
     * Process to register an account.
     *
     * @param user
     * @param model
     * @return home
     */
    @PostMapping(value = "/registerProcess")
    public String userRegistration(@ModelAttribute("user") User user, Model model) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        libraryProxy.createUser(user);

        model.addAttribute("message", "Inscription réussie.");
        model.addAttribute("user", user);

        return "home";
    }

    /**
     * Display login page
     * @param model
     * @return login
     */
    @GetMapping(value = "/login")
    public String displayLoginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return "redirect:/home";
        }
        model.addAttribute("user", new User());
        return "login";
    }

    /**
     * Process to login
     * @param user
     * @param httpSession
     * @param model
     * @return "/home"
     */
    @PostMapping(value = "/loginProcess")
    public String doLogin(@ModelAttribute("user") User user, HttpSession httpSession, Model model){
        User loggedInUser = libraryProxy.findUserByUsername(user.getUsername());
        addUserInSession(loggedInUser, httpSession);
        model.addAttribute("user", loggedInUser);
        return "redirect:/home";
    }

    /**
     * Method to logout
     * @param httpServletResponse
     * @param httpSession
     * @param webRequest
     * @param sessionStatus
     * @param model
     * @return "/home"
     */
    @GetMapping("/logout")
    public String logoutUser(HttpServletResponse httpServletResponse, HttpSession httpSession, WebRequest webRequest, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();

        webRequest.removeAttribute("userInSessionId", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("userInSessionUsername", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("userInSessionEmail", WebRequest.SCOPE_SESSION);
        webRequest.removeAttribute("userInSessionRole", WebRequest.SCOPE_SESSION);

        httpServletResponse.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
        httpServletResponse.setHeader("Pragma","no-cache");
        httpServletResponse.setHeader("Expires","0");

        httpSession.invalidate();

        return "redirect:/home";
    }

}
