// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;

class e
{

    e()
    {
    }

    public static boolean a(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getCanRetrieveWindowContent();
    }

    public static String b(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getDescription();
    }

    public static String c(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getId();
    }

    public static ResolveInfo d(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getResolveInfo();
    }

    public static String e(AccessibilityServiceInfo accessibilityserviceinfo)
    {
        return accessibilityserviceinfo.getSettingsActivityName();
    }
}
