// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.edmodo.cropper.util;

import com.edmodo.cropper.cropwindow.handle.Handle;

class a
{

    static final int a[];

    static 
    {
        a = new int[Handle.values().length];
        try
        {
            a[Handle.TOP_LEFT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            a[Handle.TOP_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[Handle.BOTTOM_LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[Handle.BOTTOM_RIGHT.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[Handle.LEFT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[Handle.TOP.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[Handle.RIGHT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[Handle.BOTTOM.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[Handle.CENTER.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8)
        {
            return;
        }
    }
}
