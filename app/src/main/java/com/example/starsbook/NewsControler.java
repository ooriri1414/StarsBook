package com.example.starsbook;

public class NewsControler {
    News view;
    NewsModel model;
    public NewsControler(News view){
        this.view = view;
        model = new NewsModel(this);
    }
}
