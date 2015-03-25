// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            u, w, t, AccessibilityNodeInfoCompat

public class AccessibilityNodeProviderCompat
{

    private static final t a;
    private final Object b;

    public AccessibilityNodeProviderCompat()
    {
        b = a.a(this);
    }

    public AccessibilityNodeProviderCompat(Object obj)
    {
        b = obj;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i)
    {
        return null;
    }

    public List findAccessibilityNodeInfosByText(String s, int i)
    {
        return null;
    }

    public Object getProvider()
    {
        return b;
    }

    public boolean performAction(int i, int j, Bundle bundle)
    {
        return false;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            a = new u();
        } else
        {
            a = new w();
        }
    }
}
