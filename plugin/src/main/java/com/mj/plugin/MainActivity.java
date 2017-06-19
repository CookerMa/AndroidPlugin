package com.mj.plugin;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.mj.mylibrary.BaseActivity;
import com.mj.mylibrary.PluginImpl;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 需要跳转的activity
 */
public class MainActivity extends AppCompatActivity implements PluginImpl
{
    AppCompatActivity that;
    private TextView tv;

    @Override
    public void attach(AppCompatActivity proxyActivity)
    {
        that =proxyActivity;
        Toast.makeText( that,"nima de ",Toast.LENGTH_LONG).show();
        Date date = new Date();
        Log.e("TTT","attach"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
    }


    public void onCreate1(Bundle savedInstanceState)
    {
        Date date = new Date();
        Log.e("TTT","onCreate"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
        tv = new TextView(that);
        tv.setBackgroundColor(Color.RED);
        tv.setWidth(200);
        tv.setHeight(290);
//        that.setContentView(tv);
        that.setContentView(R.layout.activity_main);
//
    }


}
