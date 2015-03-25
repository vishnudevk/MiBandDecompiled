// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;

// Referenced classes of package android.support.v4.app:
//            Q

class R
    implements Q
{

    R()
    {
    }

    public Notification a(NotificationCompat.Builder builder)
    {
        Notification notification = builder.r;
        notification.setLatestEventInfo(builder.a, builder.b, builder.c, builder.d);
        if (builder.j > 0)
        {
            notification.flags = 0x80 | notification.flags;
        }
        return notification;
    }
}
