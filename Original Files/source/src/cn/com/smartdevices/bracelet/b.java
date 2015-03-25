// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Utils, Debug, DataManager

class b extends AsyncHttpResponseHandler
{

    final DataManager a;

    b(DataManager datamanager)
    {
        a = datamanager;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Utils.getStringFromBytes(abyte0);
        Debug.i("DataManager", (new StringBuilder()).append("loadNetData onFailure:").append(i).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        ArrayList arraylist = new ArrayList();
        WebStatus webstatus = WebRes.parseDownload(new String(abyte0), arraylist);
        if (webstatus.success())
        {
            DataManager.getInstance().insertDatas(arraylist, 1);
        }
        Debug.i("DataManager", (new StringBuilder()).append("loadNetData onSuccess:").append(webstatus.code).toString());
    }
}
