package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<User> users= new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void GoToLogin(View v){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void CreateAccount(View v){
        String email = ((EditText)findViewById(R.id.email)).getText().toString();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(email)){
                Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
            }
        }

        String password = ((EditText)findViewById(R.id.passwordSigUp)).getText().toString();
        String passwordConfirm = ((EditText)findViewById(R.id.passwordConfirm)).getText().toString();
        if(password.equals(passwordConfirm)){
            String f_name = ((EditText)findViewById(R.id.firstName)).getText().toString();
            String l_name = ((EditText)findViewById(R.id.lastName)).getText().toString();
            User newUser = new User(f_name,l_name,email,password);
            users.add(newUser);
            Intent i = new Intent(this, LoginActivity.class);
            ((EditText)findViewById(R.id.firstName)).setText(null);
            ((EditText)findViewById(R.id.lastName)).setText(null);
            ((EditText)findViewById(R.id.email)).setText(null);
            ((EditText)findViewById(R.id.passwordSigUp)).setText(null);
            ((EditText)findViewById(R.id.passwordConfirm)).setText(null);
            startActivity(i);
        }
        if (!password.equals(passwordConfirm)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }

    }

}
class User{
    private String first_name;

    public String getLast_name() {
        return last_name;
    }

    private String last_name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
    private String password;
    public User(String first_name,String last_name,String username,String password){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=username;
        this.password=password;

    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}