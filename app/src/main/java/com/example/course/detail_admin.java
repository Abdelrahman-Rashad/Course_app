package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.course.model.Course_Database;

public class detail_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Course_Database db=new Course_Database(this);
        Intent i=getIntent();
        String s1=i.getExtras().getString("name");
        String s2=i.getExtras().getString("teachername");
        String s3=i.getExtras().getString("description");
        int s4=i.getExtras().getInt("id");

        TextView t1=(TextView) findViewById(R.id.show_name_admin);
        TextView t2=(TextView) findViewById(R.id.show_teachername_admin);
        TextView t3=(TextView) findViewById(R.id.show_des_admin);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);
        findViewById(R.id.button_admin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.delete(String.valueOf(s4));
                Intent intent=new Intent(detail_admin.this,CoursesActivity.class);
                startActivity(intent);
            }
        });
    }
}