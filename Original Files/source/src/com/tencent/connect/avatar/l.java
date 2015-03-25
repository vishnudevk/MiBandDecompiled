// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity, m, b

class l
    implements android.view.View.OnClickListener
{

    final ImageActivity a;

    l(ImageActivity imageactivity)
    {
        a = imageactivity;
        super();
    }

    public void onClick(View view)
    {
        ImageActivity.d(a).setVisibility(0);
        ImageActivity.e(a).setEnabled(false);
        ImageActivity.e(a).setTextColor(Color.rgb(21, 21, 21));
        ImageActivity.f(a).setEnabled(false);
        ImageActivity.f(a).setTextColor(Color.rgb(36, 94, 134));
        (new Thread(new m(this))).start();
        if (ImageActivity.h(a))
        {
            a.a("10657", 0L);
        } else
        {
            long l1 = System.currentTimeMillis() - ImageActivity.i(a);
            a.a("10655", l1);
            if (ImageActivity.c(a).b)
            {
                a.a("10654", 0L);
                return;
            }
        }
    }
}
