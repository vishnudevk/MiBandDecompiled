// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.util.Base64;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import de.greenrobot.daobracelet.LuaZipFile;
import de.greenrobot.daobracelet.LuaZipFileDao;
import java.util.Locale;
import org.apache.http.Header;
import org.keplerproject.luajava.LuaState;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            j, k, LuaManager

class i extends AsyncHttpResponseHandler
{

    final LuaManager a;

    i(LuaManager luamanager)
    {
        a = luamanager;
        super();
    }

    public void onFailure(int l, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.i("chenee", "getLuaZipFile onFailure=========================================");
    }

    public void onSuccess(int l, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        j j1;
        j1 = (j)Utils.getGson().fromJson(s, cn/com/smartdevices/bracelet/lua/j);
        if (j1.a != 1)
        {
            Debug.i("chenee", (new StringBuilder()).append("get latest luaZipFile error (message:").append(j1.b).append(")").toString());
            return;
        }
        try
        {
            byte abyte1[] = Base64.decode(j1.c.b, 2);
            LuaZipFile luazipfile = new LuaZipFile();
            luazipfile.setVersion(j1.c.c);
            luazipfile.setZipFile(abyte1);
            LuaZipFileDao luazipfiledao = DaoManager.getInstance().getLuaZipFileDao();
            luazipfiledao.insertOrReplace(luazipfile);
            Keeper.keepLatestDBLuaVersion(j1.c.c);
            Debug.i("chenee", (new StringBuilder()).append("save DB luaZipFile onSuccess====(version:").append(j1.c.c).append(")").toString());
            a.resetLuaState();
            LuaState luastate = a.getLuaState();
            luastate.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setLocale");
            luastate.pushString(Locale.getDefault().toString());
            a.callLua(1, 0);
            Debug.i("chenee", (new StringBuilder()).append("zipfile count:").append(luazipfiledao.count()).toString());
            return;
        }
        catch (Exception exception)
        {
            Debug.e("chenee", (new StringBuilder()).append("get latest lua gson error!:").append(exception.getMessage()).toString());
        }
        return;
    }
}
