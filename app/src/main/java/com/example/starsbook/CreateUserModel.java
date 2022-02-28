package com.example.starsbook;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateUserModel {
    public static SharedPreferences sharedPreferences;
    public static final String USER_NAME = "com.example.StarsBook.CreateUser.userName";//יוצר shared prefernces
    CreateUserControler controler;//יוצר controler
    FirebaseDatabase database = FirebaseDatabase.getInstance();//יוצר מסד נתונים
    DatabaseReference userReference;
    User[] users;

    public CreateUserModel (CreateUserControler controler){
        this.controler = controler;
        userReference = database.getReference("user");//יוצר צומת במסד הנתונים
        userReference.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                Log.d("TASK ONCOMPLETE", task.toString());
                DataSnapshot snapshot = task.getResult();
                users = new User[(int) snapshot.getChildrenCount()];
                int i = 0;
                for (DataSnapshot userSnapshot : snapshot.getChildren()){
                    users[i++] = userSnapshot.getValue(User.class);
                }
            }
        });

    }//בנאי
    public boolean checkFilds(String userName, String password, String secondlyPassword, String gmail, String phoneNum){
        if (userName.isEmpty()|| password.isEmpty()||secondlyPassword.isEmpty()||gmail.isEmpty()||phoneNum.isEmpty()){
            return false;
        }

        for (int i = 0; i < users.length; i++){
            if (users[i].getUserNameUser().equals(userName))
                return false;
        }//בודק אם יש טקסט בשדה

        for (int i = 0; i < users.length; i++){
            if (users[i].getPasswordUser().equals(password))
                return false;
        }//בודק אם יש טקסט בשדה

        for (int i = 0; i < users.length; i++){
            if (users[i].getGmailUser().equals(gmail))
                return false;
        }//בודק אם יש טקסט בשדה

        for (int i = 0; i < users.length; i++){
            if (users[i].getPhoneNumberUser().equals(phoneNum))
                return false;
        }//בודק אם יש טקסט בשדה
        return true;
    }//מתודה שבודקת אם המשתמש מילא את כל השדות ומחזירה true אם מילא ו-false אם לא מילא
    public int getNumOfUsers(){
        return users.length;
    }

    public void setToDataBase(String userName, String password, String gmail, String phoneNumber, int id) {
        User user = controler.makeUser(userName, password, gmail, phoneNumber, id);//יוצר משתמש
        userReference = database.getReference("user/" + id);
        userReference.setValue(user);//מכניס את המשתמש לבסיס הנתונים
    }//מתודה ששולחת נתונים לבסיס הנתונים
    public void setToDataBase(User user) {
        int id = user.getIdUser();
        userReference = database.getReference("user/" + id);
        userReference.push().setValue(user);//מכניס את המשתמש לבסיס הנתונים
//        userReference.push();
    }//מתודה ששולחת נתונים לבסיס הנתונים
    public void sharedPref(){
        sharedPreferences = controler.getSharedpref(sharedPreferences);
        sharedPreferences.contains(USER_NAME);
    }//מתודה ששולחת נתונים ל-shared preferences
}