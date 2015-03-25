// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import cn.com.smartdevices.bracelet.Debug;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package cn.com.smartdevices.bracelet.model.game:
//            GameManager, GameBriefInfo

class  extends AsyncHttpResponseHandler
{

    final GameManager this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.fi("GameManager", (new StringBuilder()).append("Get game register info failed , statusCode = ").append(i).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s;
        Debug.i("GameManager", (new StringBuilder()).append("get register responseBody=").append(new String(abyte0)).toString());
        s = new String(abyte0);
        JSONObject jsonobject;
        GameBriefInfo gamebriefinfo;
        jsonobject = new JSONObject(s);
        gamebriefinfo = GameManager.access$400(GameManager.this);
        boolean flag;
        if (jsonobject.optInt("code") > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            gamebriefinfo.setRegistered(flag);
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return;
    }

    ()
    {
        this$0 = GameManager.this;
        super();
    }
}
