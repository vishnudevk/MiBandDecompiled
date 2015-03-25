// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            NotificationCompat, Q

public class j
{

    Context a;
    CharSequence b;
    CharSequence c;
    PendingIntent d;
    PendingIntent e;
    RemoteViews f;
    Bitmap g;
    CharSequence h;
    int i;
    int j;
    boolean k;
    r l;
    CharSequence m;
    int n;
    int o;
    boolean p;
    ArrayList q;
    Notification r;

    private void a(int i1, boolean flag)
    {
        if (flag)
        {
            Notification notification1 = r;
            notification1.flags = i1 | notification1.flags;
            return;
        } else
        {
            Notification notification = r;
            notification.flags = notification.flags & ~i1;
            return;
        }
    }

    public r addAction(int i1, CharSequence charsequence, PendingIntent pendingintent)
    {
        q.add(new init>(i1, charsequence, pendingintent));
        return this;
    }

    public Notification build()
    {
        return NotificationCompat.a().a(this);
    }

    public Notification getNotification()
    {
        return NotificationCompat.a().a(this);
    }

    public init> setAutoCancel(boolean flag)
    {
        a(16, flag);
        return this;
    }

    public a setContent(RemoteViews remoteviews)
    {
        r.contentView = remoteviews;
        return this;
    }

    public r setContentInfo(CharSequence charsequence)
    {
        h = charsequence;
        return this;
    }

    public h setContentIntent(PendingIntent pendingintent)
    {
        d = pendingintent;
        return this;
    }

    public d setContentText(CharSequence charsequence)
    {
        c = charsequence;
        return this;
    }

    public c setContentTitle(CharSequence charsequence)
    {
        b = charsequence;
        return this;
    }

    public b setDefaults(int i1)
    {
        r.defaults = i1;
        if ((i1 & 4) != 0)
        {
            Notification notification = r;
            notification.flags = 1 | notification.flags;
        }
        return this;
    }

    public r setDeleteIntent(PendingIntent pendingintent)
    {
        r.deleteIntent = pendingintent;
        return this;
    }

    public r setFullScreenIntent(PendingIntent pendingintent, boolean flag)
    {
        e = pendingintent;
        a(128, flag);
        return this;
    }

    public a setLargeIcon(Bitmap bitmap)
    {
        g = bitmap;
        return this;
    }

    public g setLights(int i1, int j1, int k1)
    {
        boolean flag = true;
        r.ledARGB = i1;
        r.ledOnMS = j1;
        r.ledOffMS = k1;
        boolean flag1;
        Notification notification;
        int l1;
        if (r.ledOnMS != 0 && r.ledOffMS != 0)
        {
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        notification = r;
        l1 = -2 & r.flags;
        if (!flag1)
        {
            flag = false;
        }
        notification.flags = l1 | flag;
        return this;
    }

    public r setNumber(int i1)
    {
        i = i1;
        return this;
    }

    public i setOngoing(boolean flag)
    {
        a(2, flag);
        return this;
    }

    public a setOnlyAlertOnce(boolean flag)
    {
        a(8, flag);
        return this;
    }

    public a setPriority(int i1)
    {
        j = i1;
        return this;
    }

    public j setProgress(int i1, int j1, boolean flag)
    {
        n = i1;
        o = j1;
        p = flag;
        return this;
    }

    public p setSmallIcon(int i1)
    {
        r.icon = i1;
        return this;
    }

    public r setSmallIcon(int i1, int j1)
    {
        r.icon = i1;
        r.iconLevel = j1;
        return this;
    }

    public r setSound(Uri uri)
    {
        r.sound = uri;
        r.audioStreamType = -1;
        return this;
    }

    public r setSound(Uri uri, int i1)
    {
        r.sound = uri;
        r.audioStreamType = i1;
        return this;
    }

    public r setStyle(r r1)
    {
        if (l != r1)
        {
            l = r1;
            if (l != null)
            {
                l.tBuilder(this);
            }
        }
        return this;
    }

    public tBuilder setSubText(CharSequence charsequence)
    {
        m = charsequence;
        return this;
    }

    public m setTicker(CharSequence charsequence)
    {
        r.tickerText = charsequence;
        return this;
    }

    public r setTicker(CharSequence charsequence, RemoteViews remoteviews)
    {
        r.tickerText = charsequence;
        f = remoteviews;
        return this;
    }

    public f setUsesChronometer(boolean flag)
    {
        k = flag;
        return this;
    }

    public k setVibrate(long al[])
    {
        r.vibrate = al;
        return this;
    }

    public r setWhen(long l1)
    {
        r.when = l1;
        return this;
    }

    public (Context context)
    {
        q = new ArrayList();
        r = new Notification();
        a = context;
        r.when = System.currentTimeMillis();
        r.audioStreamType = -1;
        j = 0;
    }
}
