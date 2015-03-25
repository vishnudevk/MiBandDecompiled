// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import cn.com.smartdevices.bracelet.webapi.WebRes;
import cn.com.smartdevices.bracelet.webapi.WebStatus;
import com.loopj.android.http.AsyncHttpResponseHandler;
import de.greenrobot.event.EventBus;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug

final class h extends AsyncHttpResponseHandler
{

    final boolean a;

    h(boolean flag)
    {
        a = flag;
        super();
    }

    private String a(String s)
    {
        String s1 = "";
        JSONObject jsonobject = (new JSONObject(s)).optJSONObject("data");
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        String s2 = jsonobject.optString("list");
        String s3 = s2.replace("\\n", "\n");
        s1 = s3;
        Debug.i("Utils", (new StringBuilder()).append("TODO: use mi apk push after publish. get changelog:").append(s1).toString());
        return s1;
        JSONException jsonexception;
        jsonexception;
_L2:
        jsonexception.printStackTrace();
        return s1;
        JSONException jsonexception1;
        jsonexception1;
        s1 = s2;
        jsonexception = jsonexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Debug.i("Utils", (new StringBuilder()).append("get changelog onSuccess: ").append(new String(abyte0)).toString());
        String s = new String(abyte0);
        if (WebRes.getWebStatus(s).success())
        {
            String s1 = a(s);
            EventBus.getDefault().post(new EventApkupgrade(a, s1));
        }
    }
}
