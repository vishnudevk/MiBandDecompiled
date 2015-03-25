// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.eventbus.Event12HourUpdate;
import cn.com.smartdevices.bracelet.eventbus.EventAmPmUpdate;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.adapters.WheelViewAdapter;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            bp

public class PickAdapter
    implements WheelViewAdapter
{

    public static final int MIDDLE_LARGE_NUM = 0x7fffff;
    public static final String STYLE_MI_UI = "miui";
    public static final String STYLE_NORMAL = "normal";
    private static final String a = "PickAdapter";
    private static final int b = 0xffffff;
    private float c;
    private float d;
    private float e;
    private int f;
    private float g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private WheelView o;
    private LayoutInflater p;
    private Context q;
    private int r;
    private int s;
    private String t;

    public PickAdapter(Context context, int i1, int j1, WheelView wheelview, int k1, int l1)
    {
        this(context, i1, j1, wheelview, k1, l1, false);
    }

    public PickAdapter(Context context, int i1, int j1, WheelView wheelview, int k1, int l1, int i2, 
            boolean flag, int j2, int k2, int l2, int i3)
    {
        this(context, i1, j1, wheelview, k1, l1, i2, flag, j2, k2, l2, i3, 1);
    }

    public PickAdapter(Context context, int i1, int j1, WheelView wheelview, int k1, int l1, int i2, 
            boolean flag, int j2, int k2, int l2, int i3, int j3)
    {
        h = 0;
        r = 1;
        q = context;
        n = i1;
        m = j1;
        o = wheelview;
        p = LayoutInflater.from(context);
        k = k1;
        l = l1;
        f = i2;
        j = flag;
        android.util.DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        g = TypedValue.applyDimension(1, j2, displaymetrics);
        c = TypedValue.applyDimension(1, k2, displaymetrics);
        d = TypedValue.applyDimension(1, l2, displaymetrics);
        e = TypedValue.applyDimension(1, i3, displaymetrics);
        setValueGap(j3);
        h = 1 + (m - n);
        i = h * (0x7fffff / h);
    }

    public PickAdapter(Context context, int i1, int j1, WheelView wheelview, int k1, int l1, boolean flag)
    {
        this(context, i1, j1, wheelview, k1, l1, 0x88999999, flag, 32, 11, 10, 9, 1);
    }

    public int getBASE_BUNDLE()
    {
        return h;
    }

    public View getEmptyItem(View view, ViewGroup viewgroup)
    {
        return null;
    }

    public int getInitLoopBase()
    {
        return i;
    }

    public View getItem(int i1, View view, ViewGroup viewgroup)
    {
        RelativeLayout relativelayout = (RelativeLayout)view;
        int j1 = i1 % h;
        RelativeLayout relativelayout1;
        TextView textview;
        int k1;
        int l1;
        Object aobj1[];
        int i2;
        int j2;
        int k2;
        Object aobj2[];
        if (relativelayout == null)
        {
            Object aobj[];
            bp bp1;
            if ("normal".equals(t))
            {
                relativelayout1 = (RelativeLayout)p.inflate(0x7f03006c, null);
            } else
            {
                relativelayout1 = (RelativeLayout)p.inflate(0x7f03006b, null);
            }
            bp1 = new bp(this, null);
            bp1.a = (TextView)relativelayout1.findViewById(0x7f0a0202);
            bp1.a.getLayoutParams().height = (int)g;
            relativelayout1.setTag(bp1);
        } else
        {
            relativelayout1 = relativelayout;
        }
        textview = ((bp)relativelayout1.getTag()).a;
        aobj = new Object[1];
        aobj[0] = Integer.valueOf((j1 + n) * r);
        textview.setText(String.format("%02d", aobj));
        k1 = o.getRealCurrentItem();
        Debug.i("PickAdapter", (new StringBuilder()).append("realCurIndex =").append(k1).append(", pos=").append(j1).toString());
        s;
        JVM INSTR lookupswitch 3: default 228
    //                   9: 428
    //                   16: 339
    //                   17: 279;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_428;
_L5:
        i2 = (int)c;
        if (i1 == k1)
        {
            textview.setTextColor(k);
        } else
        if (i1 == k1 - 1 || i1 == k1 + 1)
        {
            i2 = (int)d;
            textview.setTextColor(l);
        } else
        {
            i2 = (int)e;
            textview.setTextColor(f);
        }
        textview.setTextSize(i2);
        return relativelayout1;
_L4:
        if (j1 == 0)
        {
            textview.setText(q.getString(0x7f0d0015));
        } else
        {
            textview.setText(q.getString(0x7f0d012a));
        }
        if (i1 == k1)
        {
            EventBus.getDefault().post(new EventAmPmUpdate(j1));
        }
          goto _L5
_L3:
        j2 = j1 + n;
        if (j2 == 0)
        {
            textview.setText("12");
        } else
        if (j2 > 12)
        {
            k2 = j2 - 12;
            aobj2 = new Object[1];
            aobj2[0] = Integer.valueOf(k2);
            textview.setText(String.format("%02d", aobj2));
        }
        if (k1 == i1)
        {
            EventBus.getDefault().post(new Event12HourUpdate(j2));
        }
          goto _L5
        l1 = j1 + n;
        if (l1 < 0)
        {
            l1 += 24;
        }
        aobj1 = new Object[1];
        aobj1[0] = Integer.valueOf(l1);
        textview.setText(String.format("%02d", aobj1));
          goto _L5
    }

    public int getItemsCount()
    {
        if (j)
        {
            return 0xffffff;
        } else
        {
            return h;
        }
    }

    public boolean isNeedLoop()
    {
        return j;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
    }

    public void setMode(int i1)
    {
        s = i1;
    }

    public void setUIStyle(String s1)
    {
        t = s1;
    }

    public void setValueGap(int i1)
    {
        r = i1;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
    }
}
