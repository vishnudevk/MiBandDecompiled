// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.content.res.Resources;
import android.os.Environment;
import cn.com.smartdevices.bracelet.DaoManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.webapi.WebAPI;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.query.LazyList;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import de.greenrobot.daobracelet.LuaZipFile;
import de.greenrobot.daobracelet.LuaZipFileDao;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipInputStream;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            i, h, ConfigDynamicDataInfo

public class LuaManager
{

    private static LuaManager __instance = null;
    private Context context;
    private LuaState mLuaState;

    public LuaManager()
    {
        mLuaState = null;
        context = null;
    }

    private String getDBLuaFileByVersion(String s)
    {
        LuaZipFileDao luazipfiledao = DaoManager.getInstance().getLuaZipFileDao();
        int j = (int)luazipfiledao.count();
        Debug.i("chenee", (new StringBuilder()).append("lzipDao.count:").append(j).toString());
        if (j > 0)
        {
            QueryBuilder querybuilder = luazipfiledao.queryBuilder();
            Property aproperty[] = new Property[1];
            aproperty[0] = de.greenrobot.daobracelet.LuaZipFileDao.Properties.Version;
            querybuilder.orderDesc(aproperty);
            querybuilder.where(de.greenrobot.daobracelet.LuaZipFileDao.Properties.Version.eq(s), new WhereCondition[0]);
            LuaZipFile luazipfile = (LuaZipFile)querybuilder.listLazy().get(0);
            String s1 = luazipfile.getVersion();
            Debug.i("chenee", (new StringBuilder()).append("luaZipFile.version:").append(s1).toString());
            return unzip(luazipfile.getZipFile());
        } else
        {
            Debug.e("chenee", (new StringBuilder()).append("read DB zip failed,version:").append(s).toString());
            return null;
        }
    }

    private String getDefaultLuaFileVersion()
    {
        InputStream inputstream;
        BufferedReader bufferedreader;
        inputstream = context.getResources().openRawResource(0x7f060004);
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L2:
        String s;
        String s1;
        try
        {
            s = bufferedreader.readLine();
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            Debug.e("chenee", "read res/raw/luafile.lua version error!!");
            return null;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!s.trim().startsWith("__luaVersion=")) goto _L2; else goto _L1
_L1:
        s1 = s.substring("__luaVersion=".length());
        inputstream.close();
        return s1.trim();
        inputstream.close();
        return null;
    }

    public static LuaManager getInstance()
    {
        if (__instance == null)
        {
            return null;
        } else
        {
            return __instance;
        }
    }

    public static LuaManager getInstance(Context context1)
    {
        if (__instance == null)
        {
            LuaManager luamanager = new LuaManager();
            luamanager.context = context1;
            luamanager.resetLuaState();
            __instance = luamanager;
        }
        return __instance;
    }

    private String getLatestDBLuaFile()
    {
        LuaZipFileDao luazipfiledao = DaoManager.getInstance().getLuaZipFileDao();
        int j = (int)luazipfiledao.count();
        Debug.i("chenee", (new StringBuilder()).append("lzipDao.count:").append(j).toString());
        if (j > 0)
        {
            QueryBuilder querybuilder = luazipfiledao.queryBuilder();
            Property aproperty[] = new Property[1];
            aproperty[0] = de.greenrobot.daobracelet.LuaZipFileDao.Properties.Version;
            querybuilder.orderDesc(aproperty);
            LuaZipFile luazipfile = (LuaZipFile)querybuilder.listLazy().get(0);
            String s = luazipfile.getVersion();
            String s1 = getDefaultLuaFileVersion();
            if (s.compareTo(s1) <= 0)
            {
                Debug.e("chenee", (new StringBuilder()).append("version compare failed: version:").append(s).append(" default version is:").append(s1).toString());
                return null;
            } else
            {
                Debug.i("chenee", (new StringBuilder()).append("use latest script, version:").append(s).append(" (default version is:").append(s1).append(")").toString());
                return unzip(luazipfile.getZipFile());
            }
        } else
        {
            Debug.e("chenee", "read DB zip file failed");
            return null;
        }
    }

    private void getLatestLuaZipFile()
    {
        WebAPI.getLuaScript(Keeper.readLoginData(), new i(this));
    }

    private void getLatestLuaZipFileWithVersionCheck()
    {
        WebAPI.getLuaScriptVersion(Keeper.readLoginData(), new h(this));
    }

    private String getSDCardLuaFile(String s)
    {
        String s1 = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(s).toString();
        String s2;
        try
        {
            FileInputStream fileinputstream = new FileInputStream(s1);
            byte abyte0[] = new byte[fileinputstream.available()];
            fileinputstream.read(abyte0);
            fileinputstream.close();
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            bytearrayoutputstream.write(abyte0);
            s2 = bytearrayoutputstream.toString();
        }
        catch (Exception exception)
        {
            Debug.e("chenee", (new StringBuilder()).append("read failed: ").append(s1).toString());
            return null;
        }
        return s2;
    }

