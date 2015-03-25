// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;


public class LuaZipFile
{

    private String date;
    private Long id;
    private String version;
    private byte zipFile[];

    public LuaZipFile()
    {
    }

    public LuaZipFile(Long long1)
    {
        id = long1;
    }

    public LuaZipFile(Long long1, String s, String s1, byte abyte0[])
    {
        id = long1;
        version = s;
        date = s1;
        zipFile = abyte0;
    }

    public String getDate()
    {
        return date;
    }

    public Long getId()
    {
        return id;
    }

    public String getVersion()
    {
        return version;
    }

    public byte[] getZipFile()
    {
        return zipFile;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setVersion(String s)
    {
        version = s;
    }

    public void setZipFile(byte abyte0[])
    {
        zipFile = abyte0;
    }
}
