package com.mj.mylibrary;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mj.mylibrary.PluginManage;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 代理
 */
public class ProxyActivity extends AppCompatActivity {


    //加载所有其他apk的资源
    String clzName ;
    private PluginImpl pl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clzName =  getIntent().getStringExtra("clzName");
        try
        {

            Class<?> loadClass = PluginManage.getInstance().getCl().loadClass(clzName);
            Constructor<?> constructor = loadClass.getConstructor(new Class[]{});
            //实例化一个activity
            Object o = constructor.newInstance(new Object[]{});
            pl = (PluginImpl) o;
            pl.attach(this);
            pl.onCreate1(new Bundle());

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart()
    {
//        pl.onStart1();
        super.onStart();
    }

    @Override
    protected void onDestroy()
    {
//        pl.onDestroy1();
        super.onDestroy();
    }

    @Override
    public Resources getResources()
    {
        //去加载插件apk的资源
        return PluginManage.getInstance().getResources();
    }
}
