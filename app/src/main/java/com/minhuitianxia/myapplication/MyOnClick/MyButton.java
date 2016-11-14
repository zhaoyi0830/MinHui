package com.minhuitianxia.myapplication.MyOnClick;

/**
 * Created by Administrator on 2016/11/14 0014.
 */
public class MyButton {
    private MyOnClickListener myOnClickListener;

    public void setMyOnClickListener(MyOnClickListener listener){
        this.myOnClickListener=listener;
    }

    public void doClick(){
        myOnClickListener.onclick();
    }
}
