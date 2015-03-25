// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

// Referenced classes of package android.support.v4.app:
//            J, FragmentActivity, v

final class K
    implements android.support.v4.content.Loader.OnLoadCompleteListener
{

    final int a;
    final Bundle b;
    LoaderManager.LoaderCallbacks c;
    Loader d;
    boolean e;
    boolean f;
    Object g;
    boolean h;
    boolean i;
    boolean j;
    boolean k;
    boolean l;
    boolean m;
    K n;
    final J o;

    public K(J j1, int i1, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        o = j1;
        super();
        a = i1;
        b = bundle;
        c = loadercallbacks;
    }

    void a()
    {
        if (i && j)
        {
            h = true;
        } else
        if (!h)
        {
            h = true;
            if (J.b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Starting: ").append(this).toString());
            }
            if (d == null && c != null)
            {
                d = c.onCreateLoader(a, b);
            }
            if (d != null)
            {
                if (d.getClass().isMemberClass() && !Modifier.isStatic(d.getClass().getModifiers()))
                {
                    throw new IllegalArgumentException((new StringBuilder()).append("Object returned from onCreateLoader must not be a non-static inner member class: ").append(d).toString());
                }
                if (!m)
                {
                    d.registerListener(a, this);
                    m = true;
                }
                d.startLoading();
                return;
            }
        }
    }

    void a(Loader loader, Object obj)
    {
        if (c == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        String s;
        Exception exception;
        if (o.f != null)
        {
            String s1 = o.f.e.z;
            o.f.e.z = "onLoadFinished";
            s = s1;
        } else
        {
            s = null;
        }
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("  onLoadFinished in ").append(loader).append(": ").append(loader.dataToString(obj)).toString());
        }
        c.onLoadFinished(loader, obj);
        if (o.f != null)
        {
            o.f.e.z = s;
        }
        f = true;
        return;
        exception;
        if (o.f != null)
        {
            o.f.e.z = s;
        }
        throw exception;
    }

    public void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s);
        printwriter.print("mId=");
        printwriter.print(a);
        printwriter.print(" mArgs=");
        printwriter.println(b);
        printwriter.print(s);
        printwriter.print("mCallbacks=");
        printwriter.println(c);
        printwriter.print(s);
        printwriter.print("mLoader=");
        printwriter.println(d);
        if (d != null)
        {
            d.dump((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
        if (e || f)
        {
            printwriter.print(s);
            printwriter.print("mHaveData=");
            printwriter.print(e);
            printwriter.print("  mDeliveredData=");
            printwriter.println(f);
            printwriter.print(s);
            printwriter.print("mData=");
            printwriter.println(g);
        }
        printwriter.print(s);
        printwriter.print("mStarted=");
        printwriter.print(h);
        printwriter.print(" mReportNextStart=");
        printwriter.print(k);
        printwriter.print(" mDestroyed=");
        printwriter.println(l);
        printwriter.print(s);
        printwriter.print("mRetaining=");
        printwriter.print(i);
        printwriter.print(" mRetainingStarted=");
        printwriter.print(j);
        printwriter.print(" mListenerRegistered=");
        printwriter.println(m);
        if (n != null)
        {
            printwriter.print(s);
            printwriter.println("Pending Loader ");
            printwriter.print(n);
            printwriter.println(":");
            n.a((new StringBuilder()).append(s).append("  ").toString(), filedescriptor, printwriter, as);
        }
    }

    void b()
    {
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("  Retaining: ").append(this).toString());
        }
        i = true;
        j = h;
        h = false;
        c = null;
    }

    void c()
    {
        if (i)
        {
            if (J.b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Finished Retaining: ").append(this).toString());
            }
            i = false;
            if (h != j && !h)
            {
                e();
            }
        }
        if (h && e && !k)
        {
            a(d, g);
        }
    }

    void d()
    {
        if (h && k)
        {
            k = false;
            if (e)
            {
                a(d, g);
            }
        }
    }

    void e()
    {
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("  Stopping: ").append(this).toString());
        }
        h = false;
        if (!i && d != null && m)
        {
            m = false;
            d.unregisterListener(this);
            d.stopLoading();
        }
    }

    void f()
    {
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("  Destroying: ").append(this).toString());
        }
        l = true;
        boolean flag = f;
        f = false;
        if (c == null || d == null || !e || !flag)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("  Reseting: ").append(this).toString());
        }
        String s;
        Exception exception;
        if (o.f != null)
        {
            String s1 = o.f.e.z;
            o.f.e.z = "onLoaderReset";
            s = s1;
        } else
        {
            s = null;
        }
        c.onLoaderReset(d);
        if (o.f != null)
        {
            o.f.e.z = s;
        }
        c = null;
        g = null;
        e = false;
        if (d != null)
        {
            if (m)
            {
                m = false;
                d.unregisterListener(this);
            }
            d.reset();
        }
        if (n != null)
        {
            n.f();
        }
        return;
        exception;
        if (o.f != null)
        {
            o.f.e.z = s;
        }
        throw exception;
    }

    public void onLoadComplete(Loader loader, Object obj)
    {
        if (J.b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("onLoadComplete: ").append(this).toString());
        }
        if (!l) goto _L2; else goto _L1
_L1:
        if (J.b)
        {
            Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
        }
_L4:
        return;
_L2:
        if (o.c.get(a) == this)
        {
            break; /* Loop/switch isn't completed */
        }
        if (J.b)
        {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        K k1 = n;
        if (k1 != null)
        {
            if (J.b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Switching to pending loader: ").append(k1).toString());
            }
            n = null;
            o.c.put(a, null);
            f();
            o.a(k1);
            return;
        }
        if (g != obj || !e)
        {
            g = obj;
            e = true;
            if (h)
            {
                a(loader, obj);
            }
        }
        K k2 = (K)o.d.get(a);
        if (k2 != null && k2 != this)
        {
            k2.f = false;
            k2.f();
            o.d.remove(a);
        }
        if (o.f != null && !o.hasRunningLoaders())
        {
            o.f.e.a();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        stringbuilder.append("LoaderInfo{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" #");
        stringbuilder.append(a);
        stringbuilder.append(" : ");
        DebugUtils.buildShortClassTag(d, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }
}
