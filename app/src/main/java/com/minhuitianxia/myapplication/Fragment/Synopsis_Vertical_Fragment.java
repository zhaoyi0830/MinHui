package com.minhuitianxia.myapplication.Fragment;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ZoomButtonsController;

import com.minhuitianxia.myapplication.Adapter.GuidePage_Adapter;
import com.minhuitianxia.myapplication.Adapter.VerticalPager_Adapter;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.VerticalPager.PagerAdapter;
import com.minhuitianxia.myapplication.VerticalPager.VerticalPagerAdapter;
import com.minhuitianxia.myapplication.VerticalPager.VerticalViewPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *s企业介绍 竖向滑动
 * Created by Administrator on 2016/8/6.
 */
public class Synopsis_Vertical_Fragment extends Fragment implements VerticalViewPager.OnPageChangeListener{
    private VideoView video;
    private ImageView back,zanting;
//    private ImageView imag_start;

    private String currUrl;
    private int isFirstUrl =1;
    List<View> listview;
    private static final int[] pics = { R.mipmap.qiye2,
            R.mipmap.qiye1, R.mipmap.qiye3,
            R.mipmap.qiye4 };
    private VerticalViewPager pager;
    private ImageView t1_next,t2_next,t3_next,t4_next;
    private List<View> pagers = new ArrayList<View>();
    private VerticalFragementPagerAdapter mAdapter;
    private ViewPager mPager;
    private int preIndex = 0;
    int i;
    private Animation animationBottom;

    private Boolean videoo = true;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_main,container,false);
        iniView(view);
        video.start();
        return view;
    }

    private void iniView(View view) {
        video = (VideoView) view.findViewById(R.id.video);
        back = (ImageView) view.findViewById(R.id.back);
//        imag_start = (ImageView) view.findViewById(R.id.imag_start);
        animationBottom = AnimationUtils.loadAnimation(getActivity(), R.anim.tutorail_bottom);
        listview = new ArrayList<>();
        pager=(VerticalViewPager)view.findViewById(R.id.pager);
        t2_next = (ImageView) view.findViewById(R.id.t2_next);
//        zanting = (ImageView) view.findViewById(R.id.zanting);
        t2_next.startAnimation(animationBottom);
//        zanting.setVisibility(View.GONE);

        String uri = "android.resource://" + getActivity().getPackageName()+ "/" + R.raw.min_hui;
        video.setVideoURI(Uri.parse(uri));
//        if (videoo){
//            video.start();
//            videoo = false;
//        }
        //播放结束侦听
//        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            public void onCompletion(MediaPlayer mp) {
//                video.setVisibility(View.INVISIBLE);
//
//            }
//        });
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
        //暂停
        video.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if (videoo){
//                        imag_start.setVisibility(View.GONE);
                        video.start();
//                        zanting.setVisibility(View.GONE);
                        videoo=false;
                    }else{
//                        imag_start.setVisibility(View.VISIBLE);
                        video.pause();
//                        zanting.setVisibility(View.VISIBLE);
                        videoo=true;
                    }
                }
                return true;
            }
        });

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            video.pause();
//            imag_start.setVisibility(View.VISIBLE);
        }else{
            video.start();
//            imag_start.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 3){
            t2_next.setVisibility(View.GONE);
            t2_next.clearAnimation();
        }else if (position != 3){
            t2_next.setVisibility(View.VISIBLE);
            t2_next.startAnimation(animationBottom);
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
