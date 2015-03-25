// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast extends Toast
{

    public CustomToast(Context context)
    {
        super(context);
    }

    public static Toast makeText(Context context, int i, int j)
    {
        return makeText(context, context.getString(i), j);
    }

    public static Toast makeText(Context context, String s, int i)
    {
        CustomToast customtoast = new CustomToast(context);
        View view = LayoutInflater.from(context).inflate(0x7f03001b, null);
        ((TextView)(TextView)view.findViewById(0x7f0a009e)).setText(s);
        customtoast.setView(view);
        return customtoast;
    }
}
