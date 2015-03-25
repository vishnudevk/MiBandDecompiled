// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.View;
import java.util.Comparator;

class aH
    implements Comparator
{

    aH()
    {
    }

    public int a(View view, View view1)
    {
        ViewPager.LayoutParams layoutparams = (ViewPager.LayoutParams)view.getLayoutParams();
        ViewPager.LayoutParams layoutparams1 = (ViewPager.LayoutParams)view1.getLayoutParams();
        if (layoutparams.isDecor != layoutparams1.isDecor)
        {
            return !layoutparams.isDecor ? -1 : 1;
        } else
        {
            return layoutparams.c - layoutparams1.c;
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((View)obj, (View)obj1);
    }
}
