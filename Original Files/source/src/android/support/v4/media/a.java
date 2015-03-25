// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.view.KeyEvent;

// Referenced classes of package android.support.v4.media:
//            c, TransportMediator, TransportPerformer

class a
    implements c
{

    final TransportMediator a;

    a(TransportMediator transportmediator)
    {
        a = transportmediator;
        super();
    }

    public long a()
    {
        return a.b.onGetCurrentPosition();
    }

    public void a(int i)
    {
        a.b.onAudioFocusChange(i);
    }

    public void a(long l)
    {
        a.b.onSeekTo(l);
    }

    public void a(KeyEvent keyevent)
    {
        keyevent.dispatch(a.i);
    }
}
