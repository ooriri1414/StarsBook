package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Friend extends AppCompatActivity implements View.OnClickListener {
    private ListView lvPostsFriend;
    private TextView tvUserNameFriend;
    private Button btExitFriend, btGroupsFriend, btStarsFriend, btFriendsFriend, btSettingsFriend;
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

    }

    @Override
    public void onClick(View view) {

    }
}