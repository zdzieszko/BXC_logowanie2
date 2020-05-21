package com.example.bxc_logowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText Name;
    EditText Password;
    EditText confirmPassword;
    Button Login;
    TextView NewUser;

    private TextView Info;
    private int counter = 5;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);


        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        NewUser = (TextView) findViewById(R.id.textView3);



        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validate(Name.getText().toString(), Password.getText().toString());
            }
        });

        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewUser.class);
                startActivity(intent);
            }
        });


    }


    private void validate(String userName, String userPassword) {

        if ((userName.equals("admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        } else {
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
        }
    }
}


