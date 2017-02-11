package com.example.app.contactapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.app.contactapp.R;
import com.example.app.contactapp.domain.MemberBean;
import com.example.app.contactapp.service.MemberService;
import com.example.app.contactapp.service.MemberServiceImpl;

public class MemberActivity extends AppCompatActivity implements View.OnClickListener {
    Button btAdd, btFindeById, btFindByName, btList, btUpdate, btDelete;
    MemberService service;
    MemberBean member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        btAdd = (Button) findViewById(R.id.btAdd);
        btFindeById = (Button) findViewById(R.id.btFindeById);
        btFindByName = (Button) findViewById(R.id.btFindByName);
        btList = (Button) findViewById(R.id.btList);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btAdd.setOnClickListener(this);
        btFindeById.setOnClickListener(this);
        btFindByName.setOnClickListener(this);
        btList.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        service = new MemberServiceImpl();
        member = new MemberBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAdd :
                service.add(member);
                break;
            case R.id.btFindeById :
                service.findOne(member);
                break;
            case R.id.btFindByName :
                service.findSome("");
                break;
            case R.id.btList :
                service.list();
                break;
            case R.id.btUpdate :
                service.update(member);
                break;
            case R.id.btDelete :
                service.delete(member);
                break;
        }

    }
}
