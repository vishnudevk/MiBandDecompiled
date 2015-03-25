// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity, g, b

class d
    implements android.view.ViewTreeObserver.OnGlobalLayoutListener
{

    final ImageActivity a;

    d(ImageActivity imageactivity)
    {
        a = imageactivity;
        super();
    }

    public void onGlobalLayout()
    {
        a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        ImageActivity.a(a, ImageActivity.a(a).a());
        ImageActivity.c(a).a(ImageActivity.b(a));
    }
}
