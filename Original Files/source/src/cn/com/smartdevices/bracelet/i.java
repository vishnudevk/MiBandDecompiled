// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.app.Activity;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.view.CustomToast;
import com.xiaomi.market.sdk.UpdateResponse;
import com.xiaomi.market.sdk.XiaomiUpdateListener;

// Referenced classes of package cn.com.smartdevices.bracelet:
//            Debug, Utils

final class i
    implements XiaomiUpdateListener
{

    final Activity a;
    final String b;
    final boolean c;

    i(Activity activity, String s, boolean flag)
    {
        a = activity;
        b = s;
        c = flag;
        super();
    }

    public void onUpdateReturned(int j, UpdateResponse updateresponse)
    {
        j;
        JVM INSTR tableswitch 0 5: default 40
    //                   0 41
    //                   1 88
    //                   2 109
    //                   3 130
    //                   4 151
    //                   5 172;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        Debug.i("Utils", (new StringBuilder()).append("\u6709\u66F4\u65B0\uFF0C UpdateResponse\u4E3A\u672C\u6B21\u66F4\u65B0\u7684\u8BE6\u7EC6\u4FE1\u606F: ").append(updateresponse).toString());
        if (!a.isDestroyed())
        {
            Utils.a(updateresponse, a, b);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (c)
        {
            CustomToast.makeText(a, 0x7f0d0017, 1).show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c)
        {
            CustomToast.makeText(a, 0x7f0d0105, 1).show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (c)
        {
            CustomToast.makeText(a, 0x7f0d0105, 1).show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (c)
        {
            CustomToast.makeText(a, 0x7f0d0105, 1).show();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (c)
        {
            CustomToast.makeText(a, 0x7f0d00e0, 1).show();
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }
}
