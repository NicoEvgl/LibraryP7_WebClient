package com.nicoe.library.beans;

import java.io.Serializable;

public class Reservation implements Serializable {
    Integer bookId;
    Integer userId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
