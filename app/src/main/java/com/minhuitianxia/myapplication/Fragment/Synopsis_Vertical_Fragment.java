package com.minhuitianxia.myapplication.Fragment;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.minhuitianxia.myapplication.Adapter.GuidePage_Adapter;
import com.minhuitianxia.myapplication.Adapter.VerticalPager_Adapter;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.VerticalPager.PagerAdapter;
import com.minhuitianxia.myapplication.VerticalPager.VerticalPagerAdapter;
import com.minhuitianxia.myapplication.VerticalPager.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 *s企业介绍 竖向滑动
 * Created by Administrator on 2016/8/6.
 */
public class Synopsis_Vertical_Fragment extends Fragment implements VerticalViewPager.OnPageChangeListener{
    private VerticalViewPager pager;
    List<View> listview;
    private static final int[] pics = { R.mipmap.qiye2,
            R.mipmap.qiye1, R.mipmap.qiye3,
            R.mipmap.qiye4 };

    private ImageView t1_next,t2_next,t3_next,t4_next;
    private List<View> pagers = new ArrayList<View>();
    private VerticalFragementPagerAdapter mAdapter;
    private ViewPager mPager;
    private int preIndex = 0;

    int i;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vertical_viewpager,null,false);
        iniView(view);
        return view;
    }

    private void iniView(View view) {
        listview = new ArrayList<>();
        pager=(VerticalViewPager)view.findViewById(R.id.pager);
        t2_next = (ImageView) view.findViewById(R.id.t2_next);


//        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.synppsispage2, null);
//        t1_next = (ImageView) view1.findViewById(R.id.t2_next);
//        pagers.add(view1);
//        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.synopsispage1, null);
//        t2_next = (ImageView) view.findViewById(R.id.t1_next);
//        pagers.add(view2);
//        View view3 = LayoutInflater.from(getContext()).inflate(R.layout.synppsispage3, null);
//        t3_next = (ImageView) view2.findViewById(R.id.t3_next);
//        pagers.add(view3);
//        View view4 = LayoutInflater.from(getContext()).inflate(R.layout.synppsispage4, null);
////        t4_next = (ImageView) view2.findViewById(R.id.t4_next);
//        pagers.add(view4);
//        mAdapter = new VerticalFragementPagerAdapter();
//        pager.setAdapter(mAdapter);

        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        for(i=0; i<pics.length; i++) {
            LinearLayout myLinear  = new LinearLayout(getActivity());
            myLinear.setBackgroundColor(Color.WHITE);
            ImageView iv = new ImageView(getActivity());
            iv.setLayoutParams(mParams);
            iv.setImageResource(pics[i]);
            myLinear.addView(iv);
            listview.add(myLinear);


        }
        //初始化Adapter
        VerticalPager_Adapter vpAdapter = new VerticalPager_Adapter(listview);
        pager.setAdapter(vpAdapter);
        pager.setOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 3){
            t2_next.setVisibility(View.GONE);
        }else if (position != 3){
            t2_next.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class VerticalFragementPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(pagers.get(position));
            return pagers.get(position);

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

}
