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
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Account_admin extends AppCompatActivity {

    EditText t1, t2;
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
        findViewById(R.id.logn_admin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = findViewById(R.id.user_nameadmin);

                t1 = (EditText) findViewById(R.id.user_nameadmin);
                t2 = (EditText) findViewById(R.id.passwordadmin);
                if(awesomeValidation.validate()) {
                    for (int i = 0; i < 2; i++) {
                        if (useradmin[i].equals(t1.getText().toString())) {
                            if (passadmin[i].equals(t2.getText().toString())) {
                                Toast.makeText(Account_admin.this, "Successed", Toast.LENGTH_LONG).show();
                                Intent i2 = new Intent(Account_admin.this, CoursesActivity.class);
                                startActivity(i2);
                            } else {
                                Toast.makeText(Account_admin.this, "Wrong password", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(Account_admin.this, "Admin isn't exist", Toast.LENGTH_LONG).show();
                        }
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