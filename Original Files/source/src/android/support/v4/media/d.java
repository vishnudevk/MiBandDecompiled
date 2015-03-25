// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package android.support.v4.media:
//            e, f, g, h, 
//            c

class d
    implements android.media.RemoteControlClient.OnGetPlaybackPositionListener, android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
{

    final Context a;
    final AudioManager b;
    final View c;
    final c d;
    final String e;
    final IntentFilter f = new IntentFilter();
    final Intent g;
    final android.view.ViewTreeObserver.OnWindowAttachListener h = new e(this);
    final android.view.ViewTreeObserver.OnWindowFocusChangeListener i = new f(this);
    final BroadcastReceiver j = new g(this);
    android.media.AudioManager.OnAudioFocusChangeListener k;
    PendingIntent l;
    RemoteControlClient m;
    boolean n;
    int o;
    boolean p;

    public d(Context context, AudioManager audiomanager, View view, c c1)
    {
        k = new h(this);
        o = 0;
        a = context;
        b = audiomanager;
        c = view;
        d = c1;
        e = (new StringBuilder()).append(context.getPackageName()).append(":transport:").append(System.identityHashCode(this)).toString();
        g = new Intent(e);
        g.setPackage(context.getPackageName());
        f.addAction(e);
        c.getViewTreeObserver().addOnWindowAttachListener(h);
        c.getViewTreeObserver().addOnWindowFocusChangeListener(i);
    }

    public Object a()
    {
        return m;
    }

    public void a(boolean flag, long l1, int i1)
    {
        if (m != null)
        {
            RemoteControlClient remotecontrolclient = m;
            byte byte0;
            float f1;
            if (flag)
            {
                byte0 = 3;
            } else
            {
                byte0 = 1;
            }
            if (flag)
            {
                f1 = 1.0F;
            } else
            {
                f1 = 0.0F;
            }
            remotecontrolclient.setPlaybackState(byte0, l1, f1);
            m.setTransportControlFlags(i1);
        }
    }

    public void b()
    {
        k();
        c.getViewTreeObserver().removeOnWindowAttachListener(h);
        c.getViewTreeObserver().removeOnWindowFocusChangeListener(i);
    }

    void c()
    {
        a.registerReceiver(j, f);
        l = PendingIntent.getBroadcast(a, 0, g, 0x10000000);
        m = new RemoteControlClient(l);
        m.setOnGetPlaybackPositionListener(this);
        m.setPlaybackPositionUpdateListener(this);
    }

    void d()
    {
        if (!n)
        {
            n = true;
            b.registerMediaButtonEventReceiver(l);
            b.registerRemoteControlClient(m);
            if (o == 3)
            {
                e();
            }
        }
    }

    void e()
    {
        if (!p)
        {
            p = true;
            b.requestAudioFocus(k, 3, 1);
        }
    }

    public void f()
    {
        if (o != 3)
        {
            o = 3;
            m.setPlaybackState(3);
        }
        if (n)
        {
            e();
        }
    }

    public void g()
    {
        if (o == 3)
        {
            o = 2;
            m.setPlaybackState(2);
        }
        i();
    }

    public void h()
    {
        if (o != 1)
        {
            o = 1;
            m.setPlaybackState(1);
        }
        i();
    }

    void i()
    {
        if (p)
        {
            p = false;
            b.abandonAudioFocus(k);
        }
    }

    void j()
    {
        i();
        if (n)
        {
            n = false;
            b.unregisterRemoteControlClient(m);
            b.unregisterMediaButtonEventReceiver(l);
        }
    }

    void k()
    {
        j();
        if (l != null)
        {
            a.unregisterReceiver(j);
            l.cancel();
            l = null;
            m = null;
        }
    }

    public long onGetPlaybackPosition()
    {
        return d.a();
    }

    public void onPlaybackPositionUpdate(long l1)
    {
        d.a(l1);
    }
}
