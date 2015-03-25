// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.tencent.mm.sdk.openapi:
//            b

class a
    implements SharedPreferences
{

    private final ContentResolver a;
    private final String b[] = {
        "_id", "key", "type", "value"
    };
    private final HashMap c = new HashMap();
    private b d;

    public a(Context context)
    {
        d = null;
        a = context.getContentResolver();
    }

    private Object a(String s)
    {
        Object obj;
        Cursor cursor;
        int i;
        int j;
        try
        {
            cursor = a.query(com.tencent.mm.sdk.c.b.CONTENT_URI, b, "key = ?", new String[] {
                s
            }, null);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        if (cursor == null)
        {
            return null;
        }
        i = cursor.getColumnIndex("type");
        j = cursor.getColumnIndex("value");
        if (!cursor.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj = com.tencent.mm.sdk.c.a.a(cursor.getInt(i), cursor.getString(j));
_L1:
        cursor.close();
        return obj;
        obj = null;
          goto _L1
    }

    public boolean contains(String s)
    {
        return a(s) != null;
    }

    public android.content.SharedPreferences.Editor edit()
    {
        if (d == null)
        {
            d = new b(a);
        }
        return d;
    }

    public Map getAll()
    {
        Cursor cursor;
        int i;
        int j;
        int k;
        Object obj;
        try
        {
            cursor = a.query(com.tencent.mm.sdk.c.b.CONTENT_URI, b, null, null, null);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return c;
        }
        if (cursor == null)
        {
            return null;
        }
        i = cursor.getColumnIndex("key");
        j = cursor.getColumnIndex("type");
        k = cursor.getColumnIndex("value");
        for (; cursor.moveToNext(); c.put(cursor.getString(i), obj))
        {
            obj = com.tencent.mm.sdk.c.a.a(cursor.getInt(j), cursor.getString(k));
        }

        HashMap hashmap;
        cursor.close();
        hashmap = c;
        return hashmap;
    }

    public boolean getBoolean(String s, boolean flag)
    {
        Object obj = a(s);
        if (obj != null && (obj instanceof Boolean))
        {
            flag = ((Boolean)obj).booleanValue();
        }
        return flag;
    }

    public float getFloat(String s, float f)
    {
        Object obj = a(s);
        if (obj != null && (obj instanceof Float))
        {
            f = ((Float)obj).floatValue();
        }
        return f;
    }

    public int getInt(String s, int i)
    {
        Object obj = a(s);
        if (obj != null && (obj instanceof Integer))
        {
            i = ((Integer)obj).intValue();
        }
        return i;
    }

    public long getLong(String s, long l)
    {
        Object obj = a(s);
        if (obj != null && (obj instanceof Long))
        {
            l = ((Long)obj).longValue();
        }
        return l;
    }

    public String getString(String s, String s1)
    {
        Object obj = a(s);
        if (obj != null && (obj instanceof String))
        {
            return (String)obj;
        } else
        {
            return s1;
        }
    }

    public Set getStringSet(String s, Set set)
    {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }

    public void unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences.OnSharedPreferenceChangeListener onsharedpreferencechangelistener)
    {
    }
}
