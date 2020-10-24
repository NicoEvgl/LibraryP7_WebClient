package com.nicoe.library.beans;

import java.io.Serializable;

public class CopySearchResult implements Serializable {
    public String title;
    public Integer nbAvailable;

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
}
