package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.minhuitianxia.myapplication.Fragment.VipLoginFragment;
import com.minhuitianxia.myapplication.MainActivity;
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.entity.VipDataEntity;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 会员信息
 * Created by Administrator on 2016/11/6 0006.
 */
public class VipBasicActivity extends Activity implements View.OnClickListener{

    private Button bt1,bt2,bt3,bt4;
    private TextView hyname,tv_balance,tv_integral,quit;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_activity);
        vipdata();
        init();

    }

    private void init() {
        quit = (TextView) findViewById(R.id.quit);
        hyname = (TextView) findViewById(R.id.hyname);
        tv_balance = (TextView) findViewById(R.id.tv_balance);
        tv_integral = (TextView) findViewById(R.id.tv_integral);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt4.setOnClickListener(this);
        quit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.bt1:
                intent = new Intent(this, VipDataActivity.class);
                intent.putExtra("name",strname);
                intent.putExtra("sex",strsex);
                intent.putExtra("tel",strphone);
                intent.putExtra("sfz",stridcar);
                intent.putExtra("shop",strshop);
                intent.putExtra("tjrname",strtjname);
                intent.putExtra("tjrcar",strtjcar);
                startActivity(intent);
                break;
            case R.id.bt2:
                intent = new Intent(this,Vip_ChongZhiJiLu.class);
                startActivity(intent);
                break;
            case R.id.bt3:
                break;
            case R.id.bt4:
                intent = new Intent(this,VipPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.quit:
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
                requestParams.addBodyParameter("hykId", MyApplication.getInstance().getZhangHao());
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
                            strshop = dataEntity.getObj().getUpdateName();
                            strtjname = dataEntity.getObj().getTjrName();
                            strtjcar = dataEntity.getObj().getTjrCardId();
                            hyname.setText(strname);
                            tv_balance.setText(strbalance+"");
                            tv_integral.setText(strintegral+"");
                        }else {
                            Toast.makeText(VipBasicActivity.this, getResources().getString(R.string.login_unusual), Toast.LENGTH_SHORT).show();
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
        AlertDialog alertdialog = new AlertDialog.Builder(this).setTitle("退出登录")
                .setMessage("是否退出当前账号").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(VipBasicActivity.this, MainActivity.class);
                        intent.putExtra("isExit","12");
                        startActivity(intent);
                        finish();
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
