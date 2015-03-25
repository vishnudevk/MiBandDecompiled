// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.graphics.Bitmap;

public class setBuilder extends setBuilder
{

    Bitmap a;
    Bitmap b;
    boolean c;

    public setBuilder bigLargeIcon(Bitmap bitmap)
    {
        b = bitmap;
        c = true;
        return this;
    }

    public c bigPicture(Bitmap bitmap)
    {
        a = bitmap;
        return this;
    }

    public a setBigContentTitle(CharSequence charsequence)
    {
        e = charsequence;
        return this;
    }

    public e setSummaryText(CharSequence charsequence)
    {
        f = charsequence;
        g = true;
        return this;
    }

    public ()
    {
    }

    public ( )
    {
        setBuilder();
    }
}
