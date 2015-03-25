// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.view:
//            I, C

class D
    implements I
{

    final MenuItemCompat.OnActionExpandListener a;
    final C b;

    D(C c, MenuItemCompat.OnActionExpandListener onactionexpandlistener)
    {
        b = c;
        a = onactionexpandlistener;
        super();
    }

    public boolean a(MenuItem menuitem)
    {
        return a.onMenuItemActionExpand(menuitem);
    }

    public boolean b(MenuItem menuitem)
    {
        return a.onMenuItemActionCollapse(menuitem);
    }
}
