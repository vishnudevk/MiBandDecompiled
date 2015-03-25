// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.view.CustomToast;

class by extends Handler
{

    final SettingAboutActivity.SettingAboutFragment a;

    by(SettingAboutActivity.SettingAboutFragment settingaboutfragment)
    {
        a = settingaboutfragment;
        super();
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 37
    //                   2 81
    //                   3 129
    //                   4 215;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        if (SettingAboutActivity.SettingAboutFragment.a(a) == null)
        {
            SettingAboutActivity.SettingAboutFragment.a(a, ProgressDialog.show(a.getActivity(), "\u4E0A\u4F20\u65E5\u5FD7\u6587\u4EF6", "\u51C6\u5907\u4E0A\u4F20\u65E5\u5FD7\u6587\u4EF6"));
            SettingAboutActivity.SettingAboutFragment.a(a).setCancelable(true);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (SettingAboutActivity.SettingAboutFragment.a(a) != null)
        {
            SettingAboutActivity.SettingAboutFragment.a(a).setMessage((new StringBuilder()).append("\u5DF2\u4E0A\u4F20\uFF1A").append(message.arg1).append("%").toString());
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (SettingAboutActivity.SettingAboutFragment.a(a) != null)
        {
            SettingAboutActivity.SettingAboutFragment.a(a).dismiss();
            SettingAboutActivity.SettingAboutFragment.a(a, null);
        }
        if (a.getActivity() != null)
        {
            if (((Boolean)message.obj).booleanValue())
            {
                CustomToast.makeText(a.getActivity(), "\u4E0A\u4F20\u6210\u529F\uFF0C\u611F\u8C22\u60A8\u7684\u652F\u6301\uFF01", 0).show();
                return;
            } else
            {
                CustomToast.makeText(a.getActivity(), "\u4E0A\u4F20\u5931\u8D25\uFF0C\u60A8\u53EF\u4EE5\u91CD\u65B0\u4E0A\u4F20\uFF0C\u611F\u8C22\u60A8\u7684\u652F\u6301\uFF01", 0).show();
                return;
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
        SettingAboutActivity.SettingAboutFragment.a(a, 0);
        return;
    }
}
