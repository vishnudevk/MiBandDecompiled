// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


public final class ThreadMode extends Enum
{

    public static final ThreadMode Async;
    public static final ThreadMode BackgroundThread;
    private static final ThreadMode ENUM$VALUES[];
    public static final ThreadMode MainThread;
    public static final ThreadMode PostThread;

    private ThreadMode(String s, int i)
    {
        super(s, i);
    }

    public static ThreadMode valueOf(String s)
    {
        return (ThreadMode)Enum.valueOf(de/greenrobot/event/ThreadMode, s);
    }

    public static ThreadMode[] values()
    {
        ThreadMode athreadmode[] = ENUM$VALUES;
        int i = athreadmode.length;
        ThreadMode athreadmode1[] = new ThreadMode[i];
        System.arraycopy(athreadmode, 0, athreadmode1, 0, i);
        return athreadmode1;
    }

    static 
    {
        PostThread = new ThreadMode("PostThread", 0);
        MainThread = new ThreadMode("MainThread", 1);
        BackgroundThread = new ThreadMode("BackgroundThread", 2);
        Async = new ThreadMode("Async", 3);
        ThreadMode athreadmode[] = new ThreadMode[4];
        athreadmode[0] = PostThread;
        athreadmode[1] = MainThread;
        athreadmode[2] = BackgroundThread;
        athreadmode[3] = Async;
        ENUM$VALUES = athreadmode;
    }
}
