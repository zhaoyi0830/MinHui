package com.minhuitianxia.myapplication;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.minhuitianxia.myapplication.Fragment.Introduce_Fragment;
import com.minhuitianxia.myapplication.Fragment.Mall_Fragment;
import com.minhuitianxia.myapplication.Fragment.Merchant_Fragment;
import com.minhuitianxia.myapplication.Fragment.Synopsis_Vertical_Fragment;
import com.minhuitianxia.myapplication.Fragment.VipLoginFragment;
import com.minhuitianxia.myapplication.Fragment.Vip_Fragment;
import com.minhuitianxia.myapplication.MyOnClick.MyButton;
import com.minhuitianxia.myapplication.MyOnClick.MyOnClickListener;
import com.minhuitianxia.myapplication.Utils.FragmentTag;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private RadioButton rb_introduce;//介绍
    //    private RadioButton rb_merchant;//积分
    private RadioButton rb_vip;//会员
    private RadioButton rb_mall;//商城
    private RadioGroup rgp_main;
    private Introduce_Fragment introuce;
    private Merchant_Fragment merchant;
    private VipLoginFragment vip;
//    private Vip_Fragment vip_fragment;
    private Mall_Fragment mallF;
    private Synopsis_Vertical_Fragment synopsisF;
    private long firstTime = 0;//第一次按返回键的时间
    private int isCurrF;
    private boolean isCanBack = false;

    /**
     * 当前Fragment的key
     */
    private FragmentTag mCurrentTag;
    private FragmentTag mTAG_MALL;
    private FragmentTag TAG_VIP;
    private FragmentTag mTAG_SYNOPSIS;
    private FragmentTag mTAG_VIPINFO;
    /**
     * 选项卡按钮数组
     */
    private ArrayList<RadioButton> mBtnTabs;
    /**
     * 当前Fragment
     */
    private Fragment mCurrentFragment;

    private RadioGroup radioGroup;
    private String isExit;
    private Boolean ISLogin = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intentGet = getIntent();
        isExit = intentGet.getStringExtra("isExit");
        iniView();

        if (savedInstanceState == null) {
            if ("12".equals(isExit)) {
                // 记录当前Fragment
                mCurrentTag = FragmentTag.TAG_VIP;
                mTAG_MALL = FragmentTag.TAG_MALL;
                mTAG_SYNOPSIS = FragmentTag.TAG_SYNOPSIS;
                mTAG_VIPINFO = FragmentTag.TAG_VIPINFO;

                mCurrentFragment = new VipLoginFragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.main_fragment, mCurrentFragment,
                                mCurrentTag.getTag()).add(R.id.main_fragment, mallF, mTAG_MALL.getTag())
                        .add(R.id.main_fragment, synopsisF, mTAG_SYNOPSIS.getTag())
                        .hide(mallF).hide(synopsisF).show(mCurrentFragment).commit();

            } else {
                // 记录当前Fragment
                mCurrentTag = FragmentTag.TAG_SYNOPSIS;
                mTAG_MALL = FragmentTag.TAG_MALL;
                TAG_VIP = FragmentTag.TAG_VIP;
                mTAG_VIPINFO = FragmentTag.TAG_VIPINFO;

                mCurrentFragment = new Synopsis_Vertical_Fragment();
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.main_fragment, mCurrentFragment,mCurrentTag.getTag())
                        .add(R.id.main_fragment, mallF, mTAG_MALL.getTag())
                        .add(R.id.main_fragment, vip, TAG_VIP.getTag())
//                        .add(R.id.main_fragment,vip_fragment,mTAG_VIPINFO.getTag())
                        .hide(mallF).hide(vip).show(mCurrentFragment).commit();

            }
        }
        vip.setOnButtonClick(new VipLoginFragment.OnButtonClick() {
            @Override
            public void onClick(View view) {
                ISLogin = true;
                switchFragment(FragmentTag.TAG_VIPINFO);
            }
        });

    }

    private void iniView() {
        radioGroup = ((RadioGroup) findViewById(R.id.rgp_main));
        radioGroup.check(R.id.rb_introduce);

        rb_introduce = (RadioButton) findViewById(R.id.rb_introduce);
//        rb_merchant = (RadioButton) findViewById(R.id.rb_merchant);
        rb_vip = (RadioButton) findViewById(R.id.rb_vip);
        rb_mall = (RadioButton) findViewById(R.id.rb_mall);
        rgp_main = (RadioGroup) findViewById(R.id.rgp_main);

        introuce = new Introduce_Fragment();//公司介绍
        merchant = new Merchant_Fragment();//积分
        vip = new VipLoginFragment();//会员
        mallF = new Mall_Fragment();//商城
//        vip_fragment = new Vip_Fragment();
        synopsisF = new Synopsis_Vertical_Fragment();//竖向滑动公司简介
        if ("12".equals(isExit)) {
            rb_vip.setChecked(true);
        } else {
            rb_introduce.setChecked(true);
        }
        rgp_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_mall://商城
                        switchFragment(FragmentTag.TAG_MALL);
                        radioGroup.check(R.id.rb_mall);
                        isCurrF = 1;
                        break;
                    case R.id.rb_introduce://介绍
                        switchFragment(FragmentTag.TAG_SYNOPSIS);
                        radioGroup.check(R.id.rb_introduce);
                        isCurrF = 2;
                        break;
                    case R.id.rb_vip://会员
                        if(ISLogin){
                            switchFragment(FragmentTag.TAG_VIPINFO);
                            radioGroup.check(R.id.rb_vip);

                        }else{
                            switchFragment(FragmentTag.TAG_VIP);
                            radioGroup.check(R.id.rb_vip);

                        }
                        isCurrF = 3;
                        break;

                }
            }
        });

    }

    /**
     * 初始化fragment
     **/
    public void switchFragment(FragmentTag to) {
        if (!mCurrentTag.equals(to)) {
            Fragment currentF = getSupportFragmentManager().findFragmentByTag(
                    mCurrentTag.getTag());
            Fragment toF = getSupportFragmentManager().findFragmentByTag(to.getTag());
            if (null == toF) { // 先判断是否被add过
                try {
                    // 未add过，使用反射新建一个Fragment并add到FragmentManager中
                    toF = (Fragment) Class.forName(to.getTag()).newInstance();
                    getSupportFragmentManager().beginTransaction().hide(currentF)
                            .add(R.id.main_fragment, toF, to.getTag()).commit(); // 隐藏当前的fragment，add下一个到Activity中
                    // 切换按钮动画
//                    switchAnimation(to.ordinal());
                    // 更新当前Fragment
                    mCurrentTag = to;
                    mCurrentFragment = toF;
                } catch (Exception e) {
                }
            } else {
                // add过，直接hide当前，并show出目标Fragment
                getSupportFragmentManager().beginTransaction().hide(currentF)
                        .show(toF).commit(); // 隐藏当前的fragment，显示下一个
                // 切换按钮动画
//                switchAnimation(to.ordinal());
                // 更新当前Fragment
                mCurrentTag = to;
                mCurrentFragment = toF;
            }
        }
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                if (isCurrF == 1) {
                    isCanBack = mallF.onBackPressedFfragment();
                }
                if (!isCanBack) {
                    Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = System.currentTimeMillis();
                }
            } else {
                System.exit(0);
            }
        }
        return false;
    }



}
