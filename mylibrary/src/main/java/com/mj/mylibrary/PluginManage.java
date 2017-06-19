package com.mj.mylibrary;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * User : nick
 * Date : 2017/6/16
 * Time : 10:27
 * Desc :
 */

public class PluginManage
{

    private static PluginManage instance;
    private Context ctx ;
    private Resources resources;
    private DexClassLoader cl;
    private PackageInfo info;

    private PluginManage(Context context){
        ctx = context;
    };
    public static PluginManage getInstance(Context context)
    {
        if (instance == null)
        {
            synchronized (PluginManage.class)
            {
                if (instance == null)
                {
                    instance = new PluginManage(context);
                }
            }
        }
        return instance;
    }


    public static PluginManage getInstance()
    {
        if (instance == null)
        {
            throw  new RuntimeException("还没有初始化");
        }
        return instance;
    }


    /**
     * 加载外部资源
     * @param path
     */
    public  void loadApkFromExternal(String path)
    {
        File dex = ctx.getDir("dex", Context.MODE_PRIVATE);
        //实例化一个DexClassLoad
        cl = new DexClassLoader(path,dex.getAbsolutePath(),null,ctx.getClassLoader());
        resources = getResources(path);

        PackageManager pm = ctx.getPackageManager();
        info = pm.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);
        // 获得资源文件
    }

    private Resources getResources(String path)
    {
        Resources surRes = null;
        try
        {
            AssetManager assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getMethod("addAssetPath",String.class);
            method.invoke(assetManager,path);
           surRes = new Resources(assetManager,ctx.getResources().getDisplayMetrics(),ctx.getResources().getConfiguration());
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        return surRes ;
    }
    public Resources getResources()
    {
        return resources;
    }

    public DexClassLoader getCl()
    {
        return cl;
    }

    public PackageInfo getInfo()
    {
        return info;
    }

}
