// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import com.tencent.tauth.UiError;
import java.util.List;

public interface IGetFileListListener
{

    public abstract void onComplete(List list);

    public abstract void onError(UiError uierror);
}
