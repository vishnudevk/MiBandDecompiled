// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            MainUIActivity

class aU
    implements Runnable
{

    final MainUIActivity a;

    aU(MainUIActivity mainuiactivity)
    {
        a = mainuiactivity;
        super();
    }

    public void run()
    {
        a.updateDynamicList(false);
    }
}
