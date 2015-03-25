// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

public abstract class TransportPerformer
{

    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = -1;
    static final int e = -2;
    static final int f = -3;

    public TransportPerformer()
    {
    }

    public void onAudioFocusChange(int i)
    {
        int j = 0;
        i;
        JVM INSTR tableswitch -1 -1: default 20
    //                   -1 65;
           goto _L1 _L2
_L1:
        if (j != 0)
        {
            long l = SystemClock.uptimeMillis();
            onMediaButtonDown(j, new KeyEvent(l, l, 0, j, 0));
            onMediaButtonUp(j, new KeyEvent(l, l, 1, j, 0));
        }
        return;
_L2:
        j = 127;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int onGetBufferPercentage()
    {
        return 100;
    }

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public int onGetTransportControlFlags()
    {
        return 60;
    }

    public abstract boolean onIsPlaying();

    public boolean onMediaButtonDown(int i, KeyEvent keyevent)
    {
        switch (i)
        {
        default:
            return true;

        case 126: // '~'
            onStart();
            return true;

        case 127: // '\177'
            onPause();
            return true;

        case 86: // 'V'
            onStop();
            return true;

        case 79: // 'O'
        case 85: // 'U'
            break;
        }
        if (onIsPlaying())
        {
            onPause();
            return true;
        } else
        {
            onStart();
            return true;
        }
    }

    public boolean onMediaButtonUp(int i, KeyEvent keyevent)
    {
        return true;
    }

    public abstract void onPause();

    public abstract void onSeekTo(long l);

    public abstract void onStart();

    public abstract void onStop();
}
