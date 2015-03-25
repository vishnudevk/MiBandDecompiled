// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;


// Referenced classes of package android.support.v4.widget:
//            E, v

class x
    implements E
{

    final SearchViewCompat.OnCloseListenerCompat a;
    final v b;

    x(v v, SearchViewCompat.OnCloseListenerCompat oncloselistenercompat)
    {
        b = v;
        a = oncloselistenercompat;
        super();
    }

    public boolean a()
    {
        return a.onClose();
    }
}
