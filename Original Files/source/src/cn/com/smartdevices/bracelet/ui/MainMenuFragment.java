// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Blur;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;

// Referenced classes of package cn.com.smartdevices.bracelet.ui:
//            aD, aE, SettingAboutActivity, SettingActivity, 
//            PersonInfoActivity, AlarmActivity, UnlockScreenHelperActivity, MainUIActivity, 
//            SystemBarTintActivity, aB, SystemBarTintManager, aC

public class MainMenuFragment extends DialogFragment
    implements android.view.View.OnClickListener
{

    private static final String a = "MainMenuFragment";
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private ImageButton i;
    private Bitmap j;
    private Bitmap k;
    private View l;
    private View m;
    private boolean n;
    private ImageView o;
    private View p;
    private MenuListener q;

    public MainMenuFragment()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = false;
        o = null;
        p = null;
        q = null;
    }

    private Animation a(int i1, long l1)
    {
        return a(l.findViewById(i1), 0x7f040009, l1, Boolean.valueOf(true));
    }

    private Animation a(View view, int i1, long l1, Boolean boolean1)
    {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), i1);
        animation.setStartOffset(l1);
        animation.setAnimationListener(new aD(this, boolean1, view));
        Object obj;
        if (!boolean1.booleanValue())
        {
            obj = new AccelerateInterpolator(3F);
        } else
        {
            obj = new DecelerateInterpolator(3F);
        }
        animation.setInterpolator(((android.view.animation.Interpolator) (obj)));
        return animation;
    }

    private void a()
    {
        if (!n)
        {
            n = true;
            Debug.i("MainMenuFragment", "in onMenuPredraw");
            int i1 = l.getWidth();
            int j1 = l.getHeight();
            Debug.i("MainMenuFragment", (new StringBuilder()).append("w=").append(i1).append(",h=").append(j1).toString());
            if (j != null && !j.isRecycled())
            {
                Debug.i("MainMenuFragment", (new StringBuilder()).append("myBackgroundImg w=").append(j.getWidth()).append(",myBackgroundImg h=").append(j.getHeight()).toString());
                Bitmap bitmap = Bitmap.createScaledBitmap(j, j.getWidth() / 10, j.getHeight() / 10, true);
                Debug.i("MainMenuFragment", (new StringBuilder()).append("scaleBmp w=").append(bitmap.getWidth()).append(",scaleBmp h=").append(bitmap.getHeight()).toString());
                Bitmap bitmap1 = Blur.fastblur(getActivity(), bitmap, 15);
                Debug.i("MainMenuFragment", (new StringBuilder()).append("outBmp w=").append(bitmap1.getWidth()).append(",outBmp h=").append(bitmap1.getHeight()).toString());
                bitmap.recycle();
                Bitmap bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getWidth(), (j1 * bitmap1.getWidth()) / i1);
                Debug.i("MainMenuFragment", (new StringBuilder()).append("cropBmp w=").append(bitmap2.getWidth()).append(",cropBmp h=").append(bitmap2.getHeight()).toString());
                bitmap1.recycle();
                k = Bitmap.createScaledBitmap(bitmap2, i1, j1, true);
                Debug.i("MainMenuFragment", (new StringBuilder()).append("myGaussianBlurImg w=").append(k.getWidth()).append(",myGaussianBlurImg h=").append(k.getHeight()).toString());
                bitmap2.recycle();
                BitmapDrawable bitmapdrawable = new BitmapDrawable(getResources(), k);
                o.setBackground(bitmapdrawable);
                Debug.i("MainMenuFragment", "out onMenuPredraw");
                return;
            }
        }
    }

    private void a(View view)
    {
        g = (TextView)view.findViewById(0x7f0a01fc);
        g.setOnClickListener(this);
        i = (ImageButton)view.findViewById(0x7f0a01f0);
        i.setOnClickListener(this);
        b = (TextView)view.findViewById(0x7f0a01f2);
        b.setOnClickListener(this);
        c = (TextView)view.findViewById(0x7f0a01f4);
        c.setOnClickListener(this);
        d = (TextView)view.findViewById(0x7f0a01f6);
        d.setOnClickListener(this);
        e = (TextView)view.findViewById(0x7f0a01f9);
        e.setOnClickListener(this);
        f = (TextView)view.findViewById(0x7f0a01fa);
        f.setOnClickListener(this);
        h = (LinearLayout)view.findViewById(0x7f0a01f8);
        if (!Utils.isSupportUnlockScreenByBracelet(getActivity()))
        {
            h.setVisibility(8);
        }
        o = (ImageView)view.findViewById(0x7f0a01ee);
        menuEnterAnimation();
    }

    static void a(MainMenuFragment mainmenufragment)
    {
        mainmenufragment.a();
    }

    private void b(int i1, long l1)
    {
        l.findViewById(i1).startAnimation(a(i1, l1));
    }

    private Animation c(int i1, long l1)
    {
        return a(l.findViewById(i1), 0x7f04000a, l1, Boolean.valueOf(false));
    }

    private void d(int i1, long l1)
    {
        l.findViewById(i1).startAnimation(c(i1, l1));
    }

    public void menuEnterAnimation()
    {
        Animation animation = a(o, 0x7f040009, 0L, Boolean.valueOf(true));
        o.startAnimation(animation);
        b(0x7f0a01fe, 0L);
        b(0x7f0a01fd, 0L);
        b(0x7f0a01fc, 0L);
        b(0x7f0a01fb, 0L);
        long l1 = 0L + 50L;
        b(0x7f0a01fa, l1);
        long l2 = l1 + 50L;
        b(0x7f0a01f7, l2);
        long l3 = l2 + 50L;
        b(0x7f0a01f6, l3);
        long l4 = l3 + 50L;
        b(0x7f0a01f5, l4);
        long l5 = l4 + 50L;
        b(0x7f0a01f4, l5);
        long l6 = l5 + 50L;
        b(0x7f0a01f3, l6);
        long l7 = l6 + 50L;
        b(0x7f0a01f2, l7);
        long l8 = l7 + 50L;
        b(0x7f0a01f1, l8);
        b(0x7f0a01f0, l8 + 50L);
    }

    public void menuExitAnimation()
    {
        d(0x7f0a01f0, 0L);
        long l1 = 0L + 50L;
        d(0x7f0a01f1, l1);
        long l2 = l1 + 50L;
        d(0x7f0a01f2, l2);
        long l3 = l2 + 50L;
        d(0x7f0a01f3, l3);
        long l4 = l3 + 50L;
        d(0x7f0a01f4, l4);
        long l5 = l4 + 50L;
        d(0x7f0a01f5, l5);
        long l6 = l5 + 50L;
        View view = getView().findViewById(0x7f0a01f6);
        Animation animation = a(view, 0x7f04000a, l6, Boolean.valueOf(false));
        animation.setAnimationListener(new aE(this));
        view.startAnimation(animation);
        long l7 = l6 + 50L;
        d(0x7f0a01f7, l7);
        long l8 = l7 + 50L;
        d(0x7f0a01fa, l8);
        long l9 = l8 + 50L;
        d(0x7f0a01fb, l9);
        long l10 = l9 + 50L;
        d(0x7f0a01fc, l10);
        d(0x7f0a01fd, l10);
        d(0x7f0a01fe, l10);
        Animation animation1 = a(o, 0x7f04000a, l10, Boolean.valueOf(false));
        o.startAnimation(animation1);
    }

    public void onClick(View view)
    {
        Intent intent;
        int i1;
        String s;
        intent = new Intent();
        i1 = view.getId();
        s = null;
        i1;
        JVM INSTR tableswitch 2131362288 2131362300: default 84
    //                   2131362288 129
    //                   2131362289 84
    //                   2131362290 139
    //                   2131362291 84
    //                   2131362292 203
    //                   2131362293 84
    //                   2131362294 171
    //                   2131362295 84
    //                   2131362296 84
    //                   2131362297 235
    //                   2131362298 265
    //                   2131362299 84
    //                   2131362300 97;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L5 _L1 _L1 _L6 _L7 _L1 _L8
_L1:
        UmengAnalytics.event(getActivity(), "ClickMainMenuItem", s);
_L10:
        return;
_L8:
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/SettingAboutActivity);
        getActivity().startActivity(intent);
        dismiss();
        s = "MenuAbout";
        continue; /* Loop/switch isn't completed */
