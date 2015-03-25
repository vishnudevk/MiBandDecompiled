// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.UiError;

public interface IUploadFileCallBack
{

    public abstract void onError(UiError uierror);

    public abstract void onPrepareStart();

    public abstract void onUploadProgress(int i);

    public abstract void onUploadStart();

    public abstract void onUploadSuccess();
}
