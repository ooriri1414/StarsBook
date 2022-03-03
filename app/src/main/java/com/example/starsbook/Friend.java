package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Friend extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView lvPostsFriend;
    private TextView tvUserNameFriend, tvPostTextFriend;
    private Button btExitFriend, btGroupsFriend, btStarsFriend, btFriendsFriend, btSettingsFriend, btBackFriend;
    ArrayList <String> titels;
    ArrayList <String> text;
    private User friend;
    FriendControler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        controler = new FriendControler(this);

        lvPostsFriend = findViewById(R.id.lvPostsFriend);
        tvUserNameFriend = findViewById(R.id.tvUserNameFriend);
        tvPostTextFriend = findViewById(R.id.tvPostTextFriend);
        btExitFriend = findViewById(R.id.btExitFriend);
        btGroupsFriend = findViewById(R.id.btGroupsFriend);
        btStarsFriend = findViewById(R.id.btStarsFriend);
        btFriendsFriend = findViewById(R.id.btFriendsFriend);
        btSettingsFriend = findViewById(R.id.btSettingsFriend);
        btBackFriend = findViewById(R.id.btBackFriend);

        btExitFriend.setOnClickListener(this);
        btGroupsFriend.setOnClickListener(this);
        btStarsFriend.setOnClickListener(this);
        btFriendsFriend.setOnClickListener(this);
        btSettingsFriend.setOnClickListener(this);
        btBackFriend.setOnClickListener(this);

        Intent intent = getIntent();
        int friendId = intent.getIntExtra(MainActivity.key, 0);
        friend = controler.getFriend(friendId);

        titels = new ArrayList<String>();
        text = new ArrayList<String>();
        ArrayList<Post> posts = friend.getPostsUser();
        int i;
        for (i = 0; i< posts.size(); i++);{
            titels.add(posts.get(i).getTitel());
            text.add(posts.get(i).getText());
        }

        ArrayAdapter<String> postsAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, titels);
        lvPostsFriend.setAdapter(postsAdapter);
        lvPostsFriend.setOnItemClickListener(this);
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
            }break;
            case R.id.btBackFriend:{
                finish();
            }break;
        }
    }

    public void startActivity(Class nextActivity){
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tvPostTextFriend.setText(text.get(i));
    }
}