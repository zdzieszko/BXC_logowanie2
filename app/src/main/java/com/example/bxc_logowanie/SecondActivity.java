package com.example.bxc_logowanie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    private Button LogOut;
    private ImageView AddNewProfile;
    private ImageView User11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        LogOut = (Button) findViewById(R.id.btnLogOut);
        AddNewProfile = (ImageView) findViewById(R.id.addNewProfile);
        User11 = (ImageView) findViewById(R.id.user11);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        AddNewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(SecondActivity.this, AddNewProfile.class);
                startActivity(intent2);
            }
        });

        User11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, HomePage.class);
                startActivity(intent);
            }
        });

    }


}
