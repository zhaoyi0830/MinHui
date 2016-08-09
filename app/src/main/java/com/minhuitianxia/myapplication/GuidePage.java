package com.minhuitianxia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.minhuitianxia.myapplication.Adapter.GuidePage_Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页
 * Created by Administrator on 2016/8/5.
 */
public class GuidePage extends Activity implements View.OnClickListener,ViewPager.OnPageChangeListener{
    private List<View> views;
    private ViewPager vp;
    private LinearLayout ll;
    private Button guide_button;
    //底部小点图片
    private ImageView[] dots ;
    //记录当前选中位置
    private int currentIndex;
    //引导图片资源
    private static final int[] pics = { R.mipmap.welcome3,
            R.mipmap.welcome2, R.mipmap.welcome1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidepage);
        iniView();
    }

    private void iniView() {
        views = new ArrayList<View>();
        dots = new ImageView[pics.length];
        ll = (LinearLayout) findViewById(R.id.ll);
        vp = (ViewPager) findViewById(R.id.guide_viewpager);
        guide_button = (Button) findViewById(R.id.guide_button);
        guide_button.setOnClickListener(this);
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        //初始化引导图片列表
        for(int i=0; i<pics.length; i++) {

            ImageView iv = new ImageView(this);
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);
            views.add(iv);
        }
        //初始化Adapter
        GuidePage_Adapter vpAdapter = new GuidePage_Adapter(views);
        vp.setAdapter(vpAdapter);
        //绑定回调
        vp.setOnPageChangeListener(this);
        iniBottomdot();
    }

    private void iniBottomdot() {
        //循环取得小点图片
        for (int i = 0; i < pics.length; i++) {
            dots[i] = (ImageView) ll.getChildAt(i);
            dots[i].setEnabled(true);//都设为灰色
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);//设置位置tag，方便取出与当前位置对应
        }
        currentIndex = 0;
        dots[currentIndex].setEnabled(false);//设置为白色，即选中状态
    }

    /**
     *设置当前的引导页
     */
    private void setCurView(int position)
    {
        if (position < 0 || position >= pics.length) {
            return;
        }

        vp.setCurrentItem(position);
    }

    /**
     *当前引导小点的选中
     */
    private void setCurDot(int positon)
    {
        if (positon < 0 || positon > pics.length - 1 || currentIndex == positon) {
            return;
        }

        dots[positon].setEnabled(false);
        dots[currentIndex].setEnabled(true);

        currentIndex = positon;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.guide_button:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                finish();
                break;
//            case R.id.ll:
//                int position = (int) v.getTag();
//                setCurView(position);
//                setCurDot(position);
//                break;
        }
    }

    //当前页面被滑动时
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    //当前页面被选择时
    @Override
    public void onPageSelected(int position) {
        //设置底部小点选中状态
        setCurDot(position);
        if(position==(pics.length-1)){
            guide_button.setVisibility(View.VISIBLE);
        }else{
            guide_button.setVisibility(View.GONE);

        }
    }
    //当滑动状态改变时
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
