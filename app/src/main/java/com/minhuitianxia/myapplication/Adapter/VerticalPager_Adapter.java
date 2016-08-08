package com.minhuitianxia.myapplication.Adapter;

import android.view.View;
import android.view.ViewGroup;

import com.minhuitianxia.myapplication.VerticalPager.PagerAdapter;
import com.minhuitianxia.myapplication.VerticalPager.VerticalViewPager;

import java.util.List;

/**
 * 引导页的适配器
 * Created by Administrator on 2016/8/5.
 */
public class VerticalPager_Adapter extends PagerAdapter {
    //界面列表
    private List<View> views;

    public VerticalPager_Adapter(List<View> views){
        this.views = views;
    }


    @Override
    public void destroyItem(View container, int position, Object object) {
        ((VerticalViewPager)container).removeView(views.get(position));
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);

    }

    @Override
    public int getCount() {
        if(views!=null){
            return views.size();
        }else{
            return 0;
        }
    }

    //初始化position位置的界面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position),0);
        return views.get(position);
    }
    //判断是否由对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==object);
    }
}
