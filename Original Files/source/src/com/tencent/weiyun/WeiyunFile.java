// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;


public class WeiyunFile
{

    private String a;
    private String b;
    private String c;
    private long d;

    public WeiyunFile(String s, String s1, String s2, long l)
    {
        a = s;
        b = s1;
        c = s2;
        d = l;
    }

    public String getCreateTime()
    {
        return c;
    }

    public String getFileId()
    {
        return a;
    }

    public String getFileName()
    {
        return b;
    }

    public long getFileSize()
    {
        return d;
    }

    public void setCreateTime(String s)
    {
        c = s;
    }

    public void setFileId(String s)
    {
        a = s;
    }

    public void setFileName(String s)
    {
        b = s;
    }

    public void setFileSize(long l)
    {
        d = l;
    }
}
