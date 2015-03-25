// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.support.v4.internal.view.SupportMenuItem;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            C, B, A, E, 
//            ActionProvider

public class MenuItemCompat
{

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    static final E a;
    private static final String b = "MenuItemCompat";

    public MenuItemCompat()
    {
    }

    public static boolean collapseActionView(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).collapseActionView();
        } else
        {
            return a.c(menuitem);
        }
    }

    public static boolean expandActionView(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).expandActionView();
        } else
        {
            return a.b(menuitem);
        }
    }

    public static ActionProvider getActionProvider(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).getSupportActionProvider();
        } else
        {
            Log.w("MenuItemCompat", "getActionProvider: item does not implement SupportMenuItem; returning null");
            return null;
        }
    }

    public static View getActionView(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).getActionView();
        } else
        {
            return a.a(menuitem);
        }
    }

    public static boolean isActionViewExpanded(MenuItem menuitem)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).isActionViewExpanded();
        } else
        {
            return a.d(menuitem);
        }
    }

    public static MenuItem setActionProvider(MenuItem menuitem, ActionProvider actionprovider)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).setSupportActionProvider(actionprovider);
        } else
        {
            Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
            return menuitem;
        }
    }

    public static MenuItem setActionView(MenuItem menuitem, int i)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).setActionView(i);
        } else
        {
            return a.b(menuitem, i);
        }
    }

    public static MenuItem setActionView(MenuItem menuitem, View view)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).setActionView(view);
        } else
        {
            return a.a(menuitem, view);
        }
    }

    public static MenuItem setOnActionExpandListener(MenuItem menuitem, OnActionExpandListener onactionexpandlistener)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            return ((SupportMenuItem)menuitem).setSupportOnActionExpandListener(onactionexpandlistener);
        } else
        {
            return a.a(menuitem, onactionexpandlistener);
        }
    }

    public static void setShowAsAction(MenuItem menuitem, int i)
    {
        if (menuitem instanceof SupportMenuItem)
        {
            ((SupportMenuItem)menuitem).setShowAsAction(i);
            return;
        } else
        {
            a.a(menuitem, i);
            return;
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 14)
        {
            a = new C();
        } else
        if (i >= 11)
        {
            a = new B();
        } else
        {
            a = new A();
        }
    }
}
