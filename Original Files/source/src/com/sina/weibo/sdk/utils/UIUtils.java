// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

public class UIUtils
{

    public UIUtils()
    {
    }

    public static void showAlert(Context context, int i, int j)
    {
        if (context != null)
        {
            showAlert(context, context.getString(i), context.getString(j));
        }
    }

    public static void showAlert(Context context, String s, String s1)
    {
        if (context != null)
        {
            (new android.app.AlertDialog.Builder(context)).setTitle(s).setMessage(s1).create().show();
        }
    }

    public static void showToast(Context context, int i, int j)
    {
        if (context != null)
        {
            Toast.makeText(context, i, j).show();
        }
    }

    public static void showToast(Context context, CharSequence charsequence, int i)
    {
        if (context != null)
        {
            Toast.makeText(context, charsequence, i).show();
        }
    }

    public static void showToastInCenter(Context context, int i, int j)
    {
        if (context != null)
        {
            Toast toast = Toast.makeText(context, i, j);
            toast.setGravity(17, 0, 0);
            toast.show();
        }
    }
}
