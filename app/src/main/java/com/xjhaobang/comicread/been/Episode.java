package com.xjhaobang.comicread.been;

import java.io.Serializable;

/**
 * Created by PC on 2017/9/30.
 */

public class Episode implements Serializable{
    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
