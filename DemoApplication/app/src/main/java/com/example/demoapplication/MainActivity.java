package com.example.demoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFunction(View view){

        EditText editTextUserName = (EditText)findViewById(R.id.editTextUserName);
        EditText editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        Log.i("Info","Button Clicked");

        Log.i("User name" , editTextUserName.getText().toString());
        Log.i("password",editTextPassword.getText().toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}