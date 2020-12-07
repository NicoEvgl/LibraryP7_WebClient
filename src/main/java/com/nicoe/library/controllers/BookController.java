package com.nicoe.library.controllers;

import com.nicoe.library.beans.Book;
import com.nicoe.library.beans.CopySearchResult;
import com.nicoe.library.proxies.LibraryProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private final LibraryProxy libraryProxy;

    @Autowired
    public BookController(LibraryProxy libraryProxy){
        this.libraryProxy = libraryProxy;
    }

    static Logger logger = LogManager.getLogger(BookController.class);
    /**
     * Display search book page
     * @param model book
     * @return bookSearch
     */
    @GetMapping("/search-book")
    public ModelAndView searchBook(Model model){
        Book book = new Book();
        model.addAttribute("book",book);
        return new ModelAndView("bookSearch");
    }

    /**
     * Search results
     * @param model copySearchResults
     * @param book book
     * @return bookList
     */
    @PostMapping("/search-book")
    public ModelAndView searchBookProcess(Model model, @ModelAttribute("book") Book book){
        logger.debug("BookController search-book");
        List<CopySearchResult> copySearchResults = new ArrayList();
        copySearchResults = libraryProxy.getCopySearchResult(book);
        return new ModelAndView("bookList","copySearchResults", copySearchResults);
    }
}
