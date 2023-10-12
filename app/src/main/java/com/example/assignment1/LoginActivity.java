package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    private Response<User> ValidateUser(String email, String password){
        List<User> users = MainActivity.users;
        Response<User> res=new Response<User>();
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getEmail(), email)){
                if(users.get(i).getPassword().equals(password)){
                    res.setUser(users.get(i));
                    res.setMessage("login success");
                    res.setSuccess(true);
                }
                else{
                    res.setUser(null);
                    res.setMessage("incorrect password");
                    res.setSuccess(false);
                }
            }else{
                res.setUser(null);
                res.setMessage("404");
                res.setSuccess(false);
            }
        }
        return res;
    }

    public void LoginUser(View v){
        String email=((EditText)findViewById(R.id.emailLogin)).getText().toString();
        String password=((EditText)findViewById(R.id.password)).getText().toString();
        Response<User> response = ValidateUser(email,password);
        if (response.getMessage().equals("incorrect password")){
            Toast.makeText(this,response.getMessage(),Toast.LENGTH_LONG).show();
        } else if (response.getMessage().equals("404")){
            Intent in = new Intent(this, MainActivity.class);
            Toast.makeText(this,response.getMessage()+" user not found",Toast.LENGTH_LONG).show();
            startActivity(in);
        }else{
            Intent in = new Intent(this, DashboardActivity.class);
            in.putExtra("firstname",response.getUser().getFirst_name());
            in.putExtra("lastname",response.getUser().getLast_name());
            in.putExtra("display_email",email);
            ((EditText)findViewById(R.id.emailLogin)).setText(null);
            ((EditText)findViewById(R.id.password)).setText(null);
            startActivity(in);
        }
    }

    public void GoToCreateUser(View v){
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void GotoPasswordReset(View v){
        Intent in = new Intent(this, ResetpasswordActivity.class);
        startActivity(in);
    }
}

class Response<T>{
    private T user;
    public Response(){}

    public void setMessage(String message) {
        this.message = message;
    }

    public T getUser() {
        return user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setUser(T user) {
        this.user = user;
    }
    private String message;
    private boolean success;


    public String getMessage() {
        return message;
    }
}