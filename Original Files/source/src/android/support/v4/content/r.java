// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;


class r
{

    static final int a[];

    static 
    {
        a = new int[ModernAsyncTask.Status.values().length];
        try
        {
            a[ModernAsyncTask.Status.RUNNING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[ModernAsyncTask.Status.FINISHED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1)
        {
            return;
        }
    }
}
