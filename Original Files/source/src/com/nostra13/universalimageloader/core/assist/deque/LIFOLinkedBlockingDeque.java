// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist.deque;


// Referenced classes of package com.nostra13.universalimageloader.core.assist.deque:
//            LinkedBlockingDeque

public class LIFOLinkedBlockingDeque extends LinkedBlockingDeque
{

    private static final long serialVersionUID = 0xc6e5579e1b2b06b0L;

    public LIFOLinkedBlockingDeque()
    {
    }

    public boolean offer(Object obj)
    {
        return super.offerFirst(obj);
    }

    public Object remove()
    {
        return super.removeFirst();
    }
}
