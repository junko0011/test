//목적: 데이터를 분류하고 정리하기 위한 클래스를 만든다

package com.example.aitest2;

import java.io.Serializable;

public class NewsData implements Serializable { //implements Serializable 는 복잡한 데이터를 정리해서 가져와라
    // title 우클릭 > generate > getter and setter > 전체선택 > 전체선택 > ok
    private String title; //private로 가져온 이유는 다른 자바에서 값 못바꾸게 하려고(기사를 바꾸면 안되지)
    private String urlToImage;
    private String content;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
