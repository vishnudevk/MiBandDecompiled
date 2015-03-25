// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;


// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            b, LinkedBlockingDeque, e, a

class d extends b
{

    final LinkedBlockingDeque d;

    private d(LinkedBlockingDeque linkedblockingdeque)
    {
        d = linkedblockingdeque;
        super(linkedblockingdeque);
    }

    d(LinkedBlockingDeque linkedblockingdeque, a a1)
    {
        this(linkedblockingdeque);
    }

    e a()
    {
        return d.a;
    }

    e a(e e1)
    {
        return e1.c;
    }
}
