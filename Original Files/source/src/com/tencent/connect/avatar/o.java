// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.view.View;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity

class o
    implements android.view.View.OnClickListener
{

    final ImageActivity a;

    o(ImageActivity imageactivity)
    {
        a = imageactivity;
        super();
    }

    public void onClick(View view)
    {
        long l = System.currentTimeMillis() - ImageActivity.i(a);
        a.a("10656", l);
        a.setResult(0);
        ImageActivity.j(a);
    }
}
