// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import de.greenrobot.daobracelet.LuaList;
import java.util.Comparator;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            LuaListAdapter

public class this._cls0
    implements Comparator
{

    final LuaListAdapter this$0;

    public int compare(LuaList lualist, LuaList lualist1)
    {
        byte byte0 = -1;
        String s = lualist1.getRight();
        String s1 = lualist.getRight();
        if (s == null && s1 == null)
        {
            byte0 = 0;
        } else
        if (s != null || s1 == null)
        {
            if (s != null && s1 == null)
            {
                return 1;
            }
            if (s.length() > s1.length())
            {
                return 1;
            }
            if (s.length() >= s1.length())
            {
                return s.compareTo(s1);
            }
        }
        return byte0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((LuaList)obj, (LuaList)obj1);
    }

    public ()
    {
        this$0 = LuaListAdapter.this;
        super();
    }
}
