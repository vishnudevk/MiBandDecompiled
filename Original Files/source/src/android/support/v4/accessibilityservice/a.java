// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

// Referenced classes of package android.support.v4.accessibilityservice:
//            c, e

class a extends c
{

    a()
    {
    }

    public boolean a(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return android.support.v4.accessibilityservice.e.a(accessibilityserviceinfo);
    }

    public String b(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return android.support.v4.accessibilityservice.e.b(accessibilityserviceinfo);
    }

    public String c(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return android.support.v4.accessibilityservice.e.c(accessibilityserviceinfo);
    }

    public ResolveInfo d(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return android.support.v4.accessibilityservice.e.d(accessibilityserviceinfo);
    }

    public String e(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return android.support.v4.accessibilityservice.e.e(accessibilityserviceinfo);
    }

    public int f(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return !a(accessibilityserviceinfo) ? 0 : 1;
    }
}
