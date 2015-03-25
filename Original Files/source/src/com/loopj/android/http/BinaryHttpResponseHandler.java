// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler

public abstract class BinaryHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String a = "BinaryHttpResponseHandler";
    private String b[] = {
        "image/jpeg", "image/png"
    };

    public BinaryHttpResponseHandler()
    {
    }

    public BinaryHttpResponseHandler(String as[])
    {
        if (as != null)
        {
            b = as;
            return;
        } else
        {
            Log.e("BinaryHttpResponseHandler", "Constructor passed allowedContentTypes was null !");
            return;
        }
    }

    public String[] getAllowedContentTypes()
    {
        return b;
    }

    public abstract void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public abstract void onSuccess(int i, Header aheader[], byte abyte0[]);

    public final void sendResponseMessage(HttpResponse httpresponse)
    {
        boolean flag;
        StatusLine statusline;
        Header header;
        String as[];
        int i;
        int j;
        flag = false;
        statusline = httpresponse.getStatusLine();
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        if (aheader.length != 1)
        {
            sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), "None, or more than one, Content-Type Header found!"));
            return;
        }
        header = aheader[0];
        as = getAllowedContentTypes();
        i = as.length;
        j = 0;
_L2:
        String s;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[j];
        boolean flag1 = Pattern.matches(s, header.getValue());
        if (flag1)
        {
            flag = true;
        }
_L3:
        j++;
        if (true) goto _L2; else goto _L1
        PatternSyntaxException patternsyntaxexception;
        patternsyntaxexception;
        Log.e("BinaryHttpResponseHandler", (new StringBuilder()).append("Given pattern is not valid: ").append(s).toString(), patternsyntaxexception);
          goto _L3
_L1:
        if (!flag)
        {
            sendFailureMessage(statusline.getStatusCode(), httpresponse.getAllHeaders(), null, new HttpResponseException(statusline.getStatusCode(), "Content-Type not allowed!"));
            return;
        } else
        {
            super.sendResponseMessage(httpresponse);
            return;
        }
    }
}
