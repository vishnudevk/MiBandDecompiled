// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.media.MediaPlayer;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import java.util.HashMap;

public class SoundPullEventListener
    implements com.handmark.pulltorefresh.library.PullToRefreshBase.OnPullEventListener
{

    private final Context a;
    private final HashMap b = new HashMap();
    private MediaPlayer c;

    public SoundPullEventListener(Context context)
    {
        a = context;
    }

    private void a(int i)
    {
        if (c != null)
        {
            c.stop();
            c.release();
        }
        c = MediaPlayer.create(a, i);
        if (c != null)
        {
            c.start();
        }
    }

    public void addSoundEvent(com.handmark.pulltorefresh.library.PullToRefreshBase.State state, int i)
    {
        b.put(state, Integer.valueOf(i));
    }

    public void clearSounds()
    {
        b.clear();
    }

    public MediaPlayer getCurrentMediaPlayer()
    {
        return c;
    }

    public final void onPullEvent(PullToRefreshBase pulltorefreshbase, com.handmark.pulltorefresh.library.PullToRefreshBase.State state, com.handmark.pulltorefresh.library.PullToRefreshBase.Mode mode)
    {
        Integer integer = (Integer)b.get(state);
        if (integer != null)
        {
            a(integer.intValue());
        }
    }
}
