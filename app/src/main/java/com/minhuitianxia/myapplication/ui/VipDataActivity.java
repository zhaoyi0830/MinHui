package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.minhuitianxia.myapplication.R;

/**
 * 会员资料
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipDataActivity extends Activity implements View.OnClickListener{
    private TextView tv_name,tv_car,tv_sex,tv_number,tv_idcar,tv_tname,tv_tcar,tv_shop;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_basicinfo);
        init();
    }

    private void init() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_car = (TextView) findViewById(R.id.tv_hycar);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_number = (TextView) findViewById(R.id.tv_phone);
        tv_idcar = (TextView) findViewById(R.id.tv_idcar);
        tv_tname = (TextView) findViewById(R.id.tv_tname);
        tv_tcar = (TextView) findViewById(R.id.tv_tcar);
        tv_shop = (TextView) findViewById(R.id.tv_shop);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
