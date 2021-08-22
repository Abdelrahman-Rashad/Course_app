package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course.model.User;
import com.example.course.model.UserDataBase;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    EditText t1,t2;
    UserDataBase obj;
    CheckBox Showpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        obj=new UserDataBase(this);
        t1=(EditText)findViewById(R.id.user_nameadmin);
        t2=(EditText)findViewById(R.id.passwordadmin);
        Showpass = (CheckBox) findViewById(R.id.Show2);
        Showpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    t2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
                else{

                    t2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        findViewById(R.id.logn_admin).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String user =t1.getText().toString();
                String pass =t2.getText().toString();
                if(user.equals("")||pass.equals("")) {
                    Toast.makeText(Login.this, "please enter all fields", Toast.LENGTH_LONG).show();
                }

                else {
                    Boolean check = obj.checkusername_pass(user,pass);
                    if (check == true){
                        Toast.makeText(Login.this, "log in successful", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Login.this,Home.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(Login.this, "Data not exist", Toast.LENGTH_LONG).show();

                    }


                }
            }
        });
    }
}