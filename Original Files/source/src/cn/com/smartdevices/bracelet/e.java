// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.view.Util;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Utils, Debug, Keeper

final class e extends AsyncHttpResponseHandler
{

    final Utils.OperationCallback a;
    final PersonInfo b;

    e(Utils.OperationCallback operationcallback, PersonInfo personinfo)
    {
        a = operationcallback;
        b = personinfo;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("WPJ", (new StringBuilder()).append("onFailure:").append(i).append(",content:").append(s).toString());
        Util.hideProgressDialog();
        if (a != null)
        {
            a.onFailure();
        }
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        Debug.i("Utils", (new StringBuilder()).append("update Profile onSuccess:").append(i).append(",content:").append(s).toString());
        WebStatus webstatus = WebRes.getWebStatus(s);
        Util.hideProgressDialog();
        if (!webstatus.success())
        {
            if (a != null)
            {
                a.onFailure();
            }
        } else
        {
            Keeper.keepPersonInfo(b);
            if (a != null)
            {
                a.onSuccess();
                return;
            }
        }
    }
}
