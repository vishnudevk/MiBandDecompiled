// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.imageaware;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;

public interface ImageAware
{

    public abstract int getHeight();

    public abstract int getId();

    public abstract ViewScaleType getScaleType();

    public abstract int getWidth();

    public abstract View getWrappedView();

    public abstract boolean isCollected();

    public abstract boolean setImageBitmap(Bitmap bitmap);

    public abstract boolean setImageDrawable(Drawable drawable);
}
