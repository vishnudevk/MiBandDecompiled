// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.MenuItem;

// Referenced classes of package android.support.v4.app:
//            Z, ac

class aa extends Z
{

    aa()
    {
    }

    public void a(MenuItem menuitem, ShareCompat.IntentBuilder intentbuilder)
    {
        ac.a(menuitem, intentbuilder.a(), intentbuilder.getIntent());
        if (a(menuitem))
        {
            menuitem.setIntent(intentbuilder.createChooserIntent());
        }
    }

    boolean a(MenuItem menuitem)
    {
        return !menuitem.hasSubMenu();
    }
}
