package com.example.starsbook;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewsModel {
    NewsControler controler;
    FirebaseDatabase database = FirebaseDatabase.getInstance();//יוצר מסד נתונים
    User user;

    public NewsModel(NewsControler controler){
        this.controler = controler;
    }

    public User getUser(int userId) {
        DatabaseReference userReference = database.getReference("user/" + userId);//יוצר צומת במסד הנתונים
        userReference.get().addOnSuccessListener(new OnSuccessListener<DataSnapshot>() {
            @Override
            public void onSuccess(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    user = userSnapshot.getValue(User.class);
                }
            }
        });
        return user;
    }
}
