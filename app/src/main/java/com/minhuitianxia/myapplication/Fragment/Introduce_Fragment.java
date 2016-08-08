package com.minhuitianxia.myapplication.Fragment;

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
import android.widget.ProgressBar;
import android.widget.ZoomButtonsController;

import com.minhuitianxia.myapplication.R;

import java.lang.reflect.Field;

/**
 * 介绍Fragment
 * Created by Administrator on 2016/7/26.
 */
public class Introduce_Fragment extends Fragment {
    private WebView introuce_webView;
    private ImageView back;
    private ProgressBar pb_goose;

    private String HomeURL ="http://www.minhuitianxia.top";
//    private String currUrl = "http://shop.55cicai.cn/minhui/";
    private String currUrl;
    private int isFirstUrl =1;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.introuce_fragment,container,false);
        iniView(view);
        return view;
    }

    private void iniView(View view) {
        introuce_webView = (WebView) view.findViewById(R.id.introuce_webView);
        pb_goose = (ProgressBar) view.findViewById(R.id.pb_goose);
        back = (ImageView) view.findViewById(R.id.back);
        webviewsettings();
        //加载需要显示的网页
        introuce_webView.loadUrl(HomeURL);
        //设置Web视图
        introuce_webView.setWebViewClient(new HelloWebViewClient());
        introuce_webView.setWebChromeClient(new WebChromeClient());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introuce_webView.goBack();
            }
        });
    }
    private void webviewsettings() {
        introuce_webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        //设置WebView属性，能够执行Javascript脚本
        introuce_webView.getSettings().setJavaScriptEnabled(true);
        // 可任意比例缩放
        introuce_webView.getSettings().setUseWideViewPort(true);
        //放大缩小
        introuce_webView.getSettings().setSupportZoom(true);
        introuce_webView.getSettings().setBuiltInZoomControls(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            introuce_webView.getSettings().setDisplayZoomControls(false);
        }
        setZoomControlGone(introuce_webView);
        introuce_webView.getSettings().setDomStorageEnabled(true);
        introuce_webView.getSettings().setUserAgentString("1");
        //webview加载模式
        introuce_webView.getSettings().setLoadWithOverviewMode(true);
        introuce_webView.getSettings().setPluginState(WebSettings.PluginState.ON);
    }
    //实现放大缩小控件隐藏
    public void setZoomControlGone(View view) {
        Class classType;
        Field field;
        try {
            classType = WebView.class;
            field = classType.getDeclaredField("mZoomButtonsController");
            field.setAccessible(true);
            ZoomButtonsController mZoomButtonsController = new ZoomButtonsController(view);
            mZoomButtonsController.getZoomControls().setVisibility(View.GONE);
            try {
                field.set(view, mZoomButtonsController);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    //Web视图
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
//            String nowUrl = view.getUrl();
//            String originaUrl = view.getOriginalUrl();
//            Log.i("<===>originaUrl", "onPageFinished: "+originaUrl);
            pb_goose.setVisibility(View.GONE);
            if(isFirstUrl==1){
                currUrl=url;
                isFirstUrl=2;
            }
            if(url!=null){
                if(currUrl.equals(url)){
                    back.setVisibility(View.GONE);
                }else{
                    back.setVisibility(View.VISIBLE);

                }
            }else{
                back.setVisibility(View.GONE);
            }
            super.onPageFinished(view, url);
        }
    }


}
