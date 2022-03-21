package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class SharePost extends AppCompatActivity implements View.OnClickListener {
    EditText etTitelSharePost, etTextSharePost;
    Button btBackSharePost, btShareSharePost;
    SharePostControler controler;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_post);

        controler = new SharePostControler(this);

        etTitelSharePost = findViewById(R.id.etTitelSharePost);
        etTextSharePost = findViewById(R.id.etTextSharePost);
        btBackSharePost = findViewById(R.id.btBackSharePost);
        btShareSharePost = findViewById(R.id.btShareSharePost);

        btBackSharePost.setOnClickListener(this);
        btShareSharePost.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btShareSharePost:{
                controler.clickedShare(user,etTitelSharePost.getText().toString(), etTextSharePost.getText().toString());
            }break;
        }
       finish();
    }
}