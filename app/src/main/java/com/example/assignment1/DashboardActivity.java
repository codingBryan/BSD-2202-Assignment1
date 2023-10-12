package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent i = getIntent();
        String firstname=i.getStringExtra("firstname");
        String lastname=i.getStringExtra("lastname");
        String email=i.getStringExtra("display_email");
        ((TextView)findViewById(R.id.firstNameDash)).setText(firstname);
        ((TextView)findViewById(R.id.lastnameDash)).setText(lastname);
        ((TextView)findViewById(R.id.emailDash)).setText(email);
    }
}