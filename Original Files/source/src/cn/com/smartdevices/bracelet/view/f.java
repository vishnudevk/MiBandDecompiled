// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.view.View;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            DynamicView

class f
    implements android.view.View.OnClickListener
{

    final DynamicView a;

    f(DynamicView dynamicview)
    {
        a = dynamicview;
        super();
    }

    public void onClick(View view)
    {
        DynamicView.a(a);
    }
}
