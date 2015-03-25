// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

// Referenced classes of package android.support.v4.app:
//            q, v, r, J, 
//            t, Fragment, s, h, 
//            u, FragmentManager, LoaderManager

public class FragmentActivity extends Activity
{

    static final String a = "android:support:fragments";
    static final int b = 1;
    static final int c = 2;
    private static final String q = "FragmentActivity";
    private static final int r = 11;
    final Handler d = new q(this);
    final v e = new v();
    final u f = new r(this);
    boolean g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    boolean n;
    HashMap o;
    J p;

    public FragmentActivity()
    {
    }

    private static String a(View view)
    {
        char c1;
        char c2;
        StringBuilder stringbuilder;
        c1 = 'F';
        c2 = '.';
        stringbuilder = new StringBuilder(128);
        stringbuilder.append(view.getClass().getName());
        stringbuilder.append('{');
        stringbuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringbuilder.append(' ');
        view.getVisibility();
        JVM INSTR lookupswitch 3: default 92
    //                   0: 497
    //                   4: 507
    //                   8: 517;
           goto _L1 _L2 _L3 _L4
_L1:
        stringbuilder.append(c2);
_L11:
        String s1;
        char c3;
        char c4;
        char c5;
        char c6;
        char c7;
        char c8;
        char c9;
        char c10;
        int i1;
        Resources resources;
        String s2;
        String s3;
        if (view.isFocusable())
        {
            c3 = c1;
        } else
        {
            c3 = c2;
        }
        stringbuilder.append(c3);
        if (view.isEnabled())
        {
            c4 = 'E';
        } else
        {
            c4 = c2;
        }
        stringbuilder.append(c4);
        if (view.willNotDraw())
        {
            c5 = c2;
        } else
        {
            c5 = 'D';
        }
        stringbuilder.append(c5);
        if (view.isHorizontalScrollBarEnabled())
        {
            c6 = 'H';
        } else
        {
            c6 = c2;
        }
        stringbuilder.append(c6);
        if (view.isVerticalScrollBarEnabled())
        {
            c7 = 'V';
        } else
        {
            c7 = c2;
        }
        stringbuilder.append(c7);
        if (view.isClickable())
        {
            c8 = 'C';
        } else
        {
            c8 = c2;
        }
        stringbuilder.append(c8);
        if (view.isLongClickable())
        {
            c9 = 'L';
        } else
        {
            c9 = c2;
        }
        stringbuilder.append(c9);
        stringbuilder.append(' ');
        if (!view.isFocused())
        {
            c1 = c2;
        }
        stringbuilder.append(c1);
        if (view.isSelected())
        {
            c10 = 'S';
        } else
        {
            c10 = c2;
        }
        stringbuilder.append(c10);
        if (view.isPressed())
        {
            c2 = 'P';
        }
        stringbuilder.append(c2);
        stringbuilder.append(' ');
        stringbuilder.append(view.getLeft());
        stringbuilder.append(',');
        stringbuilder.append(view.getTop());
        stringbuilder.append('-');
        stringbuilder.append(view.getRight());
        stringbuilder.append(',');
        stringbuilder.append(view.getBottom());
        i1 = view.getId();
        if (i1 == -1) goto _L6; else goto _L5
_L5:
        stringbuilder.append(" #");
        stringbuilder.append(Integer.toHexString(i1));
        resources = view.getResources();
        if (i1 == 0 || resources == null) goto _L6; else goto _L7
_L7:
        0xff000000 & i1;
        JVM INSTR lookupswitch 2: default 416
    //                   16777216: 588
    //                   2130706432: 581;
           goto _L8 _L9 _L10
_L8:
        s1 = resources.getResourcePackageName(i1);
_L12:
        s2 = resources.getResourceTypeName(i1);
        s3 = resources.getResourceEntryName(i1);
        stringbuilder.append(" ");
        stringbuilder.append(s1);
        stringbuilder.append(":");
        stringbuilder.append(s2);
        stringbuilder.append("/");
        stringbuilder.append(s3);
_L6:
        stringbuilder.append("}");
        return stringbuilder.toString();
_L2:
        stringbuilder.append('V');
          goto _L11
_L3:
        stringbuilder.append('I');
          goto _L11
_L4:
        stringbuilder.append('G');
          goto _L11
_L10:
        s1 = "app";
          goto _L12
_L9:
        s1 = "android";
          goto _L12
        android.content.res.Resources.NotFoundException notfoundexception;
        notfoundexception;
          goto _L6
    }

