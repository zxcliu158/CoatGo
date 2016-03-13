package com.fei.coatgo;

import android.app.Application;
import android.content.Context;

import org.xutils.x;

/**
 * Created by abcli on 2016/1/21.
 */
public class MYAPP extends Application{

    public static int X=0;
    public static int Y=0;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
       x.Ext.init(this);
        context=this;
    }
}
