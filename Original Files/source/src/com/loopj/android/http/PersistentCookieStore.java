// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

// Referenced classes of package com.loopj.android.http:
//            SerializableCookie

public class PersistentCookieStore
    implements CookieStore
{

    private static final String a = "PersistentCookieStore";
    private static final String b = "CookiePrefsFile";
    private static final String c = "names";
    private static final String d = "cookie_";
    private boolean e;
    private final ConcurrentHashMap f = new ConcurrentHashMap();
    private final SharedPreferences g;

    public PersistentCookieStore(Context context)
    {
        int i = 0;
        super();
        e = false;
        g = context.getSharedPreferences("CookiePrefsFile", 0);
        String s = g.getString("names", null);
        if (s != null)
        {
            String as[] = TextUtils.split(s, ",");
            for (int j = as.length; i < j; i++)
            {
                String s1 = as[i];
                String s2 = g.getString((new StringBuilder()).append("cookie_").append(s1).toString(), null);
                if (s2 == null)
                {
                    continue;
                }
                Cookie cookie = decodeCookie(s2);
                if (cookie != null)
                {
                    f.put(s1, cookie);
                }
            }

            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie)
    {
        if (e && !cookie.isPersistent())
        {
            return;
        }
        String s = (new StringBuilder()).append(cookie.getName()).append(cookie.getDomain()).toString();
        android.content.SharedPreferences.Editor editor;
        if (!cookie.isExpired(new Date()))
        {
            f.put(s, cookie);
        } else
        {
            f.remove(s);
        }
        editor = g.edit();
        editor.putString("names", TextUtils.join(",", f.keySet()));
        editor.putString((new StringBuilder()).append("cookie_").append(s).toString(), encodeCookie(new SerializableCookie(cookie)));
        editor.commit();
    }

    protected String byteArrayToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(2 * abyte0.length);
        int i = abyte0.length;
        for (int j = 0; j < i; j++)
        {
            int k = 0xff & abyte0[j];
            if (k < 16)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(Integer.toHexString(k));
        }

        return stringbuilder.toString().toUpperCase(Locale.US);
    }

    public void clear()
    {
        android.content.SharedPreferences.Editor editor = g.edit();
        String s;
        for (Iterator iterator = f.keySet().iterator(); iterator.hasNext(); editor.remove((new StringBuilder()).append("cookie_").append(s).toString()))
        {
            s = (String)iterator.next();
        }

        editor.remove("names");
        editor.commit();
        f.clear();
    }

    public boolean clearExpired(Date date)
    {
        android.content.SharedPreferences.Editor editor = g.edit();
        Iterator iterator = f.entrySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            boolean flag1;
            if (((Cookie)entry.getValue()).isExpired(date))
            {
                f.remove(s);
                editor.remove((new StringBuilder()).append("cookie_").append(s).toString());
                flag1 = true;
            } else
            {
                flag1 = flag;
            }
            flag = flag1;
        }
        if (flag)
        {
            editor.putString("names", TextUtils.join(",", f.keySet()));
        }
        editor.commit();
        return flag;
    }

    protected Cookie decodeCookie(String s)
    {
        ByteArrayInputStream bytearrayinputstream = new ByteArrayInputStream(hexStringToByteArray(s));
        Cookie cookie;
        try
        {
            cookie = ((SerializableCookie)(new ObjectInputStream(bytearrayinputstream)).readObject()).getCookie();
        }
        catch (Exception exception)
        {
            Log.d("PersistentCookieStore", "decodeCookie failed", exception);
            return null;
        }
        return cookie;
    }

    public void deleteCookie(Cookie cookie)
    {
        String s = cookie.getName();
        f.remove(s);
        android.content.SharedPreferences.Editor editor = g.edit();
        editor.remove((new StringBuilder()).append("cookie_").append(s).toString());
        editor.commit();
    }

    protected String encodeCookie(SerializableCookie serializablecookie)
    {
        if (serializablecookie == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            (new ObjectOutputStream(bytearrayoutputstream)).writeObject(serializablecookie);
        }
        catch (Exception exception)
        {
            return null;
        }
        return byteArrayToHexString(bytearrayoutputstream.toByteArray());
    }

    public List getCookies()
    {
        return new ArrayList(f.values());
    }

    protected byte[] hexStringToByteArray(String s)
    {
        int i = s.length();
        byte abyte0[] = new byte[i / 2];
        for (int j = 0; j < i; j += 2)
        {
            abyte0[j / 2] = (byte)((Character.digit(s.charAt(j), 16) << 4) + Character.digit(s.charAt(j + 1), 16));
        }

        return abyte0;
    }

    public void setOmitNonPersistentCookies(boolean flag)
    {
        e = flag;
    }
}
