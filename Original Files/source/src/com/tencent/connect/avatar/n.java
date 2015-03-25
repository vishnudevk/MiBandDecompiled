// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Button;
import android.widget.ProgressBar;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity

class n
    implements IUiListener
{

    final ImageActivity a;

    n(ImageActivity imageactivity)
    {
        a = imageactivity;
        super();
    }

    public void onCancel()
    {
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject;
        ImageActivity.e(a).setEnabled(true);
        ImageActivity.e(a).setTextColor(-1);
        ImageActivity.f(a).setEnabled(true);
        ImageActivity.f(a).setTextColor(-1);
        ImageActivity.d(a).setVisibility(8);
        jsonobject = (JSONObject)obj;
        int j = jsonobject.getInt("ret");
        int i = j;
_L1:
        JSONException jsonexception;
        if (i == 0)
        {
            ImageActivity.b(a, "\u8BBE\u7F6E\u6210\u529F", 0);
            a.a("10658", 0L);
            ImageActivity imageactivity = a;
            if (ImageActivity.k(a) != null && !"".equals(ImageActivity.k(a)))
            {
                Intent intent = new Intent();
                intent.setClassName(imageactivity, ImageActivity.k(a));
                if (imageactivity.getPackageManager().resolveActivity(intent, 0) != null)
                {
                    imageactivity.startActivity(intent);
                }
            }
            ImageActivity.a(a, 0, jsonobject.toString(), null, null);
            ImageActivity.j(a);
            return;
        } else
        {
            ImageActivity.b(a, "\u8BBE\u7F6E\u51FA\u9519\u4E86\uFF0C\u8BF7\u91CD\u65B0\u767B\u5F55\u518D\u5C1D\u8BD5\u4E0B\u5462\uFF1A\uFF09", 1);
            return;
        }
        jsonexception;
        jsonexception.printStackTrace();
        i = -1;
          goto _L1
    }

    public void onError(UiError uierror)
    {
        ImageActivity.e(a).setEnabled(true);
        ImageActivity.e(a).setTextColor(-1);
        ImageActivity.f(a).setEnabled(true);
        ImageActivity.f(a).setTextColor(-1);
        ImageActivity.f(a).setText("\u91CD\u8BD5");
        ImageActivity.d(a).setVisibility(8);
        ImageActivity.a(a, true);
        ImageActivity.b(a, uierror.errorMessage, 1);
        a.a("10660", 0L);
    }
}
