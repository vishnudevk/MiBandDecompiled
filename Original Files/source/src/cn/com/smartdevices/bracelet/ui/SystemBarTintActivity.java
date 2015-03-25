// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            SystemBarTintManager, cj

public class SystemBarTintActivity extends Activity
{

    private View mContentView;
    private boolean mDisableStatusBarTintAuto;
    private SystemBarTintManager mSystemBarTintManager;

    public SystemBarTintActivity()
    {
    }

    public static boolean isNotSupport(Context context)
    {
        return android.os.Build.VERSION.SDK_INT < 19 || TextUtils.isEmpty(Utils.getMiuiVersionName(context));
    }

    public void applyStatusBarTint(int i)
    {
        if (isNotSupport(this))
        {
            return;
        } else
        {
            mSystemBarTintManager.setTintColor(i);
            return;
        }
    }

    public void applyStatusBarTintAuto()
    {
        if (isNotSupport(this) || mContentView == null)
        {
            return;
        } else
        {
            mContentView.post(new cj(this));
            return;
        }
    }

    public void applyStatusBarTintRes(int i)
    {
        if (isNotSupport(this))
        {
            return;
        } else
        {
            mSystemBarTintManager.setTintResource(i);
            return;
        }
    }

    public void configStatusBarTint()
    {
        if (isNotSupport(this))
        {
            return;
        } else
        {
            mSystemBarTintManager = new SystemBarTintManager(this);
            mSystemBarTintManager.setStatusBarTintEnabled(true);
            mContentView = (ViewGroup)findViewById(0x1020002);
            return;
        }
    }

    public void disableAutoApplyStatusBarTint()
    {
        mDisableStatusBarTintAuto = true;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (!isNotSupport(this))
        {
            setTheme(0x7f0e0018);
        }
        configStatusBarTint();
        applyStatusBarTintAuto();
    }



}
