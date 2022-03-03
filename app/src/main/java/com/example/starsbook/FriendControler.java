package com.example.starsbook;

public class FriendControler {
    Friend view;
    FriendModel model;
    public FriendControler(Friend view){
        this.view = view;
        model = new FriendModel(this);
    }

    public User getFriend(int id) {
        return model.getUser(id);
    }
}
