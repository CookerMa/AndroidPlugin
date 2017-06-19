package com.mj.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class BaseActivity extends AppCompatActivity implements PluginImpl
{
    protected AppCompatActivity that;

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        that.setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params)
    {
        that.setContentView(view, params);
    }

    @Override
    public void setContentView(View view)
    {
        that.setContentView(view);
    }


    @Override
    public Intent getIntent()
    {
        return that.getIntent();
    }

    @Override
    public Resources getResources()
    {
        return that.getResources();
    }

//
    @Override
    public void onCreate1(Bundle savedInstanceState)
    {
    }
//
//    @Override
//    public void onStart()
//    {
//
//    }
//
//    @Override
//    public void onRestart()
//    {
//
//    }
//
//    @Override
//    public void onResume()
//    {
//
//    }
//
//    @Override
//    public void onPause()
//    {
//
//    }
//
//    @Override
//    public void onStop()
//    {
//
//    }
//
//    @Override
//    public void onDestroy()
//    {
//
//    }

    @Override
    public void attach(AppCompatActivity proxyActivity)
    {
        that = proxyActivity;
    }


}
