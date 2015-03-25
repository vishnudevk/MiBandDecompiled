// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import java.net.Socket;

// Referenced classes of package android.support.v4.net:
//            m, j, n

public class TrafficStatsCompat
{

    private static final n a;

    public TrafficStatsCompat()
    {
    }

    public static void clearThreadStatsTag()
    {
        a.a();
    }

    public static int getThreadStatsTag()
    {
        return a.b();
    }

    public static void incrementOperationCount(int i)
    {
        a.a(i);
    }

    public static void incrementOperationCount(int i, int k)
    {
        a.a(i, k);
    }

    public static void setThreadStatsTag(int i)
    {
        a.b(i);
    }

    public static void tagSocket(Socket socket)
    {
        a.a(socket);
    }

    public static void untagSocket(Socket socket)
    {
        a.b(socket);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new m();
        } else
        {
            a = new j();
        }
    }
}
