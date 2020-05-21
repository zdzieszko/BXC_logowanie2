package com.example.bxc_logowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewUser extends AppCompatActivity {

    private EditText AddNewUserLogin;
    private EditText AddNewUserPassword;
    private EditText ConfirmUserPassword;
    private Button AddNewUserButton;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        AddNewUserLogin = (EditText) findViewById(R.id.addNewUserLogin);
        AddNewUserPassword = (EditText) findViewById(R.id.addNewUserPassword);
        ConfirmUserPassword = (EditText) findViewById(R.id.confirmPassword);
        AddNewUserButton = (Button) findViewById(R.id.btAddNewUserAdd);
        db = new DatabaseHelper(this);


        AddNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = AddNewUserLogin.getText().toString();
                String s2 = AddNewUserPassword.getText().toString();
                String s3 = ConfirmUserPassword.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chkemail = db.chkemail(s1);
                        if (chkemail == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
