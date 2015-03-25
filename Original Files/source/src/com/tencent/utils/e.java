// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import android.content.Context;
import android.os.Bundle;

// Referenced classes of package com.tencent.utils:
//            HttpUtils

final class e extends Thread
{

    final Context a;
    final Bundle b;

    e(Context context, Bundle bundle)
    {
        a = context;
        b = bundle;
        super();
    }

    public void run()
    {
        try
        {
            HttpUtils.openUrl2(a, "http://cgi.qplus.com/report/report", "GET", b);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
