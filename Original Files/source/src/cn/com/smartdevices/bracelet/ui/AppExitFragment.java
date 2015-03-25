// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import cn.com.smartdevices.bracelet.BraceletApp;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment

public class AppExitFragment extends DimPanelFragment
{

    public AppExitFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f03001f;
    }

    protected void onRightButtomClicked()
    {
        ((BraceletApp)getActivity().getApplication()).finishBLEService();
        System.exit(0);
    }
}
