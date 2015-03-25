// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.qzone;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Albums extends BaseApi
{

    public Albums(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public Albums(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    public void addAlbum(String s, String s1, AlbumSecurity albumsecurity, String s2, String s3, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        if (s == null)
        {
            s = "";
        }
        bundle.putString("albumname", s);
        if (s1 == null)
        {
            s1 = "";
        }
        bundle.putString("albumdesc", s1);
        String s4;
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener;
        if (albumsecurity == null)
        {
            s4 = AlbumSecurity.publicToAll.getSecurity();
        } else
        {
            s4 = albumsecurity.getSecurity();
        }
        bundle.putString("priv", s4);
        if (s2 == null)
        {
            s2 = "";
        }
        bundle.putString("question", s2);
        if (s3 == null)
        {
            s3 = "";
        }
        bundle.putString("answer", s3);
        temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "photo/add_album", bundle, "POST", temprequestlistener);
    }

    public void listAlbum(IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "photo/list_album", bundle, "GET", temprequestlistener);
    }

    public void listPhotos(String s, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        if (s == null)
        {
            s = "";
        }
        bundle.putString("albumid", s);
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, "photo/list_photo", bundle, "GET", temprequestlistener);
    }

    public void uploadPicture(String s, String s1, String s2, String s3, String s4, IUiListener iuilistener)
    {
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        FileInputStream fileinputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        byte abyte0[];
        fileinputstream = new FileInputStream(s);
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = new byte[1024];
_L1:
        int i = fileinputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                bytearrayoutputstream.write(abyte0, 0, i);
            }
            catch (IOException ioexception)
            {
                temprequestlistener.onIOException(ioexception);
                return;
            }
        }
          goto _L1
        byte abyte1[];
        bytearrayoutputstream.close();
        fileinputstream.close();
        abyte1 = bytearrayoutputstream.toByteArray();
        Bundle bundle = composeCGIParams();
        File file = new File(s);
        bundle.putByteArray("picture", abyte1);
        if (s1 == null)
        {
            s1 = "";
        }
        bundle.putString("photodesc", s1);
        bundle.putString("title", file.getName());
        if (s2 != null)
        {
            if (s2 == null)
            {
                s2 = "";
            }
            bundle.putString("albumid", s2);
        }
        if (s3 == null)
        {
            s3 = "";
        }
        bundle.putString("x", s3);
        if (s4 == null)
        {
            s4 = "";
        }
        bundle.putString("y", s4);
        HttpUtils.requestAsync(mToken, mContext, "photo/upload_pic", bundle, "POST", temprequestlistener);
        return;
    }

    private class AlbumSecurity extends Enum
    {

        private static final AlbumSecurity b[];
        public static final AlbumSecurity friendsOnly;
        public static final AlbumSecurity needQuestion;
        public static final AlbumSecurity privateOnly;
        public static final AlbumSecurity publicToAll;
        private final String a;

        public String getSecurity()
        {
            return a;
        }

        static 
        {
            publicToAll = new AlbumSecurity("publicToAll", 0, "1");
            privateOnly = new AlbumSecurity("privateOnly", 1, "2");
            friendsOnly = new AlbumSecurity("friendsOnly", 2, "4");
            needQuestion = new AlbumSecurity("needQuestion", 3, "5");
            AlbumSecurity aalbumsecurity[] = new AlbumSecurity[4];
            aalbumsecurity[0] = publicToAll;
            aalbumsecurity[1] = privateOnly;
            aalbumsecurity[2] = friendsOnly;
            aalbumsecurity[3] = needQuestion;
            b = aalbumsecurity;
        }

        private AlbumSecurity(String s, int i, String s1)
        {
            super(s, i);
            a = s1;
        }
    }

}
