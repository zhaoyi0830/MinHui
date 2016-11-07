package com.minhuitianxia.myapplication;

import android.app.Application;
import android.content.Context;

import com.minhuitianxia.myapplication.entity.VipLoginEntity;

import org.xutils.x;

/**
 * Created by Administrator on 2016/11/7 0007.
 */
public class MyApplication extends Application {
    private VipLoginEntity viplogin;
    private static MyApplication myApplication;
    public static MyApplication getInstance(){
        return myApplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }

    public String getZhangHao(){
        return viplogin.getZhanghao();
    }
    public void setZhanghao(VipLoginEntity vipentity){
        this.viplogin=vipentity;
    }
}
