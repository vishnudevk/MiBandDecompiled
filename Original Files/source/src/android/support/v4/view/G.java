// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.view:
//            H, I

class G
{

    G()
    {
    }

    public static MenuItem a(MenuItem menuitem, I i)
    {
        return menuitem.setOnActionExpandListener(new H(i));
    }

    public static boolean a(MenuItem menuitem)
    {
        return menuitem.expandActionView();
    }

    public static boolean b(MenuItem menuitem)
    {
        return menuitem.collapseActionView();
    }

    public static boolean c(MenuItem menuitem)
    {
        return menuitem.isActionViewExpanded();
    }
}
