// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;


// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            u, RulerScrollView

class v
    implements Runnable
{

    final u a;

    v(u u1)
    {
        a = u1;
        super();
    }

    public void run()
    {
        RulerScrollView.a(a.a);
    }
}
