package com.example.app.contactapp.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app.contactapp.R;
import com.example.app.contactapp.domain.MemberBean;
import com.example.app.contactapp.service.MemberService;
import com.example.app.contactapp.service.MemberServiceImpl;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {
    Button btList, btUpdate, btCall, btMessage, btDelete;
    TextView tvID, tvName, tvPhone, tvAddr, tvEmail;
    ImageView ivProfile;
    MemberService service;
    MemberBean member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this);
        member = new MemberBean();
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        member.setId(id);
        member = service.findOne(member);

        btList = (Button) findViewById(R.id.btList);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btCall = (Button) findViewById(R.id.btCall);
        btMessage = (Button) findViewById(R.id.btMessage);
        btDelete = (Button) findViewById(R.id.btDelete);
        tvID = (TextView) findViewById(R.id.tvID);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        ivProfile = (ImageView) findViewById(R.id.ivProfile);


        int temp = getResources().getIdentifier(this.getPackageName()+":drawable/default_profile", null, null);
        ivProfile.setImageDrawable(
                getResources()
                .getDrawable(temp, this.getApplicationContext().getTheme()));

        tvID.setText(member.getId());
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
        tvAddr.setText(member.getAddr());
        tvEmail.setText(member.getEmail());

        btList.setOnClickListener(this);
        btUpdate.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btMessage.setOnClickListener(this);
        btDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btList :
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
            case R.id.btUpdate :
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                intent.putExtra("id", "hong");
                startActivity(intent);
                break;
            case R.id.btCall :

                break;
            case R.id.btMessage :

                break;
            case R.id.btDelete :

                break;
        }
    }
}
