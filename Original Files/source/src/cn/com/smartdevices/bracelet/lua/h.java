// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpResponseHandler;
import org.apache.http.Header;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            j, k, LuaManager

class h extends AsyncHttpResponseHandler
{

    final LuaManager a;

    h(LuaManager luamanager)
    {
        a = luamanager;
        super();
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        Debug.i("chenee", "getLuaZipFile onFailure=======================================================");
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        String s = Utils.getStringFromBytes(abyte0);
        j j1;
        j1 = (j)Utils.getGson().fromJson(s, cn/com/smartdevices/bracelet/lua/j);
        if (j1.a != 1)
        {
            Debug.i("chenee", (new StringBuilder()).append("get latest luaZipFileVersion error (message:").append(j1.b).append(")").toString());
            return;
        }
        try
        {
            String s1 = j1.c.c;
            String s2 = Keeper.readLatestDBLuaVersion();
            Debug.i("chenee", (new StringBuilder()).append("getLuaZipFileVersion onSuccess====(server version:").append(s1).append(", cur version:").append(s2).append(")").toString());
            if (s1.compareTo(s2) > 0)
            {
                LuaManager.access$000(a);
                return;
            }
        }
        catch (Exception exception)
        {
            Debug.e("chenee", (new StringBuilder()).append("get latest lua gson error!:").append(exception.getMessage()).toString());
        }
        return;
    }
}
