package com.example.starsbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateUser extends AppCompatActivity implements View.OnClickListener{
    EditText etUserNameCreateUser, etpasswordCreateUser, etSecondlyPasswordCreateUser, etGmailCreateUser, etPhoneNumberCreateUser;//יוצר editText
    Button btCreateUserCreateUser;//יוצר כפתור יצירת משתמש
    CreateUserControler controler = new CreateUserControler(this);//יוצר controler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etUserNameCreateUser = findViewById(R.id.etUserNameCreateUser);
        etpasswordCreateUser = findViewById(R.id.etPasswordCreateUser);
        etSecondlyPasswordCreateUser = findViewById(R.id.etSecondlyPasswordCreateUser);
        etGmailCreateUser = findViewById(R.id.etGmailCreateUser);
        etPhoneNumberCreateUser = findViewById(R.id.etPhoneNumberCreateUser);
        btCreateUserCreateUser = findViewById(R.id.btCreateUserCreateUser);
        btCreateUserCreateUser.setOnClickListener(this);//עד כאן שמירת הכפתורים וה-editText ושליחת onaclickListenr
    }

    @Override
    public void onClick(View view) {
        controler.clickedCreateUser(etUserNameCreateUser.getText().toString(), etpasswordCreateUser.getText().toString(), etSecondlyPasswordCreateUser.getText().toString(), etGmailCreateUser.getText().toString(), etPhoneNumberCreateUser.getText().toString());//מודיע ל-controler שנלחץ הכפתור ליצירת משתמש ושולח לו את הנתונים שהוזנו בשדות
    }

    public  void  toToast (int text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }//מתודה שמטרתה ליצור Toast

    public void startActivity (Class nextActivity){
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }//מתודה שמטרתה להפעיל מסך
    public SharedPreferences getSharedPref(SharedPreferences sharedPreferences){
        sharedPreferences = getSharedPreferences("userName", this.MODE_PRIVATE);
        return sharedPreferences;
    }//מתודה שיוצרת shared preferences ומחזירה אותו

    public void startActivityWithUserExtra (Class nextActivity, User extra){
        Intent intent = new Intent(this, nextActivity);
        intent.putExtra(MainActivity.key, extra.getIdUser());
        startActivity(intent);
    }//מחלקה שמטרתה להפעיל מסך
}