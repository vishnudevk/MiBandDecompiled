// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.api.share;

import android.content.DialogInterface;

// Referenced classes of package com.sina.weibo.sdk.api.share:
//            IWeiboDownloadListener

class val.listener
    implements android.content.ClickListener
{

    private final IWeiboDownloadListener val$listener;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (val$listener != null)
        {
            val$listener.onCancel();
        }
    }

    ener()
    {
        val$listener = iweibodownloadlistener;
        super();
    }
}
