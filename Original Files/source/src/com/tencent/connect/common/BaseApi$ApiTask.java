// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.common;

import com.tencent.tauth.IUiListener;

// Referenced classes of package com.tencent.connect.common:
//            BaseApi

public class mListener
{

    final BaseApi a;
    public IUiListener mListener;
    public int mRequestCode;

    public (BaseApi baseapi, int i, IUiListener iuilistener)
    {
        a = baseapi;
        super();
        mRequestCode = i;
        mListener = iuilistener;
    }
}
