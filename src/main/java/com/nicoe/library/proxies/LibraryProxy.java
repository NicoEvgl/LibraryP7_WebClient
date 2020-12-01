package com.nicoe.library.proxies;

import com.nicoe.library.beans.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Connection to Web API
 */
@FeignClient(name = "libraryApi", url = "localhost:9090")
public interface LibraryProxy {

    @PostMapping("/account-creation")
    void accountCreation(User user);

    @GetMapping("/find-user/{pseudo}")
    User findUserByPseudo(@PathVariable("pseudo") String pseudo);

    @GetMapping("/extend/{copyId}")
    void extendLoan(@PathVariable("copyId")Integer copyId);

    @PostMapping("/search-book")
    List<CopySearchResult> getCopySearchResult(Book book);

    @GetMapping("/consult-loans/{userId}")
    List<Copy> consultMyLoans(@PathVariable("userId") Integer userId);
}
