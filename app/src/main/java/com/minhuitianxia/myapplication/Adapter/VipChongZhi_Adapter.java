package com.minhuitianxia.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Entity;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Obj;

import java.util.List;

/**
 * 会员充值记录
 * Created by Administrator on 2016/11/8 0008.
 */
public class VipChongZhi_Adapter extends BaseAdapter {
    private List<VipChongZhi_Obj> Chongzhi_list;
    private Context context;

    public VipChongZhi_Adapter(List<VipChongZhi_Obj> chongzhi_list, Context context) {
        this.Chongzhi_list = chongzhi_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Chongzhi_list.size();
    }

    @Override
    public Object getItem(int position) {
        return Chongzhi_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.vip_chongzhiadapter,null);
            holder.mTv_czmoney = (TextView) convertView.findViewById(R.id.tv_czmoney);
            holder.mTv_changemoney = (TextView)convertView.findViewById(R.id.tv_changemoney);
            holder.mTv_czshop = (TextView) convertView.findViewById(R.id.tv_czshop);
            holder.mTv_cztime = (TextView) convertView.findViewById(R.id.tv_cztime);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        VipChongZhi_Obj vipchongzhi=Chongzhi_list.get(position);
        holder.mTv_czmoney.setText(vipchongzhi.getCzJe()+"");
        holder.mTv_changemoney.setText("没找到字段");
        holder.mTv_czshop.setText(vipchongzhi.getDpName()+"");
        holder.mTv_cztime.setText(vipchongzhi.getCreateDate().getTime()+"");
        return convertView;
    }

    public class ViewHolder {
        private TextView mTv_czmoney;
        private TextView mTv_changemoney;
        private TextView mTv_czshop;
        private TextView mTv_cztime;
    }
    }
