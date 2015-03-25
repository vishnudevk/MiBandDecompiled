// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.listener;

import android.widget.AbsListView;
import com.nostra13.universalimageloader.core.ImageLoader;

public class PauseOnScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private ImageLoader a;
    private final boolean b;
    private final boolean c;
    private final android.widget.AbsListView.OnScrollListener d;

    public PauseOnScrollListener(ImageLoader imageloader, boolean flag, boolean flag1)
    {
        this(imageloader, flag, flag1, null);
    }

    public PauseOnScrollListener(ImageLoader imageloader, boolean flag, boolean flag1, android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        a = imageloader;
        b = flag;
        c = flag1;
        d = onscrolllistener;
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (d != null)
        {
            d.onScroll(abslistview, i, j, k);
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        i;
        JVM INSTR tableswitch 0 2: default 28
    //                   0 47
    //                   1 57
    //                   2 74;
           goto _L1 _L2 _L3 _L4
_L1:
        if (d != null)
        {
            d.onScrollStateChanged(abslistview, i);
        }
        return;
_L2:
        a.resume();
        continue; /* Loop/switch isn't completed */
_L3:
        if (b)
        {
            a.pause();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c)
        {
            a.pause();
        }
        if (true) goto _L1; else goto _L5
_L5:
    }
}
