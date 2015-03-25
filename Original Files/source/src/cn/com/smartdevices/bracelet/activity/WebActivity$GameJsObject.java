// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            WebActivity

public class a
{

    final WebActivity a;

    public void webCallback(String s, String s1, String s2, String s3)
    {
        Debug.i("WebActivity", (new StringBuilder()).append("uid:").append(s).append(",security:").append(s1).append(", type = ").append(s2).append(", data=").append(s3).toString());
        if ("dislike".equals(s2))
        {
            UmengAnalytics.event(a, "Game_Dislike");
            a.finish();
        }
    }

    public (WebActivity webactivity)
    {
        a = webactivity;
        super();
    }
}
