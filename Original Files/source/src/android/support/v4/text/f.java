// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f
{

    private static final String a = "ICUCompatIcs";
    private static Method b;
    private static Method c;

    f()
    {
    }

    public static String a(String s)
    {
        String s1;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Object aobj[] = {
            s
        };
        s1 = (String)b.invoke(null, aobj);
        return s1;
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.w("ICUCompatIcs", illegalaccessexception);
_L2:
        return null;
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        Log.w("ICUCompatIcs", invocationtargetexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static String b(String s)
    {
        String s1;
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Object aobj[] = {
            s
        };
        s1 = (String)c.invoke(null, aobj);
        return s1;
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        Log.w("ICUCompatIcs", illegalaccessexception);
_L2:
        return s;
        InvocationTargetException invocationtargetexception;
        invocationtargetexception;
        Log.w("ICUCompatIcs", invocationtargetexception);
        if (true) goto _L2; else goto _L1
_L1:
    }

    static 
    {
        Class class1;
        try
        {
            class1 = Class.forName("libcore.icu.ICU");
        }
        catch (Exception exception)
        {
            Log.w("ICUCompatIcs", exception);
        }
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        b = class1.getMethod("getScript", new Class[] {
            java/lang/String
        });
        c = class1.getMethod("addLikelySubtags", new Class[] {
            java/lang/String
        });
    }
}
