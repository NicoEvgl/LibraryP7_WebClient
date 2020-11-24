package com.nicoe.library.proxies;

import com.nicoe.library.beans.Book;
import com.nicoe.library.beans.Copy;
import com.nicoe.library.beans.CopySearchResult;
import com.nicoe.library.beans.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "libraryApi", url = "localhost:9090")
public interface LibraryProxy {

    @PostMapping("/registerProcess")
    void createUser(User user);

    @GetMapping("/findUser/{username}")
    User findUserByUsername(@PathVariable("username") String username);

    @GetMapping("/findUser/{id}")
    User findUserById(@PathVariable("id") Integer id);

    @GetMapping("/extend/{copyId}")
    void extendLoan(@PathVariable("copyId")Integer id);

    @PostMapping("/searchBook")
    List<CopySearchResult> getCopySearchResult(Book book);

    @GetMapping("/findMyLoans/{username}")
    List<Copy> findMyLoans(@PathVariable("username") String username);
}
