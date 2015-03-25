// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.content.DialogInterface;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            WeiboDownloader

class val.context
    implements android.content.ClickListener
{

    private final Context val$context;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        WeiboDownloader.access$0(val$context);
    }

    ()
    {
        val$context = context1;
        super();
    }
}
