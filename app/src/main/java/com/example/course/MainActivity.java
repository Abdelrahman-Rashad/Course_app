package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.course.model.Course;
import com.example.course.model.Course_Database;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText CourseName,Description,TeacherName;
    Button add;
    Course_Database db;
    String check;

    AwesomeValidation awesomeValidation;
    ArrayList<Course> c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         CourseName=(EditText) findViewById(R.id.coursename);
         Description=(EditText) findViewById(R.id.description);
         TeacherName=(EditText) findViewById(R.id.teachername);
         add =(Button) findViewById(R.id.addcourse);
         db=new Course_Database(this);

         awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

         awesomeValidation.addValidation(this,R.id.coursename, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.description, RegexTemplate.NOT_EMPTY,R.string.invalid_description);
        awesomeValidation.addValidation(this,R.id.teachername, RegexTemplate.NOT_EMPTY,R.string.invalid_teachername);


        // Add Course in Database
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate())
                {
                    check=db.insert(CourseName.getText().toString(),Description.getText().toString(),TeacherName.getText().toString());
                    Toast.makeText(MainActivity.this,c.get(0).getTeacherName()+"",Toast.LENGTH_LONG).show();

                }
                else{

                }

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