// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

// Referenced classes of package com.tencent.open:
//            SocialApiIml

class i
    implements b.a
{

    final Bundle a;
    final Activity b;
    final IUiListener c;
    final SocialApiIml d;

    i(SocialApiIml socialapiiml, Bundle bundle, Activity activity, IUiListener iuilistener)
    {
        d = socialapiiml;
        a = bundle;
        b = activity;
        c = iuilistener;
        super();
    }

    public void a(String s)
    {
        a.remove("image_date");
        if (!TextUtils.isEmpty(s))
        {
            a.putString("image_date", s);
        }
        SocialApiIml.a(d, b, a, c);
    }

    public void b(String s)
    {
        a.remove("image_date");
        UiError uierror = new UiError(-5, "\u56FE\u7247\u8BFB\u53D6\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u8BE5\u56FE\u7247\u662F\u5426\u6709\u6548", "\u56FE\u7247\u8BFB\u53D6\u5931\u8D25\uFF0C\u8BF7\u68C0\u67E5\u8BE5\u56FE\u7247\u662F\u5426\u6709\u6548");
        c.onError(uierror);
        SocialApiIml.a(d);
    }
}
