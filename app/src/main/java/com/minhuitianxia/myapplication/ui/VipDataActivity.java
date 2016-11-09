package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.minhuitianxia.myapplication.Fragment.VipLoginFragment;
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.entity.VipLoginEntity;

/**
 * 会员资料
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipDataActivity extends Activity implements View.OnClickListener{
    private TextView tv_name,tv_car,tv_sex,tv_number,tv_idcar,tv_tname,tv_tcar,tv_shop;
    private ImageView back;
    private TextView title_top_bar;
    private TextView tname,tcar,tsex,tphone,tidcar,ttname,ttcar,tshop;

    private String name;
    private String idcar;
    private String sex;
    private String tel;
    private String sfz;
    private String shop;
    private String tjrname;
    private String tjrcar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_basicinfo);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        sex = intent.getStringExtra("sex");
        tel = intent.getStringExtra("tel");
        sfz = intent.getStringExtra("sfz");
        shop = intent.getStringExtra("shop");
        tjrname = intent.getStringExtra("tjrname");
        tjrcar = intent.getStringExtra("tjrcar");
        init();
    }

    private void init() {
        title_top_bar = (TextView) findViewById(R.id.title_top_bar);
        back = (ImageView) findViewById(R.id.back);

        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_car = (TextView) findViewById(R.id.tv_hycar);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        tv_number = (TextView) findViewById(R.id.tv_phone);
        tv_idcar = (TextView) findViewById(R.id.tv_idcar);
        tv_tname = (TextView) findViewById(R.id.tv_tname);
        tv_tcar = (TextView) findViewById(R.id.tv_tcar);
        tv_shop = (TextView) findViewById(R.id.tv_shop);

        tname = (TextView) findViewById(R.id.name);
        tcar = (TextView) findViewById(R.id.car);
        tsex = (TextView) findViewById(R.id.sex);
        tphone = (TextView) findViewById(R.id.phone);
        tidcar = (TextView) findViewById(R.id.idcar);
        ttname = (TextView) findViewById(R.id.tname);
        ttcar = (TextView) findViewById(R.id.tcar);
        tshop = (TextView) findViewById(R.id.shop);

        Typeface face = Typeface.createFromAsset(getAssets() ,"fonts/lier.ttf");
        tv_name.setTypeface(face);
        tv_car.setTypeface(face);
        tv_sex.setTypeface(face);
        tv_number.setTypeface(face);
        tv_idcar.setTypeface(face);
        tv_tcar.setTypeface(face);
        tv_shop.setTypeface(face);
        tv_tname.setTypeface(face);

        tname.setTypeface(face);
        tcar.setTypeface(face);
        tsex.setTypeface(face);
        tphone.setTypeface(face);
        tidcar.setTypeface(face);
        ttname.setTypeface(face);
        ttcar.setTypeface(face);
        tshop.setTypeface(face);

        title_top_bar.setText("会员基本资料");
        tv_name.setText(name+"");
        tv_car.setText(MyApplication.getInstance().getZhangHao());
        if ("0".equals(sex)){
            tv_sex.setText("男");
        }else if("1".equals(sex)){
            tv_sex.setText("女");
        }
        tv_number.setText(tel+"");
        tv_idcar.setText(sfz+"");
        tv_shop.setText(shop+"");
        tv_tname.setText(tjrname+"");
        tv_tcar.setText(tjrcar+"");
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