    private String getSDCardZipLuaFile()
    {
        String s;
        try
        {
            FileInputStream fileinputstream = new FileInputStream((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/cheneeispig_hm.zip").toString());
            byte abyte0[] = new byte[fileinputstream.available()];
            fileinputstream.read(abyte0);
            fileinputstream.close();
            s = unzip(abyte0);
        }
        catch (Exception exception)
        {
            Debug.e("chenee", "read sdcard/strangeName.zip failed");
            return null;
        }
        return s;
    }

    private void initLocalizationLua()
    {
        String s = getSDCardLuaFile("/localization_chinese.lua");
        String s1 = getSDCardLuaFile("/localization_english.lua");
        String s2 = getSDCardLuaFile("/localization_traditional_chinese.lua");
        String s3 = getSDCardLuaFile("/localization.lua");
        if (s3 != null && s != null && s1 != null)
        {
            mLuaState.LdoString(s);
            mLuaState.LdoString(s1);
            mLuaState.LdoString(s2);
            mLuaState.LdoString(s3);
        } else
        {
            int ai[] = {
                0x7f060001, 0x7f060002, 0x7f060003, 0x7f060000
            };
            int j = ai.length;
            int k = 0;
            while (k < j) 
            {
                int l = ai[k];
                String s4 = readStream(context.getResources().openRawResource(l));
                mLuaState.LdoString(s4);
                k++;
            }
        }
    }

    private void loadScriptFile()
    {
        String s = getSDCardZipLuaFile();
        if (s == null)
        {
            s = getLatestDBLuaFile();
        }
        initLocalizationLua();
        if (s == null)
        {
            s = readStream(context.getResources().openRawResource(0x7f060004));
        }
        mLuaState.LdoString(s);
        luaSendVersion();
    }

    private void luaSendVersion()
    {
        ConfigDynamicDataInfo configdynamicdatainfo = ConfigDynamicDataInfo.getInstance();
        String s = Keeper.readApkVersion();
        mLuaState.getField(LuaState.LUA_GLOBALSINDEX.intValue(), "setVersion");
        mLuaState.pushJavaObject(configdynamicdatainfo);
        mLuaState.pushString(s);
        callLua(2, 0);
    }

    private String readStream(InputStream inputstream)
    {
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        String s;
        try
        {
            bytearrayoutputstream = new ByteArrayOutputStream();
            j = inputstream.read();
        }
        catch (IOException ioexception)
        {
            Debug.e("chenee", "read res/raw/luafile.lua failed");
            return "";
        }
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        bytearrayoutputstream.write(j);
        j = inputstream.read();
        break MISSING_BLOCK_LABEL_14;
        s = bytearrayoutputstream.toString();
        return s;
    }

    public void callLua(int j, int k)
    {
        int l = mLuaState.pcall(j, k, 0);
        if (l != 0)
        {
            String s = mLuaState.toString(-1);
            Debug.e("chenee", (new StringBuilder()).append("LuaERROR:(").append(l).append(") ").append(s).toString());
        }
    }

    public void checkServerLua()
    {
        getInstance().getLatestLuaZipFileWithVersionCheck();
    }

    public LuaState getLuaState()
    {
        return mLuaState;
    }

    public void resetLuaState()
    {
        if (mLuaState != null)
        {
            mLuaState.close();
        }
        mLuaState = LuaStateFactory.newLuaState();
        mLuaState.openLibs();
        loadScriptFile();
    }

    public String unzip(byte abyte0[])
    {
        ZipInputStream zipinputstream = new ZipInputStream(new ByteArrayInputStream(abyte0));
        String s = null;
_L3:
        ByteArrayOutputStream bytearrayoutputstream;
        int j;
        if (zipinputstream.getNextEntry() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        bytearrayoutputstream = new ByteArrayOutputStream();
        j = zipinputstream.read();
_L1:
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        bytearrayoutputstream.write(j);
        j = zipinputstream.read();
          goto _L1
        String s1;
        zipinputstream.closeEntry();
        s1 = bytearrayoutputstream.toString();
        s = s1;
        if (true) goto _L3; else goto _L2
_L2:
        zipinputstream.close();
        return s;
        IOException ioexception;
        ioexception;
        Debug.e("chenee", ioexception.getMessage());
        ioexception.printStackTrace();
        zipinputstream.close();
        return s;
        Exception exception1;
        exception1;
_L5:
        Debug.e("chenee", exception1.getMessage());
        exception1.printStackTrace();
        return s;
        Exception exception;
        exception;
        zipinputstream.close();
        throw exception;
        Exception exception2;
        exception2;
        exception1 = exception2;
        s = null;
        if (true) goto _L5; else goto _L4
_L4:
    }


}
