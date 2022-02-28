package com.example.starsbook;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etUserNameMainActivity, etPasswordMainActivity;//שומר editText
    Button btLoginMainActivity, btCreateUserMainActivity;//שומר כפתורים
    MainActivityControler controler;//שומר controler
    public static final String key = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controler= new MainActivityControler(this);
        etUserNameMainActivity = findViewById(R.id.etUserNameMainActivity);
        etPasswordMainActivity = findViewById(R.id.etPasswordMainActivity);
        btLoginMainActivity = findViewById(R.id.btLoginMainActivity);
        btLoginMainActivity.setOnClickListener(this);
        btCreateUserMainActivity = findViewById(R.id.btCreateUserMainActivity);
        btCreateUserMainActivity.setOnClickListener(this);
        btLoginMainActivity.setOnClickListener(this);
        //עד כאן שמירת ה-buttons וה-EditTexts ןשליחה של onClickListener.
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){//חלוקה בתגובה בין אירועים של לחיצה על כל אחד מהכפתורים.
            case R.id.btLoginMainActivity:{//כאשר נלחץ הכפתור "לחץ כאן להתחברות":
                    controler.clickedLogin(etUserNameMainActivity.getText().toString(), etPasswordMainActivity.getText().toString());//מודיע ל-controler שנלחץ הכפתור התחברות ונותן לו את שם המשתמש והסיסמה שניתנו
            } break;
            case R.id.btCreateUserMainActivity:{//כאשר נלחץ הכפתור ליצירת משתמש
                startActivity(CreateUser.class);//מפעיל את מסך 2
            }break;
        }
    }
    public void toToast(int textRsc){
        Toast.makeText(this, textRsc, Toast.LENGTH_SHORT).show();
    }//מחלקה שמטרתה ליצור Toast
    public void startActivityWithUserExtra (Class nextActivity, User extra){
        Intent intent = new Intent(this, nextActivity);
        intent.putExtra(key, extra.getIdUser());
        startActivity(intent);
    }//מחלקה שמטרתה להפעיל מסך
    public void startActivity(Class nextActivity){
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
    }

}
/* Mainactivity - מסך1
 * CreateUser - מסך2*/