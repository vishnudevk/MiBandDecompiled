// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.media:
//            TransportController, a, b, d, 
//            TransportStateListener, TransportPerformer, c

public class TransportMediator extends TransportController
{

    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final Context a;
    final TransportPerformer b;
    final AudioManager c;
    final View d;
    final Object e;
    final d f;
    final ArrayList g;
    final c h;
    final android.view.KeyEvent.Callback i;

    public TransportMediator(Activity activity, TransportPerformer transportperformer)
    {
        this(activity, null, transportperformer);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer transportperformer)
    {
        g = new ArrayList();
        h = new a(this);
        i = new b(this);
        Object obj;
        if (activity != null)
        {
            obj = activity;
        } else
        {
            obj = view.getContext();
        }
        a = ((Context) (obj));
        b = transportperformer;
        c = (AudioManager)a.getSystemService("audio");
        if (activity != null)
        {
            view = activity.getWindow().getDecorView();
        }
        d = view;
        e = KeyEventCompat.getKeyDispatcherState(d);
        if (android.os.Build.VERSION.SDK_INT >= 18)
        {
            f = new d(a, c, d, h);
            return;
        } else
        {
            f = null;
            return;
        }
    }

    public TransportMediator(View view, TransportPerformer transportperformer)
    {
        this(null, view, transportperformer);
    }

    static boolean a(int j)
    {
        switch (j)
        {
        default:
            return false;

        case 79: // 'O'
        case 85: // 'U'
        case 86: // 'V'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        case 90: // 'Z'
        case 91: // '['
        case 126: // '~'
        case 127: // '\177'
        case 130: 
            return true;
        }
    }

    private TransportStateListener[] a()
    {
        if (g.size() <= 0)
        {
            return null;
        } else
        {
            TransportStateListener atransportstatelistener[] = new TransportStateListener[g.size()];
            g.toArray(atransportstatelistener);
            return atransportstatelistener;
        }
    }

    private void b()
    {
        TransportStateListener atransportstatelistener[] = a();
        if (atransportstatelistener != null)
        {
            int j = atransportstatelistener.length;
            for (int k = 0; k < j; k++)
            {
                atransportstatelistener[k].onPlayingChanged(this);
            }

        }
    }

    private void c()
    {
        TransportStateListener atransportstatelistener[] = a();
        if (atransportstatelistener != null)
        {
            int j = atransportstatelistener.length;
            for (int k = 0; k < j; k++)
            {
                atransportstatelistener[k].onTransportControlsChanged(this);
            }

        }
    }

    private void d()
    {
        if (f != null)
        {
            f.a(b.onIsPlaying(), b.onGetCurrentPosition(), b.onGetTransportControlFlags());
        }
    }

    public void destroy()
    {
        f.b();
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        return KeyEventCompat.dispatch(keyevent, i, e, this);
    }

    public int getBufferPercentage()
    {
        return b.onGetBufferPercentage();
    }

    public long getCurrentPosition()
    {
        return b.onGetCurrentPosition();
    }

    public long getDuration()
    {
        return b.onGetDuration();
    }

    public Object getRemoteControlClient()
    {
        if (f != null)
        {
            return f.a();
        } else
        {
            return null;
        }
    }

    public int getTransportControlFlags()
    {
        return b.onGetTransportControlFlags();
    }

    public boolean isPlaying()
    {
        return b.onIsPlaying();
    }

    public void pausePlaying()
    {
        if (f != null)
        {
            f.g();
        }
        b.onPause();
        d();
        b();
    }

    public void refreshState()
    {
        d();
        b();
        c();
    }

    public void registerStateListener(TransportStateListener transportstatelistener)
    {
        g.add(transportstatelistener);
    }

    public void seekTo(long l)
    {
        b.onSeekTo(l);
    }

    public void startPlaying()
    {
        if (f != null)
        {
            f.f();
        }
        b.onStart();
        d();
        b();
    }

    public void stopPlaying()
    {
        if (f != null)
        {
            f.h();
        }
        b.onStop();
        d();
        b();
    }

    public void unregisterStateListener(TransportStateListener transportstatelistener)
    {
        g.remove(transportstatelistener);
    }
}
