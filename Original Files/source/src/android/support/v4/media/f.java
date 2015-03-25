// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media;


// Referenced classes of package android.support.v4.media:
//            d

class f
    implements android.view.ViewTreeObserver.OnWindowFocusChangeListener
{

    final d a;

    f(d d1)
    {
        a = d1;
        super();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (flag)
        {
            a.d();
            return;
        } else
        {
            a.j();
            return;
        }
    }
}
