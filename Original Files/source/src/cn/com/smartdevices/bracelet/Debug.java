// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Debug
{

    public static int DEBUG_ERROR = 0;
    public static boolean DEBUG_FILE = false;
    public static int DEBUG_INFO = 0;
    public static int DEBUG_LEVEL = 0;
    public static int DEBUG_NONE = 0;
    public static int DEBUG_WARN = 0;
    public static int STACK_LEVEL = 0;
    private static final int a = 0x1400000;

    public Debug()
    {
    }

    private static String a()
    {
        StackTraceElement stacktraceelement = (new Exception()).getStackTrace()[STACK_LEVEL];
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<");
        String s = stacktraceelement.getClassName();
        stringbuilder.append(s.substring(1 + s.lastIndexOf(".")));
        stringbuilder.append(":");
        stringbuilder.append(stacktraceelement.getMethodName());
        stringbuilder.append(":");
        stringbuilder.append(stacktraceelement.getLineNumber());
        stringbuilder.append("> ");
        return stringbuilder.toString();
    }

    private static String b()
    {
        Date date = new Date();
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")).format(date);
    }

    public static void e(String s, String s1)
    {
        if (DEBUG_LEVEL > DEBUG_NONE)
        {
            Log.e(s, (new StringBuilder()).append(a()).append(s1).toString());
        }
    }

    public static void enable(boolean flag)
    {
        int j;
        if (flag)
        {
            j = DEBUG_INFO;
        } else
        {
            j = DEBUG_NONE;
        }
        DEBUG_LEVEL = j;
        DEBUG_FILE = flag;
        com.xiaomi.hm.bleservice.util.Debug.enable(flag);
    }

    public static void enable(boolean flag, boolean flag1)
    {
        int j;
        if (flag)
        {
            j = DEBUG_INFO;
        } else
        {
            j = DEBUG_NONE;
        }
        DEBUG_LEVEL = j;
        com.xiaomi.hm.bleservice.util.Debug.enable(flag);
        DEBUG_FILE = flag1;
    }

    public static void f(String s, String s1)
    {
        if (!DEBUG_FILE)
        {
            return;
        }
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/mili_log.txt").toString());
        if (file.exists() && file.length() > 0x1400000L)
        {
            file.delete();
        }
        try
        {
            FileWriter filewriter = new FileWriter(file, true);
            filewriter.write((new StringBuilder()).append(b()).append("  ").append(s).append("  ").append(s1).append("\n").toString());
            filewriter.close();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public static void fi(String s, String s1)
    {
        i(s, s1);
        f(s, s1);
    }

    public static void i(String s, String s1)
    {
        if (DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_WARN)
        {
            Log.i(s, (new StringBuilder()).append(a()).append(s1).toString());
        }
    }

    public static boolean isEnabled()
    {
        return DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_ERROR;
    }

    public static boolean isEnaledFile()
    {
        return DEBUG_FILE;
    }

    public static void l(String s, String s1)
    {
        if (DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_WARN)
        {
            for (int j = 0; j <= s1.length() / 1000; j++)
            {
                int k = j * 1000;
                int i1 = 1000 * (j + 1);
                if (i1 > s1.length())
                {
                    i1 = s1.length();
                }
                Log.i(s, (new StringBuilder()).append(a()).append(s1.substring(k, i1)).toString());
            }

        }
    }

    public static void line()
    {
        if (DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_WARN)
        {
            StackTraceElement stacktraceelement = (new Exception()).getStackTrace()[-1 + STACK_LEVEL];
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(stacktraceelement.getMethodName());
            stringbuilder.append(":");
            stringbuilder.append(stacktraceelement.getLineNumber());
            String s = stacktraceelement.getClassName();
            Log.i(s.substring(1 + s.lastIndexOf(".")), stringbuilder.toString());
        }
    }

    public static void w(String s, String s1)
    {
        if (DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_ERROR)
        {
            Log.w(s, (new StringBuilder()).append(a()).append(s1).toString());
        }
    }

    public static void w(String s, String s1, Throwable throwable)
    {
        if (DEBUG_LEVEL > DEBUG_NONE && DEBUG_LEVEL < DEBUG_ERROR)
        {
            Log.w(s, s1, throwable);
        }
    }

    static 
    {
        DEBUG_NONE = -1;
        DEBUG_INFO = 0;
        DEBUG_WARN = 1;
        DEBUG_ERROR = 2;
        DEBUG_LEVEL = DEBUG_INFO;
        DEBUG_FILE = true;
        STACK_LEVEL = 2;
    }
}
