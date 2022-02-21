package com.example.starsbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Post {
    private String text;
    private Bitmap image;
    private int intImage;
    public Post (String text, int image, String information, Context context){
        this.text = text;
        this.image = BitmapFactory.decodeResource(context.getResources(),image);
        this.intImage = image;
    }
    public Post (String name, Bitmap symbol, String information){
        this.text = name;
        this.image = symbol;
    }
    public int getIntImage(){
        return intImage;
    }
    public void setImage (Bitmap image){this.image = image;}
    public void setImage (int image, Context context){
        this.intImage = image;
        this.image = BitmapFactory.decodeResource(context.getResources(),image);
        this.intImage = image;
    }
    public Bitmap getImage(){
        return image;
    }
    public void setText (String information){
        this.text = information;
    }
    public String getText(){
        return text;
    }

}
