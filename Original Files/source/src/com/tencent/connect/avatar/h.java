// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.os.Handler;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity, i

class h
    implements IUiListener
{

    final ImageActivity a;

    h(ImageActivity imageactivity)
    {
        a = imageactivity;
        super();
    }

    private void a(int j)
    {
        if (ImageActivity.m(a) < 2)
        {
            ImageActivity.n(a);
        }
    }

    public void onCancel()
    {
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject;
        int j;
        jsonobject = (JSONObject)obj;
        j = -1;
        j = jsonobject.getInt("ret");
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        try
        {
            String s = jsonobject.getString("nickname");
            ImageActivity.l(a).post(new i(this, s));
            a.a("10659", 0L);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        if (j != 0)
        {
            a(j);
        }
        return;
        a.a("10661", 0L);
        break MISSING_BLOCK_LABEL_57;
    }

    public void onError(UiError uierror)
    {
        a(0);
    }
}
