// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.hm.cheneehealth.wxapi;

import android.view.View;
import com.tencent.mm.sdk.openapi.IWXAPI;

// Referenced classes of package com.hm.cheneehealth.wxapi:
//            WXEntryActivity

class a
    implements android.view.View.OnClickListener
{

    final WXEntryActivity a;

    a(WXEntryActivity wxentryactivity)
    {
        a = wxentryactivity;
        super();
    }

    public void onClick(View view)
    {
        WXEntryActivity.a(a).registerApp("wx28e2610e92fbe111");
    }
}
