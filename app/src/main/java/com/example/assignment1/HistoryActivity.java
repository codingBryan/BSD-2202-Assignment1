package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    ListView L;
    List<CalchHistory> History = CalculatorActivity.History;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        L = (ListView)findViewById(R.id.hist);
        ArrayAdapter<CalchHistory> arr;
        arr = new ArrayAdapter<>(
                this,R.layout.activity_history,History
        );
        L.setAdapter(arr);

    }
}