// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.decode;


public class flipHorizontal
{

    public final boolean flipHorizontal;
    public final int rotation;

    protected ()
    {
        rotation = 0;
        flipHorizontal = false;
    }

    protected flipHorizontal(int i, boolean flag)
    {
        rotation = i;
        flipHorizontal = flag;
    }
}
