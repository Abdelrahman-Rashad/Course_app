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
import com.example.course.model.Course_Database;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AwesomeValidation awesomeValidation;
        EditText in = findViewById(R.id.teachername);
        EditText CourseName=(EditText) findViewById(R.id.coursename);
        EditText Description=(EditText) findViewById(R.id.description);
        EditText TeacherName=(EditText) findViewById(R.id.teachername);
        Button add =(Button) findViewById(R.id.addcourse);
        Course_Database db=new Course_Database(this);


        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // add validation
        awesomeValidation.addValidation(this,R.id.coursename,RegexTemplate.NOT_EMPTY,R.string.invalid_course);
        awesomeValidation.addValidation(this,R.id.teachername,RegexTemplate.NOT_EMPTY,R.string.invalid_teacher);
        awesomeValidation.addValidation(this,R.id.description,RegexTemplate.NOT_EMPTY,R.string.invalid_desription);

        // Add Course in Database
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    String check = db.insert(CourseName.getText().toString(), Description.getText().toString(), TeacherName.getText().toString());
                    Toast.makeText(MainActivity.this, check, Toast.LENGTH_LONG).show();
                }
                else {

                }
                String text2 = in.getText().toString();
                CourseName.setText("");
                Description.setText("");
                TeacherName.setText("");
            }
        });

        // Move to update screen
        TextView update=(TextView) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Update_courses.class);
                startActivity(i);
                // write Intent to go next page (update screen)
            }
        });
    }
}