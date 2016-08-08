package com.minhuitianxia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * 欢迎页
 * Created by Administrator on 2016/7/27.
 */
public class WelcomeActivity extends AppCompatActivity {
    SharedPreferences myShard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.minhui_welcome);
        myShard = getSharedPreferences("text",Activity.MODE_PRIVATE);
        String isFirst = myShard.getString("isFirst","");
        if("1".equals(isFirst)){
            new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Intent i = new Intent(WelcomeActivity.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }.sendEmptyMessageDelayed(0,3000);
        }else {
            Intent i = new Intent(this,GuidePage.class);
            startActivity(i);
            iniShard();
            finish();
        }

    }
    private void iniShard(){
        SharedPreferences.Editor shardEdit = myShard.edit();
        shardEdit.putString("isFirst","1");
        shardEdit.commit();
    }
}
