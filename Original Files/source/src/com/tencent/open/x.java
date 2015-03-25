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
//            C, TaskGuide, y, E, 
//            z, t

class x extends C
{

    final TaskGuide a;

    private x(TaskGuide taskguide)
    {
        a = taskguide;
        super(taskguide, null);
    }

    x(TaskGuide taskguide, t t)
    {
        this(taskguide);
    }

    protected void a(Exception exception)
    {
        if (exception != null)
        {
            exception.printStackTrace();
        }
        if (exception == null)
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("result", "\u6682\u65E0\u4EFB\u52A1");
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
            a.c.onComplete(jsonobject);
        } else
        {
            a.c.onError(new UiError(100, "error ", "\u83B7\u53D6\u4EFB\u52A1\u5931\u8D25"));
        }
        TaskGuide.x(a).post(new y(this));
    }

    public void onComplete(JSONObject jsonobject)
    {
        try
        {
            TaskGuide.a(a, E.a(jsonobject));
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        if (TaskGuide.y(a) != null && TaskGuide.y(a).a())
        {
            a.showWindow();
            TaskGuide.a(a, 2, z.d);
            JSONObject jsonobject1 = new JSONObject();
            try
            {
                jsonobject1.put("result", "\u83B7\u53D6\u6210\u529F");
            }
            catch (JSONException jsonexception1)
            {
                jsonexception1.printStackTrace();
            }
            a.c.onComplete(jsonobject1);
            return;
        } else
        {
            a(null);
            return;
        }
    }
}
