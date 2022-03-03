package com.example.starsbook;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FriendModel {
    FirebaseDatabase database = FirebaseDatabase.getInstance();//יוצר מסד נתונים
    User user;
    FriendControler controler;
    public FriendModel(FriendControler controler){
        this.controler = controler;
    }

    public User getUser(int id) {
        DatabaseReference userReference = database.getReference("user/" + id);//יוצר צומת במסד הנתונים
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
