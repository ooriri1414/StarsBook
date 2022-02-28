package com.example.starsbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Post {
    private String titel;
    private String text;
    public Post (String titel, String text){
        this.titel = titel;
        this.text = text;
    }

    public String getTitel(){
        return titel;
    }
    public void setTitel (String titel){this.titel = titel;}

    public void setText (String information){
        this.text = information;
    }
    public String getText(){
        return text;
    }

}
