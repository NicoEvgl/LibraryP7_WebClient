package com.nicoe.library.beans;

import java.io.Serializable;
import java.util.Date;

public class CopySearchResult implements Serializable {
    public String title;
    public Integer nbAvailable;
    Date expectedReturnDate;
    Integer nbReservationsMade;
    Integer nbPossibleReservations;
    Integer bookId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNbAvailable() {
        return nbAvailable;
    }

    public void setNbAvailable(Integer nbAvailable) {
        this.nbAvailable = nbAvailable;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public Integer getNbReservationsMade() {
        return nbReservationsMade;
    }

    public void setNbReservationsMade(Integer nbReservationsMade) {
        this.nbReservationsMade = nbReservationsMade;
    }

    public Integer getNbPossibleReservations() {
        return nbPossibleReservations;
    }

    public void setNbPossibleReservations(Integer nbPossibleReservations) {
        this.nbPossibleReservations = nbPossibleReservations;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
