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
import com.xiaomi.hm.view.GifListener;
import com.xiaomi.hm.view.GifView;
import java.io.IOException;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            aA, InstructionActivity

public class ge extends ge
    implements GifListener
{

    private static int a = 4;
    private int b;

    static int a(ge ge)
    {
        return ge.b;
    }

    static int a(b b1, int i)
    {
        b1.b = i;
        return i;
    }

    public void frameCount(int i)
    {
    }

    public void gifEnd(int i)
    {
        if (i < a)
        {
            return;
        } else
        {
            mGifView.post(new aA(this, null));
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Debug.i("DDDD", "Load Gif!!");
        java.io.InputStream inputstream = getResources().openRawResource(0x7f02007e);
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
        mTip.setCurrentText(getString(0x7f0d00d3));
        mGifView.setGifImageType(GifImageType.COVER);
        mGifView.setLoopNumber(a);
        mGifView.setListener(this, 1);
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
            mTip.setCurrentText(getString(0x7f0d00d3));
            mGifView.setGifImage(mGifFirst);
            b = 1;
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
