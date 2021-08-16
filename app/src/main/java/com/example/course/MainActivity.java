package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course.model.Course_Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText CourseName=(EditText) findViewById(R.id.coursename);
        EditText Description=(EditText) findViewById(R.id.description);
        EditText TeacherName=(EditText) findViewById(R.id.teachername);
        Button add =(Button) findViewById(R.id.addcourse);
        Course_Database db=new Course_Database(this);

        // Add Course in Database
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=db.insert(CourseName.getText().toString(),Description.getText().toString(),TeacherName.getText().toString());
                Toast.makeText(MainActivity.this,check,Toast.LENGTH_LONG).show();
            }
        });

        // Move to update screen
        TextView update=(TextView) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // write Intent to go next page (update screen)
            }
        });
    }
}