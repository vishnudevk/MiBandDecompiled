// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.chart.util.ChartUtil;
import java.util.ArrayList;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            ah

public class DynamicListFragment extends Fragment
{

    private static final String a = "Dynamic.List";
    private ArrayList b;
    private ListView c;
    private ah d;

    public DynamicListFragment()
    {
    }

    static ArrayList a(DynamicListFragment dynamiclistfragment)
    {
        return dynamiclistfragment.b;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b = new ArrayList();
        DynamicItem dynamicitem = new DynamicItem();
        dynamicitem.title = "\u6B22\u8FCE\u4F7F\u7528\u5C0F\u7C73\u624B\u73AF";
        dynamicitem.summary = "\u70B9\u51FB\u67E5\u770B\u5982\u4F55\u73A9\u8F6C\u5C0F\u7C73\u624B\u73AF";
        dynamicitem.uri = Uri.parse("file:///android_asset/help.html");
        b.add(dynamicitem);
        DynamicItem dynamicitem1 = new DynamicItem();
        dynamicitem1.title = "\u6234\u4E0A\u5C0F\u7C73\u624B\u73AF\u51FA\u53BB\u8D70\u4E00\u8D70\u5427\uFF01";
        dynamicitem1.summary = "\u8BA9\u5C0F\u7C73\u624B\u73AF\u5B9E\u65F6\u8BB0\u5F55\u4F60\u7684\u8FD0\u52A8\u4FE1\u606F\uFF0C\u505A\u4F60\u7684\u5065\u5EB7\u52A9\u624B";
        b.add(dynamicitem1);
        d = new ah(this, null);
        c.setAdapter(d);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030029, viewgroup, false);
        c = (ListView)view;
        View view1 = new View(getActivity());
        view1.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, (int)(390F * ChartUtil.getDensity(getActivity()))));
        view1.setTag("MarginView");
        c.addHeaderView(view1, null, false);
        return view;
    }

    private class DynamicItem
    {

        public String action;
        public String summary;
        public String title;
        public Uri uri;

        public DynamicItem()
        {
        }
    }

}
