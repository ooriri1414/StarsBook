package com.example.starsbook;

public class SharePostControler {
    SharePost view;
    SharePostModel model;
    public SharePostControler(SharePost view){
        this.view = view;
        model = new SharePostModel(this);
    }
}
