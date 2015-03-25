// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

class c
{

    c()
    {
    }

    public static void a(Context context, Intent aintent[], Bundle bundle)
    {
        context.startActivities(aintent, bundle);
    }
}
