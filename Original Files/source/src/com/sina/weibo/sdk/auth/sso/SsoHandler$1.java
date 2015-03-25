// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.sina.sso.RemoteSSO;
import com.sina.weibo.sdk.auth.WeiboAuth;

// Referenced classes of package com.sina.weibo.sdk.auth.sso:
//            SsoHandler

class this._cls0
    implements ServiceConnection
{

    final SsoHandler this$0;

    public void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        RemoteSSO remotesso = com.sina.sso.b.asInterface(ibinder);
        try
        {
            String s = remotesso.getPackageName();
            String s1 = remotesso.getActivityName();
            if (!SsoHandler.access$2(SsoHandler.this, s, s1))
            {
                SsoHandler.access$0(SsoHandler.this).anthorize(SsoHandler.access$1(SsoHandler.this));
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            remoteexception.printStackTrace();
        }
    }

    public void onServiceDisconnected(ComponentName componentname)
    {
        SsoHandler.access$0(SsoHandler.this).anthorize(SsoHandler.access$1(SsoHandler.this));
    }

    ()
    {
        this$0 = SsoHandler.this;
        super();
    }
}
