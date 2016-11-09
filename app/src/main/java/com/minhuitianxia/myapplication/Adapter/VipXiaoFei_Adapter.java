package com.minhuitianxia.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.entity.VipChongZhi_Obj;
import com.minhuitianxia.myapplication.entity.VipXiaoFei_Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 会员消费记录
 * Created by Administrator on 2016/11/8 0008.
 */
public class VipXiaoFei_Adapter extends BaseAdapter {
    private List<VipXiaoFei_Obj> XiaoFei_list;
    private Context context;

    public VipXiaoFei_Adapter(List<VipXiaoFei_Obj> xiaofei_list, Context context) {
        this.XiaoFei_list = xiaofei_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return XiaoFei_list.size();
    }

    @Override
    public Object getItem(int position) {
        return XiaoFei_list.get(position);
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
            convertView = LayoutInflater.from(context).inflate(R.layout.vip_xiaofeiadapter,null);
            holder.mTv_xfcode = (TextView) convertView.findViewById(R.id.tv_xfcode);
            holder.mTv_xfmoney = (TextView) convertView.findViewById(R.id.tv_xfmoney);
            holder.mTv_xfshop = (TextView) convertView.findViewById(R.id.tv_xfshop);
            holder.mTv_xftime = (TextView) convertView.findViewById(R.id.tv_xftime);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        VipXiaoFei_Obj vipXiaoFei=XiaoFei_list.get(position);
        holder.mTv_xfcode.setText(vipXiaoFei.getDdCode()+"");
        holder.mTv_xfmoney.setText(vipXiaoFei.getDdMoney()+"");
        holder.mTv_xfshop.setText(vipXiaoFei.getDpName()+"");
        holder.mTv_xftime.setText(getDateTimeFromMillisecond(vipXiaoFei.getCreateDate().getTime())+"");
        return convertView;
    }

    public class ViewHolder {
        private TextView mTv_xfcode;//消费单号
        private TextView mTv_xfmoney;//消费金额
        private TextView mTv_xfshop;//消费店铺
        private TextView mTv_xftime;//消费时间
    }
    public static String getDateTimeFromMillisecond(Long millisecond){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(millisecond);
        String dateStr = simpleDateFormat.format(date);
        return dateStr;
    }
    }
