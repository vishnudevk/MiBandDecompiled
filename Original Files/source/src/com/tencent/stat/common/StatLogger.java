// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.stat.common;

import android.util.Log;
import com.tencent.stat.StatConfig;

public final class StatLogger
{

    private String a;
    private boolean b;
    private int c;

    public StatLogger()
    {
        a = "default";
        b = true;
        c = 2;
    }

    public StatLogger(String s)
    {
        a = "default";
        b = true;
        c = 2;
        a = s;
    }

    private String a()
    {
        StackTraceElement astacktraceelement[] = Thread.currentThread().getStackTrace();
        if (astacktraceelement != null)
        {
            int j = astacktraceelement.length;
            int k = 0;
            while (k < j) 
            {
                StackTraceElement stacktraceelement = astacktraceelement[k];
                if (stacktraceelement.isNativeMethod() || stacktraceelement.getClassName().equals(java/lang/Thread.getName()) || stacktraceelement.getClassName().equals(getClass().getName()))
                {
                    k++;
                } else
                {
                    return (new StringBuilder()).append("[").append(Thread.currentThread().getName()).append("(").append(Thread.currentThread().getId()).append("): ").append(stacktraceelement.getFileName()).append(":").append(stacktraceelement.getLineNumber()).append("]").toString();
                }
            }
        }
        return null;
    }

    public void d(Object obj)
    {
        if (isDebugEnable())
        {
            debug(obj);
        }
    }

    public void debug(Object obj)
    {
        if (c <= 3)
        {
            String s = a();
            String s1;
            if (s == null)
            {
                s1 = obj.toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append(" - ").append(obj).toString();
            }
            Log.d(a, s1);
        }
    }

    public void e(Exception exception)
    {
        if (StatConfig.isDebugEnable())
        {
            error(exception);
        }
    }

    public void e(Object obj)
    {
        if (isDebugEnable())
        {
            error(obj);
        }
    }

    public void error(Exception exception)
    {
        if (c <= 6)
        {
            StringBuffer stringbuffer = new StringBuffer();
            String s = a();
            StackTraceElement astacktraceelement[] = exception.getStackTrace();
            if (s != null)
            {
                stringbuffer.append((new StringBuilder()).append(s).append(" - ").append(exception).append("\r\n").toString());
            } else
            {
                stringbuffer.append((new StringBuilder()).append(exception).append("\r\n").toString());
            }
            if (astacktraceelement != null && astacktraceelement.length > 0)
            {
                int j = astacktraceelement.length;
                for (int k = 0; k < j; k++)
                {
                    StackTraceElement stacktraceelement = astacktraceelement[k];
                    if (stacktraceelement != null)
                    {
                        stringbuffer.append((new StringBuilder()).append("[ ").append(stacktraceelement.getFileName()).append(":").append(stacktraceelement.getLineNumber()).append(" ]\r\n").toString());
                    }
                }

            }
            Log.e(a, stringbuffer.toString());
        }
    }

    public void error(Object obj)
    {
        if (c <= 6)
        {
            String s = a();
            String s1;
            if (s == null)
            {
                s1 = obj.toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append(" - ").append(obj).toString();
            }
            Log.e(a, s1);
        }
    }

    public int getLogLevel()
    {
        return c;
    }

    public void i(Object obj)
    {
        if (isDebugEnable())
        {
            info(obj);
        }
    }

    public void info(Object obj)
    {
        if (c <= 4)
        {
            String s = a();
            String s1;
            if (s == null)
            {
                s1 = obj.toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append(" - ").append(obj).toString();
            }
            Log.i(a, s1);
        }
    }

    public boolean isDebugEnable()
    {
        return b;
    }

    public void setDebugEnable(boolean flag)
    {
        b = flag;
    }

    public void setLogLevel(int j)
    {
        c = j;
    }

    public void setTag(String s)
    {
        a = s;
    }

    public void v(Object obj)
    {
        if (isDebugEnable())
        {
            verbose(obj);
        }
    }

    public void verbose(Object obj)
    {
        if (c <= 2)
        {
            String s = a();
            String s1;
            if (s == null)
            {
                s1 = obj.toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append(" - ").append(obj).toString();
            }
            Log.v(a, s1);
        }
    }

    public void w(Object obj)
    {
        if (isDebugEnable())
        {
            warn(obj);
        }
    }

    public void warn(Object obj)
    {
        if (c <= 5)
        {
            String s = a();
            String s1;
            if (s == null)
            {
                s1 = obj.toString();
            } else
            {
                s1 = (new StringBuilder()).append(s).append(" - ").append(obj).toString();
            }
            Log.w(a, s1);
        }
    }
}
