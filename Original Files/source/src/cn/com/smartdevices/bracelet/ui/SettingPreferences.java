// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.SharedPreferences;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SettingPreferences
{

    private static final String a = "SettingPreferences";
    private static final String b = "SettingPreferences";
    private static SharedPreferences c;

    private SettingPreferences()
    {
    }

    public static Object read(Context context, String s)
    {
        Map map;
        Iterator iterator;
        if (c == null)
        {
            c = context.getSharedPreferences("SettingPreferences", 0);
        }
        map = c.getAll();
        iterator = map.keySet().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1 = (String)iterator.next();
        if (!s1.equals(s)) goto _L4; else goto _L3
_L3:
        Object obj = map.get(s1);
_L6:
        if (obj == null)
        {
            Debug.w("SettingPreferences", (new StringBuilder()).append("Not Found Value For : ").append(s).toString());
        }
        Debug.i("SettingPreferences", (new StringBuilder()).append("Read : ").append(s).append(",").append(obj).toString());
        return obj;
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object read(Context context, String s, Object obj)
    {
        Object obj1 = read(context, s);
        if (obj1 == null)
        {
            return obj;
        } else
        {
            return obj1;
        }
    }

    public static void save(Context context, String s, Object obj)
    {
        if (c == null)
        {
            c = context.getSharedPreferences("SettingPreferences", 0);
        }
        Debug.i("SettingPreferences", (new StringBuilder()).append("Save : ").append(s).append(",").append(obj).toString());
        android.content.SharedPreferences.Editor editor = c.edit();
        if (obj instanceof Boolean)
        {
            editor.putBoolean(s, ((Boolean)obj).booleanValue());
        } else
        if (obj instanceof Float)
        {
            editor.putFloat(s, ((Float)obj).floatValue());
        } else
        if (obj instanceof Integer)
        {
            editor.putInt(s, ((Integer)obj).intValue());
        } else
        if (obj instanceof Long)
        {
            editor.putLong(s, ((Long)obj).longValue());
        } else
        if (obj instanceof String)
        {
            editor.putString(s, (String)obj);
        } else
        if (obj instanceof Set)
        {
            try
            {
                editor.putStringSet(s, (Set)obj);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Debug.w("SettingPreferences", (new StringBuilder()).append("Not Support Value Type : ").append(obj).toString());
            }
        } else
        {
            Debug.w("SettingPreferences", (new StringBuilder()).append("Not Support Value Type : ").append(obj).toString());
        }
        editor.commit();
    }
}
