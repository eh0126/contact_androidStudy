package com.example.app.contactapp.service;

import android.content.Context;

import com.example.app.contactapp.dao.MemberDao;
import com.example.app.contactapp.domain.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2010 on 2017-02-04.
 */

public class MemberServiceImpl implements  MemberService{
    MemberDao dao;
    public MemberServiceImpl(Context context) {
        dao = new MemberDao(context);
    }

    @Override
    public void add(MemberBean bean) {
        dao.add(bean);
    }

    @Override
    public MemberBean findOne(MemberBean bean) {
        return dao.findOne(bean);
    }

    @Override
    public boolean login(MemberBean bean) {
        boolean flag = false;
        MemberBean member = this.findOne(bean);
        if(!member.getId().equals("fail") && member.getPass().equals(bean.getPass()) ){
            flag  = true;
        }
        return flag;
    }

    @Override
    public ArrayList<MemberBean> findSome(String keyword) {
        return null;
    }

    @Override
    public ArrayList<MemberBean> list() {

        return dao.selectAll();
    }

    @Override
    public void update(MemberBean bean) {

    }

    @Override
    public void delete(MemberBean bean) {
        dao.delete(bean);
    }
}
