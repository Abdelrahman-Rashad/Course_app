package com.example.course;

import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class Account_admin extends AppCompatActivity {

    EditText t1, t2,t3;
    CheckBox Showpass;
    String[] useradmin = {"Mohamed", "Salma"};
    String[] passadmin = {"123", "456"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AwesomeValidation awesomeValidation;



        //initialize validation style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        // add validation
        awesomeValidation.addValidation(this,R.id.user_nameadmin, RegexTemplate.NOT_EMPTY,R.string.invalid_n);
        awesomeValidation.addValidation(this,R.id.passwordadmin,RegexTemplate.NOT_EMPTY,R.string.invalid_pass);
        t1 = (EditText) findViewById(R.id.user_nameadmin);
        t2 = (EditText) findViewById(R.id.passwordadmin);
        Showpass = (CheckBox) findViewById(R.id.Show);
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


        findViewById(R.id.logn_admin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.user_nameadmin);

                t1 = (EditText) findViewById(R.id.user_nameadmin);
                t2 = (EditText) findViewById(R.id.passwordadmin);
                if(awesomeValidation.validate()) {

                    if (useradmin[0].equals(t1.getText().toString())||useradmin[1].equals(t1.getText().toString())) {
                        if (passadmin[0].equals(t2.getText().toString())||passadmin[1].equals(t2.getText().toString())) {

                            Toast.makeText(Account_admin.this, "Successed", Toast.LENGTH_LONG).show();
                            Intent i2 = new Intent(Account_admin.this, CoursesActivity.class);
                            startActivity(i2);

                        }
                        else {
                            Toast.makeText(Account_admin.this, "Wrong password", Toast.LENGTH_LONG).show();


                        }

                    }
                    else {

                        Toast.makeText(Account_admin.this, "Admin isn't exist", Toast.LENGTH_LONG).show();

                    }



                }
                else{

                }
                String text = input.getText().toString();

                t1.setText("");
                t2.setText("");
            }
        });


    }
}