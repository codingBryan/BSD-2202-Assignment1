package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cat1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat1);
    }
    public void GotoNextPage(View view){
        Intent in = new Intent(this, NextPageActivity.class);
        startActivity(in);
    }

    public void GotoKCA(View view){
        Intent in = new Intent(this, KCAActivity.class);
        startActivity(in);
    }
}