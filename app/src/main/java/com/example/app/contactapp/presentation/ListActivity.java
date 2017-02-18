package com.example.app.contactapp.presentation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.app.contactapp.R;
import com.example.app.contactapp.domain.MemberBean;
import com.example.app.contactapp.service.MemberService;
import com.example.app.contactapp.service.MemberServiceImpl;
import com.example.app.contactapp.util.MemberAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    MemberService service;
    ListView lvMemberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        lvMemberlist = (ListView) findViewById(R.id.lvMemberlist);
        ArrayList<MemberBean> list = service.list();
        lvMemberlist.setAdapter(new MemberAdapter(list, this));
        Log.d("리스트에 담긴 값 : ", String.valueOf(list.size()) );

        lvMemberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lvMemberlist.getItemAtPosition(i);
                MemberBean member = (MemberBean) o;
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });
        lvMemberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                Object o = lvMemberlist.getItemAtPosition(i);
                final MemberBean member = (MemberBean) o;
                new AlertDialog.Builder(ListActivity.this)
                        .setTitle("삭제 ? ")
                        .setMessage("정말로 삭제하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.delete(member);
                                Intent intent = new Intent(ListActivity.this, ListActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;
            }
        });
    }
}
