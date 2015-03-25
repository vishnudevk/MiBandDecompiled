// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.b.a;

public class WXEmojiSharedObject
    implements WXMediaMessage.IMediaObject
{

    private static final String a = "MicroMsg.SDK.WXEmojiSharedObject";
    public int packageflag;
    public String packageid;
    public String thumburl;
    public String url;

    public WXEmojiSharedObject()
    {
    }

    public WXEmojiSharedObject(String s, int i, String s1, String s2)
    {
        thumburl = s;
        packageflag = i;
        packageid = s1;
        url = s2;
    }

    public boolean checkArgs()
    {
        if (TextUtils.isEmpty(packageid) || TextUtils.isEmpty(thumburl) || TextUtils.isEmpty(url) || packageflag == -1)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXEmojiSharedObject", "checkArgs fail, packageid or thumburl is invalid");
            return false;
        } else
        {
            return true;
        }
    }

    public void serialize(Bundle bundle)
    {
        bundle.putString("_wxemojisharedobject_thumburl", thumburl);
        bundle.putInt("_wxemojisharedobject_packageflag", packageflag);
        bundle.putString("_wxemojisharedobject_packageid", packageid);
        bundle.putString("_wxemojisharedobject_url", url);
    }

    public int type()
    {
        return 15;
    }

    public void unserialize(Bundle bundle)
    {
        thumburl = bundle.getString("_wxwebpageobject_thumburl");
        packageflag = bundle.getInt("_wxwebpageobject_packageflag");
        packageid = bundle.getString("_wxwebpageobject_packageid");
        url = bundle.getString("_wxwebpageobject_url");
    }
}
