// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;


// Referenced classes of package com.tencent.tauth:
//            UiError

public interface IUiListener
{

    public abstract void onCancel();

    public abstract void onComplete(Object obj);

    public abstract void onError(UiError uierror);
}
