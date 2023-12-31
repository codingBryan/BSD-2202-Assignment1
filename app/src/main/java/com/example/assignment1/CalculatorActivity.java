package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.ezylang.evalex.EvaluationException;
import com.ezylang.evalex.Expression;
import com.ezylang.evalex.bigmath.BigMathExpression;
import com.ezylang.evalex.data.EvaluationValue;
import com.ezylang.evalex.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;


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

    public void GetAnswer(View view) {
        String displayAnswer;

         BigMathExpression e = new BigMathExpression(getExpressionText());
        try {
            EvaluationValue ans = e.evaluate();
            displayAnswer = ans.getStringValue();
            ((TextView) findViewById(R.id.answerString)).setText(displayAnswer);
            CalchHistory h = new CalchHistory(getExpressionText(), displayAnswer);
            History.add(h);
            Toast.makeText(this, "calculation saved", Toast.LENGTH_SHORT).show();
        } catch (EvaluationException ex) {
            displayAnswer = ex.getMessage();
            ((TextView) findViewById(R.id.answerString)).setText(displayAnswer);
        } catch (ParseException ex) {
            displayAnswer = ex.getMessage();
            ((TextView) findViewById(R.id.answerString)).setText(displayAnswer);
        }
    }


    public void DelBtnClicked(View view) {
        if (getExpressionText() == null || getExpressionText().isEmpty()) {
            return; // Return the original string if it's null or empty
        }
        String deleted = getExpressionText().substring(0, getExpressionText().length() - 1);
        setExpressionText(deleted);
        ((TextView) findViewById(R.id.expression)).setText(getExpressionText());
    }

    public void AcBtnClicked(View view) {
        ((TextView) findViewById(R.id.expression)).setText(null);
    }

    public void CloseBtnClicked(View view) {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void HistoryBtnClicked(View view) {
        Intent i = new Intent(this, HistoryActivity.class);
        startActivity(i);
    }



    public void BtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + btnText;
        expressionView.setText(expressionText);
    }


    public void FactBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "FACT(";
        expressionView.setText(expressionText);
    }
    public void CosecBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "CSC(";
        expressionView.setText(expressionText);
    }
    public void SecBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "SEC(";
        expressionView.setText(expressionText);
    }
    public void CotBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "COT(";
        expressionView.setText(expressionText);
    }

    public void CosBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "COS(";
        expressionView.setText(expressionText);
    }

    public void SqrtBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "SQRT(";
        expressionView.setText(expressionText);
    }
    public void TanBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "TAN(";
        expressionView.setText(expressionText);
    }
    public void PiBtnClicked(View view) {
        Button btn = (Button) view;
        String btnText = btn.getText().toString();
        TextView expressionView = ((TextView) findViewById(R.id.expression));
        expressionText = expressionView.getText().toString() + "PI(";
        expressionView.setText(expressionText);
    }
}

    class CalchHistory{
        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        public CalchHistory(String e, String a){
        expression = e;
        answer = a;
        }

        public String getExpression() {
            return expression;
        }

        public void setExpression(String expression) {
            this.expression = expression;
        }

        String expression;
        String answer;
}