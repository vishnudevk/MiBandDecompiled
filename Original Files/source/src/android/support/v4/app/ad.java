// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.text.Html;

class ad
{

    ad()
    {
    }

    public static String a(CharSequence charsequence)
    {
        return Html.escapeHtml(charsequence);
    }
}
