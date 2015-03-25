// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;

// Referenced classes of package android.support.v4.app:
//            d, c, e, b

public class ActionBarDrawerToggle
    implements android.support.v4.widget.DrawerLayout.DrawerListener
{

    private static final b a;
    private static final int b = 0x102002c;
    private final Activity c;
    private final Delegate d;
    private final DrawerLayout e;
    private boolean f;
    private Drawable g;
    private Drawable h;
    private e i;
    private final int j;
    private final int k;
    private final int l;
    private Object m;

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerlayout, int i1, int j1, int k1)
    {
        f = true;
        c = activity;
        e = drawerlayout;
        j = i1;
        k = j1;
        l = k1;
        g = a();
        h = activity.getResources().getDrawable(i1);
        i = new e(h);
        i.b(0.3333333F);
        if (activity instanceof DelegateProvider)
        {
            d = ((DelegateProvider)activity).getDrawerToggleDelegate();
            return;
        } else
        {
            d = null;
            return;
        }
    }

    Drawable a()
    {
        if (d != null)
        {
            return d.getThemeUpIndicator();
        } else
        {
            return a.a(c);
        }
    }

    void a(int i1)
    {
        if (d != null)
        {
            d.setActionBarDescription(i1);
            return;
        } else
        {
            m = a.a(m, c, i1);
            return;
        }
    }

    void a(Drawable drawable, int i1)
    {
        if (d != null)
        {
            d.setActionBarUpIndicator(drawable, i1);
            return;
        } else
        {
            m = a.a(m, c, drawable, i1);
            return;
        }
    }

    public boolean isDrawerIndicatorEnabled()
    {
        return f;
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        g = a();
        h = c.getResources().getDrawable(j);
        syncState();
    }

    public void onDrawerClosed(View view)
    {
        i.a(0.0F);
        if (f)
        {
            a(l);
        }
    }

    public void onDrawerOpened(View view)
    {
        i.a(1.0F);
        if (f)
        {
            a(k);
        }
    }

    public void onDrawerSlide(View view, float f1)
    {
        float f2 = i.a();
        float f3;
        if (f1 > 0.5F)
        {
            f3 = Math.max(f2, 2.0F * Math.max(0.0F, f1 - 0.5F));
        } else
        {
            f3 = Math.min(f2, f1 * 2.0F);
        }
        i.a(f3);
    }

    public void onDrawerStateChanged(int i1)
    {
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem != null && menuitem.getItemId() == 0x102002c && f)
        {
            if (e.isDrawerVisible(0x800003))
            {
                e.closeDrawer(0x800003);
            } else
            {
                e.openDrawer(0x800003);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void setDrawerIndicatorEnabled(boolean flag)
    {
        if (flag != f)
        {
            if (flag)
            {
                e e1 = i;
                int i1;
                if (e.isDrawerOpen(0x800003))
                {
                    i1 = k;
                } else
                {
                    i1 = l;
                }
                a(e1, i1);
            } else
            {
                a(g, 0);
            }
            f = flag;
        }
    }

    public void syncState()
    {
        if (e.isDrawerOpen(0x800003))
        {
            i.a(1.0F);
        } else
        {
            i.a(0.0F);
        }
        if (f)
        {
            e e1 = i;
            int i1;
            if (e.isDrawerOpen(0x800003))
            {
                i1 = k;
            } else
            {
                i1 = l;
            }
            a(e1, i1);
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new d(null);
        } else
        {
            a = new c(null);
        }
    }

    private class DelegateProvider
    {

        public abstract Delegate getDrawerToggleDelegate();
    }


    private class Delegate
    {

        public abstract Drawable getThemeUpIndicator();

        public abstract void setActionBarDescription(int i1);

        public abstract void setActionBarUpIndicator(Drawable drawable, int i1);
    }

}
