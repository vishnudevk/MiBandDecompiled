// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.b.a;
import java.io.ByteArrayOutputStream;

public final class WXMediaMessage
{

    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public static final int THUMB_LENGTH_LIMIT = 32768;
    private static final String a = "MicroMsg.SDK.WXMediaMessage";
    private static final int b = 512;
    private static final int c = 1024;
    private static final int d = 64;
    private static final int e = 2048;
    private static final int f = 2048;
    public String description;
    public IMediaObject mediaObject;
    public String mediaTagName;
    public String messageAction;
    public String messageExt;
    public int sdkVer;
    public byte thumbData[];
    public String title;

    public WXMediaMessage()
    {
        this(null);
    }

    public WXMediaMessage(IMediaObject imediaobject)
    {
        mediaObject = imediaobject;
    }

    final boolean a()
    {
        if (getType() == 8 && (thumbData == null || thumbData.length == 0))
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData should not be null when send emoji");
            return false;
        }
        if (thumbData != null && thumbData.length > 32768)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, thumbData is invalid");
            return false;
        }
        if (title != null && title.length() > 512)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, title is invalid");
            return false;
        }
        if (description != null && description.length() > 1024)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, description is invalid");
            return false;
        }
        if (mediaObject == null)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaObject is null");
            return false;
        }
        if (mediaTagName != null && mediaTagName.length() > 64)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, mediaTagName is too long");
            return false;
        }
        if (messageAction != null && messageAction.length() > 2048)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageAction is too long");
            return false;
        }
        if (messageExt != null && messageExt.length() > 2048)
        {
            com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "checkArgs fail, messageExt is too long");
            return false;
        } else
        {
            return mediaObject.checkArgs();
        }
    }

    public final int getType()
    {
        if (mediaObject == null)
        {
            return 0;
        } else
        {
            return mediaObject.type();
        }
    }

    public final void setThumbImage(Bitmap bitmap)
    {
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 85, bytearrayoutputstream);
            thumbData = bytearrayoutputstream.toByteArray();
            bytearrayoutputstream.close();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
    }

    private class IMediaObject
    {

        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_CARD_SHARE = 16;
        public static final int TYPE_DEVICE_ACCESS = 12;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_EMOTICON_GIFT = 11;
        public static final int TYPE_EMOTICON_SHARED = 15;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_LOCATION_SHARE = 17;
        public static final int TYPE_MALL_PRODUCT = 13;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_OLD_TV = 14;
        public static final int TYPE_PRODUCT = 10;
        public static final int TYPE_RECODE = 19;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_TV = 20;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        public abstract boolean checkArgs();

        public abstract void serialize(Bundle bundle);

        public abstract int type();

        public abstract void unserialize(Bundle bundle);
    }

}
