// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.internal.view;

import android.support.v4.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

public interface SupportMenuItem
    extends MenuItem
{

    public static final int SHOW_AS_ACTION_ALWAYS = 2;
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;
    public static final int SHOW_AS_ACTION_NEVER = 0;
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;

    public abstract boolean collapseActionView();

    public abstract boolean expandActionView();

    public abstract View getActionView();

    public abstract ActionProvider getSupportActionProvider();

    public abstract boolean isActionViewExpanded();

    public abstract MenuItem setActionView(int i);

    public abstract MenuItem setActionView(View view);

    public abstract void setShowAsAction(int i);

    public abstract MenuItem setShowAsActionFlags(int i);

    public abstract SupportMenuItem setSupportActionProvider(ActionProvider actionprovider);

    public abstract SupportMenuItem setSupportOnActionExpandListener(android.support.v4.view.MenuItemCompat.OnActionExpandListener onactionexpandlistener);
}
