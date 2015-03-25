// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.query;


public class string extends n
{

    protected final String string;

    public void appendTo(StringBuilder stringbuilder, String s)
    {
        stringbuilder.append(string);
    }

    public n(String s)
    {
        string = s;
    }

    public string(String s, Object obj)
    {
        super(obj);
        string = s;
    }

    public transient string(String s, Object aobj[])
    {
        super(aobj);
        string = s;
    }
}
