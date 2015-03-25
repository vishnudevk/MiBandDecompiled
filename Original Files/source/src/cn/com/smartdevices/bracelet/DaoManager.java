// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.content.Context;
import de.greenrobot.daobracelet.DaoMaster;
import de.greenrobot.daobracelet.DaoSession;
import de.greenrobot.daobracelet.LuaListDao;
import de.greenrobot.daobracelet.LuaZipFileDao;

public class DaoManager
{

    private static DaoManager b = null;
    private static Context c = null;
    DaoSession a;

    private DaoManager(Context context)
    {
        a = null;
        a = (new DaoMaster((new de.greenrobot.daobracelet.DaoMaster.DevOpenHelper(context, "user-db", null)).getWritableDatabase())).newSession();
    }

    public static DaoManager getInstance()
    {
        if (b == null)
        {
            b = new DaoManager(c);
        }
        return b;
    }

    public static void init(Context context)
    {
        c = context;
    }

    public LuaListDao getLuaListDao()
    {
        return a.getLuaListDao();
    }

    public LuaZipFileDao getLuaZipFileDao()
    {
        return a.getLuaZipFileDao();
    }

}
