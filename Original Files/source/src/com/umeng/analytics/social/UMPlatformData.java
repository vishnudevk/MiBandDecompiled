// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.text.TextUtils;

// Referenced classes of package com.umeng.analytics.social:
//            b

public class UMPlatformData
{

    private UMedia a;
    private String b;
    private String c;
    private String d;
    private GENDER e;

    public UMPlatformData(UMedia umedia, String s)
    {
        b = "";
        c = "";
        if (umedia == null || TextUtils.isEmpty(s))
        {
            com.umeng.analytics.social.b.b("MobclickAgent", "parameter is not valid");
            return;
        } else
        {
            a = umedia;
            b = s;
            return;
        }
    }

    public GENDER getGender()
    {
        return e;
    }

    public UMedia getMeida()
    {
        return a;
    }

    public String getName()
    {
        return d;
    }

    public String getUsid()
    {
        return b;
    }

    public String getWeiboId()
    {
        return c;
    }

    public boolean isValid()
    {
        return a != null && !TextUtils.isEmpty(b);
    }

    public void setGender(GENDER gender)
    {
        e = gender;
    }

    public void setName(String s)
    {
        d = s;
    }

    public void setWeiboId(String s)
    {
        c = s;
    }

    public String toString()
    {
        return (new StringBuilder("UMPlatformData [meida=")).append(a).append(", usid=").append(b).append(", weiboId=").append(c).append(", name=").append(d).append(", gender=").append(e).append("]").toString();
    }
}
