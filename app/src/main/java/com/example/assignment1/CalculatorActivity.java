package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import javax.script.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import org.apache.commons.math3.analysis.*;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.analysis.function.Pow;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.analysis.function.Tan;
import org.apache.commons.math3.analysis.function.Ulp;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {

    String expressionText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

    }


    public void BtnClicked(View view){
        Button btn= (Button)view;
        String btnText = btn.getText().toString();

        TextView expressionView = ((TextView) findViewById(R.id.expression));



        if (btnText.equals("del") || btnText.equals("ac") || btnText.equals("=") || btnText.equals("history") || btnText.equals("log") || btnText.equals("close")){
            return;
        }
        if(btnText.equals("square")){
            findViewById(R.id.squareIndicator).setVisibility(view.VISIBLE);
        }
        if(btnText.equals("fact")){
            findViewById(R.id.factIndicator).setVisibility(view.VISIBLE);
        }
        if(btnText.equals("sqrt")){
            findViewById(R.id.sqrtIndicator).setVisibility(view.VISIBLE);
        }
        if(btnText.equals("log")){
            findViewById(R.id.logIndicator).setVisibility(view.VISIBLE);
        }
        if(btnText.equals("="))
        {
            String expression = expressionView.getText().toString();
//            double result = ExpressionEvaluator.evaluateExpression(expression);
        }
        else{
            expressionText = expressionView.getText().toString() + btnText;
            expressionView.setText(expressionText);
        }


    }

}
class ExpressionEvaluator{
//    public static double evaluateExpression(String expression) {
//        // Create a parser
//
//    }
}