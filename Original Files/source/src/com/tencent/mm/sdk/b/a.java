// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Looper;
import android.os.Process;

// Referenced classes of package com.tencent.mm.sdk.b:
//            b, d

public final class a
{

    private static int a = 6;
    private static a b;
    private static a c;
    private static final String d;
    public static d h;

    static int a()
    {
        return a;
    }

    private static String a(String s)
    {
        if (h != null)
        {
            s = h.b(s);
        }
        return s;
    }

    public static void a(String s, String s1)
    {
        a(s, s1, null);
    }

    public static transient void a(String s, String s1, Object aobj[])
    {
        if (c != null && c.b() <= 4)
        {
            String s2;
            String s3;
            a a1;
            if (aobj == null)
            {
                s2 = s1;
            } else
            {
                s2 = String.format(s1, aobj);
            }
            if (s2 == null)
            {
                s2 = "";
            }
            s3 = a(s);
            a1 = c;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            a1.f(s3, s2);
        }
    }

    public static void b(String s, String s1)
    {
        if (c != null && c.b() <= 2)
        {
            if (s1 == null)
            {
                s1 = "";
            }
            String s2 = a(s);
            a a1 = c;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            a1.d(s2, s1);
        }
    }

    public static void c(String s, String s1)
    {
        if (c != null && c.b() <= 1)
        {
            if (s1 == null)
            {
                s1 = "";
            }
            String s2 = a(s);
            a a1 = c;
            Process.myPid();
            Thread.currentThread().getId();
            Looper.getMainLooper().getThread().getId();
            a1.e(s2, s1);
        }
    }

    static 
    {
        b b1 = new b();
        b = b1;
        c = b1;
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append((new StringBuilder("VERSION.RELEASE:[")).append(android.os.Build.VERSION.RELEASE).toString());
        stringbuilder.append((new StringBuilder("] VERSION.CODENAME:[")).append(android.os.Build.VERSION.CODENAME).toString());
        stringbuilder.append((new StringBuilder("] VERSION.INCREMENTAL:[")).append(android.os.Build.VERSION.INCREMENTAL).toString());
        stringbuilder.append((new StringBuilder("] BOARD:[")).append(Build.BOARD).toString());
        stringbuilder.append((new StringBuilder("] DEVICE:[")).append(Build.DEVICE).toString());
        stringbuilder.append((new StringBuilder("] DISPLAY:[")).append(Build.DISPLAY).toString());
        stringbuilder.append((new StringBuilder("] FINGERPRINT:[")).append(Build.FINGERPRINT).toString());
        stringbuilder.append((new StringBuilder("] HOST:[")).append(Build.HOST).toString());
        stringbuilder.append((new StringBuilder("] MANUFACTURER:[")).append(Build.MANUFACTURER).toString());
        stringbuilder.append((new StringBuilder("] MODEL:[")).append(Build.MODEL).toString());
        stringbuilder.append((new StringBuilder("] PRODUCT:[")).append(Build.PRODUCT).toString());
        stringbuilder.append((new StringBuilder("] TAGS:[")).append(Build.TAGS).toString());
        stringbuilder.append((new StringBuilder("] TYPE:[")).append(Build.TYPE).toString());
        stringbuilder.append((new StringBuilder("] USER:[")).append(Build.USER).append("]").toString());
        d = stringbuilder.toString();
    }

    private class a
    {

        public abstract int b();

        public abstract void d(String s, String s1);

        public abstract void e(String s, String s1);

        public abstract void f(String s, String s1);
    }

}
