package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class Startpage  extends AppCompatActivity{

    Button b1,b2;
    TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);

        findViewById(R.id.admin_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Startpage.this,Account_admin.class);
                startActivity(i);
            }
        });

        findViewById(R.id.student_button).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Startpage.this,Account_student.class);
                startActivity(i);
            }
        });



    }
}