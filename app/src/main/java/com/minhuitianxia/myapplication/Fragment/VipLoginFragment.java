package com.minhuitianxia.myapplication.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.ui.VipBasicActivity;
import com.minhuitianxia.myapplication.ui.VipRechargeAvtivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 会员登陆界面
 * Created by Administrator on 2016/11/4 0004.
 */
public class VipLoginFragment extends Fragment implements View.OnClickListener{
    private EditText lg_username,lg_password;
    private Button   lg_button;
    private CheckBox im_password;
    private CheckBox im_show;
    private String StrUserName,StrPassWord;
    private SharedPreferences sp = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viplogin,container,false);
        sp = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        iniView(view);
        return view;
    }

    private void iniView(View view) {
        lg_username = (EditText) view.findViewById(R.id.lg_username);
        lg_password = (EditText) view.findViewById(R.id.lg_password);
        lg_button = (Button) view.findViewById(R.id.lg_button);
        im_show = (CheckBox) view.findViewById(R.id.im_show);
        im_password = (CheckBox) view.findViewById(R.id.im_password);
        lg_button.setOnClickListener(this);
        im_password.setOnClickListener(this);
        im_show.setOnClickListener(this);
        im_show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //如果选中，显示密码
                    lg_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    //否则隐藏密码
                    lg_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
        if (sp.getBoolean("checkboxBoolean", false))
        {
            lg_username.setText(sp.getString("uname", null));
            lg_password.setText(sp.getString("upswd", null));
            im_password.setChecked(true);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lg_button:
//                getPassword();
//                startActivity(new Intent(getActivity(),VipInfo_Activity.class));
                StrUserName=lg_username.getText().toString();
                StrPassWord=lg_password.getText().toString();
                if ("".equals(StrUserName) || StrUserName == null) {
                    Toast.makeText(getActivity(), "卡号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ("".equals(StrPassWord) || StrPassWord == null) {
                    Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean CheckBoxLogin = im_password.isChecked();
                if (CheckBoxLogin)
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("uname", StrUserName);
                    editor.putString("upswd", StrPassWord);
                    editor.putBoolean("checkboxBoolean", true);
                    editor.commit();
                }
                else
                {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("uname", null);
                    editor.putString("upswd", null);
                    editor.putBoolean("checkboxBoolean", false);
                    editor.commit();
                }
                Intent intent=new Intent(getActivity(),VipBasicActivity.class);
                startActivity(intent);
                break;
            case R.id.im_password:
                break;
        }
    }


//    private void getPassword() {
//        StrUserName=lg_username.getText().toString();
//        StrPassWord=lg_password.getText().toString();
//        if ("".equals(StrUserName) || StrUserName == null) {
//            Toast.makeText(getActivity(), "卡号不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if ("".equals(StrPassWord) || StrPassWord == null) {
//            Toast.makeText(getActivity(), "密码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        } else {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    RequestParams requestParams =
//                            new RequestParams(getResources().getString(R.string.http_service_login));
//                    requestParams.addBodyParameter("hykId",StrUserName);
//                    requestParams.addBodyParameter("pwd",StrPassWord);
//                    x.http().post(requestParams, new Callback.CommonCallback<Object>() {
//                        @Override
//                        public void onSuccess(Object result) {
//                            Toast.makeText(getActivity(), getResources().getString(R.string.login_success), Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getActivity(),VipInfo_Activity.class));
//                        }
//
//                        @Override
//                        public void onError(Throwable ex, boolean isOnCallback) {
//                            Toast.makeText(getActivity(), getResources().getString(R.string.login_fail), Toast.LENGTH_SHORT).show();
//                        }
//
//                        @Override
//                        public void onCancelled(CancelledException cex) {
//
//                        }
//
//                        @Override
//                        public void onFinished() {
//
//                        }
//                    });
//                }
//            }).start();
//        }
//    }


}
