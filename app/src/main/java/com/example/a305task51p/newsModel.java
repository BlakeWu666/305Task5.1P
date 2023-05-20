package com.example.a305task51p;

import java.text.BreakIterator;

public class newsModel {
    int image;

    String news;

    public int getImage() {
        return image;
    }

    public String getNews() {
        return news;
    }

    public newsModel(int image, String news) {
        this.image = image;
        this.news = news;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
