// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.activity;

import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.activity:
//            LoginActivity

class h
    implements cn.com.smartdevices.bracelet.Utils.OperationCallback
{

    final LoginActivity a;

    h(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }

    public void onFailure()
    {
        Debug.i("LoginActivity", "Update sh fail ");
        LoginActivity.j(a);
    }

    public void onSuccess()
    {
        Debug.i("LoginActivity", "Update sh ok");
        LoginActivity.j(a);
    }
}
