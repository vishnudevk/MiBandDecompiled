// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import java.util.Comparator;

// Referenced classes of package android.support.v4.view:
//            aC

final class ay
    implements Comparator
{

    ay()
    {
    }

    public int a(aC ac, aC ac1)
    {
        return ac.b - ac1.b;
    }

    public int compare(Object obj, Object obj1)
    {
        return a((aC)obj, (aC)obj1);
    }
}