    private void a(String s1, PrintWriter printwriter, View view)
    {
        printwriter.print(s1);
        if (view != null) goto _L2; else goto _L1
_L1:
        printwriter.println("null");
_L4:
        return;
_L2:
        printwriter.println(a(view));
        if (view instanceof ViewGroup)
        {
            ViewGroup viewgroup = (ViewGroup)view;
            int i1 = viewgroup.getChildCount();
            if (i1 > 0)
            {
                String s2 = (new StringBuilder()).append(s1).append("  ").toString();
                int j1 = 0;
                while (j1 < i1) 
                {
                    a(s2, printwriter, viewgroup.getChildAt(j1));
                    j1++;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    J a(String s1, boolean flag, boolean flag1)
    {
        if (o == null)
        {
            o = new HashMap();
        }
        J j1 = (J)o.get(s1);
        if (j1 == null)
        {
            if (flag1)
            {
                j1 = new J(s1, this, flag);
                o.put(s1, j1);
            }
            return j1;
        } else
        {
            j1.a(this);
            return j1;
        }
    }

    void a()
    {
        if (n)
        {
            n = false;
            if (p != null)
            {
                if (!k)
                {
                    p.b();
                } else
                {
                    p.c();
                }
            }
        }
        e.m();
    }

    void a(String s1)
    {
        if (o != null)
        {
            J j1 = (J)o.get(s1);
            if (j1 != null && !j1.h)
            {
                j1.g();
                o.remove(s1);
            }
        }
    }

    void a(boolean flag)
    {
        if (!j)
        {
            j = true;
            k = flag;
            d.removeMessages(1);
            a();
        }
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        if (android.os.Build.VERSION.SDK_INT < 11);
        printwriter.print(s1);
        printwriter.print("Local FragmentActivity ");
        printwriter.print(Integer.toHexString(System.identityHashCode(this)));
        printwriter.println(" State:");
        String s2 = (new StringBuilder()).append(s1).append("  ").toString();
        printwriter.print(s2);
        printwriter.print("mCreated=");
        printwriter.print(g);
        printwriter.print("mResumed=");
        printwriter.print(h);
        printwriter.print(" mStopped=");
        printwriter.print(i);
        printwriter.print(" mReallyStopped=");
        printwriter.println(j);
        printwriter.print(s2);
        printwriter.print("mLoadersStarted=");
        printwriter.println(n);
        if (p != null)
        {
            printwriter.print(s1);
            printwriter.print("Loader Manager ");
            printwriter.print(Integer.toHexString(System.identityHashCode(p)));
            printwriter.println(":");
            p.dump((new StringBuilder()).append(s1).append("  ").toString(), filedescriptor, printwriter, as);
        }
        e.dump(s1, filedescriptor, printwriter, as);
        printwriter.print(s1);
        printwriter.println("View Hierarchy:");
        a((new StringBuilder()).append(s1).append("  ").toString(), printwriter, getWindow().getDecorView());
    }

    public Object getLastCustomNonConfigurationInstance()
    {
        t t1 = (t)getLastNonConfigurationInstance();
        if (t1 != null)
        {
            return t1.b;
        } else
        {
            return null;
        }
    }

    public FragmentManager getSupportFragmentManager()
    {
        return e;
    }

    public LoaderManager getSupportLoaderManager()
    {
        if (p != null)
        {
            return p;
        } else
        {
            m = true;
            p = a(null, n, true);
            return p;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        e.f();
        int k1 = i1 >> 16;
        if (k1 != 0)
        {
            int l1 = k1 - 1;
            if (e.k == null || l1 < 0 || l1 >= e.k.size())
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result fragment index out of range: 0x").append(Integer.toHexString(i1)).toString());
                return;
            }
            Fragment fragment = (Fragment)e.k.get(l1);
            if (fragment == null)
            {
                Log.w("FragmentActivity", (new StringBuilder()).append("Activity result no fragment exists for index: 0x").append(Integer.toHexString(i1)).toString());
                return;
            } else
            {
                fragment.onActivityResult(0xffff & i1, j1, intent);
                return;
            }
        } else
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
    }

    public void onAttachFragment(Fragment fragment)
    {
    }

    public void onBackPressed()
    {
        if (!e.popBackStackImmediate())
        {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        e.a(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        e.a(this, f, null);
        if (getLayoutInflater().getFactory() == null)
        {
            getLayoutInflater().setFactory(this);
        }
        super.onCreate(bundle);
        t t1 = (t)getLastNonConfigurationInstance();
        if (t1 != null)
        {
            o = t1.e;
        }
        if (bundle != null)
        {
            android.os.Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            v v1 = e;
            ArrayList arraylist;
            if (t1 != null)
            {
                arraylist = t1.d;
            } else
            {
                arraylist = null;
            }
            v1.a(parcelable, arraylist);
        }
        e.g();
    }

    public boolean onCreatePanelMenu(int i1, Menu menu)
    {
        if (i1 == 0)
        {
            boolean flag = super.onCreatePanelMenu(i1, menu) | e.a(menu, getMenuInflater());
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                return flag;
            } else
            {
                return true;
            }
        } else
        {
            return super.onCreatePanelMenu(i1, menu);
        }
    }

    public View onCreateView(String s1, Context context, AttributeSet attributeset)
    {
        if (!"fragment".equals(s1))
        {
            return super.onCreateView(s1, context, attributeset);
        }
        String s2 = attributeset.getAttributeValue(null, "class");
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, s.a);
        if (s2 == null)
        {
            s2 = typedarray.getString(0);
        }
        int i1 = typedarray.getResourceId(1, -1);
        String s3 = typedarray.getString(2);
        typedarray.recycle();
        int j1 = 0;
        if (false)
        {
            j1 = null.getId();
        }
        if (j1 == -1 && i1 == -1 && s3 == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Must specify unique android:id, android:tag, or have a parent with an id for ").append(s2).toString());
        }
        Fragment fragment = null;
        if (i1 != -1)
        {
            fragment = e.findFragmentById(i1);
        }
        if (fragment == null && s3 != null)
        {
            fragment = e.findFragmentByTag(s3);
        }
        if (fragment == null && j1 != -1)
        {
            fragment = e.findFragmentById(j1);
        }
        if (v.a)
        {
            Log.v("FragmentActivity", (new StringBuilder()).append("onCreateView: id=0x").append(Integer.toHexString(i1)).append(" fname=").append(s2).append(" existing=").append(fragment).toString());
        }
        if (fragment == null)
        {
            Fragment fragment1 = Fragment.instantiate(this, s2);
            fragment1.D = true;
            int k1;
            if (i1 != 0)
            {
                k1 = i1;
            } else
            {
                k1 = j1;
            }
            fragment1.L = k1;
            fragment1.M = j1;
            fragment1.N = s3;
            fragment1.E = true;
            fragment1.H = e;
            fragment1.onInflate(this, attributeset, fragment1.s);
            e.a(fragment1, true);
            fragment = fragment1;
        } else
        {
            if (fragment.E)
            {
                throw new IllegalArgumentException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Duplicate id 0x").append(Integer.toHexString(i1)).append(", tag ").append(s3).append(", or parent id 0x").append(Integer.toHexString(j1)).append(" with another fragment for ").append(s2).toString());
            }
            fragment.E = true;
            if (!fragment.R)
            {
                fragment.onInflate(this, attributeset, fragment.s);
            }
            e.b(fragment);
        }
        if (fragment.X == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("Fragment ").append(s2).append(" did not create a view.").toString());
        }
        if (i1 != 0)
        {
            fragment.X.setId(i1);
        }
        if (fragment.X.getTag() == null)
        {
            fragment.X.setTag(s3);
        }
        return fragment.X;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        a(false);
        e.o();
        if (p != null)
        {
            p.g();
        }
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (android.os.Build.VERSION.SDK_INT < 5 && i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        e.p();
    }

    public boolean onMenuItemSelected(int i1, MenuItem menuitem)
    {
        if (super.onMenuItemSelected(i1, menuitem))
        {
            return true;
        }
        switch (i1)
        {
        default:
            return false;

        case 0: // '\0'
            return e.a(menuitem);

        case 6: // '\006'
            return e.b(menuitem);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        e.f();
    }

    public void onPanelClosed(int i1, Menu menu)
    {
        i1;
        JVM INSTR tableswitch 0 0: default 20
    //                   0 27;
           goto _L1 _L2
_L1:
        super.onPanelClosed(i1, menu);
        return;
_L2:
        e.b(menu);
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        h = false;
        if (d.hasMessages(2))
        {
            d.removeMessages(2);
            onResumeFragments();
        }
        e.k();
    }

    protected void onPostResume()
    {
        super.onPostResume();
        d.removeMessages(2);
        onResumeFragments();
        e.b();
    }

    public boolean onPreparePanel(int i1, View view, Menu menu)
    {
        if (i1 == 0 && menu != null)
        {
            if (l)
            {
                l = false;
                menu.clear();
                onCreatePanelMenu(i1, menu);
            }
            return super.onPreparePanel(i1, view, menu) | e.a(menu);
        } else
        {
            return super.onPreparePanel(i1, view, menu);
        }
    }

    protected void onResume()
    {
        super.onResume();
        d.sendEmptyMessage(2);
        h = true;
        e.b();
    }

    protected void onResumeFragments()
    {
        e.j();
    }

    public Object onRetainCustomNonConfigurationInstance()
    {
        return null;
    }

    public final Object onRetainNonConfigurationInstance()
    {
        if (i)
        {
            a(true);
        }
        Object obj = onRetainCustomNonConfigurationInstance();
        ArrayList arraylist = e.d();
        HashMap hashmap = o;
        int i1 = 0;
        if (hashmap != null)
        {
            J aj[] = new J[o.size()];
            o.values().toArray(aj);
            i1 = 0;
            if (aj != null)
            {
                boolean flag = false;
                while (i1 < aj.length) 
                {
                    J j1 = aj[i1];
                    if (j1.h)
                    {
                        flag = true;
                    } else
                    {
                        j1.g();
                        o.remove(j1.e);
                    }
                    i1++;
                }
                i1 = ((flag) ? 1 : 0);
            }
        }
        if (arraylist == null && i1 == 0 && obj == null)
        {
            return null;
        } else
        {
            t t1 = new t();
            t1.a = null;
            t1.b = obj;
            t1.c = null;
            t1.d = arraylist;
            t1.e = o;
            return t1;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        android.os.Parcelable parcelable = e.e();
        if (parcelable != null)
        {
            bundle.putParcelable("android:support:fragments", parcelable);
        }
    }

    protected void onStart()
    {
        super.onStart();
        i = false;
        j = false;
        d.removeMessages(1);
        if (!g)
        {
            g = true;
            e.h();
        }
        e.f();
        e.b();
        if (n) goto _L2; else goto _L1
_L1:
        n = true;
        if (p == null) goto _L4; else goto _L3
_L3:
        p.a();
_L6:
        m = true;
_L2:
        e.i();
        if (o != null)
        {
            J aj[] = new J[o.size()];
            o.values().toArray(aj);
            int i1 = 0;
            if (aj != null)
            {
                for (; i1 < aj.length; i1++)
                {
                    J j1 = aj[i1];
                    j1.d();
                    j1.f();
                }

            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (!m)
        {
            p = a(null, n, false);
            if (p != null && !p.g)
            {
                p.a();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onStop()
    {
        super.onStop();
        i = true;
        d.sendEmptyMessage(1);
        e.l();
    }

    public void startActivityForResult(Intent intent, int i1)
    {
        if (i1 != -1 && (0xffff0000 & i1) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, i1);
            return;
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i1)
    {
        if (i1 == -1)
        {
            super.startActivityForResult(intent, -1);
            return;
        }
        if ((0xffff0000 & i1) != 0)
        {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else
        {
            super.startActivityForResult(intent, (1 + fragment.u << 16) + (0xffff & i1));
            return;
        }
    }

    public void supportInvalidateOptionsMenu()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            android.support.v4.app.h.a(this);
            return;
        } else
        {
            l = true;
            return;
        }
    }
}
