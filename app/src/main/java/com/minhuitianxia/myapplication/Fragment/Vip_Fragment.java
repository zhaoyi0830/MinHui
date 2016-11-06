package com.minhuitianxia.myapplication.Fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ZoomButtonsController;

import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.ui.VipConsumeActivity;
import com.minhuitianxia.myapplication.ui.VipDataActivity;
import com.minhuitianxia.myapplication.ui.VipPasswordActivity;
import com.minhuitianxia.myapplication.ui.VipRechargeAvtivity;

import java.lang.reflect.Field;

/**
 * 会员Fragment
 * Created by Administrator on 2016/7/26.
 */
public class Vip_Fragment extends Fragment implements View.OnClickListener{
    private LinearLayout lin1;
    private LinearLayout lin2;
    private LinearLayout lin3;
    private LinearLayout lin4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vip,container,false);
        iniView(view);
        return view;

    }

    private void iniView(View view) {
        lin1 = (LinearLayout) view.findViewById(R.id.lin1);
        lin2 = (LinearLayout) view.findViewById(R.id.lin2);
        lin3 = (LinearLayout) view.findViewById(R.id.lin3);
        lin4 = (LinearLayout) view.findViewById(R.id.lin4);
        lin1.setOnClickListener(this);
        lin2.setOnClickListener(this);
        lin3.setOnClickListener(this);
        lin4.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.lin1:
                intent = new Intent(getActivity(), VipDataActivity.class);
                startActivity(intent);
                break;
            case R.id.lin2:
                intent = new Intent(getActivity(), VipConsumeActivity.class);
                startActivity(intent);
                break;
            case R.id.lin3:
                intent = new Intent(getActivity(), VipRechargeAvtivity.class);
                startActivity(intent);
                break;
            case R.id.lin4:
                intent = new Intent(getActivity(), VipPasswordActivity.class);
                startActivity(intent);
                break;
        }
    }
}
