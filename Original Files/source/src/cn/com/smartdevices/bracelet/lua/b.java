// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.view.CustomToast;
import de.greenrobot.daobracelet.LuaList;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            LuaListAdapter, d, LuaAction

class b
    implements android.view.View.OnClickListener
{

    final LuaListAdapter a;

    b(LuaListAdapter lualistadapter)
    {
        a = lualistadapter;
        super();
    }

    public void onClick(View view)
    {
        LuaList lualist;
        String s;
        UmengAnalytics.event(LuaListAdapter.access$000(a), "DynamicList", "DynamicListItemClick");
        lualist = (LuaList)((d)view.getTag()).a.getTag();
        s = lualist.getLuaActionScript();
        if (s == null || s.length() < 5)
        {
            return;
        }
        try
        {
            if (s.startsWith("http://"))
            {
                Debug.e("chenee", (new StringBuilder()).append("should not use http:// use script directly instead!!(script:").append(s).append(")").toString());
                return;
            }
        }
        catch (Exception exception)
        {
            Debug.e("chenee", exception.getMessage());
            return;
        }
        if (s.startsWith("file://"))
        {
            Debug.e("chenee", (new StringBuilder()).append("should not use file:// use script directly instead!!(script:").append(s).append(")").toString());
            return;
        }
        if ("GAME_20141001".equals(lualist.getType()) && !Utils.isNetworkConnected(LuaListAdapter.access$000(a)))
        {
            CustomToast.makeText(LuaListAdapter.access$000(a), 0x7f0d010c, 1).show();
            return;
        }
        LuaAction.getInstance(LuaListAdapter.access$000(a)).doLuaAction(s);
        return;
    }
}
