// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model.game;

import cn.com.smartdevices.bracelet.Debug;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.model.game:
//            GameManager

class  extends AsyncHttpResponseHandler
{

    final GameManager this$0;

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.fi("GameManager", (new StringBuilder()).append("Get game info failed , statusCode = ").append(i).toString());
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        Debug.i("GameManager", (new StringBuilder()).append("get responseBody=").append(new String(abyte0)).toString());
        if (abyte0 != null && abyte0.length > 0)
        {
            GameManager.access$700(GameManager.this, GameManager.access$400(GameManager.this), abyte0);
        }
    }

    ()
    {
        this$0 = GameManager.this;
        super();
    }
}
