// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.text;


// Referenced classes of package android.support.v4.text:
//            e, d, c

public class ICUCompat
{

    private static final c a;

    public ICUCompat()
    {
    }

    public static String addLikelySubtags(String s)
    {
        return a.b(s);
    }

    public static String getScript(String s)
    {
        return a.a(s);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new e();
        } else
        {
            a = new d();
        }
    }
}
