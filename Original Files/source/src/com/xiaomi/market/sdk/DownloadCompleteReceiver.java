// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.market.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.xiaomi.market.sdk:
//            m

public class DownloadCompleteReceiver extends BroadcastReceiver
{

    private static final String a = "MarketSDKDownloadReceiver";

    public DownloadCompleteReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        long l;
label0:
        {
            if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction()))
            {
                l = intent.getLongExtra("extra_download_id", -1L);
                Log.d("MarketSDKDownloadReceiver", (new StringBuilder("on sdk download complete : id = ")).append(l).toString());
                if (l != -1L)
                {
                    break label0;
                }
            }
            return;
        }
        m.i(context).a(l);
    }
}
