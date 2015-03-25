// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.dataprovider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import java.io.File;
import java.lang.ref.WeakReference;

public final class CallbackManager
{

    private WeakReference a;
    private Uri b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;
    private int h;

    public CallbackManager(Activity activity)
    {
        g = false;
        a = new WeakReference(activity.getApplicationContext());
        Intent intent = activity.getIntent();
        if (intent != null)
        {
            b = intent.getData();
            c = intent.getStringExtra("srcPackageName");
            d = intent.getStringExtra("srcClassName");
            e = intent.getStringExtra("srcAction");
            h = intent.getIntExtra("requestDataTypeFlag", 0);
            f = intent.getStringExtra("params_appid");
            if (b != null && d != null)
            {
                g = true;
            }
        }
    }

    private int a(Bundle bundle)
    {
        if (!g)
        {
            return -2;
        } else
        {
            Intent intent = new Intent();
            intent.setClassName(c, d);
            intent.setAction(e);
            bundle.putString("params_appid", f);
            intent.putExtras(bundle);
            intent.setFlags(0x10000000);
            ((Context)a.get()).startActivity(intent);
            return 0;
        }
    }

    private int a(String s)
    {
        byte byte0;
        if (s == null)
        {
            byte0 = -7;
        } else
        {
            String s1 = s.toLowerCase();
            boolean flag = s1.startsWith("http://");
            byte0 = 0;
            if (!flag)
            {
                if (Environment.getExternalStorageState().equals("mounted"))
                {
                    if (!s1.startsWith(Environment.getExternalStorageDirectory().toString().toLowerCase()))
                    {
                        return -5;
                    }
                } else
                {
                    return -10;
                }
                File file = new File(s);
                if (!file.exists() || file.isDirectory())
                {
                    return -8;
                }
                long l = file.length();
                if (l == 0L)
                {
                    return -9;
                }
                int i = l != 0x40000000L;
                byte0 = 0;
                if (i > 0)
                {
                    return -6;
                }
            }
        }
        return byte0;
    }

    public int getRequestDateTypeFlag()
    {
        return h;
    }

    public boolean isCallFromTencentApp()
    {
        return g;
    }

    public boolean isSupportType(int i)
    {
        return (i & getRequestDateTypeFlag()) != 0;
    }

    public int sendTextAndImagePath(String s, String s1)
    {
        int i;
        if (!isSupportType(1))
        {
            i = -1;
        } else
        {
            i = a(s1);
            if (i == 0)
            {
                DataType.TextAndMediaPath textandmediapath = new DataType.TextAndMediaPath(s, s1);
                Bundle bundle = new Bundle();
                bundle.putInt("contentDataType", 1);
                bundle.putParcelable("contentData", textandmediapath);
                return a(bundle);
            }
        }
        return i;
    }

    public int sendTextAndVideoPath(String s, String s1)
    {
        int i;
        if (!isSupportType(2))
        {
            i = -1;
        } else
        {
            i = a(s1);
            if (i == 0)
            {
                DataType.TextAndMediaPath textandmediapath = new DataType.TextAndMediaPath(s, s1);
                Bundle bundle = new Bundle();
                bundle.putInt("contentDataType", 2);
                bundle.putParcelable("contentData", textandmediapath);
                return a(bundle);
            }
        }
        return i;
    }

    public int sendTextOnly(String s)
    {
        if (!isSupportType(4))
        {
            return -1;
        } else
        {
            DataType.TextOnly textonly = new DataType.TextOnly(s);
            Bundle bundle = new Bundle();
            bundle.putInt("contentDataType", 4);
            bundle.putParcelable("contentData", textonly);
            return a(bundle);
        }
    }
}
