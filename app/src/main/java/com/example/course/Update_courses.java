package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.course.model.Course;
import com.example.course.model.Course_Database;

import java.util.ArrayList;

public class Update_courses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_courses);
        AwesomeValidation awesomeValidation;
        EditText input = findViewById(R.id.idstudent);

        EditText Id=(EditText) findViewById(R.id.idstudent);
        EditText Coursename=(EditText) findViewById(R.id.coursenames);
        EditText TeacherName=(EditText) findViewById(R.id.Teachername);
        EditText Description=(EditText) findViewById(R.id.descripe);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // add validation
        awesomeValidation.addValidation(this,R.id.idstudent, RegexTemplate.NOT_EMPTY,R.string.invalid_id);
        awesomeValidation.addValidation(this,R.id.coursenames, RegexTemplate.NOT_EMPTY,R.string.invalid_course);
        awesomeValidation.addValidation(this,R.id.Teachername,RegexTemplate.NOT_EMPTY,R.string.invalid_teacher);
        awesomeValidation.addValidation(this,R.id.descripe,RegexTemplate.NOT_EMPTY,R.string.invalid_desription);

        Course_Database db=new Course_Database(this);

        // back to add screen
        findViewById(R.id.Update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()) {
                    String id = Id.getText().toString();
                    String Coursename2 = Coursename.getText().toString();
                    String TeacherName2 = TeacherName.getText().toString();
                    String  Description2 = Description.getText().toString();


                    Boolean checkUpdate = db.update(id,Coursename2,Description2,TeacherName2);

                    ArrayList<Course> d = db.getdata();

                    if(checkUpdate==true){
                        Toast.makeText(Update_courses.this, "Updated...", Toast.LENGTH_LONG).show();
                        //Toast.makeText(Update_courses.this, d.get(1).getTeacherName(), Toast.LENGTH_LONG).show();


                    }
                    else{
                        Toast.makeText(Update_courses.this, "Not Updated...", Toast.LENGTH_LONG).show();

                    }





                }


                else {

                }

                String text = input.getText().toString();

                Id.setText("");
                Coursename.setText("");
                TeacherName.setText("");
                Description.setText("");
            }
        });

        // back to add screen
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}