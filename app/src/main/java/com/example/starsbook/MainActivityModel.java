package com.example.starsbook;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivityModel {
    MainActivityControler controler;
    FirebaseDatabase database = FirebaseDatabase.getInstance();//יוצר מסד נתונים
    DatabaseReference userReference = database.getReference("user");//יוצר צומת במסד הנתונים
    User user;
    User[] users;

    public MainActivityModel(MainActivityControler controler){
        this.controler = controler;
        userReference.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                users = new User[(int) dataSnapshot.getChildrenCount()];
                int i = 0;
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                    user = userSnapshot.getValue(User.class);
                    users[i] = user;
                    i++;
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        });
    }

    public boolean chekFilds(String fild1, String fild2){
        if (fild1.isEmpty()){
            return false;
        }//בודק אם המשתמש מילא את שדה שם המשתמש.
        if (fild2.isEmpty()){
            return false;
        }//בודק אם המשתמש מילא את שדה הסיסמה.
        return true;//אחרת מחזיר true
    }
    public User searchUser(String userName, String password){//מתודה שמטרתה למצוא במסד הנתונים את המשתמש התואם את זה שהמשתמש הזין את נתוניו
        User userForReturn = null;
        for (int i = 0; i < users.length; i++){
            if (users[i].getUserNameUser().equals(userName) && users[i].getPasswordUser().equals(password))
                userForReturn = users[i];
        }
        return userForReturn;
    }

    public User lookForUser(String userName, String password) {
        for (int i = 0; i < users.length; i++){
            if (users[i].getUserNameUser().equals(userName) && users[i].getPasswordUser().equals(password)){
                return users[i];}
        }
        return null;
    }
}
