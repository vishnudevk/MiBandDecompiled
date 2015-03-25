// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.chart.typeface;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

// Referenced classes of package cn.com.smartdevices.bracelet.chart.typeface:
//            TypefaceManager

public class TypefaceTextView extends TextView
{

    public TypefaceTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TypefaceManager.getInstance().applyTypeface(this, context, attributeset);
    }

    public void setTextStyle(TypefaceManager.TextStyle textstyle)
    {
        TypefaceManager.getInstance().applyTypeface(this, textstyle);
    }
}
