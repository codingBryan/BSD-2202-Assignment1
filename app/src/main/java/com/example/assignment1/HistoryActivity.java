package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private List<CalchHistory> history = CalculatorActivity.History;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.calculationContainer);
        linearLayout.setPadding(20,10,0,5);

        // Dynamically add frames to the LinearLayout
        if (history != null && !history.isEmpty()) {
            for (CalchHistory result : history) {
                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                ));
                LinearLayout verticalLayout = new LinearLayout(this);
                verticalLayout.setLayoutParams(new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT
                ));
                verticalLayout.setOrientation(LinearLayout.VERTICAL);

                TextView expressionTextView = new TextView(this);
                expressionTextView.setText(result.getExpression());
                expressionTextView.setTextColor(Color.WHITE);

                TextView answerTextView = new TextView(this);
                answerTextView.setTextSize(20);
                answerTextView.setTextColor(1);
                answerTextView.setTextColor(Color.WHITE);
                answerTextView.setText(result.getAnswer());

                verticalLayout.addView(expressionTextView);
                verticalLayout.addView(answerTextView);
                frameLayout.setPadding(10,10,0,10);
                frameLayout.addView(verticalLayout);

                linearLayout.addView(frameLayout);
            }
        } else {
            Log.e("No history", "calculationResults is null or empty");
        }
    }
}