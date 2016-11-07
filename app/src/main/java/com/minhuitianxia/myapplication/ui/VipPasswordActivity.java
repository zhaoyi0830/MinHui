package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.minhuitianxia.myapplication.Fragment.VipLoginFragment;
import com.minhuitianxia.myapplication.MainActivity;
import com.minhuitianxia.myapplication.MyApplication;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.Utils.FragmentTag;
import com.minhuitianxia.myapplication.entity.VipLoginEntity;
import com.minhuitianxia.myapplication.entity.VipPasswordEntity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 修改密码
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipPasswordActivity extends Activity implements View.OnClickListener{
    private EditText edittext_old_pwd,edittext_new_pwd1,edittext_new_pwd2;
    private Button button_save;
    private ImageView back;
    private String Sold_pwd;
    private String Snew_pwd1;
    private String Snew_pwd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_password);
        init();
    }

    private void init() {
        edittext_old_pwd = (EditText) findViewById(R.id.edittext_old_pwd);
        edittext_new_pwd1 = (EditText) findViewById(R.id.edittext_new_pwd);
        edittext_new_pwd2 = (EditText) findViewById(R.id.edittext_new_pwd2);
        button_save = (Button) findViewById(R.id.button_save);
        back = (ImageView) findViewById(R.id.back);
        button_save.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
            case R.id.button_save:
                Sold_pwd = edittext_old_pwd.getText().toString();
                Snew_pwd1 = edittext_new_pwd1.getText().toString();
                Snew_pwd2 = edittext_new_pwd2.getText().toString();
                if (null == Sold_pwd||"".equals(Sold_pwd)){
                    Toast.makeText(this,"旧密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (null == Snew_pwd1||"".equals(Snew_pwd1)){
                    Toast.makeText(this,"新密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (null == Snew_pwd2||"".equals(Snew_pwd2)){
                    Toast.makeText(this,"确认密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Snew_pwd1.equals(Snew_pwd2)){
                    Toast.makeText(this,"两次密码不一致，请重新确认",Toast.LENGTH_SHORT).show();
                    return;
                }
                revise();
                break;
        }
    }

    private void revise() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                RequestParams requestParams =
                        new RequestParams(getResources().getString(R.string.http_service_pass));
                requestParams.addBodyParameter("hykId",MyApplication.getInstance().getZhangHao());
                requestParams.addBodyParameter("oldPwd",Sold_pwd);
                requestParams.addBodyParameter("newPwd",Snew_pwd1);
                requestParams.addBodyParameter("miKey",getResources().getString(R.string.miKey));
                x.http().post(requestParams, new Callback.CacheCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        VipPasswordEntity passentity = gson.fromJson(result,VipPasswordEntity.class);
                        boolean isSuccess = passentity.isSuccess();
                        if (isSuccess){
                            Toast.makeText(VipPasswordActivity.this, getResources().getString(R.string.password_success), Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(VipPasswordActivity.this,VipBasicActivity.class));
                            finish();
                        }else {
                            Toast.makeText(VipPasswordActivity.this, getResources().getString(R.string.password_fail), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {

                    }

                    @Override
                    public boolean onCache(String result) {
                        return false;
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
