package com.example.starsbook;

import android.content.SharedPreferences;

public class CreateUserControler {
    CreateUser view;//יוצר view
    CreateUserModel model;//יוצר model

    String userName, password, secondlyPassword, gmail, phoneNumber;
    public CreateUserControler (CreateUser view){
        this.view = view;
        model = new CreateUserModel(this);
        model.setToDataBase(makeUser(userName, password, gmail, phoneNumber, model.getNumOfUsers()));
    }//בנאי

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setSecondlyPassword(String secondlyPassword){
        this.secondlyPassword = secondlyPassword;
    }

    public String getSecondlyPassword(){
        return secondlyPassword;
    }

    public void setGmail(String gmail){
        this.gmail = gmail;
    }

    private String getGmail(){
        return gmail;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }//עד כאן geters ו-seters

    public void clickedCreateUser(String userName, String password, String secondlyPassword, String gmail, String phoneNumber){
        if (model.checkFilds(userName, password, secondlyPassword, gmail, phoneNumber)){//קורא ל-model שיבדוק אם כל השדות מלאים ואם כן שולח את המשתמש למסד הנתונים ומפעיל את מסך 3 ואם לא אז שולח למשתמש שחסרים נתונים
            if (password.equals(secondlyPassword)){//בודק אם הסיסמה והחזרה על הסיסמה זהות. אם כן אז גומר את הפעולות לעיל ואם לא אז שולח למשתמש שהסיסמאות לא זהות
                model.setToDataBase(userName, password, gmail, phoneNumber, model.getNumOfUsers() + 1);//שולח את המשתמש למסד הנתונים
                view.startActivity(News.class);//מפעיל את מסך 3
            }
            else {
                view.toToast(R.string.diferentPasswords);//שולח למשתמש שהסיסמאות לא זהות
            }
        }
        else {
            view.toToast(R.string.dataLess);//שןלח למשתמש שחסרים נתונים
        }

    }

    public User makeUser(String userName, String password, String gmail, String phoneNumber, int id){
        User user = new User(userName, password, gmail, phoneNumber, id);
        return user;
    }//מתודה שיוצרת user ומחזירה אותו

    public SharedPreferences getSharedpref(SharedPreferences sharedPreferences) {
        return view.getSharedPref(sharedPreferences);
    }//מתודה שיוצרת shared preferences
}
//TODO broudcast reciver of internet disconected or flieng status