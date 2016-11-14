package com.minhuitianxia.myapplication.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomButtonsController;

import com.google.gson.Gson;
import com.minhuitianxia.myapplication.MainActivity;
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.entity.VipDataEntity;
import com.minhuitianxia.myapplication.ui.VipConsumeActivity;
import com.minhuitianxia.myapplication.ui.VipDataActivity;
import com.minhuitianxia.myapplication.ui.VipPasswordActivity;
import com.minhuitianxia.myapplication.ui.VipRechargeAvtivity;
import com.minhuitianxia.myapplication.ui.Vip_ChongZhiJiLu;
import com.minhuitianxia.myapplication.ui.Vip_XiaoFeiActivity;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.lang.reflect.Field;

/**
 * 会员Fragment
 * Created by Administrator on 2016/7/26.
 */
public class Vip_Fragment extends Fragment implements View.OnClickListener{
    private Button bt1,bt2,bt3,bt4;
    private TextView hyname,tv_balance,tv_integral,quit,tv_yue,tv_jifen;
    private String strname;
    private double strbalance;//余额
    private double strintegral;//积分
    private String strsex;//性别
    private String strphone;//手机号
    private String stridcar;//身份证
    private String strshop;//开卡店铺
    private String strtjname;//推荐人姓名
    private String strtjcar;//推荐人卡号
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vip_activity,container,false);
        vipdata();
        iniView(view);
        return view;

    }

    private void iniView(View view) {
        quit = (TextView) view.findViewById(R.id.quit);
        hyname = (TextView) view.findViewById(R.id.hyname);
        tv_balance = (TextView) view.findViewById(R.id.tv_balance);
        tv_integral = (TextView) view.findViewById(R.id.tv_integral);
        tv_yue = (TextView) view.findViewById(R.id.tv_yue);
        tv_jifen = (TextView) view.findViewById(R.id.tv_jifen);
        bt1 = (Button) view.findViewById(R.id.bt1);
        bt2 = (Button) view.findViewById(R.id.bt2);
        bt3 = (Button) view.findViewById(R.id.bt3);
        bt4 = (Button) view.findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        quit.setOnClickListener(this);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets() ,"fonts/lier.ttf");
        hyname.setTypeface(face);
        tv_balance.setTypeface(face);
        tv_integral.setTypeface(face);
        tv_yue.setTypeface(face);
        tv_jifen.setTypeface(face);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt1://会员基本资料
                intent = new Intent(getActivity(), VipDataActivity.class);
                intent.putExtra("name",strname);
                intent.putExtra("sex",strsex);
                intent.putExtra("tel",strphone);
                intent.putExtra("sfz",stridcar);
                intent.putExtra("shop",strshop);
                intent.putExtra("tjrname",strtjname);
                intent.putExtra("tjrcar",strtjcar);
                startActivity(intent);
                break;
            case R.id.bt2://会员充值记录
                intent = new Intent(getActivity(),Vip_ChongZhiJiLu.class);
                startActivity(intent);
                break;
            case R.id.bt3://会员消费记录
                startActivity(new Intent(getActivity(),Vip_XiaoFeiActivity.class));
                break;
            case R.id.bt4://会员密码修改
                intent = new Intent(getActivity(),VipPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.quit://退出登录
                logout();
                break;
        }
    }
    private void vipdata(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestParams requestParams =
                        new RequestParams(getResources().getString(R.string.http_service_data));
                requestParams.addBodyParameter("hykId",MyApplication.getInstance().getZhangHao());
                requestParams.addBodyParameter("miKey",getResources().getString(R.string.miKey));
                x.http().request(HttpMethod.POST, requestParams, new Callback.CommonCallback<String>(){

                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        VipDataEntity dataEntity = gson.fromJson(result,VipDataEntity.class);
                        boolean issuccess = dataEntity.isSuccess();
                        if (issuccess){
                            strname = dataEntity.getObj().getHyName();
                            strbalance = dataEntity.getObj().getCzye();
                            strintegral = dataEntity.getObj().getJfye();
                            strsex = dataEntity.getObj().getSex();
                            strphone = dataEntity.getObj().getTel();
                            stridcar = dataEntity.getObj().getSfz();
                            strshop = dataEntity.getObj().getUpdateName().toString();
                            strtjname = dataEntity.getObj().getTjrName();
                            strtjcar = dataEntity.getObj().getTjrCardId();
                            hyname.setText(strname+"");
                            tv_balance.setText(strbalance+"");
                            tv_integral.setText(strintegral+"");
                        }else {
                            Toast.makeText(getActivity(), getResources().getString(R.string.login_unusual), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public void onCancelled(CancelledException cex) {

                    }

                    @Override
                    public void onFinished() {

                    }
                });
            }
        }).start();
    }
    private void logout() {
        AlertDialog alertdialog = new AlertDialog.Builder(getActivity()).setTitle("退出登录")
                .setMessage("是否退出当前账号").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        intent.putExtra("isExit","12");
                        startActivity(intent);
                        getActivity().finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        return;
                    }
                }).create();
        alertdialog.show();//显示对话框
    }
}
