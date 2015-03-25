// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.app.Dialog;
import android.view.View;
import com.tencent.tauth.IUiListener;

// Referenced classes of package com.tencent.connect.auth:
//            g, c

class d extends g
{

    final IUiListener a;
    final Object b;
    final c c;

    d(c c1, Dialog dialog, IUiListener iuilistener, Object obj)
    {
        c = c1;
        a = iuilistener;
        b = obj;
        super(c1, dialog);
    }

    public void onClick(View view)
    {
        c.a();
        if (d != null && d.isShowing())
        {
            d.dismiss();
        }
        if (a != null)
        {
            a.onComplete(b);
        }
    }
}
