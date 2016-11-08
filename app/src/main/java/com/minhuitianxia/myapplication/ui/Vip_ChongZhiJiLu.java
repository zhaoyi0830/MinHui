package com.minhuitianxia.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.minhuitianxia.myapplication.Adapter.VipChongZhi_Adapter;
import com.minhuitianxia.myapplication.R;
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
public class Vip_ChongZhiJiLu extends AppCompatActivity {
    private TextView mTv_czmoney;
    private TextView mTv_changemoney;
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
        getHttp();
    }

    private void iniView() {
        mTv_czmoney = (TextView) findViewById(R.id.tv_czmoney);
        mTv_changemoney = (TextView) findViewById(R.id.tv_changemoney);
        mTv_czshop = (TextView) findViewById(R.id.tv_czshop);
        mTv_cztime = (TextView) findViewById(R.id.tv_cztime);
        lv_chongzhijilu = (ListView) findViewById(R.id.lv_chongzhijilu);
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
                requestParams.addBodyParameter("hykId","6225350818094406");
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
}
