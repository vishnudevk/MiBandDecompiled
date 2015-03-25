// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;


public final class adv
{

    public final int adv;
    public final int conn;
    public final int light;
    public final int vibrate;
    public final int wake;

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append((new StringBuilder()).append("[[[ ").append(getClass().getSimpleName()).append(" ]]]").toString());
        stringbuilder.append((new StringBuilder()).append("\n     wake: ").append(wake).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n  vibrate: ").append(vibrate).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n    light: ").append(light).append("ms").toString());
        stringbuilder.append((new StringBuilder()).append("\n     conn: ").append(conn).append("s").toString());
        stringbuilder.append((new StringBuilder()).append("\n      adv: ").append(adv).append("s").toString());
        return stringbuilder.toString();
    }

    public _cls9(int i, int j, int k, int l, int i1)
    {
        wake = i;
        vibrate = j;
        light = k;
        conn = l;
        adv = i1;
    }
}
