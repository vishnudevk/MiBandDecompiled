// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.view;


public interface GifListener
{

    public static final int FRAME_COUNT_ONLY = 2;
    public static final int LOOP_AND_FRAME_COUNT = 3;
    public static final int LOOP_ONLY = 1;

    public abstract void frameCount(int i);

    public abstract void gifEnd(int i);
}
