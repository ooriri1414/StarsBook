package com.example.starsbook;

public class NewsControler {
    private NewsModel model;
    private News view;
    private User user;
    public NewsControler(News view, User user){
        this.view = view;
        model = new NewsModel(this);
        this.user = user;
    }

    public void makeFriendsList() {
        for (int i = 0; i < user.getFriendsUser().toArray().length; i++){
            view.addToList(user.getFriendsUser().get(i));;
        }
    }

    public User getUserFromId(int userId) {
        return model.getUser(userId);
    }

    public void clikedFriend(int id) {
        view.startActivityWithExtra(Friend.class, id);
    }
}
