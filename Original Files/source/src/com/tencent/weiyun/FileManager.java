// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.weiyun;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQAuth;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;

// Referenced classes of package com.tencent.weiyun:
//            a, e, f, WeiyunFile, 
//            IDownLoadFileCallBack, IGetFileListListener, IUploadFileCallBack

public class FileManager extends BaseApi
{

    private static final String a[] = {
        "https://graph.qq.com/weiyun/get_photo_list", "https://graph.qq.com/weiyun/get_music_list", "https://graph.qq.com/weiyun/get_video_list"
    };
    private static final String b[] = {
        "https://graph.qq.com/weiyun/delete_photo", "https://graph.qq.com/weiyun/delete_music", "https://graph.qq.com/weiyun/delete_video"
    };

    public FileManager(Context context, QQAuth qqauth, QQToken qqtoken)
    {
        super(context, qqauth, qqtoken);
    }

    public FileManager(Context context, QQToken qqtoken)
    {
        super(context, qqtoken);
    }

    static Bundle a(FileManager filemanager)
    {
        return filemanager.composeCGIParams();
    }

    static QQToken b(FileManager filemanager)
    {
        return filemanager.mToken;
    }

    static Bundle c(FileManager filemanager)
    {
        return filemanager.composeCGIParams();
    }

    static QQToken d(FileManager filemanager)
    {
        return filemanager.mToken;
    }

    public void deleteFile(WeiyunFileType weiyunfiletype, String s, IUiListener iuilistener)
    {
        String s1 = b[weiyunfiletype.value()];
        Bundle bundle = composeCGIParams();
        bundle.putString("file_id", s);
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        HttpUtils.requestAsync(mToken, mContext, s1, bundle, "GET", temprequestlistener);
    }

    public void downLoadFile(WeiyunFileType weiyunfiletype, WeiyunFile weiyunfile, String s, IDownLoadFileCallBack idownloadfilecallback)
    {
        (new a(this, mContext, weiyunfiletype, weiyunfile, s, idownloadfilecallback)).a();
    }

    public void downLoadThumb(WeiyunFile weiyunfile, String s, String s1, IDownLoadFileCallBack idownloadfilecallback)
    {
        a a1 = new a(this, mContext, WeiyunFileType.ImageFile, weiyunfile, s, idownloadfilecallback);
        a1.a(s1);
        a1.a();
    }

    public void getFileList(WeiyunFileType weiyunfiletype, IGetFileListListener igetfilelistlistener)
    {
        String s = a[weiyunfiletype.value()];
        Bundle bundle = composeCGIParams();
        bundle.putString("offset", "0");
        bundle.putString("number", "100");
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, new e(this, igetfilelistlistener));
        HttpUtils.requestAsync(mToken, mContext, s, bundle, "GET", temprequestlistener);
    }

    public void uploadFile(WeiyunFileType weiyunfiletype, String s, IUploadFileCallBack iuploadfilecallback)
    {
        (new f(this, mContext, weiyunfiletype, s, iuploadfilecallback)).a();
    }


    private class WeiyunFileType extends Enum
    {

        public static final WeiyunFileType ImageFile;
        public static final WeiyunFileType MusicFile;
        public static final WeiyunFileType VideoFile;
        private static final WeiyunFileType b[];
        private final int a;

        public static WeiyunFileType valueOf(String s)
        {
            return (WeiyunFileType)Enum.valueOf(com/tencent/weiyun/FileManager$WeiyunFileType, s);
        }

        public static WeiyunFileType[] values()
        {
            return (WeiyunFileType[])b.clone();
        }

        public int value()
        {
            return a;
        }

        static 
        {
            ImageFile = new WeiyunFileType("ImageFile", 0, 0);
            MusicFile = new WeiyunFileType("MusicFile", 1, 1);
            VideoFile = new WeiyunFileType("VideoFile", 2, 2);
            WeiyunFileType aweiyunfiletype[] = new WeiyunFileType[3];
            aweiyunfiletype[0] = ImageFile;
            aweiyunfiletype[1] = MusicFile;
            aweiyunfiletype[2] = VideoFile;
            b = aweiyunfiletype;
        }

        private WeiyunFileType(String s, int i, int j)
        {
            super(s, i);
            a = j;
        }
    }

}
