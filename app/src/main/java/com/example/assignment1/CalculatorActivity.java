package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorActivity extends AppCompatActivity {

    public static List<CalchHistory> History = new ArrayList<>();
    public String getExpressionText() {
        return expressionText;
    }
    public void setExpressionText(String expressionText) {
        this.expressionText = expressionText;
    }
    String expressionText = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    public void GetAnswer(View view){
        String displayAnswer;

        Expression e = new Expression(getExpressionText());
        try {
            //Ezylang
            EvaluationValue ans = e.evaluate();
            displayAnswer = ans.getStringValue();
            ((TextView)findViewById(R.id.answerString)).setText(displayAnswer);
            CalchHistory h = new CalchHistory(getExpressionText(),displayAnswer);
            History.add(h);
        }catch (EvaluationException ex){
            displayAnswer = ex.getMessage();
            ((TextView)findViewById(R.id.answerString)).setText(displayAnswer);
        } catch (ParseException ex) {
            displayAnswer = ex.getMessage();
            ((TextView)findViewById(R.id.answerString)).setText(displayAnswer);
        } finally {
            return;
        }
    }
    public void DelBtnClicked(View view){
        if (getExpressionText() == null || getExpressionText().isEmpty()) {
            return ; // Return the original string if it's null or empty
        }
        String deleted = getExpressionText().substring(0, getExpressionText().length() - 1);
        setExpressionText(deleted);
        ((TextView)findViewById(R.id.expression)).setText(getExpressionText());
    }
    public void AcBtnClicked(View view){
        ((TextView)findViewById(R.id.expression)).setText(null);
    }
    public void CloseBtnClicked(View view){
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }
    public void historyBtnClicked(View view){
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }
    public void BtnClicked(View view){
        Button btn= (Button)view;
        String btnText = btn.getText().toString();

        TextView expressionView = ((TextView) findViewById(R.id.expression));
        if (btnText.equals("history")){
            return;
        }
        if (btnText.equals("mod")){
            expressionText = expressionView.getText().toString() + "%";
            expressionView.setText(expressionText);
        }
        else{
            expressionText = expressionView.getText().toString() + btnText;
            expressionView.setText(expressionText);
        }
    }
}

class CalchHistory{
    public CalchHistory(String e,String a){
        expression = e;
        answer = a;
    }
    public String expression;
    public String answer;
}