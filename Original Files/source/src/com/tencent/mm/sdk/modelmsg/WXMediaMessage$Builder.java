// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;

// Referenced classes of package com.tencent.mm.sdk.modelmsg:
//            WXMediaMessage

public class ject
{

    public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

    private static String a(String s)
    {
        if (s == null || s.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "pathNewToOld fail, newPath is null");
            return s;
        } else
        {
            return s.replace("com.tencent.mm.sdk.modelmsg", "com.tencent.mm.sdk.openapi");
        }
    }

    private static String b(String s)
    {
        if (s == null || s.length() == 0)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "pathOldToNew fail, oldPath is null");
            return s;
        } else
        {
            return s.replace("com.tencent.mm.sdk.openapi", "com.tencent.mm.sdk.modelmsg");
        }
    }

    public static WXMediaMessage fromBundle(Bundle bundle)
    {
        WXMediaMessage wxmediamessage = new WXMediaMessage();
        wxmediamessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
        wxmediamessage.title = bundle.getString("_wxobject_title");
        wxmediamessage.description = bundle.getString("_wxobject_description");
        wxmediamessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
        wxmediamessage.mediaTagName = bundle.getString("_wxobject_mediatagname");
        wxmediamessage.messageAction = bundle.getString("_wxobject_message_action");
        wxmediamessage.messageExt = bundle.getString("_wxobject_message_ext");
        String s = b(bundle.getString("_wxobject_identifier_"));
        if (s == null || s.length() <= 0)
        {
            return wxmediamessage;
        }
        try
        {
            wxmediamessage.mediaObject = (ject)Class.forName(s).newInstance();
            wxmediamessage.mediaObject.unserialize(bundle);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", (new StringBuilder("get media object from bundle failed: unknown ident ")).append(s).append(", ex = ").append(exception.getMessage()).toString());
            return wxmediamessage;
        }
        return wxmediamessage;
    }

    public static Bundle toBundle(WXMediaMessage wxmediamessage)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("_wxobject_sdkVer", wxmediamessage.sdkVer);
        bundle.putString("_wxobject_title", wxmediamessage.title);
        bundle.putString("_wxobject_description", wxmediamessage.description);
        bundle.putByteArray("_wxobject_thumbdata", wxmediamessage.thumbData);
        if (wxmediamessage.mediaObject != null)
        {
            bundle.putString("_wxobject_identifier_", a(wxmediamessage.mediaObject.getClass().getName()));
            wxmediamessage.mediaObject.serialize(bundle);
        }
        bundle.putString("_wxobject_mediatagname", wxmediamessage.mediaTagName);
        bundle.putString("_wxobject_message_action", wxmediamessage.messageAction);
        bundle.putString("_wxobject_message_ext", wxmediamessage.messageExt);
        return bundle;
    }

    public ject()
    {
    }
}
