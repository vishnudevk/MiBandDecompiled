// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SearchSingleBraceletActivity

class bs extends AsyncHttpResponseHandler
{

    final SearchSingleBraceletActivity a;

    bs(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        a = searchsinglebraceletactivity;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        if (abyte0 != null)
        {
            if (!WebRes.getWebStatus(new String(abyte0)).success());
        }
    }
}
