// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.view.GifImageType;
import com.xiaomi.hm.view.GifView;
import java.io.IOException;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            InstructionActivity

public class ge extends ge
{

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.i("DDDD", "Load Gif!!");
        java.io.InputStream inputstream = getResources().openRawResource(0x7f020083);
        try
        {
            mGifFirst = InstructionActivity.a(inputstream);
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030006, viewgroup, false);
        initView(view);
        mTip.setCurrentText(getString(0x7f0d00d8));
        mGifView.setGifImageType(GifImageType.COVER);
        mGifView.setLoopAnimation();
        return view;
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (mGifView == null)
        {
            return;
        }
        if (flag)
        {
            mGifView.setGifImage(mGifFirst);
            return;
        } else
        {
            mGifView.pauseGifAnimation();
            return;
        }
    }

    public ge()
    {
    }
}
