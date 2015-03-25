// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;

// Referenced classes of package android.support.v4.view:
//            PagerTabStrip, ViewPager

class N
    implements android.view.View.OnClickListener
{

    final PagerTabStrip a;

    N(PagerTabStrip pagertabstrip)
    {
        a = pagertabstrip;
        super();
    }

    public void onClick(View view)
    {
        a.a.setCurrentItem(-1 + a.a.getCurrentItem());
    }
}
