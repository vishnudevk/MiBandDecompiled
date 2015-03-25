// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package cn.com.smartdevices.bracelet.lua:
//            f, g, e

public class LuaListAdapterFake extends BaseAdapter
{

    private Animation animB2T;
    private Animation animT2B;
    private List infoList;
    private Context mContext;
    private int newItemCount;
    private TranslateAnimation taBlow;
    private TranslateAnimation taLeft;
    private TranslateAnimation taRight;
    private TranslateAnimation taTop;

    public LuaListAdapterFake(Context context)
    {
        mContext = null;
        infoList = new ArrayList();
        newItemCount = 0;
        mContext = context;
        InitAnim();
    }

    private void InitAnim()
    {
        taLeft = new TranslateAnimation(2, 1.0F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        taRight = new TranslateAnimation(2, -1F, 2, 0.0F, 2, 0.0F, 2, 0.0F);
        taTop = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, 1.0F, 2, 0.0F);
        taBlow = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1F, 2, 0.0F);
        taLeft.setDuration(1000L);
        taRight.setDuration(1000L);
        taTop.setDuration(1000L);
        taBlow.setDuration(1000L);
    }

    private String getDate()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    public void add(String s, String s1)
    {
        f f1 = new f(this);
        f1.a = s;
        f1.b = s1;
        infoList.add(f1);
    }

    public int getCount()
    {
        if (infoList != null)
        {
            return infoList.size();
        } else
        {
            return 0;
        }
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getListSize()
    {
        if (infoList == null)
        {
            return 0;
        } else
        {
            return infoList.size();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        f f1 = (f)infoList.get(i);
        g g1 = new g(this);
        View view1 = LayoutInflater.from(mContext).inflate(0x7f030050, null);
        g1.a = (TextView)view1.findViewById(0x7f0a0165);
        g1.a.setTypeface(Typeface.DEFAULT, 1);
        g1.b = (TextView)view1.findViewById(0x7f0a0166);
        g1.b.setTypeface(Typeface.DEFAULT, 1);
        ((ImageView)view1.findViewById(0x7f0a0164)).setVisibility(8);
        view1.setOnTouchListener(new e(this));
        g1.a.setText("");
        g1.b.setText("");
        view1.setTag(g1);
        g1.a.setTag(f1);
        return view1;
    }

    public void setList(List list)
    {
        if (list != null)
        {
            notifyDataSetChanged();
        }
    }
}
