// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.database.Cursor;

interface e
{

    public abstract void changeCursor(Cursor cursor);

    public abstract CharSequence convertToString(Cursor cursor);

    public abstract Cursor getCursor();

    public abstract Cursor runQueryOnBackgroundThread(CharSequence charsequence);
}
