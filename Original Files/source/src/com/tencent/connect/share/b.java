// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.a.a.c;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.AsynLoadImgBack;
import java.util.ArrayList;

// Referenced classes of package com.tencent.connect.share:
//            QQShare

class b
    implements AsynLoadImgBack
{

    final Bundle a;
    final String b;
    final String c;
    final IUiListener d;
    final Activity e;
    final QQShare f;

    b(QQShare qqshare, Bundle bundle, String s, String s1, IUiListener iuilistener, Activity activity)
    {
        f = qqshare;
        a = bundle;
        b = s;
        c = s1;
        d = iuilistener;
        e = activity;
        super();
    }

    public void batchSaved(int i, ArrayList arraylist)
    {
    }

    public void saved(int i, String s)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        a.putString("imageLocalUrl", s);
_L6:
        QQShare.a(f, e, a, d);
_L4:
        return;
_L2:
        if (!TextUtils.isEmpty(b) || !TextUtils.isEmpty(c))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (d != null)
        {
            d.onError(new UiError(-6, "\u83B7\u53D6\u5206\u4EAB\u56FE\u7247\u5931\u8D25!", null));
            com.tencent.a.a.c.a("shareToQQ", "\u83B7\u53D6\u5206\u4EAB\u56FE\u7247\u5931\u8D25!");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }
}
