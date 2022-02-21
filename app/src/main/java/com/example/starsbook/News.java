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
import android.widget.Toast;

import java.util.ArrayList;

public class News extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button btExitNews, btGroupsNews, btStarsNews, btFriendsNews, btSettingsNews;
    private ListView lvFriendNews, lvGroupNews;
    private ArrayList<User> friends;
    private ArrayList<Group> groups;
    private User user;
    private NewsControler controler;
//Todo אולי אפשר לעשות ירושה בשביל לשתף את ה-user.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        controler = new NewsControler(this);

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

        lvFriendNews = findViewById(R.id.lvFriendNews);
        lvGroupNews = findViewById(R.id.lvGroupNews);

        Intent intent = getIntent();
        user = intent.getExtras().getParcelable(MainActivity.key);

        friends = new ArrayList<>();
        groups = new ArrayList<>();

        for (int i = 0; i < user.getFriends().length; i++){
            friends.add(user.getFriends()[i]);
        }
        ArrayAdapter friendsAdapter = new ArrayAdapter <User> (this, android.R.layout.simple_list_item_1, friends);
        lvFriendNews.setAdapter(friendsAdapter);
        lvFriendNews.setOnItemClickListener(this);

        for (int i = 0; i < user.getGroups().length; i++){
            groups.add(user.getGroups()[i]);
        }
        ArrayAdapter groupsAdapter = new ArrayAdapter<Group>(this, android.R.layout.simple_list_item_1);
        lvGroupNews.setAdapter(groupsAdapter);
        lvFriendNews.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btExitNews:{
                startActivity(MainActivity.class);
            }break;
            case R.id.btGroupsNews:{
                //TODOיתחיל
            }
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
        switch (view.getId()){
            case R.id.lvFriendNews:{
                //TODO העברה למסך בו יוצגו הפוסטים של החבר הנ"ל.
            }break;
            case R.id.lvGroupNews:{
                //TODO העברה למסך בו יוצגו הפוסטים של הקבוצה הנ"ל.
            }
        }
    }
    public <T> void addToList(ArrayList <T> arrayList, T add){

    }
}
//TODO מזהה ייחודי לכל משתמש כך שכל משתמש ישמור את המזהה ולא את המשתמש של החבר וכנ"ל לגבי קבוצות.
//TODO שמירת הפוסטים תתבצע כך: כל הפוסטים שמשתמש משתף ישמרו אצלו ובחלק חדשות ייראו כל החברים והקבוצות של אדם. בלחיצה על אחד מהם יחשפו מאת הפוסטים האחרונים ששותפו שם. כל אדם או קבוצה ששותף בה פוסט מאז הכניסה האחרונה של המשתמש (שתתועד בשיירד פרפרנסז) יובלט בדרך כלשהיא.