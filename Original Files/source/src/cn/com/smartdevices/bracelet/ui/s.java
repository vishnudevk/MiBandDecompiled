// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseSCActivity, t

class s
    implements Runnable
{

    final BaseSCActivity a;

    s(BaseSCActivity basescactivity)
    {
        a = basescactivity;
        super();
    }

    public void run()
    {
        BaseSCActivity.a(a, true);
        a.runOnUiThread(new t(this));
    }
}
