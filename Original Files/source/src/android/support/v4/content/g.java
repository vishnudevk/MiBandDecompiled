// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

// Referenced classes of package android.support.v4.content:
//            f

class g
    implements f
{

    g()
    {
    }

    public Intent a(ComponentName componentname)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setComponent(componentname);
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }

    public Intent a(String s, String s1)
    {
        Intent intent = new Intent(s);
        intent.addCategory(s1);
        return intent;
    }

    public Intent b(ComponentName componentname)
    {
        Intent intent = a(componentname);
        intent.addFlags(0x10008000);
        return intent;
    }
}
