// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            y, v, A, z

public class SearchViewCompat
{

    private static final z a;

    private SearchViewCompat(Context context)
    {
    }

    static z a()
    {
        return a;
    }

    public static CharSequence getQuery(View view)
    {
        return a.a(view);
    }

    public static boolean isIconified(View view)
    {
        return a.b(view);
    }

    public static boolean isQueryRefinementEnabled(View view)
    {
        return a.d(view);
    }

    public static boolean isSubmitButtonEnabled(View view)
    {
        return a.c(view);
    }

    public static View newSearchView(Context context)
    {
        return a.a(context);
    }

    public static void setIconified(View view, boolean flag)
    {
        a.a(view, flag);
    }

    public static void setImeOptions(View view, int i)
    {
        a.b(view, i);
    }

    public static void setInputType(View view, int i)
    {
        a.c(view, i);
    }

    public static void setMaxWidth(View view, int i)
    {
        a.a(view, i);
    }

    public static void setOnCloseListener(View view, OnCloseListenerCompat oncloselistenercompat)
    {
        a.b(view, oncloselistenercompat.a);
    }

    public static void setOnQueryTextListener(View view, OnQueryTextListenerCompat onquerytextlistenercompat)
    {
        a.a(view, onquerytextlistenercompat.a);
    }

    public static void setQuery(View view, CharSequence charsequence, boolean flag)
    {
        a.a(view, charsequence, flag);
    }

    public static void setQueryHint(View view, CharSequence charsequence)
    {
        a.a(view, charsequence);
    }

    public static void setQueryRefinementEnabled(View view, boolean flag)
    {
        a.c(view, flag);
    }

    public static void setSearchableInfo(View view, ComponentName componentname)
    {
        a.a(view, componentname);
    }

    public static void setSubmitButtonEnabled(View view, boolean flag)
    {
        a.b(view, flag);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new y();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new v();
        } else
        {
            a = new A();
        }
    }

    private class OnCloseListenerCompat
    {

        final Object a = SearchViewCompat.a().a(this);

        public boolean onClose()
        {
            return false;
        }

        public OnCloseListenerCompat()
        {
        }
    }


    private class OnQueryTextListenerCompat
    {

        final Object a = SearchViewCompat.a().a(this);

        public boolean onQueryTextChange(String s)
        {
            return false;
        }

        public boolean onQueryTextSubmit(String s)
        {
            return false;
        }

        public OnQueryTextListenerCompat()
        {
        }
    }

}