_L2:
        menuExitAnimation();
        s = null;
        continue; /* Loop/switch isn't completed */
_L3:
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/SettingActivity);
        getActivity().startActivity(intent);
        dismiss();
        s = "MenuBracelet";
        continue; /* Loop/switch isn't completed */
_L5:
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/PersonInfoActivity);
        getActivity().startActivity(intent);
        dismiss();
        s = "MenuPerson";
        continue; /* Loop/switch isn't completed */
_L4:
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/AlarmActivity);
        getActivity().startActivity(intent);
        dismiss();
        s = "MenuAlarm";
        continue; /* Loop/switch isn't completed */
_L6:
        intent.setClass(getActivity(), cn/com/smartdevices/bracelet/ui/UnlockScreenHelperActivity);
        getActivity().startActivity(intent);
        dismiss();
        s = null;
        continue; /* Loop/switch isn't completed */
_L7:
        MainUIActivity mainuiactivity = (MainUIActivity)getActivity();
        if (mainuiactivity == null) goto _L10; else goto _L9
_L9:
        mainuiactivity.shareTopHalf();
        dismiss();
        s = "MenuShare";
        if (true) goto _L1; else goto _L11
_L11:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        int i1 = 0x7f0e0014;
        if (!SystemBarTintActivity.isNotSupport(getActivity()))
        {
            i1 = 0x7f0e001a;
        }
        setStyle(0, i1);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030068, null);
        l = view.findViewById(0x7f0a01ef);
        m = view.findViewById(0x7f0a01ed);
        m.setVisibility(0);
        l.getViewTreeObserver().addOnPreDrawListener(new aB(this));
        if (!SystemBarTintActivity.isNotSupport(getActivity()))
        {
            SystemBarTintManager systembartintmanager = new SystemBarTintManager(getActivity());
            l.setPadding(0, systembartintmanager.getConfig().getPixelInsetTop(false), 0, 0);
        }
        a(view);
        getDialog().setCanceledOnTouchOutside(true);
        p = view.findViewById(0x7f0a00a3);
        if (p != null)
        {
            p.setOnClickListener(new aC(this));
        }
        return view;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (k != null)
        {
            k.recycle();
            k = null;
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (q != null)
        {
            q.onDismiss();
        }
    }

    public void setBackground(Bitmap bitmap)
    {
        j = bitmap;
    }

    public void setListener(MenuListener menulistener)
    {
        q = menulistener;
    }

    private class MenuListener
    {

        public abstract void onDismiss();
    }

}
