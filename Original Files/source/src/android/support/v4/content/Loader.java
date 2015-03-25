// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.content;

import android.content.Context;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader
{

    int o;
    OnLoadCompleteListener p;
    Context q;
    boolean r;
    boolean s;
    boolean t;
    boolean u;
    boolean v;

    public Loader(Context context)
    {
        r = false;
        s = false;
        t = true;
        u = false;
        v = false;
        q = context.getApplicationContext();
    }

    public void abandon()
    {
        s = true;
        onAbandon();
    }

    public void commitContentChanged()
    {
        v = false;
    }

    public String dataToString(Object obj)
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(obj, stringbuilder);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void deliverResult(Object obj)
    {
        if (p != null)
        {
            p.onLoadComplete(this, obj);
        }
    }

    public void dump(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.print(s1);
        printwriter.print("mId=");
        printwriter.print(o);
        printwriter.print(" mListener=");
        printwriter.println(p);
        if (r || u || v)
        {
            printwriter.print(s1);
            printwriter.print("mStarted=");
            printwriter.print(r);
            printwriter.print(" mContentChanged=");
            printwriter.print(u);
            printwriter.print(" mProcessingChange=");
            printwriter.println(v);
        }
        if (s || t)
        {
            printwriter.print(s1);
            printwriter.print("mAbandoned=");
            printwriter.print(s);
            printwriter.print(" mReset=");
            printwriter.println(t);
        }
    }

    public void forceLoad()
    {
        onForceLoad();
    }

    public Context getContext()
    {
        return q;
    }

    public int getId()
    {
        return o;
    }

    public boolean isAbandoned()
    {
        return s;
    }

    public boolean isReset()
    {
        return t;
    }

    public boolean isStarted()
    {
        return r;
    }

    protected void onAbandon()
    {
    }

    public void onContentChanged()
    {
        if (r)
        {
            forceLoad();
            return;
        } else
        {
            u = true;
            return;
        }
    }

    protected void onForceLoad()
    {
    }

    protected void onReset()
    {
    }

    protected void onStartLoading()
    {
    }

    protected void onStopLoading()
    {
    }

    public void registerListener(int i, OnLoadCompleteListener onloadcompletelistener)
    {
        if (p != null)
        {
            throw new IllegalStateException("There is already a listener registered");
        } else
        {
            p = onloadcompletelistener;
            o = i;
            return;
        }
    }

    public void reset()
    {
        onReset();
        t = true;
        r = false;
        s = false;
        u = false;
        v = false;
    }

    public void rollbackContentChanged()
    {
        if (v)
        {
            u = true;
        }
    }

    public final void startLoading()
    {
        r = true;
        t = false;
        s = false;
        onStartLoading();
    }

    public void stopLoading()
    {
        r = false;
        onStopLoading();
    }

    public boolean takeContentChanged()
    {
        boolean flag = u;
        u = false;
        v = flag | v;
        return flag;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(o);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }

    public void unregisterListener(OnLoadCompleteListener onloadcompletelistener)
    {
        if (p == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (p != onloadcompletelistener)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            p = null;
            return;
        }
    }

    private class OnLoadCompleteListener
    {

        public abstract void onLoadComplete(Loader loader, Object obj);
    }

}
