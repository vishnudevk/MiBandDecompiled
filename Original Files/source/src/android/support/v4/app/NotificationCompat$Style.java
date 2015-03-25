// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

public abstract class g
{

    r d;
    CharSequence e;
    CharSequence f;
    boolean g;

    public Notification build()
    {
        r r = d;
        Notification notification = null;
        if (r != null)
        {
            notification = d.build();
        }
        return notification;
    }

    public void setBuilder(r r)
    {
        if (d != r)
        {
            d = r;
            if (d != null)
            {
                d.setStyle(this);
            }
        }
    }

    public r()
    {
        g = false;
    }
}
