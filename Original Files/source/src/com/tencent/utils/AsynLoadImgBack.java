// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.utils;

import java.util.ArrayList;

public interface AsynLoadImgBack
{

    public static final int LOAD_IMAGE_COMPLETED = 0;
    public static final int LOAD_IMAGE_IMAGE_FORMAT_ERROR = 3;
    public static final int LOAD_IMAGE_NO_SDCARD = 2;
    public static final int LOAD_IMAGE_PATH_NULL = 1;

    public abstract void batchSaved(int i, ArrayList arraylist);

    public abstract void saved(int i, String s);
}
