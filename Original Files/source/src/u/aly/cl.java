// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package u.aly:
//            cm

public class cl
    implements Serializable
{

    private static Map d = new HashMap();
    public final String a;
    public final byte b;
    public final cm c;

    public cl(String s, byte byte0, cm cm)
    {
        a = s;
        b = byte0;
        c = cm;
    }

    public static Map a(Class class1)
    {
        if (!d.containsKey(class1))
        {
            try
            {
                class1.newInstance();
            }
            catch (InstantiationException instantiationexception)
            {
                throw new RuntimeException((new StringBuilder("InstantiationException for TBase class: ")).append(class1.getName()).append(", message: ").append(instantiationexception.getMessage()).toString());
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw new RuntimeException((new StringBuilder("IllegalAccessException for TBase class: ")).append(class1.getName()).append(", message: ").append(illegalaccessexception.getMessage()).toString());
            }
        }
        return (Map)d.get(class1);
    }

    public static void a(Class class1, Map map)
    {
        d.put(class1, map);
    }

}
