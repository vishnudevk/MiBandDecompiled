// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import android.net.TrafficStats;
import java.net.Socket;

class o
{

    o()
    {
    }

    public static void a()
    {
        TrafficStats.clearThreadStatsTag();
    }

    public static void a(int i)
    {
        TrafficStats.incrementOperationCount(i);
    }

    public static void a(int i, int j)
    {
        TrafficStats.incrementOperationCount(i, j);
    }

    public static void a(Socket socket)
    {
        TrafficStats.tagSocket(socket);
    }

    public static int b()
    {
        return TrafficStats.getThreadStatsTag();
    }

    public static void b(int i)
    {
        TrafficStats.setThreadStatsTag(i);
    }

    public static void b(Socket socket)
    {
        TrafficStats.untagSocket(socket);
    }
}
