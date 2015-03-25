// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Bundle;
import android.util.Log;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            SocialApiIml, j, b

public class a
    implements IUiListener
{

    j a;
    final SocialApiIml b;

    public void onCancel()
    {
        SocialApiIml.a(b);
        com.tencent.open.b.a(a.c.getString("image_date"));
        SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
    }

    public void onComplete(Object obj)
    {
        boolean flag;
        JSONObject jsonobject;
        Log.d("TAG", (new StringBuilder()).append("CheckListener--onComplete--response = ").append(obj.toString()).toString());
        flag = false;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        jsonobject = (JSONObject)obj;
        boolean flag1 = jsonobject.getBoolean("check_result");
        flag = flag1;
_L1:
        SocialApiIml.a(b);
        JSONException jsonexception;
        if (flag)
        {
            Log.d("TAG", (new StringBuilder()).append("CheckListener---delayStartParam.agentIntent = ").append(a.a).append(" delayStartParam.action = ").append(a.b).toString());
            SocialApiIml.a(b, SocialApiIml.b(b), a.a, a.b, a.c, a.d, a.e);
            return;
        } else
        {
            com.tencent.open.b.a(a.c.getString("image_date"));
            SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
            return;
        }
        jsonexception;
        jsonexception.printStackTrace();
        flag = false;
          goto _L1
    }

    public void onError(UiError uierror)
    {
        SocialApiIml.a(b);
        com.tencent.open.b.a(a.c.getString("image_date"));
        SocialApiIml.a(b, SocialApiIml.b(b), null, a.b, a.c, a.d, a.e);
    }

    public (SocialApiIml socialapiiml, j j1)
    {
        b = socialapiiml;
        super();
        a = j1;
    }
}
