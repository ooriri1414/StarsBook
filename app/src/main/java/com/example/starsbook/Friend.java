package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Friend extends AppCompatActivity implements View.OnClickListener {
    private ListView lvPostsFriend;
    private TextView tvUserNameFriend;
    private Button btExitFriend, btGroupsFriend, btStarsFriend, btFriendsFriend, btSettingsFriend;
    ArrayList <String> titels;
    ArrayList <String> text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        lvPostsFriend = findViewById(R.id.lvPostsFriend);
        tvUserNameFriend = findViewById(R.id.tvUserNameFriend);
        btExitFriend = findViewById(R.id.btExitFriend);
        btGroupsFriend = findViewById(R.id.btGroupsFriend);
        btStarsFriend = findViewById(R.id.btStarsFriend);
        btFriendsFriend = findViewById(R.id.btFriendsFriend);
        btSettingsFriend = findViewById(R.id.btSettingsFriend);

        btExitFriend.setOnClickListener(this);
        btGroupsFriend.setOnClickListener(this);
        btStarsFriend.setOnClickListener(this);
        btFriendsFriend.setOnClickListener(this);
        btSettingsFriend.setOnClickListener(this);

        titels = new ArrayList<String>();
        text = new ArrayList<String>();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btExitFriend:{
                startActivity(MainActivity.class);
            } break;
            case R.id.btGroupsFriend:{
                //TODO start the Groups activity.
            } break;
            case R.id.btStarsFriend:{
                //TODO start the stars activity.
            }break;
            case R.id.btFriendsFriend:{
                //TODO start the friends activity.
            }break;
            case R.id.btSettingsFriend:{
                //TODO start the settings activity.
            }
        }
    }

    public void startActivity(Class nextActivity){
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }
}