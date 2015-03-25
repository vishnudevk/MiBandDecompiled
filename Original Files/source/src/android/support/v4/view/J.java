// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.MotionEvent;

// Referenced classes of package android.support.v4.view:
//            L

class J
    implements L
{

    J()
    {
    }

    public int a(MotionEvent motionevent)
    {
        return 1;
    }

    public int a(MotionEvent motionevent, int i)
    {
        return i != 0 ? -1 : 0;
    }

    public int b(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }

    public float c(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return motionevent.getX();
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }

    public float d(MotionEvent motionevent, int i)
    {
        if (i == 0)
        {
            return motionevent.getY();
        } else
        {
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }
    }
}
