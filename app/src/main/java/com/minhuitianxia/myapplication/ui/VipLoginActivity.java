package com.minhuitianxia.myapplication.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.minhuitianxia.myapplication.MainActivity;
import com.minhuitianxia.myapplication.MainActivityyk;
import com.minhuitianxia.myapplication.R;

/**登陆分类
 * Created by Administrator on 2016/11/15 0015.
 */
public class VipLoginActivity extends Activity implements View.OnClickListener{

    private TextView te_ny,te_hy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_login);
        init();
    }

    private void init() {
        te_ny = (TextView) findViewById(R.id.tv_ny);
        te_hy = (TextView) findViewById(R.id.tv_hy);
        te_ny.setOnClickListener(this);
        te_hy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.tv_ny:
                intent = new Intent(this, MainActivityyk.class);
                startActivity(intent);
                break;
            case R.id.tv_hy:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
