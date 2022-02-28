package com.example.starsbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class News extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btExitNews, btGroupsNews, btStarsNews, btFriendsNews, btSettingsNews;
    private ListView lvFriendNews, lvGroupNews;
    private TextView tvUserNameNews;
    private ArrayList<User> friends;
    private User user;
    private NewsControler controler;
    InternetLessReciver internetLessReciver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        Intent intent = getIntent();
        int userId = intent.getIntExtra(MainActivity.key, 0);
        user = controler.getUserFromId(userId);
        tvUserNameNews = findViewById(R.id.tvUserNameNews);
        tvUserNameNews.setText(user.getUserNameUser());

        controler = new NewsControler(this, user);

        btExitNews = findViewById(R.id.btExitNews);
        btGroupsNews = findViewById(R.id.btGroupsNews);
        btStarsNews = findViewById(R.id.btStarsNews);
        btFriendsNews = findViewById(R.id.btFriendsNews);
        btSettingsNews = findViewById(R.id.btSettingsNews);

        btExitNews.setOnClickListener(this);
        btGroupsNews.setOnClickListener(this);
        btStarsNews.setOnClickListener(this);
        btFriendsNews.setOnClickListener(this);
        btSettingsNews.setOnClickListener(this);

        lvFriendNews = findViewById(R.id.lvFriendsListNews);

        friends = new ArrayList<>();
        controler.makeFriendsList();
        ArrayAdapter friendsAdapter = new ArrayAdapter <User> (this, android.R.layout.simple_list_item_1, friends);
        lvFriendNews.setAdapter(friendsAdapter);
        lvFriendNews.setOnItemClickListener(this);

        internetLessReciver = new InternetLessReciver();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btExitNews:{
                startActivity(MainActivity.class);
            }break;/*
            case R.id.btGroupsNews:{
                //TODO start the groups activity
            }break;//TODO finish*/
        }
    }
    public void startActivity(Class clas){
        Intent intent = new Intent(this, clas);
        startActivity(intent);
    }
    public void toToast(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        controler.clikedFriend(friends.get(i).getIdUser());
    }

    public void addToList( User add){
        friends.add(add);
    }

    public void startActivityWithExtra(Class nextActivity, int id){
        Intent intent = new Intent(this, nextActivity);
        intent.putExtra(MainActivity.key, id);
        startActivity(intent);
    }
}
//TODO to check the broadcast reciver.