package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Account_student extends AppCompatActivity {
    Button b1,b2;
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_student);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Account_student.this,Login.class);
                startActivity(i);
            }
        });
        findViewById(R.id.signup).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Account_student.this,SignUp_page.class);
                startActivity(i);
            }
        });

    }
}