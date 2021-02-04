package com.nicoe.library.controllers;

import com.nicoe.library.beans.Reservation;
import com.nicoe.library.beans.User;
import com.nicoe.library.proxies.LibraryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {
    private final LibraryProxy libraryProxy;

    @Autowired
    public ReservationController(LibraryProxy libraryProxy) {
        this.libraryProxy = libraryProxy;
    }

    @GetMapping("/reservation/{bookId}")
    public ModelAndView createReservation(Model model, @PathVariable Integer bookId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if ((auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/login");
        }
        Reservation reservation = new Reservation();
        reservation.setBookId(bookId);
        User user = (User) auth.getPrincipal();
        reservation.setUserId(user.getUserId());
        libraryProxy.createReservation(reservation);
        return new ModelAndView("redirect:/personalSpace");
    }

    @GetMapping("/cancel-reservation/{reservationId}")
    public ModelAndView cancelReservation(Model model, @PathVariable Integer reservationId) {
        libraryProxy.cancelReservation(reservationId);
        return new ModelAndView("redirect:/personalSpace");
    }
}
