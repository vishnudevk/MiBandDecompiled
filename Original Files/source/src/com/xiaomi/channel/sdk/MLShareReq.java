// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.xiaomi.channel.sdk:
//            IShareReq, MLShareMessage, MLImgObj, ShareUtils, 
//            MLExtraInfo

public class MLShareReq
    implements IShareReq
{

    private int a;
    private MLShareMessage b;
    private final int c;
    private MLExtraInfo d;

    public MLShareReq(int i, MLShareMessage mlsharemessage, int j)
    {
        this(mlsharemessage, j);
    }

    public MLShareReq(MLShareMessage mlsharemessage, int i)
    {
        b = mlsharemessage;
        c = i;
    }

    public MLExtraInfo getJumpBackInfo()
    {
        return d;
    }

    public int getShareType()
    {
        return a;
    }

    public void parseFromBundle(Bundle bundle)
    {
        if (bundle != null)
        {
            a = bundle.getInt("share_type");
            String s = bundle.getString("share_title");
            b = new MLShareMessage();
            b.title = s;
            if (bundle.containsKey("share_text"))
            {
                b.text = bundle.getString("share_text");
            }
            if (bundle.containsKey("share_url"))
            {
                b.url = bundle.getString("share_url");
            }
            if (bundle.containsKey("share_img_data_bmp"))
            {
                MLImgObj mlimgobj = new MLImgObj((Bitmap)bundle.getParcelable("share_img_data_bmp"));
                b.imgObj = mlimgobj;
            }
        }
    }

    public void setJumpBackInfo(MLExtraInfo mlextrainfo)
    {
        d = mlextrainfo;
    }

    public Bundle toBundle()
    {
        boolean flag;
        Bundle bundle;
        flag = true;
        bundle = new Bundle();
        bundle.putInt("share_target", c);
        if (b == null) goto _L2; else goto _L1
_L1:
        boolean flag1;
        boolean flag2;
        Bitmap bitmap;
        File file;
        String s;
        if (!TextUtils.isEmpty(b.title))
        {
            bundle.putString("share_title", b.title);
            flag1 = flag;
        } else
        {
            flag1 = false;
        }
        if (!TextUtils.isEmpty(b.text))
        {
            bundle.putString("share_text", b.text);
            flag1 = flag;
        }
        if (!TextUtils.isEmpty(b.url))
        {
            bundle.putString("share_url", b.url);
            flag2 = flag;
        } else
        {
            flag2 = false;
        }
        if (TextUtils.isEmpty(b.imgUrl)) goto _L4; else goto _L3
_L3:
        bundle.putString("share_img_url", b.imgUrl);
_L6:
        if (flag1 && !flag && !flag2)
        {
            a = 0x18704;
        } else
        if (flag && !flag1 && !flag2)
        {
            a = 0x18705;
        } else
        if (flag && flag1 || flag && flag2 || flag1 && flag2)
        {
            a = 0x18708;
        } else
        {
            return null;
        }
        bundle.putInt("share_type", a);
_L2:
        return bundle;
_L4:
        if (b.imgObj != null)
        {
            bitmap = b.imgObj.getCompressBmp();
            if (bitmap != null)
            {
                file = ShareUtils.getTmpImgFile();
                if (file != null)
                {
                    if (file.exists())
                    {
                        file.delete();
                    }
                    s = file.getAbsolutePath();
                    if (ShareUtils.saveBitmap(bitmap, s))
                    {
                        Log.d("MLShare", (new StringBuilder("MLShare shareFilePath:")).append(s).toString());
                        bundle.putString("share_img_file_path", s);
                    } else
                    {
                        bundle.putParcelable("share_img_data_bmp", bitmap);
                    }
                } else
                {
                    bundle.putParcelable("share_img_data_bmp", bitmap);
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
