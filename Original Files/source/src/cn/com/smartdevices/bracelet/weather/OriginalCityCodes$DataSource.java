// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.weather;


public class 
{

    private String key;
    private String type;

    public String getKey()
    {
        return key;
    }

    public String getType()
    {
        return type;
    }

    public void setKey(String s)
    {
        key = s;
    }

    public void setType(String s)
    {
        type = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Key : ").append(key).append(", ");
        stringbuilder.append("Type : ").append(type);
        return stringbuilder.toString();
    }

    public ()
    {
    }
}
