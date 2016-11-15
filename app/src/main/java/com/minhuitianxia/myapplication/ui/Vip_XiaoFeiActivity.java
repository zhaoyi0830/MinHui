package com.minhuitianxia.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.minhuitianxia.myapplication.Adapter.VipChongZhi_Adapter;
import com.minhuitianxia.myapplication.Adapter.VipXiaoFei_Adapter;
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.Utils.IsNetWork;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Entity;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Obj;
import com.minhuitianxia.myapplication.entity.VipLoginEntity;
import com.minhuitianxia.myapplication.entity.VipXiaoFei_Entity;
import com.minhuitianxia.myapplication.entity.VipXiaoFei_Obj;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员消费记录
 * Created by Administrator on 2016/11/9 0009.
 */
public class Vip_XiaoFeiActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title_top_bar;
    private ImageView back;
    private TextView mTv_xfcode;
    private TextView mTv_xfmoney;
    private TextView mTv_xfshop;
    private TextView mTv_xftime;
    private ListView mLv_xfjilu;

    private VipXiaoFei_Entity vipentity;
    private List<VipXiaoFei_Obj> listObj = new ArrayList<>();
    private VipXiaoFei_Adapter vipadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_xiaofei);
        iniView();
        if(IsNetWork.isNetworkAvailable(this)){
            getHttp();
        }else{
            Toast.makeText(this,getResources().getString(R.string.Fail_Network), Toast.LENGTH_SHORT).show();
        }
    }

    private void iniView() {
        mTv_xfcode = (TextView) findViewById(R.id.tv_xfcode);
        mTv_xfmoney = (TextView) findViewById(R.id.tv_xfmoney);
        mTv_xfshop = (TextView) findViewById(R.id.tv_xfshop);
        mTv_xftime = (TextView) findViewById(R.id.tv_xftime);
        mLv_xfjilu = (ListView) findViewById(R.id.lv_xfjilu);
        back = (ImageView) findViewById(R.id.back);
        title_top_bar = (TextView) findViewById(R.id.title_top_bar);
        title_top_bar.setText("会员消费记录");
        back.setOnClickListener(this);
        vipadapter = new VipXiaoFei_Adapter(listObj,this);
        mLv_xfjilu.setAdapter(vipadapter);
        vipadapter.notifyDataSetChanged();

    }
    private void getHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final RequestParams requestParams =
                        new RequestParams(getResources().getString(R.string.http_service_xiaofei));
                requestParams.addBodyParameter("hykId", MyApplication.getInstance().getZhangHao());
                requestParams.addBodyParameter("miKey",getResources().getString(R.string.miKey));
                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        vipentity =gson.fromJson(result,VipXiaoFei_Entity.class);
                        String strVip=vipentity.getObj().toString();
//                            VipChongZhi_Obj objEntity=gson.fromJson(strVip,VipChongZhi_Obj.class);
//                            listObj.add(objEntity);
//                            vipadapter.notifyDataSetChanged();

                        try {
                            JSONArray json = new JSONArray(strVip);
//                            JSONArray json = new JSONObject(strVip).getJSONArray("DetailInfo");
                            for (int i = 0; i < json.length(); i++) {
                                JSONObject j = (JSONObject) json.get(i);
                                String ddCode = j.getString("ddCode");
                                int ddMoney = j.getInt("ddMoney");
                                String xfdp = j.getString("dpName");
                                JSONObject jsonObj = new JSONObject(j.getString("createDate"));
                                long xftime = jsonObj.getLong("time");
                                VipXiaoFei_Obj vipxf = new VipXiaoFei_Obj();
                                VipXiaoFei_Obj.CreateDateBean createDate = new VipXiaoFei_Obj.CreateDateBean();
                                vipxf.setDdCode(ddCode);
                                vipxf.setDdMoney(ddMoney);
                                vipxf.setDpName(xfdp);
                                createDate.setTime(xftime);
                                vipxf.setCreateDate(createDate);

                                listObj.add(vipxf);
                                vipadapter.notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(Vip_XiaoFeiActivity.this,getResources().getString(R.string.login_unusual)+"", Toast.LENGTH_SHORT).show();

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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }
}
