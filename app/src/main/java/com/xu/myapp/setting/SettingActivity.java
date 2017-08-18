package com.xu.myapp.setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.xu.Config;
import com.xu.myapp.BaseActivity;
import com.xu.myapp.R;

public class SettingActivity extends BaseActivity implements CompoundButton.OnCheckedChangeListener{

    Switch debugSwitch;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    public static void start(Context context){
        Intent intent=new Intent(context,SettingActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        debugSwitch=(Switch)findViewById(R.id.debug_switch);
        loadSettingInfo();
        debugSwitch.setOnCheckedChangeListener(this);
    }
    private void loadSettingInfo(){
        sharedPreferences=getSharedPreferences(Config.SETTING_PREFERENCES_NAME,MODE_PRIVATE);
        debugSwitch.setChecked(sharedPreferences.getBoolean(Config.PREFERENCES_KEY_DEBUG,false));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(sharedPreferencesEditor==null){
            sharedPreferencesEditor=sharedPreferences.edit();
        }
        switch (buttonView.getId()){
            case R.id.debug_switch:
                sharedPreferencesEditor.putBoolean(Config.PREFERENCES_KEY_DEBUG,isChecked);
                sharedPreferencesEditor.commit();
                Config.getInstance().setDebug(isChecked);
                break;
            default:
                break;
        }
    }
}
