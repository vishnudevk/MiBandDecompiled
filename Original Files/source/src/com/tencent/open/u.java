// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.os.Handler;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.open:
//            C, TaskGuide, v, z

class u extends C
{

    int a;
    final TaskGuide b;

    public u(TaskGuide taskguide, int i)
    {
        b = taskguide;
        super(taskguide, null);
        a = -1;
        a = i;
    }

    protected void a(Exception exception)
    {
        if (exception != null)
        {
            exception.printStackTrace();
        }
        b.c.onError(new UiError(101, "error ", "\u91D1\u5238\u9886\u53D6\u65F6\u51FA\u73B0\u5F02\u5E38"));
        if (TaskGuide.x(b) != null)
        {
            TaskGuide.x(b).post(new v(this, exception));
        }
    }

    public void onComplete(JSONObject jsonobject)
    {
        String s = null;
        int i;
        i = jsonobject.getInt("code");
        s = jsonobject.getString("message");
        if (i != 0) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1;
        TaskGuide.a(b, a, z.e);
        jsonobject1 = new JSONObject();
        jsonobject1.put("result", "\u91D1\u5238\u9886\u53D6\u6210\u529F");
_L3:
        JSONException jsonexception1;
        try
        {
            b.c.onComplete(jsonobject1);
        }
        catch (JSONException jsonexception)
        {
            TaskGuide.a(b, a, z.d);
            TaskGuide.a(b, s);
            jsonexception.printStackTrace();
        }
_L4:
        TaskGuide.c(b, a);
        TaskGuide.e(b, 2000);
        return;
        jsonexception1;
        jsonexception1.printStackTrace();
          goto _L3
_L2:
        JSONObject jsonobject2;
        TaskGuide.a(b, a, z.d);
        TaskGuide.a(b, s);
        jsonobject2 = new JSONObject();
        jsonobject2.put("result", "\u91D1\u5238\u9886\u53D6\u5931\u8D25");
_L5:
        b.c.onComplete(jsonobject2);
          goto _L4
        JSONException jsonexception2;
        jsonexception2;
        jsonexception2.printStackTrace();
          goto _L5
    }
}
