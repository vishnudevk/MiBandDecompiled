// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;

public interface 
{

    public abstract Loader onCreateLoader(int i, Bundle bundle);

    public abstract void onLoadFinished(Loader loader, Object obj);

    public abstract void onLoaderReset(Loader loader);
}
