// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.hardware.display;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

// Referenced classes of package android.support.v4.hardware.display:
//            DisplayManagerCompat

class b extends DisplayManagerCompat
{

    private final WindowManager a;

    public b(Context context)
    {
        a = (WindowManager)context.getSystemService("window");
    }

    public Display getDisplay(int i)
    {
        Display display = a.getDefaultDisplay();
        if (display.getDisplayId() == i)
        {
            return display;
        } else
        {
            return null;
        }
    }

    public Display[] getDisplays()
    {
        Display adisplay[] = new Display[1];
        adisplay[0] = a.getDefaultDisplay();
        return adisplay;
    }

    public Display[] getDisplays(String s)
    {
        if (s == null)
        {
            return getDisplays();
        } else
        {
            return new Display[0];
        }
    }
}
