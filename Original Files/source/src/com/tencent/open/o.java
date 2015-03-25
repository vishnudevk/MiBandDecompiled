// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.open.a.b;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class o
    implements IUiListener
{

    String a;
    String b;
    private WeakReference c;
    private String d;
    private IUiListener e;

    public o(Context context, String s, String s1, String s2, IUiListener iuilistener)
    {
        c = new WeakReference(context);
        d = s;
        a = s1;
        b = s2;
        e = iuilistener;
    }

    static void a(o o1, String s)
    {
        o1.a(s);
    }

    private void a(String s)
    {
        try
        {
            onComplete(Util.parseJson(s));
            return;
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        onError(new UiError(-4, "\u670D\u52A1\u5668\u8FD4\u56DE\u6570\u636E\u683C\u5F0F\u6709\u8BEF!", s));
    }

    public void onCancel()
    {
        if (e != null)
        {
            e.onCancel();
            e = null;
        }
    }

    public void onComplete(Object obj)
    {
        JSONObject jsonobject = (JSONObject)obj;
        com.tencent.open.a.b.a().a((Context)c.get(), (new StringBuilder()).append(d).append("_H5").toString(), SystemClock.elapsedRealtime(), 0L, 0L, jsonobject.optInt("ret", -6), b, a, "1000067");
        if (e != null)
        {
            e.onComplete(jsonobject);
            e = null;
        }
    }

    public void onError(UiError uierror)
    {
        String s;
        if (uierror.errorMessage != null)
        {
            s = (new StringBuilder()).append(uierror.errorMessage).append(a).toString();
        } else
        {
            s = a;
        }
        com.tencent.open.a.b.a().a((Context)c.get(), (new StringBuilder()).append(d).append("_H5").toString(), SystemClock.elapsedRealtime(), 0L, 0L, uierror.errorCode, b, s, "1000067");
        if (e != null)
        {
            e.onError(uierror);
            e = null;
        }
    }
}
