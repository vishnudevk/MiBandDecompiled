// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.net;

import java.net.Socket;

// Referenced classes of package android.support.v4.net:
//            n, k, l

class j
    implements n
{

    private ThreadLocal a;

    j()
    {
        a = new k(this);
    }

    public void a()
    {
        ((l)a.get()).a = -1;
    }

    public void a(int i)
    {
    }

    public void a(int i, int i1)
    {
    }

    public void a(Socket socket)
    {
    }

    public int b()
    {
        return ((l)a.get()).a;
    }

    public void b(int i)
    {
        ((l)a.get()).a = i;
    }

    public void b(Socket socket)
    {
    }
}
