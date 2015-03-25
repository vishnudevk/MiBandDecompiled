// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class ActionProvider
{

    private static final String a = "ActionProvider(support)";
    private final Context b;
    private SubUiVisibilityListener c;
    private VisibilityListener d;

    public ActionProvider(Context context)
    {
        b = context;
    }

    public Context getContext()
    {
        return b;
    }

    public boolean hasSubMenu()
    {
        return false;
    }

    public boolean isVisible()
    {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuitem)
    {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction()
    {
        return false;
    }

    public void onPrepareSubMenu(SubMenu submenu)
    {
    }

    public boolean overridesItemVisibility()
    {
        return false;
    }

    public void refreshVisibility()
    {
        if (d != null && overridesItemVisibility())
        {
            d.onActionProviderVisibilityChanged(isVisible());
        }
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subuivisibilitylistener)
    {
        c = subuivisibilitylistener;
    }

    public void setVisibilityListener(VisibilityListener visibilitylistener)
    {
        if (d != null && visibilitylistener != null)
        {
            Log.w("ActionProvider(support)", (new StringBuilder()).append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?").toString());
        }
        d = visibilitylistener;
    }

    public void subUiVisibilityChanged(boolean flag)
    {
        if (c != null)
        {
            c.onSubUiVisibilityChanged(flag);
        }
    }

    private class VisibilityListener
    {

        public abstract void onActionProviderVisibilityChanged(boolean flag);
    }


    private class SubUiVisibilityListener
    {

        public abstract void onSubUiVisibilityChanged(boolean flag);
    }

}
