// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;


public interface GifAction
{

    public static final int RETURN_CACHE_FINISH = 3;
    public static final int RETURN_ERROR = 4;
    public static final int RETURN_FINISH = 2;
    public static final int RETURN_FIRST = 1;

    public abstract void loopEnd();

    public abstract void parseReturn(int i);
}
