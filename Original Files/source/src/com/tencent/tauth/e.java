// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import org.json.JSONObject;

// Referenced classes of package com.tencent.tauth:
//            d, UiError, IUiListener, LocationApi

class e extends d
{

    final LocationApi b;
    private IUiListener c;

    public e(LocationApi locationapi, IUiListener iuilistener)
    {
        b = locationapi;
        super(locationapi, null);
        c = iuilistener;
    }

    protected void a(Exception exception)
    {
        if (c != null)
        {
            c.onError(new UiError(100, exception.getMessage(), null));
        }
    }

    public void onComplete(JSONObject jsonobject)
    {
        if (c != null)
        {
            c.onComplete(jsonobject);
        }
    }
}
