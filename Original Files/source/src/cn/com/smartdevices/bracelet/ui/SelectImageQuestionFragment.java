// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.UmengAnalytics;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            DimPanelFragment, CropImageActivity

public class SelectImageQuestionFragment extends DimPanelFragment
{

    public SelectImageQuestionFragment()
    {
    }

    protected int inflateLayout()
    {
        return 0x7f03003f;
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131362057 2131362058: default 28
    //                   2131362057 33
    //                   2131362058 56;
           goto _L1 _L2 _L3
_L1:
        dismiss();
        return;
_L2:
        Intent intent1 = new Intent("android.media.action.IMAGE_CAPTURE");
        getActivity().startActivityForResult(intent1, 18);
        continue; /* Loop/switch isn't completed */
_L3:
        Intent intent = new Intent(getActivity(), cn/com/smartdevices/bracelet/ui/CropImageActivity);
        getActivity().startActivityForResult(intent, 17);
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = super.onCreateView(layoutinflater, viewgroup, bundle);
        view.findViewById(0x7f0a0109).setOnClickListener(this);
        view.findViewById(0x7f0a010a).setOnClickListener(this);
        return view;
    }

    public void onPause()
    {
        super.onPause();
        UmengAnalytics.endPage("PagePersonInfoAvatarSelection");
    }

    public void onResume()
    {
        super.onResume();
        UmengAnalytics.startPage("PagePersonInfoAvatarSelection");
    }
}
