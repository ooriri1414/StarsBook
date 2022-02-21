package com.example.starsbook;

public class Group {
    User[] members = new User[200];
    Post[] groupsPosts = new Post[100];

    public Group(){
    }
    public Group(User[] members){
        this.members = members;
    }
    public void setMembers (User[] members){
        this.members = members;
    }
    public User[] getMembers() {
        return members;
    }
    public void setGroupsPosts(Post[] groupsPosts){
        this.groupsPosts = groupsPosts;
    }
    public Post[] getGroupsPosts(){
        return this.groupsPosts;
    }
}
