package com.example.bxc_logowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText Name;
    EditText Password;
    Button Login;

    TextView Info;
    TextView NewUser;
    int counter = 5;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Info = (TextView) findViewById(R.id.tvInfo);
        Login = (Button) findViewById(R.id.btnLogin);
        NewUser = (TextView) findViewById(R.id.textView3);

        db = new DatabaseHelper(this);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = Name.getText().toString();
                String password = Password.getText().toString();
                Boolean LoginPassword = db.loginpassword(login, password);
                if (LoginPassword == true){
                    Intent intent = new Intent(Login.this, SecondActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong login or password", Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No of attempts remaining: " + String.valueOf(counter));

                    if (counter == 0) {
                        Login.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"Mozliwosc logowania zablokowana", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        NewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, AddNewUser.class);
                startActivity(intent);
            }
        });
    }
}
