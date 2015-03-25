// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import android.widget.Toast;

// Referenced classes of package com.tencent.open:
//            TaskGuide

class r
    implements Runnable
{

    final String a;
    final TaskGuide b;

    r(TaskGuide taskguide, String s)
    {
        b = taskguide;
        a = s;
        super();
    }

    public void run()
    {
        Toast.makeText(TaskGuide.z(b), (new StringBuilder()).append("\u5931\u8D25\uFF1A").append(a).toString(), 1).show();
    }
}
