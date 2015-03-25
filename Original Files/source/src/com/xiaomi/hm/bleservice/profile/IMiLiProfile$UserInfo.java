// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class type
{

    public static final byte CLEAR_DATA = 1;
    public static final byte NORMAL = 0;
    public static final byte RETAIN_DATA = 2;
    public static final alias SAMPLE = new <init>(0xa2867cf, (byte)0, (byte)23, (byte)-88, (byte)50, "anri.okita\0".getBytes());
    public final byte age;
    public final byte alias[];
    public final byte gender;
    public final byte height;
    public final byte type;
    public final int uid;
    public final byte weight;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n     uid: ").append(uid).toString());
        StringBuilder stringbuilder1 = (new StringBuilder()).append("\n  gender: ");
        String s;
        if (gender == 0)
        {
            s = "female";
        } else
        {
            s = "male";
        }
        stringbuilder.append(stringbuilder1.append(s).toString());
        stringbuilder.append((new StringBuilder()).append("\n     age: ").append(age).append("yrs").toString());
        stringbuilder.append((new StringBuilder()).append("\n  height: ").append(0xff & height).append("cm").toString());
        stringbuilder.append((new StringBuilder()).append("\n  weight: ").append(0xff & weight).append("kg").toString());
        stringbuilder.append((new StringBuilder()).append("\n   alias: ").append(new String(alias)).toString());
        return stringbuilder.toString();
    }


    public (int i, byte byte0, byte byte1, byte byte2, byte byte3, byte byte4, byte abyte0[])
    {
        uid = i;
        gender = byte0;
        age = byte1;
        height = byte2;
        weight = byte3;
        alias = abyte0;
        type = byte4;
    }

    public type(int i, byte byte0, byte byte1, byte byte2, byte byte3, byte abyte0[])
    {
        uid = i;
        gender = byte0;
        age = byte1;
        height = byte2;
        weight = byte3;
        alias = abyte0;
        type = 0;
    }
}
