// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            PersonInfoFragment

class bm extends AsyncHttpResponseHandler
{

    final PersonInfoFragment a;

    bm(PersonInfoFragment personinfofragment)
    {
        a = personinfofragment;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        PersonInfoFragment.a(a, false);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        WebStatus webstatus = WebRes.getWebStatus(Utils.getStringFromBytes(abyte0));
        PersonInfoFragment.a(a, webstatus.success());
    }
}
