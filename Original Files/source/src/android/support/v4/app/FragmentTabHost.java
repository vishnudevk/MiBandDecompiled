// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;

// Referenced classes of package android.support.v4.app:
//            G, FragmentManager, FragmentTransaction, Fragment, 
//            E

public class FragmentTabHost extends TabHost
    implements android.widget.TabHost.OnTabChangeListener
{

    private final ArrayList a;
    private FrameLayout b;
    private Context c;
    private FragmentManager d;
    private int e;
    private android.widget.TabHost.OnTabChangeListener f;
    private G g;
    private boolean h;

    public FragmentTabHost(Context context)
    {
        super(context, null);
        a = new ArrayList();
        a(context, ((AttributeSet) (null)));
    }

    public FragmentTabHost(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new ArrayList();
        a(context, attributeset);
    }

    private FragmentTransaction a(String s, FragmentTransaction fragmenttransaction)
    {
        G g1 = null;
        int i = 0;
        while (i < a.size()) 
        {
            G g2 = (G)a.get(i);
            if (!G.b(g2).equals(s))
            {
                g2 = g1;
            }
            i++;
            g1 = g2;
        }
        if (g1 == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No tab known for tag ").append(s).toString());
        }
        if (g != g1)
        {
            if (fragmenttransaction == null)
            {
                fragmenttransaction = d.beginTransaction();
            }
            if (g != null && G.a(g) != null)
            {
                fragmenttransaction.detach(G.a(g));
            }
            if (g1 != null)
            {
                if (G.a(g1) == null)
                {
                    G.a(g1, Fragment.instantiate(c, G.c(g1).getName(), G.d(g1)));
                    fragmenttransaction.add(e, G.a(g1), G.b(g1));
                } else
                {
                    fragmenttransaction.attach(G.a(g1));
                }
            }
            g = g1;
        }
        return fragmenttransaction;
    }

    private void a()
    {
        if (b == null)
        {
            b = (FrameLayout)findViewById(e);
            if (b == null)
            {
                throw new IllegalStateException((new StringBuilder()).append("No tab content FrameLayout found for id ").append(e).toString());
            }
        }
    }

    private void a(Context context, AttributeSet attributeset)
    {
        TypedArray typedarray = context.obtainStyledAttributes(attributeset, new int[] {
            0x10100f3
        }, 0, 0);
        e = typedarray.getResourceId(0, 0);
        typedarray.recycle();
        super.setOnTabChangedListener(this);
        if (findViewById(0x1020013) == null)
        {
            LinearLayout linearlayout = new LinearLayout(context);
            linearlayout.setOrientation(1);
            addView(linearlayout, new android.widget.FrameLayout.LayoutParams(-1, -1));
            TabWidget tabwidget = new TabWidget(context);
            tabwidget.setId(0x1020013);
            tabwidget.setOrientation(0);
            linearlayout.addView(tabwidget, new android.widget.LinearLayout.LayoutParams(-1, -2, 0.0F));
            FrameLayout framelayout = new FrameLayout(context);
            framelayout.setId(0x1020011);
            linearlayout.addView(framelayout, new android.widget.LinearLayout.LayoutParams(0, 0, 0.0F));
            FrameLayout framelayout1 = new FrameLayout(context);
            b = framelayout1;
            b.setId(e);
            linearlayout.addView(framelayout1, new android.widget.LinearLayout.LayoutParams(-1, 0, 1.0F));
        }
    }

    public void addTab(android.widget.TabHost.TabSpec tabspec, Class class1, Bundle bundle)
    {
        tabspec.setContent(new E(c));
        String s = tabspec.getTag();
        G g1 = new G(s, class1, bundle);
        if (h)
        {
            G.a(g1, d.findFragmentByTag(s));
            if (G.a(g1) != null && !G.a(g1).isDetached())
            {
                FragmentTransaction fragmenttransaction = d.beginTransaction();
                fragmenttransaction.detach(G.a(g1));
                fragmenttransaction.commit();
            }
        }
        a.add(g1);
        addTab(tabspec);
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        String s = getCurrentTabTag();
        FragmentTransaction fragmenttransaction = null;
        int i = 0;
        while (i < a.size()) 
        {
            G g1 = (G)a.get(i);
            G.a(g1, d.findFragmentByTag(G.b(g1)));
            if (G.a(g1) != null && !G.a(g1).isDetached())
            {
                if (G.b(g1).equals(s))
                {
                    g = g1;
                } else
                {
                    if (fragmenttransaction == null)
                    {
                        fragmenttransaction = d.beginTransaction();
                    }
                    fragmenttransaction.detach(G.a(g1));
                }
            }
            i++;
        }
        h = true;
        FragmentTransaction fragmenttransaction1 = a(s, fragmenttransaction);
        if (fragmenttransaction1 != null)
        {
            fragmenttransaction1.commit();
            d.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        h = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        SavedState savedstate = (SavedState)parcelable;
        super.onRestoreInstanceState(savedstate.getSuperState());
        setCurrentTabByTag(savedstate.a);
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.a = getCurrentTabTag();
        return savedstate;
    }

    public void onTabChanged(String s)
    {
        if (h)
        {
            FragmentTransaction fragmenttransaction = a(s, ((FragmentTransaction) (null)));
            if (fragmenttransaction != null)
            {
                fragmenttransaction.commit();
            }
        }
        if (f != null)
        {
            f.onTabChanged(s);
        }
    }

    public void setOnTabChangedListener(android.widget.TabHost.OnTabChangeListener ontabchangelistener)
    {
        f = ontabchangelistener;
    }

    public void setup()
    {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setup(Context context, FragmentManager fragmentmanager)
    {
        super.setup();
        c = context;
        d = fragmentmanager;
        a();
    }

    public void setup(Context context, FragmentManager fragmentmanager, int i)
    {
        super.setup();
        c = context;
        d = fragmentmanager;
        e = i;
        a();
        b.setId(i);
        if (getId() == -1)
        {
            setId(0x1020012);
        }
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new F();
        String a;

        public String toString()
        {
            return (new StringBuilder()).append("FragmentTabHost.SavedState{").append(Integer.toHexString(System.identityHashCode(this))).append(" curTab=").append(a).append("}").toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeString(a);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readString();
        }

        SavedState(Parcel parcel, D d1)
        {
            this(parcel);
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
