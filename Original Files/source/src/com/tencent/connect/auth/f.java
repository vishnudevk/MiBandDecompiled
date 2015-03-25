// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.auth;

import android.content.DialogInterface;
import com.tencent.tauth.IUiListener;

// Referenced classes of package com.tencent.connect.auth:
//            c

class f
    implements android.content.DialogInterface.OnCancelListener
{

    final IUiListener a;
    final Object b;
    final c c;

    f(c c1, IUiListener iuilistener, Object obj)
    {
        c = c1;
        a = iuilistener;
        b = obj;
        super();
    }

    public void onCancel(DialogInterface dialoginterface)
    {
        if (a != null)
        {
            a.onComplete(b);
        }
    }
}
