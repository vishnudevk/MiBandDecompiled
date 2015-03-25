// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

// Referenced classes of package cn.com.smartdevices.bracelet.view:
//            RulerScrollView

public class HoriRulerView extends FrameLayout
{

    private static final String a = "HoriRulerView";
    private RulerScrollView b;
    private View c;
    private LayoutInflater d;
    private String e;
    private int f;
    private int g;

    public HoriRulerView(Context context)
    {
        super(context);
        f = 50;
        g = 80;
    }

    public HoriRulerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        f = 50;
        g = 80;
        d = LayoutInflater.from(context);
        d.inflate(0x7f030058, this);
        b = (RulerScrollView)findViewById(0x7f0a0196);
        c = findViewById(0x7f0a0197);
        b.setIndicatorView(c);
    }

    public HoriRulerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        f = 50;
        g = 80;
    }

    public void addView(View view)
    {
        b.addView(view);
    }

    public float getCurValue()
    {
        return b.getCurValue();
    }

    public int getScrollLeft()
    {
        return b.getScrollLeft();
    }

    public void initRuler(int i, int j, int k, String s)
    {
        f = i;
        g = j;
        e = s;
        for (; i < j; i += k)
        {
            View view = d.inflate(0x7f030059, null);
            ((TextView)view.findViewById(0x7f0a019b)).setText((new StringBuilder()).append("").append(i).toString());
            addView(view);
        }

        Debug.i("HoriRulerView", "initRuler");
        b.setStartEnd(f, g, s);
    }

    public void setScroll(int i)
    {
        b.setScroll(i);
    }
}
