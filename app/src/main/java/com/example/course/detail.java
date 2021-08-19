package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i=getIntent();
        String s1=i.getExtras().getString("name");
        String s2=i.getExtras().getString("teachername");
        String s3=i.getExtras().getString("description");

        TextView t1=(TextView) findViewById(R.id.show_name);
        TextView t2=(TextView) findViewById(R.id.show_teachername);
        TextView t3=(TextView) findViewById(R.id.show_description);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);

    }
}