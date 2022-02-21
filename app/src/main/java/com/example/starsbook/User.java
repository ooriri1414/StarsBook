package com.example.starsbook;

public class User {
    private String userNameUser, passwordUser, gmailUser, phoneNumberUser;//שומר את נתוני המשתמש
    private Post[] myPosts;
    private User[] friends;
    private Group[] groups;
    private int id;

    public User(){
    }//בנאי חסר
    public User (String userNameUser, String passwordUser, String gmailUser, String phoneNumberUser, int id){
        this.userNameUser = userNameUser;
        this.passwordUser = passwordUser;
        this.gmailUser = gmailUser;
        this.phoneNumberUser = phoneNumberUser;
        myPosts = new Post[100];
        friends = new User[1000];
        groups = new Group[100];
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
    public User[] getFriends(){
        return this.friends;
    }
    public void setFriends(User[] friends){
        this.friends = friends;
    }
    public Post[] getMyPosts(){
        return this.myPosts;
    }
    public void setMyPosts(Post[] myPosts){
        this.myPosts = myPosts;
    }
    public Group[] getGroups(){
        return this.groups;
    }
    public void setGroups(Group[] groups){
        this.groups = groups;
    }
}
