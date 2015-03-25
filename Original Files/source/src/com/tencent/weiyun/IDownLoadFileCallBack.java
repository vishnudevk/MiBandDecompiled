// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.UiError;

public interface IDownLoadFileCallBack
{

    public abstract void onDownloadProgress(int i);

    public abstract void onDownloadStart();

    public abstract void onDownloadSuccess(String s);

    public abstract void onError(UiError uierror);

    public abstract void onPrepareStart();
}
