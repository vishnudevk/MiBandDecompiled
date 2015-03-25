// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BindWeixinActivity

class D
    implements android.media.MediaScannerConnection.MediaScannerConnectionClient
{

    final BindWeixinActivity a;

    D(BindWeixinActivity bindweixinactivity)
    {
        a = bindweixinactivity;
        super();
    }

    public void onMediaScannerConnected()
    {
        BindWeixinActivity.m(a).scanFile(BindWeixinActivity.l(a), null);
    }

    public void onScanCompleted(String s, Uri uri)
    {
        BindWeixinActivity.h(a).sendEmptyMessage(4);
    }
}
