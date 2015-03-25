// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.listener;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

public interface ImageLoadingListener
{

    public abstract void onLoadingCancelled(String s, View view);

    public abstract void onLoadingComplete(String s, View view, Bitmap bitmap);

    public abstract void onLoadingFailed(String s, View view, FailReason failreason);

    public abstract void onLoadingStarted(String s, View view);
}
