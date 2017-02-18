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

public class SigninActivit extends AppCompatActivity implements View.OnClickListener {
    EditText etID, etPass;
    Button btLogin, btCancel;
    MemberService service;
    MemberBean member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sighnin);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = new MemberBean();
        etID = (EditText) findViewById(R.id.etID);
        etPass = (EditText) findViewById(R.id.etPass);
        btLogin = (Button) findViewById(R.id.btLogin);
        btCancel = (Button) findViewById(R.id.btCancel);
        btLogin.setOnClickListener(this);
        btCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin :
                String id = etID.getText().toString();
                String pass = etPass.getText().toString();
                member.setId(id);
                member.setPass(pass);
                MemberBean result = service.findOne(member);

                if( pass.equals(result.getPass()) ){
                    startActivity(new Intent(SigninActivit.this, ListActivity.class));
                }else{
                }
                break;
            case R.id.btCancel :
                break;
        }

    }
}
