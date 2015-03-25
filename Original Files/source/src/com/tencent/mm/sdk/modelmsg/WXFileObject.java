// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXFileObject
    implements WXMediaMessage.IMediaObject
{

    private static final String a = "MicroMsg.SDK.WXFileObject";
    private static final int b = 0xa00000;
    private int c;
    public byte fileData[];
    public String filePath;

    public WXFileObject()
    {
        c = 0xa00000;
        fileData = null;
        filePath = null;
    }

    public WXFileObject(String s)
    {
        c = 0xa00000;
        filePath = s;
    }

    public WXFileObject(byte abyte0[])
    {
        c = 0xa00000;
        fileData = abyte0;
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
        if ((fileData == null || fileData.length == 0) && (filePath == null || filePath.length() == 0))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (fileData != null && fileData.length > c)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileData is too large");
            return false;
        }
        if (filePath != null && a(filePath) > c)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXFileObject", "checkArgs fail, fileSize is too large");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putByteArray("_wxfileobject_fileData", fileData);
        bundle.putString("_wxfileobject_filePath", filePath);
    }

    public void setContentLengthLimit(int i)
    {
        c = i;
    }

    public void setFileData(byte abyte0[])
    {
        fileData = abyte0;
    }

    public void setFilePath(String s)
    {
        filePath = s;
    }

    public int type()
    {
        return 6;
    }

    public void unserialize(Bundle bundle)
    {
        fileData = bundle.getByteArray("_wxfileobject_fileData");
        filePath = bundle.getString("_wxfileobject_filePath");
    }
}
