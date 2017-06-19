package com.mj.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * User : nick
 * Date : 2017/6/16
 * Time : 9:26
 * Desc : 一个实现所有生命周期的接口
 */

public interface PluginImpl
{
    public void onCreate1(Bundle savedInstanceState);
//    public void onStart();
//    public void onRestart();
//    public void onActivityResult(int requestCode, int resultCode, Intent data);
//    public void onResume();
//    public void onPause();
//    public void onStop();
//    public void onDestroy();
    public void attach(AppCompatActivity proxyActivity);
//    public void onSaveInstanceState(Bundle outState);
//    public void onNewIntent(Intent intent);
//    public void onRestoreInstanceState(Bundle savedInstanceState);
//    public boolean onTouchEvent1(MotionEvent event);
//    public boolean onKeyUp1(int keyCode, KeyEvent event);
//    public void onWindowFocusChanged1(boolean hasFocus);
//    public void onBackPressed1();

}
