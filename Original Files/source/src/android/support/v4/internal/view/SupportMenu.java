// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.internal.view;

import android.view.Menu;

public interface SupportMenu
    extends Menu
{

    public static final int CATEGORY_MASK = 0xffff0000;
    public static final int CATEGORY_SHIFT = 16;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT;
}
