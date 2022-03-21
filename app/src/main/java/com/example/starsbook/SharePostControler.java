package com.example.starsbook;

public class SharePostControler {
    SharePost view;
    public SharePostControler(SharePost view){
        this.view = view;
    }

    public void clickedShare(User user, String titel, String text) {
        Post post = new Post(titel, titel);
        user.getPostsUser().add(post);
    }
}
