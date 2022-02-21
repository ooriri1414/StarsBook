package com.example.starsbook;

import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MainActivityControler {
    MainActivity view;
    MainActivityModel model;

    public MainActivityControler(MainActivity view) {
        this.view = view;
        model = new MainActivityModel(this);
    }//בנאי

    public void clickedLogin(String userName, String password) {
        if (userName.equals(null)){
            view.toToast(R.string.app_name);
        }
        if (model.chekFilds(userName, password)) {
            User user = model.lookForUser(userName, password);
            if (user == null){
                view.toToast(R.string.user_name_or_password_eror);
            }
            else {
                view.startActivityWithUserExtra(News.class, user);
            }
            //כאן יש להשלים את השמירה של שם המשתמש והסיסמא לאחר שאלמד להשתמש במסד נתונים כך שייבדק האם שם המשתמש והסיסמה נכונים ואם לא אז יש להדפיס ע"י Toast שאחד מהם שגוי ואם כן אז יש להעביר למסך 3.
        }//שולח ל-modek שיבדוק אם כל השדות מלאים ואם כן אז בודק אם שם המשתמש והסיסמה נכונים ואם כן אז עובר למסך 3 אחרת שולח Toast ששם המשתמש או הסיסמה שגויים ואם לא אז שולח הודעה ששם המשתמש או הסיסמה חסרים
        else {
            view.toToast(R.string.user_name_or_password_less);
            ;//מדפיס "שם המשתמש או הסיסמא חסרים"
        }
    }

    public void sharedPref(String value) {
        CreateUserModel.sharedPreferences.edit().putString(CreateUserModel.USER_NAME, value).commit();
    }//יוצר shared preferences
}
