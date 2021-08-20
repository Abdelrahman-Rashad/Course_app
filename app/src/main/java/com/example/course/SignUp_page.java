package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.course.model.UserDataBase;


public class SignUp_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        EditText input = findViewById(R.id.pass);


        AwesomeValidation awesomeValidation;
        UserDataBase obj=new UserDataBase(this);

        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        EditText t1 = (EditText) findViewById(R.id.username);
        EditText t2=(EditText) findViewById(R.id.fullname);
        EditText t3=(EditText) findViewById(R.id.e_mail);
        EditText t4=(EditText) findViewById(R.id.pass);

        // add validation
        awesomeValidation.addValidation(this,R.id.username, RegexTemplate.NOT_EMPTY,R.string.invalid_n);
        awesomeValidation.addValidation(this,R.id.fullname, RegexTemplate.NOT_EMPTY,R.string.invalid_f);
        awesomeValidation.addValidation(this,R.id.e_mail,RegexTemplate.NOT_EMPTY,R.string.invalid_e);
        awesomeValidation.addValidation(this,R.id.pass,RegexTemplate.NOT_EMPTY,R.string.invalid_pa);


        findViewById(R.id.sign).setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (awesomeValidation.validate()) {

                    String check = obj.Insert_Data(t1.getText().toString(),t2.getText().toString(),t3.getText().toString(),t4.getText().toString());
                    Toast.makeText(SignUp_page.this, check, Toast.LENGTH_LONG).show();
                }
                else {

                }
                String text = input.getText().toString();

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
            }
        });
    }
}