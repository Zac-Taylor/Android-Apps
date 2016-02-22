package com.example.taylor.smpleloginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    int attempt_count =5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }

    public  void LoginButton(){

        username = (EditText) findViewById(R.id.editText_user);
        password = (EditText) findViewById(R.id.editText_password);
        attempts = (TextView) findViewById(R.id.textView_attempts_count);
        login_btn = (Button) findViewById(R.id.button_login);

        attempts.setText(Integer.toString(attempt_count));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("user")&&
                                password.getText().toString().equals("password")){
                            Toast.makeText(Login.this,"User and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.taylor.smpleloginapp.User"); //Shows next page
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(Login.this,"User and password is incorrect",
                                    Toast.LENGTH_SHORT).show();
                            attempt_count--;
                            attempts.setText(Integer.toString(attempt_count));
                            if(attempt_count==0){
                                login_btn.setEnabled(false);
                            }
                        }
                    }
                }
        );

    }
}