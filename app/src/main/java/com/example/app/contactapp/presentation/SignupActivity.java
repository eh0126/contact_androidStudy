package com.example.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.contactapp.R;
import com.example.app.contactapp.domain.MemberBean;
import com.example.app.contactapp.service.MemberService;
import com.example.app.contactapp.service.MemberServiceImpl;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etID, etPass, etName, etPhone, etAddr;
    Button btSubmit, btCancel;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();
        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etAddr = (EditText) findViewById(R.id.etAddr);
        btSubmit = (Button) findViewById(R.id.btSubmit);
        btCancel = (Button) findViewById(R.id.btCancel);
        btSubmit.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSubmit:
                member.setId(etID.getText().toString());
                member.setPass(etPass.getText().toString());
                member.setName(etName.getText().toString());
                member.setPhone(etPhone.getText().toString());
                member.setAddr(etAddr.getText().toString());

                service.add(member);
                Intent intent = new Intent(SignupActivity.this, SigninActivit.class);
                startActivity(intent);
                break;
            case R.id.btCancel:
                break;

        }
    }
}
