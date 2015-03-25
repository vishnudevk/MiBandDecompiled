// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nineoldandroids.animation;

import android.os.Handler;
import android.os.Message;
import android.view.animation.AnimationUtils;
import java.util.ArrayList;

// Referenced classes of package com.nineoldandroids.animation:
//            ValueAnimator

class H extends Handler
{

    private H()
    {
    }

    H(H h)
    {
        this();
    }

    public void handleMessage(Message message)
    {
        ArrayList arraylist;
        ArrayList arraylist1;
        arraylist = (ArrayList)ValueAnimator.b().get();
        arraylist1 = (ArrayList)ValueAnimator.c().get();
        message.what;
        JVM INSTR tableswitch 0 1: default 48
    //                   0 49
    //                   1 466;
           goto _L1 _L2 _L3
_L1:
        return;
_L2:
        boolean flag;
        ArrayList arraylist4 = (ArrayList)ValueAnimator.d().get();
        long l;
        ArrayList arraylist2;
        ArrayList arraylist3;
        int i;
        int j;
        ValueAnimator valueanimator;
        int k;
        int i1;
        int j1;
        ValueAnimator valueanimator1;
        int k1;
        int l1;
        ValueAnimator valueanimator2;
        ArrayList arraylist5;
        int i2;
        int j2;
        ValueAnimator valueanimator3;
        if (arraylist.size() > 0 || arraylist1.size() > 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
_L17:
        if (arraylist4.size() > 0) goto _L5; else goto _L4
_L4:
        l = AnimationUtils.currentAnimationTimeMillis();
        arraylist2 = (ArrayList)ValueAnimator.e().get();
        arraylist3 = (ArrayList)ValueAnimator.f().get();
        i = arraylist1.size();
        j = 0;
_L18:
        if (j < i) goto _L7; else goto _L6
_L6:
        k = arraylist2.size();
        if (k <= 0) goto _L9; else goto _L8
_L8:
        l1 = 0;
_L19:
        if (l1 < k) goto _L11; else goto _L10
_L10:
        arraylist2.clear();
_L9:
        i1 = arraylist.size();
        j1 = 0;
_L20:
        if (j1 < i1) goto _L13; else goto _L12
_L12:
        if (arraylist3.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        k1 = 0;
_L21:
        if (k1 < arraylist3.size()) goto _L15; else goto _L14
_L14:
        arraylist3.clear();
        if (!flag || arraylist.isEmpty() && arraylist1.isEmpty()) goto _L1; else goto _L16
_L16:
        sendEmptyMessageDelayed(1, Math.max(0L, ValueAnimator.g() - (AnimationUtils.currentAnimationTimeMillis() - l)));
        return;
_L5:
        arraylist5 = (ArrayList)arraylist4.clone();
        arraylist4.clear();
        i2 = arraylist5.size();
        j2 = 0;
        while (j2 < i2) 
        {
            valueanimator3 = (ValueAnimator)arraylist5.get(j2);
            if (ValueAnimator.a(valueanimator3) == 0L)
            {
                ValueAnimator.b(valueanimator3);
            } else
            {
                arraylist1.add(valueanimator3);
            }
            j2++;
        }
          goto _L17
_L7:
        valueanimator = (ValueAnimator)arraylist1.get(j);
        if (ValueAnimator.a(valueanimator, l))
        {
            arraylist2.add(valueanimator);
        }
        j++;
          goto _L18
_L11:
        valueanimator2 = (ValueAnimator)arraylist2.get(l1);
        ValueAnimator.b(valueanimator2);
        ValueAnimator.a(valueanimator2, true);
        arraylist1.remove(valueanimator2);
        l1++;
          goto _L19
_L13:
        valueanimator1 = (ValueAnimator)arraylist.get(j1);
        if (valueanimator1.a(l))
        {
            arraylist3.add(valueanimator1);
        }
        if (arraylist.size() == i1)
        {
            j1++;
        } else
        {
            i1--;
            arraylist3.remove(valueanimator1);
        }
          goto _L20
_L15:
        ValueAnimator.c((ValueAnimator)arraylist3.get(k1));
        k1++;
          goto _L21
_L3:
        flag = true;
          goto _L4
    }
}
