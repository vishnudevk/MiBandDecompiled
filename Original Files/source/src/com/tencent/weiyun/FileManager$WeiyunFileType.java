// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;


public final class a extends Enum
{

    public static final b ImageFile;
    public static final b MusicFile;
    public static final b VideoFile;
    private static final b b[];
    private final int a;

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/tencent/weiyun/FileManager$WeiyunFileType, s);
    }

    public static a[] values()
    {
        return (a[])b.clone();
    }

    public int value()
    {
        return a;
    }

    static 
    {
        ImageFile = new <init>("ImageFile", 0, 0);
        MusicFile = new <init>("MusicFile", 1, 1);
        VideoFile = new <init>("VideoFile", 2, 2);
        a aa[] = new <init>[3];
        aa[0] = ImageFile;
        aa[1] = MusicFile;
        aa[2] = VideoFile;
        b = aa;
    }

    private (String s, int i, int j)
    {
        super(s, i);
        a = j;
    }
}
