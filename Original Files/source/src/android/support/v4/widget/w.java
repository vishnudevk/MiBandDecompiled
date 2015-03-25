// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;


// Referenced classes of package android.support.v4.widget:
//            F, v

class w
    implements F
{

    final SearchViewCompat.OnQueryTextListenerCompat a;
    final v b;

    w(v v, SearchViewCompat.OnQueryTextListenerCompat onquerytextlistenercompat)
    {
        b = v;
        a = onquerytextlistenercompat;
        super();
    }

    public boolean a(String s)
    {
        return a.onQueryTextSubmit(s);
    }

    public boolean b(String s)
    {
        return a.onQueryTextChange(s);
    }
}
