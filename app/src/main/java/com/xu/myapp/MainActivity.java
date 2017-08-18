package com.xu.myapp;

import android.os.Bundle;
import android.view.View;

import com.xu.myapp.setting.SettingActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.setting_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_button:
                SettingActivity.start(this);
                break;
            default:
                break;
        }
    }
}
