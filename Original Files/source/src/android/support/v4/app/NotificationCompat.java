// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;


// Referenced classes of package android.support.v4.app:
//            U, T, S, R, 
//            Q

public class NotificationCompat
{

    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    private static final Q a;

    public NotificationCompat()
    {
    }

    static Q a()
    {
        return a;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new U();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new T();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new S();
        } else
        {
            a = new R();
        }
    }
}
