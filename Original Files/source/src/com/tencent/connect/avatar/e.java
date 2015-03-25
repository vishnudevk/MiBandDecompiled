// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils;
import java.io.ByteArrayOutputStream;

// Referenced classes of package com.tencent.connect.avatar:
//            ImageActivity

class e extends BaseApi
{

    final ImageActivity a;

    public e(ImageActivity imageactivity, Context context, QQToken qqtoken)
    {
        a = imageactivity;
        super(context, qqtoken);
    }

    public void a(Bitmap bitmap, IUiListener iuilistener)
    {
        Bundle bundle = composeCGIParams();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, 40, bytearrayoutputstream);
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        bitmap.recycle();
        com.tencent.connect.common.BaseApi.TempRequestListener temprequestlistener = new com.tencent.connect.common.BaseApi.TempRequestListener(this, iuilistener);
        bundle.putByteArray("picture", abyte0);
        HttpUtils.requestAsync(mToken, mContext, "user/set_user_face", bundle, "POST", temprequestlistener);
    }
}
