// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextSwitcher;
import com.xiaomi.hm.view.GifView;

public class  extends Fragment
    implements android.widget.tructionBasePage
{

    protected byte mGifFirst[];
    protected GifView mGifView;
    protected TextSwitcher mTip;

    protected void initView(View view)
    {
        View view1 = view.findViewById(0x7f0a0039);
        if (view1 != null)
        {
            mGifView = (GifView)view1;
        }
        mTip = (TextSwitcher)view.findViewById(0x7f0a0038);
        mTip.setFactory(this);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(300L);
        AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation1.setDuration(300L);
        mTip.setInAnimation(alphaanimation);
        mTip.setOutAnimation(alphaanimation1);
    }

    public View makeView()
    {
        return LayoutInflater.from(getActivity()).inflate(0x7f030007, mTip, false);
    }

    public void onDestroy()
    {
        if (mGifView != null)
        {
            try
            {
                mGifView.destroy();
                mGifView = null;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        super.onDestroy();
    }

    public void onPageScrollIdle()
    {
        if (mGifView != null)
        {
            mGifView.restartGifAnimation();
        }
    }

    public void onPageScrolling()
    {
        if (mGifView != null)
        {
            mGifView.pauseGifAnimation();
        }
    }

    public ()
    {
    }
}
