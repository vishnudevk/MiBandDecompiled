// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;

import android.content.ContentResolver;
import android.content.ContentValues;
import com.tencent.mm.sdk.b.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class b
    implements android.content.SharedPreferences.Editor
{

    private Map a;
    private Set b;
    private boolean c;
    private ContentResolver d;

    public b(ContentResolver contentresolver)
    {
        a = new HashMap();
        b = new HashSet();
        c = false;
        d = contentresolver;
    }

    public void apply()
    {
    }

    public android.content.SharedPreferences.Editor clear()
    {
        c = true;
        return this;
    }

    public boolean commit()
    {
        ContentValues contentvalues = new ContentValues();
        if (c)
        {
            d.delete(com.tencent.mm.sdk.c.a.b.CONTENT_URI, null, null);
            c = false;
        }
        String s;
        for (Iterator iterator = b.iterator(); iterator.hasNext(); d.delete(com.tencent.mm.sdk.c.a.b.CONTENT_URI, "key = ?", new String[] {
    s
}))
        {
            s = (String)iterator.next();
        }

        Iterator iterator1 = a.entrySet().iterator();
        do
        {
            if (iterator1.hasNext())
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator1.next();
                Object obj = entry.getValue();
                byte byte0;
                boolean flag;
                if (obj == null)
                {
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                    byte0 = 0;
                } else
                if (obj instanceof Integer)
                {
                    byte0 = 1;
                } else
                if (obj instanceof Long)
                {
                    byte0 = 2;
                } else
                if (obj instanceof String)
                {
                    byte0 = 3;
                } else
                if (obj instanceof Boolean)
                {
                    byte0 = 4;
                } else
                if (obj instanceof Float)
                {
                    byte0 = 5;
                } else
                if (obj instanceof Double)
                {
                    byte0 = 6;
                } else
                {
                    com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", (new StringBuilder("unresolve failed, unknown type=")).append(obj.getClass().toString()).toString());
                    byte0 = 0;
                }
                if (byte0 == 0)
                {
                    flag = false;
                } else
                {
                    contentvalues.put("type", Integer.valueOf(byte0));
                    contentvalues.put("value", obj.toString());
                    flag = true;
                }
                if (flag)
                {
                    ContentResolver contentresolver = d;
                    android.net.Uri uri = com.tencent.mm.sdk.c.a.b.CONTENT_URI;
                    String as[] = new String[1];
                    as[0] = (String)entry.getKey();
                    contentresolver.update(uri, contentvalues, "key = ?", as);
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public android.content.SharedPreferences.Editor putBoolean(String s, boolean flag)
    {
        a.put(s, Boolean.valueOf(flag));
        b.remove(s);
        return this;
    }

    public android.content.SharedPreferences.Editor putFloat(String s, float f)
    {
        a.put(s, Float.valueOf(f));
        b.remove(s);
        return this;
    }

    public android.content.SharedPreferences.Editor putInt(String s, int i)
    {
        a.put(s, Integer.valueOf(i));
        b.remove(s);
        return this;
    }

    public android.content.SharedPreferences.Editor putLong(String s, long l)
    {
        a.put(s, Long.valueOf(l));
        b.remove(s);
        return this;
    }

    public android.content.SharedPreferences.Editor putString(String s, String s1)
    {
        a.put(s, s1);
        b.remove(s);
        return this;
    }

    public android.content.SharedPreferences.Editor putStringSet(String s, Set set)
    {
        return null;
    }

    public android.content.SharedPreferences.Editor remove(String s)
    {
        b.add(s);
        return this;
    }
}
