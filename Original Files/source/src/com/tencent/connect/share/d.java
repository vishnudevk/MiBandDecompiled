// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.share;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.AsynLoadImgBack;
import java.util.ArrayList;

// Referenced classes of package com.tencent.connect.share:
//            QzoneShare

class d
    implements AsynLoadImgBack
{

    final Bundle a;
    final Activity b;
    final IUiListener c;
    final QzoneShare d;

    d(QzoneShare qzoneshare, Bundle bundle, Activity activity, IUiListener iuilistener)
    {
        d = qzoneshare;
        a = bundle;
        b = activity;
        c = iuilistener;
        super();
    }

    public void batchSaved(int i, ArrayList arraylist)
    {
        if (i == 0)
        {
            a.putStringArrayList("imageUrl", arraylist);
        }
        QzoneShare.a(d, b, a, c);
    }

    public void saved(int i, String s)
    {
    }
}
