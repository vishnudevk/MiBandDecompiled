// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;

public abstract class Policy
{

    protected String mParam;

    public Policy()
    {
    }

    public abstract void end();

    public abstract void execute(Event event);

    public abstract void prepare();

    public void setParam(String s)
    {
        mParam = s;
    }
}
