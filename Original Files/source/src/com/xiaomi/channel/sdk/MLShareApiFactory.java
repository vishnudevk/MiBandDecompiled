// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;

// Referenced classes of package com.xiaomi.channel.sdk:
//            IShareReq, MLExtraInfo, ShareUtils, g

public class MLShareApiFactory
{

    public static final String KEY_EXTRA_SHARE_BUNDLE = "extra_share_bundle";
    private Context a;
    private String b;
    private String c;
    private String d;
    private Drawable e;
    private String f;
    public String mVipId;

    public MLShareApiFactory(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context could not be null!");
        } else
        {
            a(context);
            return;
        }
    }

    public MLShareApiFactory(Context context, String s, String s1)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("context could not be null!");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("appId could not be empty!");
        } else
        {
            b = s;
            mVipId = s1;
            a(context);
            return;
        }
    }

    static Context a(MLShareApiFactory mlshareapifactory)
    {
        return mlshareapifactory.a;
    }

    private void a(Context context)
    {
        a = context.getApplicationContext();
        try
        {
            PackageInfo packageinfo = a.getPackageManager().getPackageInfo(d, 0);
            c = packageinfo.applicationInfo.loadLabel(a.getPackageManager()).toString();
            e = packageinfo.applicationInfo.loadIcon(a.getPackageManager());
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public boolean sendReq(IShareReq isharereq, boolean flag)
    {
        if (isharereq == null) goto _L2; else goto _L1
_L1:
        Intent intent;
        List list;
        int i;
        boolean flag1;
        intent = new Intent();
        Bundle bundle = isharereq.toBundle();
        if (bundle != null)
        {
            if (!TextUtils.isEmpty(b))
            {
                bundle.putString("app_id", b);
            }
            bundle.putString("app_name", c);
            if (flag)
            {
                bundle.putString("app_package_name", d);
                MLExtraInfo mlextrainfo = isharereq.getJumpBackInfo();
                if (mlextrainfo != null)
                {
                    bundle.putString("app_jump_back_info", mlextrainfo.toJson());
                }
            }
            if (e != null)
            {
                bundle.putParcelable("app_icon_bmp", ShareUtils.drawableToBitmap(e));
            }
            int j;
            Intent intent1;
            String s;
            if (TextUtils.isEmpty(mVipId))
            {
                s = "800720";
            } else
            {
                s = mVipId;
            }
            bundle.putString("vip_id", s);
            if (!TextUtils.isEmpty(f))
            {
                bundle.putString("app_ios_local_uri", f);
            }
        }
        list = ((ActivityManager)a.getSystemService("activity")).getRunningAppProcesses();
        i = 0;
_L3:
        j = list.size();
        flag1 = false;
        if (i < j)
        {
label0:
            {
                if (!((android.app.ActivityManager.RunningAppProcessInfo)list.get(i)).processName.equals("com.xiaomi.channel"))
                {
                    break label0;
                }
                flag1 = true;
            }
        }
        intent.putExtra("share_bundle", bundle);
        intent.setAction("com.xiaomi.channel.share");
        if (!flag1)
        {
            intent1 = a.getPackageManager().getLaunchIntentForPackage("com.xiaomi.channel");
            a.startActivity(intent1);
            (new Handler(Looper.getMainLooper())).postDelayed(new g(this, intent), 1000L);
            return true;
        } else
        {
            a.sendBroadcast(intent);
            return true;
        }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
        return false;
    }

    public void setIosLocalUri(String s)
    {
        f = s;
    }

    public void setPackageNameAndAppName(String s, String s1)
    {
        if (!TextUtils.isEmpty(s))
        {
            d = s;
            if (!TextUtils.isEmpty(s1))
            {
                c = s1;
            }
        }
    }
}
