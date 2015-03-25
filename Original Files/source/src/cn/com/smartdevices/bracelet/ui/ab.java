// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;


// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DynamicFragment, MainUIActivity

class ab
    implements cn.com.smartdevices.bracelet.chart.util.AnimUtil.AnimColorListener
{

    final DynamicFragment a;

    ab(DynamicFragment dynamicfragment)
    {
        a = dynamicfragment;
        super();
    }

    public void onColorChanged(int i)
    {
        ((MainUIActivity)a.getActivity()).applyStatusBarTint(i);
    }
}
