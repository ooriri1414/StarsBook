package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class Friends extends AppCompatActivity {
    private Button btSettingsFriends, btNewsFriends, btStarsFriend, btGroupsFriends, btExitFriends, btLookForFriendFriends;
    private ListView lvAsksFriends, lvFriendsFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        btExitFriends = findViewById(R.id.btExitFriends);
        btGroupsFriends = findViewById(R.id.btGroupsFriends);
        btStarsFriend = findViewById(R.id.btStarsFriends);
        btNewsFriends = findViewById(R.id.btNewsFriends);
        btSettingsFriends = findViewById(R.id.btSettingsFriends);
        btLookForFriendFriends = findViewById(R.id.btlookForFriendFriends);

        lvAsksFriends = findViewById(R.id.lvAsksFriends);
        lvFriendsFriends = findViewById(R.id.lvFriendsFriends);
    }
}