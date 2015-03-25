// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SearchSingleBraceletActivity, bu

class bv extends BaseAdapter
{

    final SearchSingleBraceletActivity a;

    bv(SearchSingleBraceletActivity searchsinglebraceletactivity)
    {
        a = searchsinglebraceletactivity;
        super();
    }

    public int getCount()
    {
        return SearchSingleBraceletActivity.a(a).size();
    }

    public Object getItem(int i)
    {
        return Integer.valueOf(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = LayoutInflater.from(SearchSingleBraceletActivity.c(a)).inflate(0x7f03005b, null);
        bu bu1 = (bu)SearchSingleBraceletActivity.a(a).get(i);
        TextView textview = (TextView)view1.findViewById(0x7f0a019d);
        TextView textview1 = (TextView)view1.findViewById(0x7f0a019e);
        ((android.widget.LinearLayout.LayoutParams)view1.findViewById(0x7f0a019f).getLayoutParams()).rightMargin = 5 * -bu1.b;
        view1.invalidate();
        String s = bu1.a.getAddress();
        textview.setText(s.substring(s.length() - "MM:AA:CC".length(), s.length()));
        textview1.setText((new StringBuilder()).append("\u4FE1\u53F7\u5F3A\u5EA6\uFF1A").append(bu1.b).toString());
        return view1;
    }
}
