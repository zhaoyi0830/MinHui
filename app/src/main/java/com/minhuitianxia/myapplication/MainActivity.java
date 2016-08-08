package com.minhuitianxia.myapplication;

import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.minhuitianxia.myapplication.Fragment.Introduce_Fragment;
import com.minhuitianxia.myapplication.Fragment.Mall_Fragment;
import com.minhuitianxia.myapplication.Fragment.Merchant_Fragment;
import com.minhuitianxia.myapplication.Fragment.Synopsis_Vertical_Fragment;
import com.minhuitianxia.myapplication.Fragment.Vip_Fragment;

public class MainActivity extends AppCompatActivity {
    private RadioButton rb_introduce;//介绍
//    private RadioButton rb_merchant;//积分
    private RadioButton rb_vip;//会员
    private RadioButton rb_mall;//商城
    private RadioGroup rgp_main;
    private Introduce_Fragment introuce;
    private Merchant_Fragment merchant;
    private Vip_Fragment vip;
    private Mall_Fragment mallF;
    private Synopsis_Vertical_Fragment synopsisF;
    private long firstTime =0;//第一次按返回键的时间
    private int isCurrF ;
    private boolean isCanBack =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniView();
    }
    private void iniView() {
        rb_introduce = (RadioButton) findViewById(R.id.rb_introduce);
//        rb_merchant = (RadioButton) findViewById(R.id.rb_merchant);
        rb_vip = (RadioButton) findViewById(R.id.rb_vip);
        rb_mall = (RadioButton) findViewById(R.id.rb_mall);
        rgp_main = (RadioGroup) findViewById(R.id.rgp_main);
        introuce = new Introduce_Fragment();//公司介绍
        merchant = new Merchant_Fragment();//积分
        vip = new Vip_Fragment();//会员
        mallF = new Mall_Fragment();//商城
        synopsisF = new Synopsis_Vertical_Fragment();//竖向滑动公司简介
        rb_introduce.setChecked(true);
        initFragment(synopsisF);
        rgp_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rb_mall://商城
                        initFragment(mallF);
                        isCurrF=1;
                        break;
                    case R.id.rb_introduce://介绍
                        initFragment(synopsisF);
                        isCurrF = 2;
                        break;
                    case R.id.rb_vip://会员
                        initFragment(vip);
                        isCurrF = 3;
                        break;
                }
            }
        });

    }

    /**
     * 初始化fragment
     **/
    public void initFragment(Fragment mFragment){
        android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.main_fragment, mFragment);
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(System.currentTimeMillis()-firstTime>2000){
                if(isCurrF==1){
                    isCanBack=mallF.onBackPressedFfragment();
                }else if(isCurrF==3){
                    isCanBack=vip.onBackPressedFfragment();
                }
                if(!isCanBack){
                    Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = System.currentTimeMillis();
                }
            }else{
                System.exit(0);
            }
        }
        return false;
    }

}
