// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseSCActivity, w

class v
    implements Runnable
{

    final boolean a;
    final BaseSCActivity b;

    v(BaseSCActivity basescactivity, boolean flag)
    {
        b = basescactivity;
        a = flag;
        super();
    }

    public void run()
    {
        BaseSCActivity.c(b, a);
        BaseSCActivity.d(b, a);
        b.generateSleepReport();
        b.generateActivitiesReport();
        BaseSCActivity.p(b);
        BaseSCActivity.a(b, a);
        b.runOnUiThread(new w(this));
    }
}
