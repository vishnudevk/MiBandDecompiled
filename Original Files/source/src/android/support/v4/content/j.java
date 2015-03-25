// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.ComponentName;
import android.content.Intent;

class j
{

    j()
    {
    }

    public static Intent a(ComponentName componentname)
    {
        return Intent.makeMainActivity(componentname);
    }

    public static Intent b(ComponentName componentname)
    {
        return Intent.makeRestartActivityTask(componentname);
    }
}
