// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;


class w
{

    String a;
    int b;
    String c;
    int d;
    String e;
    String f;
    String g;
    long h;
    String i;
    String j;
    long k;
    int l;

    w()
    {
        i = "";
        j = "";
    }

    public String toString()
    {
        return (new StringBuilder("UpdateInfo:\nhost = ")).append(a).append("\nfitness = ").append(b).append("\nupdateLog = ").append(c).append("\nversionCode = ").append(d).append("\nversionName = ").append(e).append("\napkUrl = ").append(f).append("\napkHash = ").append(g).append("\napkSize = ").append(h).append("\ndiffUrl = ").append(i).append("\ndiffHash = ").append(j).append("\ndiffSize = ").append(k).append("\nsource = ").append(l).toString();
    }
}
