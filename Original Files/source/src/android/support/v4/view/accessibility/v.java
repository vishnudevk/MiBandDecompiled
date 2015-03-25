// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v4.view.accessibility:
//            z, AccessibilityNodeProviderCompat, AccessibilityNodeInfoCompat, u

class v
    implements z
{

    final AccessibilityNodeProviderCompat a;
    final u b;

    v(u u, AccessibilityNodeProviderCompat accessibilitynodeprovidercompat)
    {
        b = u;
        a = accessibilitynodeprovidercompat;
        super();
    }

    public Object a(int i)
    {
        AccessibilityNodeInfoCompat accessibilitynodeinfocompat = a.createAccessibilityNodeInfo(i);
        if (accessibilitynodeinfocompat == null)
        {
            return null;
        } else
        {
            return accessibilitynodeinfocompat.getInfo();
        }
    }

    public List a(String s, int i)
    {
        List list = a.findAccessibilityNodeInfosByText(s, i);
        ArrayList arraylist = new ArrayList();
        int j = list.size();
        for (int k = 0; k < j; k++)
        {
            arraylist.add(((AccessibilityNodeInfoCompat)list.get(k)).getInfo());
        }

        return arraylist;
    }

    public boolean a(int i, int j, Bundle bundle)
    {
        return a.performAction(i, j, bundle);
    }
}
