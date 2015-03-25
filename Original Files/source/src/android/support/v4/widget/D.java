// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;


// Referenced classes of package android.support.v4.widget:
//            E

final class D
    implements android.widget.SearchView.OnCloseListener
{

    final E a;

    D(E e)
    {
        a = e;
        super();
    }

    public boolean onClose()
    {
        return a.a();
    }
}
