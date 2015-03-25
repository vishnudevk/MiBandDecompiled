// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class PersonPageUserInfoView extends FrameLayout
{

    private static final String a = "PersonPageUserInfoView";
    private LayoutInflater b;
    private String c;

    public PersonPageUserInfoView(Context context)
    {
        super(context);
        b = LayoutInflater.from(context);
        b.inflate(0x7f030055, this);
    }

    public PersonPageUserInfoView(Context context, AttributeSet attributeset)
    {
        super(context);
    }

    public PersonPageUserInfoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }
}
