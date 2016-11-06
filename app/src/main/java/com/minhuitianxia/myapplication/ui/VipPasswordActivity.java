package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.minhuitianxia.myapplication.MainActivity;
import com.minhuitianxia.myapplication.R;
import com.minhuitianxia.myapplication.Utils.FragmentTag;

/**
 * 修改密码
 * Created by Administrator on 2016/11/3 0003.
 */
public class VipPasswordActivity extends Activity implements View.OnClickListener{
    private EditText edittext_old_pwd,edittext_new_pwd,edittext_new_pwd2;
    private Button button_save;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_password);
        init();
    }

    private void init() {
        edittext_old_pwd = (EditText) findViewById(R.id.edittext_old_pwd);
        edittext_new_pwd = (EditText) findViewById(R.id.edittext_new_pwd);
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
                onBackPressed();
                break;
        }
    }



}
