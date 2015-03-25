// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            aw, ax

public class HelpFragment extends Fragment
{

    private String a;
    private WebView b;
    private ProgressBar c;
    private WebViewClient d;
    private WebChromeClient e;

    public HelpFragment()
    {
        d = new aw(this);
        e = new ax(this);
    }

    static ProgressBar a(HelpFragment helpfragment)
    {
        return helpfragment.c;
    }

    public static HelpFragment newInstance()
    {
        HelpFragment helpfragment = new HelpFragment();
        helpfragment.setArguments(new Bundle());
        return helpfragment;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menu.clear();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f03002e, null);
        a = "http://ota.app-xae.xiaomi.net/help.html";
        b = (WebView)view.findViewById(0x7f0a0023);
        c = (ProgressBar)view.findViewById(0x7f0a00df);
        b.setWebViewClient(d);
        b.setWebChromeClient(e);
        b.loadUrl(a);
        setHasOptionsMenu(true);
        return view;
    }
}
