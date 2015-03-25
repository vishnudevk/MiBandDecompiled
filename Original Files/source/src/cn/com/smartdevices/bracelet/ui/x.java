// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            BaseSCActivity

class x extends AsyncHttpResponseHandler
{

    final DataManager a;
    final ArrayList b;
    final BaseSCActivity c;

    x(BaseSCActivity basescactivity, DataManager datamanager, ArrayList arraylist)
    {
        c = basescactivity;
        a = datamanager;
        b = arraylist;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("WPJ", (new StringBuilder()).append("syncToServer onFailure:").append(s).toString());
        Debug.f(BaseSCActivity.a(c), (new StringBuilder()).append("syncToServer onFailure:").append(s).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        if (WebRes.getWebStatus(s).success())
        {
            a.updateSyncState(b, 1);
        }
        Debug.i("WPJ", (new StringBuilder()).append("syncToServer onSuccess:").append(s).toString());
        Debug.f(BaseSCActivity.a(c), (new StringBuilder()).append("syncToServer onSuccess:").append(s).toString());
    }
}
