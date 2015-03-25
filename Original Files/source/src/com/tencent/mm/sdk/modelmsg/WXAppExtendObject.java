// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import java.io.File;

public class WXAppExtendObject
    implements WXMediaMessage.IMediaObject
{

    private static final String a = "MicroMsg.SDK.WXAppExtendObject";
    private static final int b = 2048;
    private static final int c = 10240;
    private static final int d = 0xa00000;
    public String extInfo;
    public byte fileData[];
    public String filePath;

    public WXAppExtendObject()
    {
    }

    public WXAppExtendObject(String s, String s1)
    {
        extInfo = s;
        filePath = s1;
    }

    public WXAppExtendObject(String s, byte abyte0[])
    {
        extInfo = s;
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
        if ((extInfo == null || extInfo.length() == 0) && (filePath == null || filePath.length() == 0) && (fileData == null || fileData.length == 0))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, all arguments is null");
            return false;
        }
        if (extInfo != null && extInfo.length() > 2048)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, extInfo is invalid");
            return false;
        }
        if (filePath != null && filePath.length() > 10240)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, filePath is invalid");
            return false;
        }
        if (filePath != null && a(filePath) > 0xa00000)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileSize is too large");
            return false;
        }
        if (fileData != null && fileData.length > 0xa00000)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXAppExtendObject", "checkArgs fail, fileData is too large");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxappextendobject_extInfo", extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", fileData);
        bundle.putString("_wxappextendobject_filePath", filePath);
    }

    public int type()
    {
        return 7;
    }

    public void unserialize(Bundle bundle)
    {
        extInfo = bundle.getString("_wxappextendobject_extInfo");
        fileData = bundle.getByteArray("_wxappextendobject_fileData");
        filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
