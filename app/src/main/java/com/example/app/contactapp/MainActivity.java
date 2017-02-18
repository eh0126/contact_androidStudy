package com.example.app.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app.contactapp.presentation.SigninActivit;
import com.example.app.contactapp.presentation.SignupActivity;
import com.example.app.contactapp.service.MemberService;
import com.example.app.contactapp.service.MemberServiceImpl;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btSignUp, btSignIn;
    MemberService service;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btSignUp = (Button) findViewById(R.id.btSignUp);
        btSignIn = (Button) findViewById(R.id.btSignIn);
        btSignIn.setOnClickListener(this);
        btSignUp.setOnClickListener(this);
        service = new MemberServiceImpl(this.getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSignIn:
                Toast.makeText(MainActivity.this, "Go to Add", Toast.LENGTH_LONG).show();
                startActivity( new Intent(MainActivity.this, SignupActivity.class) );
                break;
            case R.id.btSignUp :
                Toast.makeText(MainActivity.this, "Go to Login", Toast.LENGTH_LONG).show();
                startActivity( new Intent(MainActivity.this, SigninActivit.class) );
                break;
        }
    }
}
