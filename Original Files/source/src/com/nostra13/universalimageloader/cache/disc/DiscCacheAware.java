// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.disc;

import android.graphics.Bitmap;
import java.io.File;
import java.io.InputStream;

public interface DiscCacheAware
{

    public abstract void clear();

    public abstract void close();

    public abstract File get(String s);

    public abstract File getDirectory();

    public abstract boolean remove(String s);

    public abstract boolean save(String s, Bitmap bitmap);

    public abstract boolean save(String s, InputStream inputstream, com.nostra13.universalimageloader.utils.IoUtils.CopyListener copylistener);
}
