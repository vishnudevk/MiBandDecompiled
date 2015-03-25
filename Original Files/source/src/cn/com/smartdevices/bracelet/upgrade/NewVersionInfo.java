// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;


public class NewVersionInfo
{

    private int a;
    private String b;
    private String c;
    private String d;
    private String e;

    public NewVersionInfo()
    {
    }

    public String getChangeLog()
    {
        return c;
    }

    public String getFileUrl()
    {
        return d;
    }

    public String getMd5()
    {
        return e;
    }

    public int getVersionCode()
    {
        return a;
    }

    public String getVersionName()
    {
        return b;
    }

    public void setChangeLog(String s)
    {
        c = s;
    }

    public void setFileUrl(String s)
    {
        d = s;
    }

    public void setMd5(String s)
    {
        e = s;
    }

    public void setVersionCode(int i)
    {
        a = i;
    }

    public void setVersionName(String s)
    {
        b = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append(a).append(";").append(b).append(";").append(d).append(";").append(e).append(";").append(c).toString();
    }
}
