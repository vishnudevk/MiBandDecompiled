// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.ComponentName;
import android.content.Context;
import android.view.View;

interface z
{

    public abstract View a(Context context);

    public abstract CharSequence a(View view);

    public abstract Object a(SearchViewCompat.OnCloseListenerCompat oncloselistenercompat);

    public abstract Object a(SearchViewCompat.OnQueryTextListenerCompat onquerytextlistenercompat);

    public abstract void a(View view, int i);

    public abstract void a(View view, ComponentName componentname);

    public abstract void a(View view, CharSequence charsequence);

    public abstract void a(View view, CharSequence charsequence, boolean flag);

    public abstract void a(View view, boolean flag);

    public abstract void a(Object obj, Object obj1);

    public abstract void b(View view, int i);

    public abstract void b(View view, boolean flag);

    public abstract void b(Object obj, Object obj1);

    public abstract boolean b(View view);

    public abstract void c(View view, int i);

    public abstract void c(View view, boolean flag);

    public abstract boolean c(View view);

    public abstract boolean d(View view);
}
