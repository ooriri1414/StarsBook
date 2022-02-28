package com.example.starsbook;

import java.util.ArrayList;

public class User {
    private String userNameUser, passwordUser, gmailUser, phoneNumberUser;//שומר את נתוני המשתמש
    private ArrayList<Post> posts;
    private ArrayList<User> friends;
    private ArrayList<Group> groups;
    private int id;

    public User(){
    }//בנאי חסר
    public User (String userNameUser, String passwordUser, String gmailUser, String phoneNumberUser, int id){
        this.userNameUser = userNameUser;
        this.passwordUser = passwordUser;
        this.gmailUser = gmailUser;
        this.phoneNumberUser = phoneNumberUser;
        this.id = id;
    }//בנאי מלא
    public String getUserNameUser(){
        return userNameUser;
    }
    public void setUserNameUser(String userNameUser){
        this.userNameUser = userNameUser;
    }
    public String getPasswordUser(){
        return passwordUser;
    }
    public void setPasswordUser(String passwordUser){
        this.passwordUser = passwordUser;
    }
    public String getGmailUser(){
        return gmailUser;
    }
    public void setGmailUser(String gmailUser){
        this.gmailUser = gmailUser;
    }
    public String getPhoneNumberUser(){
        return phoneNumberUser;
    }
    public void setPhoneNumberUser(String phoneNumberUser){
        this.phoneNumberUser = phoneNumberUser;
    }
    public ArrayList<User> getFriendsUser(){
        return this.friends;
    }
    public void setFriendsUser(ArrayList<User> friends){
        this.friends = friends;
    }
    public ArrayList<Post> getPostsUser(){
        return this.posts;
    }
    public void setPostsUser(ArrayList<Post> myPosts){
        this.posts = myPosts;
    }
    public ArrayList<Group> getGroupsUser(){
        return this.groups;
    }
    public void setGroupsUser(ArrayList<Group> groups){
        this.groups = groups;
    }
    public int getIdUser(){
        return id;
    }
    public void setIdUser(int id){
        this.id = id;
    }
}
