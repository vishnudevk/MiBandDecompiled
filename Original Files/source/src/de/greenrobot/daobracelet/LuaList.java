// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.daobracelet;


public class LuaList
{

    private String date;
    private Long id;
    private String index;
    private String jsonString;
    private String luaActionScript;
    private String right;
    private String scriptVersion;
    private String start;
    private String stop;
    private String text1;
    private String text2;
    private String time;
    private String type;

    public LuaList()
    {
    }

    public LuaList(Long long1)
    {
        id = long1;
    }

    public LuaList(Long long1, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6, String s7, String s8, String s9, String s10, String s11)
    {
        id = long1;
        date = s;
        time = s1;
        type = s2;
        right = s3;
        index = s4;
        jsonString = s5;
        scriptVersion = s6;
        luaActionScript = s7;
        text1 = s8;
        text2 = s9;
        start = s10;
        stop = s11;
    }

    public String getDate()
    {
        return date;
    }

    public Long getId()
    {
        return id;
    }

    public String getIndex()
    {
        return index;
    }

    public String getJsonString()
    {
        return jsonString;
    }

    public String getLuaActionScript()
    {
        return luaActionScript;
    }

    public String getRight()
    {
        return right;
    }

    public String getScriptVersion()
    {
        return scriptVersion;
    }

    public String getStart()
    {
        return start;
    }

    public String getStop()
    {
        return stop;
    }

    public String getText1()
    {
        return text1;
    }

    public String getText2()
    {
        return text2;
    }

    public String getTime()
    {
        return time;
    }

    public String getType()
    {
        return type;
    }

    public void setDate(String s)
    {
        date = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setIndex(String s)
    {
        index = s;
    }

    public void setJsonString(String s)
    {
        jsonString = s;
    }

    public void setLuaActionScript(String s)
    {
        luaActionScript = s;
    }

    public void setRight(String s)
    {
        right = s;
    }

    public void setScriptVersion(String s)
    {
        scriptVersion = s;
    }

    public void setStart(String s)
    {
        start = s;
    }

    public void setStop(String s)
    {
        stop = s;
    }

    public void setText1(String s)
    {
        text1 = s;
    }

    public void setText2(String s)
    {
        text2 = s;
    }

    public void setTime(String s)
    {
        time = s;
    }

    public void setType(String s)
    {
        type = s;
    }
}
