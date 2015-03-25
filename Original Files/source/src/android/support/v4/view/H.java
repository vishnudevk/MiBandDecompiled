// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.view:
//            I

class H
    implements android.view.MenuItem.OnActionExpandListener
{

    private I a;

    public H(I i)
    {
        a = i;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        return a.b(menuitem);
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return a.a(menuitem);
    }
}
