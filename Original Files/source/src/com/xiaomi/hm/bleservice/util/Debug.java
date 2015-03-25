// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.util;

import android.util.Log;

public final class Debug
{

    private static boolean a = false;
    private static final boolean b = true;
    private static final boolean c = true;
    private static final boolean d = true;
    private static final boolean e = true;
    private static final boolean f = true;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static final boolean j = true;
    private static final boolean k = false;
    private static final String l = "DEBUG";

    public Debug()
    {
    }

    public static void ASSERT_NOT_NULL(Object obj)
    {
        if (h && obj == null)
        {
            a("DEBUG", ">>> `NOT NULL` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void ASSERT_NULL(Object obj)
    {
        if (h && obj != null)
        {
            a("DEBUG", ">>> `NULL` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void ASSERT_RUN_ON_THREAD(Thread thread)
    {
        if (h && thread != null && Thread.currentThread().getId() != thread.getId())
        {
            a("DEBUG", ">>> `RUN ON THREAD` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void ASSERT_TRUE(boolean flag)
    {
        if (h && !flag)
        {
            a("DEBUG", ">>> `TRUE` ASSERTION FAILED <<<", 0, 'e');
        }
    }

    public static void DEBUG(String s)
    {
        a("DEBUG", s, 0, 'd');
    }

    public static void DEBUG_LOCK(String s)
    {
        if (i)
        {
            a("DEBUG", (new StringBuilder()).append("LOCK#").append(s).toString(), 0, 'v');
        }
    }

    public static void ENABLE(boolean flag, boolean flag1, boolean flag2)
    {
        a = true;
        g = flag;
        h = flag1;
        i = flag2;
        a();
        INFO("         ENABLE_VERBOSE: TRUE");
        INFO("           ENABLE_DEBUG: TRUE");
        INFO("            ENABLE_INFO: TRUE");
        INFO("            ENABLE_WARN: TRUE");
        INFO("           ENABLE_ERROR: TRUE");
        StringBuilder stringbuilder = (new StringBuilder()).append("           ENABLE_TRACE: ");
        String s;
        StringBuilder stringbuilder1;
        String s1;
        StringBuilder stringbuilder2;
        String s2;
        if (g)
        {
            s = "TRUE";
        } else
        {
            s = "FALSE";
        }
        INFO(stringbuilder.append(s).toString());
        stringbuilder1 = (new StringBuilder()).append("          ENABLE_ASSERT: ");
        if (h)
        {
            s1 = "TRUE";
        } else
        {
            s1 = "FALSE";
        }
        INFO(stringbuilder1.append(s1).toString());
        stringbuilder2 = (new StringBuilder()).append("      ENABLE_DEBUG_LOCK: ");
        if (i)
        {
            s2 = "TRUE";
        } else
        {
            s2 = "FALSE";
        }
        INFO(stringbuilder2.append(s2).toString());
        INFO("        ENABLE_LOG_META: TRUE");
        INFO("  ENABLE_LOG_TRACE_INFO: FALSE");
    }

    public static void ERROR(String s)
    {
        a("DEBUG", s, 0, 'e');
    }

    public static void INFO(String s)
    {
        a("DEBUG", s, 0, 'i');
    }

    public static void TRACE()
    {
        if (g)
        {
            a("DEBUG", "<<<<====", 0, 'v');
        }
    }

    public static void VERBOSE(String s)
    {
        a("DEBUG", s, 0, 'v');
    }

    public static void WARN(String s)
    {
        a("DEBUG", s, 0, 'w');
    }

    private static void a()
    {
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MM.:  .:'   `:::  .:`MMMMMMMMMMM|`MMM'|MMMMMMMMMMM':  .:'   `:::  .:'.MM");
        INFO("MMMM.     :          `MMMMMMMMMM  :*'  MMMMMMMMMM'        :        .MMMM");
        INFO("MMMMM.    ::    .     `MMMMMMMM'  ::   `MMMMMMMM'   .     ::   .  .MMMMM");
        INFO("MMMMMM. :   :: ::'  :   :: ::'  :   :: ::'      :: ::'  :   :: ::.MMMMMM");
        INFO("MMMMMMM    ;::         ;::         ;::         ;::         ;::   MMMMMMM");
        INFO("MMMMMMM .:'   `:::  .:'   `:::  .:'   `:::  .:'   `:::  .:'   `::MMMMMMM");
        INFO("MMMMMM'     :           :           :           :           :    `MMMMMM");
        INFO("MMMMM'______::____      ::    .     ::    .     ::     ___._::____`MMMMM");
        INFO("MMMMMMMMMMMMMMMMMMM`---._ :: ::'  :   :: ::'  _.--::MMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMM::.         ::  .--MMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMM-.     ;::-MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM. .:' .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM.   .MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\\ /MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMVMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .:ZylvanaS:. MM");
        INFO("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
    }

    private static void a(String s, String s1, int i1, char c1)
    {
        if (!a)
        {
            return;
        }
        String s2 = Thread.currentThread().getName();
        StackTraceElement stacktraceelement = Thread.currentThread().getStackTrace()[i1 + 4];
        String s3 = stacktraceelement.getClassName();
        String s4 = s3.substring(1 + s3.lastIndexOf('.'));
        String s5 = stacktraceelement.getMethodName();
        int j1 = stacktraceelement.getLineNumber();
        String s6 = (new StringBuilder()).append("[").append(s2).append("]").append("<").append(s4).append(":").append(s5).append(":").append(j1).append("> ").toString();
        switch (c1)
        {
        default:
            return;

        case 100: // 'd'
            Log.d(s, (new StringBuilder()).append(s6).append(s1).append("").toString());
            return;

        case 118: // 'v'
            Log.v(s, (new StringBuilder()).append(s6).append(s1).append("").toString());
            return;

        case 105: // 'i'
            Log.i(s, (new StringBuilder()).append(s6).append(s1).append("").toString());
            return;

        case 119: // 'w'
            Log.w(s, (new StringBuilder()).append(s6).append(s1).append("").toString());
            return;

        case 101: // 'e'
            Log.e(s, (new StringBuilder()).append(s6).append(s1).append("").toString());
            return;
        }
    }

    public static void enable(boolean flag)
    {
        a = flag;
        g = flag;
        h = flag;
        i = flag;
    }

    static 
    {
        a = false;
        g = true;
        h = true;
        i = true;
    }
}
