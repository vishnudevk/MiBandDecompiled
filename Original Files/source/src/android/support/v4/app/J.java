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

// Referenced classes of package android.support.v4.app:
//            LoaderManager, K, FragmentActivity, v

class J extends LoaderManager
{

    static final String a = "LoaderManager";
    static boolean b = false;
    final SparseArrayCompat c = new SparseArrayCompat();
    final SparseArrayCompat d = new SparseArrayCompat();
    final String e;
    FragmentActivity f;
    boolean g;
    boolean h;
    boolean i;
    boolean j;

    J(String s, FragmentActivity fragmentactivity, boolean flag)
    {
        e = s;
        f = fragmentactivity;
        g = flag;
    }

    private K a(int k, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        K k1 = new K(this, k, bundle, loadercallbacks);
        k1.d = loadercallbacks.onCreateLoader(k, bundle);
        return k1;
    }

    private K b(int k, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        K k1;
        j = true;
        k1 = a(k, bundle, loadercallbacks);
        a(k1);
        j = false;
        return k1;
        Exception exception;
        exception;
        j = false;
        throw exception;
    }

    void a()
    {
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Starting in ").append(this).toString());
        }
        if (g)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStart when already started: ").append(this).toString(), runtimeexception);
        } else
        {
            g = true;
            int k = -1 + c.size();
            while (k >= 0) 
            {
                ((K)c.valueAt(k)).a();
                k--;
            }
        }
    }

    void a(FragmentActivity fragmentactivity)
    {
        f = fragmentactivity;
    }

    void a(K k)
    {
        c.put(k.a, k);
        if (g)
        {
            k.a();
        }
    }

    void b()
    {
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Stopping in ").append(this).toString());
        }
        if (!g)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doStop when not started: ").append(this).toString(), runtimeexception);
            return;
        }
        for (int k = -1 + c.size(); k >= 0; k--)
        {
            ((K)c.valueAt(k)).e();
        }

        g = false;
    }

    void c()
    {
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Retaining in ").append(this).toString());
        }
        if (!g)
        {
            RuntimeException runtimeexception = new RuntimeException("here");
            runtimeexception.fillInStackTrace();
            Log.w("LoaderManager", (new StringBuilder()).append("Called doRetain when not started: ").append(this).toString(), runtimeexception);
        } else
        {
            h = true;
            g = false;
            int k = -1 + c.size();
            while (k >= 0) 
            {
                ((K)c.valueAt(k)).b();
                k--;
            }
        }
    }

    void d()
    {
        if (h)
        {
            if (b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Finished Retaining in ").append(this).toString());
            }
            h = false;
            for (int k = -1 + c.size(); k >= 0; k--)
            {
                ((K)c.valueAt(k)).c();
            }

        }
    }

    public void destroyLoader(int k)
    {
        if (j)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("destroyLoader in ").append(this).append(" of ").append(k).toString());
        }
        int l = c.indexOfKey(k);
        if (l >= 0)
        {
            K k2 = (K)c.valueAt(l);
            c.removeAt(l);
            k2.f();
        }
        int i1 = d.indexOfKey(k);
        if (i1 >= 0)
        {
            K k1 = (K)d.valueAt(i1);
            d.removeAt(i1);
            k1.f();
        }
        if (f != null && !hasRunningLoaders())
        {
            f.e.a();
        }
    }

    public void dump(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        int k = 0;
        if (c.size() > 0)
        {
            printwriter.print(s);
            printwriter.println("Active Loaders:");
            String s2 = (new StringBuilder()).append(s).append("    ").toString();
            for (int l = 0; l < c.size(); l++)
            {
                K k2 = (K)c.valueAt(l);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(c.keyAt(l));
                printwriter.print(": ");
                printwriter.println(k2.toString());
                k2.a(s2, filedescriptor, printwriter, as);
            }

        }
        if (d.size() > 0)
        {
            printwriter.print(s);
            printwriter.println("Inactive Loaders:");
            String s1 = (new StringBuilder()).append(s).append("    ").toString();
            for (; k < d.size(); k++)
            {
                K k1 = (K)d.valueAt(k);
                printwriter.print(s);
                printwriter.print("  #");
                printwriter.print(d.keyAt(k));
                printwriter.print(": ");
                printwriter.println(k1.toString());
                k1.a(s1, filedescriptor, printwriter, as);
            }

        }
    }

    void e()
    {
        for (int k = -1 + c.size(); k >= 0; k--)
        {
            ((K)c.valueAt(k)).k = true;
        }

    }

    void f()
    {
        for (int k = -1 + c.size(); k >= 0; k--)
        {
            ((K)c.valueAt(k)).d();
        }

    }

    void g()
    {
        if (!h)
        {
            if (b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("Destroying Active in ").append(this).toString());
            }
            for (int l = -1 + c.size(); l >= 0; l--)
            {
                ((K)c.valueAt(l)).f();
            }

            c.clear();
        }
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("Destroying Inactive in ").append(this).toString());
        }
        for (int k = -1 + d.size(); k >= 0; k--)
        {
            ((K)d.valueAt(k)).f();
        }

        d.clear();
    }

    public Loader getLoader(int k)
    {
        if (j)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        K k1 = (K)c.get(k);
        if (k1 != null)
        {
            if (k1.n != null)
            {
                return k1.n.d;
            } else
            {
                return k1.d;
            }
        } else
        {
            return null;
        }
    }

    public boolean hasRunningLoaders()
    {
        int k = c.size();
        int l = 0;
        boolean flag = false;
        while (l < k) 
        {
            K k1 = (K)c.valueAt(l);
            boolean flag1;
            if (k1.h && !k1.f)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag |= flag1;
            l++;
        }
        return flag;
    }

    public Loader initLoader(int k, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        if (j)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        K k1 = (K)c.get(k);
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("initLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (k1 == null)
        {
            k1 = b(k, bundle, loadercallbacks);
            if (b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Created new loader ").append(k1).toString());
            }
        } else
        {
            if (b)
            {
                Log.v("LoaderManager", (new StringBuilder()).append("  Re-using existing loader ").append(k1).toString());
            }
            k1.c = loadercallbacks;
        }
        if (k1.e && g)
        {
            k1.a(k1.d, k1.g);
        }
        return k1.d;
    }

    public Loader restartLoader(int k, Bundle bundle, LoaderManager.LoaderCallbacks loadercallbacks)
    {
        if (j)
        {
            throw new IllegalStateException("Called while creating a loader");
        }
        K k1 = (K)c.get(k);
        if (b)
        {
            Log.v("LoaderManager", (new StringBuilder()).append("restartLoader in ").append(this).append(": args=").append(bundle).toString());
        }
        if (k1 != null)
        {
            K k2 = (K)d.get(k);
            if (k2 != null)
            {
                if (k1.e)
                {
                    if (b)
                    {
                        Log.v("LoaderManager", (new StringBuilder()).append("  Removing last inactive loader: ").append(k1).toString());
                    }
                    k2.f = false;
                    k2.f();
                    k1.d.abandon();
                    d.put(k, k1);
                } else
                if (!k1.h)
                {
                    if (b)
                    {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    c.put(k, null);
                    k1.f();
                } else
                {
                    if (k1.n != null)
                    {
                        if (b)
                        {
                            Log.v("LoaderManager", (new StringBuilder()).append("  Removing pending loader: ").append(k1.n).toString());
                        }
                        k1.n.f();
                        k1.n = null;
                    }
                    if (b)
                    {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    k1.n = a(k, bundle, loadercallbacks);
                    return k1.n.d;
                }
            } else
            {
                if (b)
                {
                    Log.v("LoaderManager", (new StringBuilder()).append("  Making last loader inactive: ").append(k1).toString());
                }
                k1.d.abandon();
                d.put(k, k1);
            }
        }
        return b(k, bundle, loadercallbacks).d;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(128);
        stringbuilder.append("LoaderManager{");
        stringbuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringbuilder.append(" in ");
        DebugUtils.buildShortClassTag(f, stringbuilder);
        stringbuilder.append("}}");
        return stringbuilder.toString();
    }

}
