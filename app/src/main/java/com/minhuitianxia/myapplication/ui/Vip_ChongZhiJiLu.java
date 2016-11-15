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
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.Utils.IsNetWork;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Entity;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Obj;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 会员充值记录
 * Created by Administrator on 2016/11/8 0008.
 */
public class Vip_ChongZhiJiLu extends AppCompatActivity implements View.OnClickListener{
    private ImageView back;
    private TextView title_top_bar;
    private TextView mTv_czmoney;
    private TextView mTv_czshop;
    private TextView mTv_cztime;
    private VipChongZhi_Entity vipentity;
    private List<VipChongZhi_Entity> listChongZhi = new ArrayList<>();
    private List<VipChongZhi_Obj> listObj = new ArrayList<>();
    private ListView lv_chongzhijilu;
    private VipChongZhi_Adapter vipadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_chongzhijilu);
        iniView();
        if(IsNetWork.isNetworkAvailable(this)){
            getHttp();
        }else{
            Toast.makeText(this,getResources().getString(R.string.Fail_Network), Toast.LENGTH_SHORT).show();
        }
    }

    private void iniView() {
        back = (ImageView) findViewById(R.id.back);
        title_top_bar = (TextView) findViewById(R.id.title_top_bar);
        mTv_czmoney = (TextView) findViewById(R.id.tv_czmoney);
        mTv_czshop = (TextView) findViewById(R.id.tv_czshop);
        mTv_cztime = (TextView) findViewById(R.id.tv_cztime);
        lv_chongzhijilu = (ListView) findViewById(R.id.lv_chongzhijilu);
        back.setOnClickListener(this);
        title_top_bar.setText("会员充值记录");
        vipadapter = new VipChongZhi_Adapter(listObj,this);
        lv_chongzhijilu.setAdapter(vipadapter);
        vipadapter.notifyDataSetChanged();
    }

    private void getHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final RequestParams requestParams =
                        new RequestParams(getResources().getString(R.string.http_service_chongzhi));
                requestParams.addBodyParameter("hykId", MyApplication.getInstance().getZhangHao());
                requestParams.addBodyParameter("miKey",getResources().getString(R.string.miKey));
                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                            Gson gson = new Gson();
                            vipentity =gson.fromJson(result,VipChongZhi_Entity.class);
                            String strVip=vipentity.getObj().toString();
//                            VipChongZhi_Obj objEntity=gson.fromJson(strVip,VipChongZhi_Obj.class);
//                            listObj.add(objEntity);
//                            vipadapter.notifyDataSetChanged();

                        try {
                            JSONArray json = new JSONArray(strVip);
//                            JSONArray json = new JSONObject(strVip).getJSONArray("DetailInfo");
                            for (int i = 0; i < json.length(); i++) {
                                JSONObject j = (JSONObject) json.get(i);
                                int money = j.getInt("czJe");
                                String czdp = j.getString("dpName");
                                JSONObject jsonObj = new JSONObject(j.getString("createDate"));
                                long cztime = jsonObj.getLong("time");
                                VipChongZhi_Obj vipcz = new VipChongZhi_Obj();
                                VipChongZhi_Obj.CreateDateBean createDate = new VipChongZhi_Obj.CreateDateBean();
                                vipcz.setCzJe(money);
                                vipcz.setDpName(czdp);
                                createDate.setTime(cztime);
                                vipcz.setCreateDate(createDate);
                                listObj.add(vipcz);
                                vipadapter.notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        Toast.makeText(Vip_ChongZhiJiLu.this,getResources().getString(R.string.login_unusual)+"", Toast.LENGTH_SHORT).show();

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
