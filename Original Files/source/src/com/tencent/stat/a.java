// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat;

import org.json.JSONObject;

class a
{

    int a;
    JSONObject b;
    String c;
    int d;

    public a(int i)
    {
        b = new JSONObject();
        c = "";
        d = 0;
        a = i;
    }

    String a()
    {
        return b.toString();
    }
}
