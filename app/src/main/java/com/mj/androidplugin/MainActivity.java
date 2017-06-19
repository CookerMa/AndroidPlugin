package com.mj.androidplugin;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mj.mylibrary.PluginManage;
import com.mj.mylibrary.ProxyActivity;

import java.io.File;
import java.io.FileWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManage.getInstance(this);
    }

    public void load(View view)
    {
        File file = new File(Environment.getExternalStorageDirectory(),"plugin-debug.apk");
        String path = file.getAbsolutePath();
        PluginManage.getInstance().loadApkFromExternal(path);
    }

    public void jump(View v)
    {
        //跳转到第三方的activity
        startActivity(new Intent(this,ProxyActivity.class).putExtra("clzName", PluginManage.getInstance().getInfo().activities[0].name));
    }
}
