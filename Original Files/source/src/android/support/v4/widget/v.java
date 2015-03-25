// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

// Referenced classes of package android.support.v4.widget:
//            A, B, x, w

class v extends A
{

    v()
    {
    }

    public View a(Context context)
    {
        return B.a(context);
    }

    public CharSequence a(View view)
    {
        return B.a(view);
    }

    public Object a(SearchViewCompat.OnCloseListenerCompat oncloselistenercompat)
    {
        return B.a(new x(this, oncloselistenercompat));
    }

    public Object a(SearchViewCompat.OnQueryTextListenerCompat onquerytextlistenercompat)
    {
        return B.a(new w(this, onquerytextlistenercompat));
    }

    public void a(View view, int i)
    {
        B.a(view, i);
    }

    public void a(View view, ComponentName componentname)
    {
        B.a(view, componentname);
    }

    public void a(View view, CharSequence charsequence)
    {
        B.a(view, charsequence);
    }

    public void a(View view, CharSequence charsequence, boolean flag)
    {
        B.a(view, charsequence, flag);
    }

    public void a(View view, boolean flag)
    {
        B.a(view, flag);
    }

    public void a(Object obj, Object obj1)
    {
        B.a(obj, obj1);
    }

    public void b(View view, boolean flag)
    {
        B.b(view, flag);
    }

    public void b(Object obj, Object obj1)
    {
        B.b(obj, obj1);
    }

    public boolean b(View view)
    {
        return B.b(view);
    }

    public void c(View view, boolean flag)
    {
        B.c(view, flag);
    }

    public boolean c(View view)
    {
        return B.c(view);
    }

    public boolean d(View view)
    {
        return B.d(view);
    }
}
