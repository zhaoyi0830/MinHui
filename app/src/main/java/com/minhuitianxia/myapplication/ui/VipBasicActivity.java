package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.minhuitianxia.myapplication.R;

/**
 * Created by Administrator on 2016/11/6 0006.
 */
public class VipBasicActivity extends Activity implements View.OnClickListener{

    private Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_activity);
        init();
    }

    private void init() {
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt1:
                intent = new Intent(this, VipDataActivity.class);
                startActivity(intent);
                break;
            case R.id.bt2:
                intent = new Intent(this,VipRechargeAvtivity.class);
                startActivity(intent);
                break;
            case R.id.bt3:
                break;
            case R.id.bt4:
                intent = new Intent(this,VipPasswordActivity.class);
                startActivity(intent);
                break;

        }
    }
}
