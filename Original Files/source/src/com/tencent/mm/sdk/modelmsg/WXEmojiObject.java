// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXEmojiObject
    implements WXMediaMessage.IMediaObject
{

    private static final String a = "MicroMsg.SDK.WXEmojiObject";
    private static final int b = 0xa00000;
    public byte emojiData[];
    public String emojiPath;

    public WXEmojiObject()
    {
        emojiData = null;
        emojiPath = null;
    }

    public WXEmojiObject(String s)
    {
        emojiPath = s;
    }

    public WXEmojiObject(byte abyte0[])
    {
        emojiData = abyte0;
    }

    private int a(String s)
    {
        File file;
        if (s != null && s.length() != 0)
        {
            if ((file = new File(s)).exists())
            {
                return (int)file.length();
            }
        }
        return 0;
    }

    public boolean checkArgs()
    {
        if ((emojiData == null || emojiData.length == 0) && (emojiPath == null || emojiPath.length() == 0))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (emojiData != null && emojiData.length > 0xa00000)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
            return false;
        }
        if (emojiPath != null && a(emojiPath) > 0xa00000)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putByteArray("_wxemojiobject_emojiData", emojiData);
        bundle.putString("_wxemojiobject_emojiPath", emojiPath);
    }

    public void setEmojiData(byte abyte0[])
    {
        emojiData = abyte0;
    }

    public void setEmojiPath(String s)
    {
        emojiPath = s;
    }

    public int type()
    {
        return 8;
    }

    public void unserialize(Bundle bundle)
    {
        emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }
}
