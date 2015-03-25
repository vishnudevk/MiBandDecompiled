// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.event;

import android.content.Context;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tencent.stat.event:
//            Event, EventType

public class CustomEvent extends Event
{

    private long a;
    protected Key key;

    public CustomEvent(Context context, int i, String s)
    {
        super(context, i);
        key = new Key();
        a = -1L;
        key.a = s;
    }

    public Key getKey()
    {
        return key;
    }

    public EventType getType()
    {
        return EventType.CUSTOM;
    }

    public boolean onEncode(JSONObject jsonobject)
    {
        jsonobject.put("ei", key.a);
        if (a > 0L)
        {
            jsonobject.put("du", a);
        }
        if (key.b != null)
        {
            JSONArray jsonarray = new JSONArray();
            String as[] = key.b;
            int i = as.length;
            for (int j = 0; j < i; j++)
            {
                jsonarray.put(as[j]);
            }

            jsonobject.put("ar", jsonarray);
        }
        if (key.c != null)
        {
            jsonobject.put("kv", new JSONObject(key.c));
        }
        return true;
    }

    public void setArgs(String as[])
    {
        key.b = as;
    }

    public void setDuration(long l)
    {
        a = l;
    }

    public void setProperties(Properties properties)
    {
        key.c = properties;
    }

    private class Key
    {

        String a;
        String b[];
        Properties c;

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            Key key1;
            boolean flag;
            if (!(obj instanceof Key))
            {
                break MISSING_BLOCK_LABEL_94;
            }
            key1 = (Key)obj;
            if (a.equals(key1.a) && Arrays.equals(b, key1.b))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (flag && c.equals(key1.c)) goto _L1; else goto _L3
_L3:
            return false;
            if (flag && key1.c == null) goto _L1; else goto _L4
_L4:
            return false;
            return false;
        }

        public int hashCode()
        {
            String s = a;
            int i = 0;
            if (s != null)
            {
                i = a.hashCode();
            }
            if (b != null)
            {
                i ^= Arrays.hashCode(b);
            }
            if (c != null)
            {
                i ^= c.hashCode();
            }
            return i;
        }

        public String toString()
        {
            String s = a;
            String s1 = "";
            if (b != null)
            {
                String s2 = b[0];
                for (int i = 1; i < b.length; i++)
                {
                    s2 = (new StringBuilder()).append(s2).append(",").append(b[i]).toString();
                }

                s1 = (new StringBuilder()).append("[").append(s2).append("]").toString();
            }
            if (c != null)
            {
                s1 = (new StringBuilder()).append(s1).append(c.toString()).toString();
            }
            return (new StringBuilder()).append(s).append(s1).toString();
        }

        public Key()
        {
            c = null;
        }
    }

}
