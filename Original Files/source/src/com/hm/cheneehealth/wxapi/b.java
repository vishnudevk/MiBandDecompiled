// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.hm.cheneehealth.wxapi;

import android.content.Intent;
import android.view.View;
import cn.com.smartdevices.bracelet.activity.MainActivity;

// Referenced classes of package com.hm.cheneehealth.wxapi:
//            WXEntryActivity

class b
    implements android.view.View.OnClickListener
{

    final WXEntryActivity a;

    b(WXEntryActivity wxentryactivity)
    {
        a = wxentryactivity;
        super();
    }

    public void onClick(View view)
    {
        a.startActivity(new Intent(a, cn/com/smartdevices/bracelet/activity/MainActivity));
        a.finish();
    }
}
