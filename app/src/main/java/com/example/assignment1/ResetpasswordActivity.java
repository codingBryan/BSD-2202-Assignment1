package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class ResetpasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
    }

    public void ResetPassword(View v){
        String email=((EditText)findViewById(R.id.emailPR)).getText().toString();
        String password=((EditText)findViewById(R.id.newPassword)).getText().toString();
        String passwordConfirmation=((EditText)findViewById(R.id.newPasswordConfirm)).getText().toString();
        if(!password.equals(passwordConfirmation)){
            Toast.makeText(this, "Passwords don't match", Toast.LENGTH_LONG).show();
        }else{
            List<User> users = MainActivity.users;
            boolean userPresent=false;
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if(user.getEmail().equals(email)){
                    userPresent=true;
                    user.setPassword(password);
                    Toast.makeText(this, "Password changed.Login with new password", Toast.LENGTH_LONG).show();
                    Intent in = new Intent(this, LoginActivity.class);
                    startActivity(in);
                }
            }
            if(!userPresent){
                Toast.makeText(this, "Invalid email", Toast.LENGTH_LONG).show();
            }
        }


    }

}