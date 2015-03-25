// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

// Referenced classes of package android.support.v4.app:
//            Fragment, FragmentManager, FragmentTransaction, FragmentActivity

public class DialogFragment extends Fragment
    implements android.content.DialogInterface.OnCancelListener, android.content.DialogInterface.OnDismissListener
{

    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    private static final String ae = "android:savedDialogState";
    private static final String af = "android:style";
    private static final String ag = "android:theme";
    private static final String ah = "android:cancelable";
    private static final String ai = "android:showsDialog";
    private static final String aj = "android:backStackId";
    int a;
    int b;
    boolean c;
    boolean d;
    int e;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    public DialogFragment()
    {
        a = 0;
        b = 0;
        c = true;
        d = true;
        e = -1;
    }

    void a(boolean flag)
    {
        if (h)
        {
            return;
        }
        h = true;
        i = false;
        if (f != null)
        {
            f.dismiss();
            f = null;
        }
        g = true;
        if (e >= 0)
        {
            getFragmentManager().popBackStack(e, 1);
            e = -1;
            return;
        }
        FragmentTransaction fragmenttransaction = getFragmentManager().beginTransaction();
        fragmenttransaction.remove(this);
        if (flag)
        {
            fragmenttransaction.commitAllowingStateLoss();
            return;
        } else
        {
            fragmenttransaction.commit();
            return;
        }
    }

    public void dismiss()
    {
        a(false);
    }

    public void dismissAllowingStateLoss()
    {
        a(true);
    }

    public Dialog getDialog()
    {
        return f;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle)
    {
        if (!d)
        {
            return super.getLayoutInflater(bundle);
        }
        f = onCreateDialog(bundle);
        a;
        JVM INSTR tableswitch 1 3: default 52
    //                   1 87
    //                   2 87
    //                   3 75;
           goto _L1 _L2 _L2 _L3
_L1:
        if (f != null)
        {
            return (LayoutInflater)f.getContext().getSystemService("layout_inflater");
        } else
        {
            return (LayoutInflater)I.getSystemService("layout_inflater");
        }
_L3:
        f.getWindow().addFlags(24);
_L2:
        f.requestWindowFeature(1);
          goto _L1
    }

    public boolean getShowsDialog()
    {
        return d;
    }

    public int getTheme()
    {
        return b;
    }

    public boolean isCancelable()
    {
        return c;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (d)
        {
            View view = getView();
            if (view != null)
            {
                if (view.getParent() != null)
                {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                f.setContentView(view);
            }
            f.setOwnerActivity(getActivity());
            f.setCancelable(c);
            f.setOnCancelListener(this);
            f.setOnDismissListener(this);
            if (bundle != null)
            {
                Bundle bundle1 = bundle.getBundle("android:savedDialogState");
                if (bundle1 != null)
                {
                    f.onRestoreInstanceState(bundle1);
                    return;
                }
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!i)
        {
            h = false;
        }
    }

    public void onCancel(DialogInterface dialoginterface)
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (M == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
        if (bundle != null)
        {
            a = bundle.getInt("android:style", 0);
            b = bundle.getInt("android:theme", 0);
            c = bundle.getBoolean("android:cancelable", true);
            d = bundle.getBoolean("android:showsDialog", d);
            e = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        return new Dialog(getActivity(), getTheme());
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        if (f != null)
        {
            g = true;
            f.dismiss();
            f = null;
        }
    }

    public void onDetach()
    {
        super.onDetach();
        if (!i && !h)
        {
            h = true;
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        if (!g)
        {
            a(true);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (f != null)
        {
            Bundle bundle1 = f.onSaveInstanceState();
            if (bundle1 != null)
            {
                bundle.putBundle("android:savedDialogState", bundle1);
            }
        }
        if (a != 0)
        {
            bundle.putInt("android:style", a);
        }
        if (b != 0)
        {
            bundle.putInt("android:theme", b);
        }
        if (!c)
        {
            bundle.putBoolean("android:cancelable", c);
        }
        if (!d)
        {
            bundle.putBoolean("android:showsDialog", d);
        }
        if (e != -1)
        {
            bundle.putInt("android:backStackId", e);
        }
    }

    public void onStart()
    {
        super.onStart();
        if (f != null)
        {
            g = false;
            f.show();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (f != null)
        {
            f.hide();
        }
    }

    public void setCancelable(boolean flag)
    {
        c = flag;
        if (f != null)
        {
            f.setCancelable(flag);
        }
    }

    public void setShowsDialog(boolean flag)
    {
        d = flag;
    }

    public void setStyle(int j, int k)
    {
        a = j;
        if (a == 2 || a == 3)
        {
            b = 0x1030059;
        }
        if (k != 0)
        {
            b = k;
        }
    }

    public int show(FragmentTransaction fragmenttransaction, String s)
    {
        h = false;
        i = true;
        fragmenttransaction.add(this, s);
        g = false;
        e = fragmenttransaction.commit();
        return e;
    }

    public void show(FragmentManager fragmentmanager, String s)
    {
        h = false;
        i = true;
        FragmentTransaction fragmenttransaction = fragmentmanager.beginTransaction();
        fragmenttransaction.add(this, s);
        fragmenttransaction.commit();
    }
}
