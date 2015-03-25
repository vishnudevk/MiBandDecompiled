// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nirhart.parallaxscroll.views;

import android.view.View;

// Referenced classes of package com.nirhart.parallaxscroll.views:
//            ParallaxedView, ParallaxScrollView

public class a extends ParallaxedView
{

    final ParallaxScrollView a;

    protected void translatePreICS(View view, float f)
    {
        view.offsetTopAndBottom((int)f - lastOffset);
        lastOffset = (int)f;
    }

    public (ParallaxScrollView parallaxscrollview, View view)
    {
        a = parallaxscrollview;
        super(view);
    }
}
