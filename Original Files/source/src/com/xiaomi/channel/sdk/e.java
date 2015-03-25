// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.xiaomi.channel.sdk:
//            f, AccountManager

abstract class e extends FutureTask
    implements AccountManagerFuture
{

    final Handler b;
    final AccountManagerCallback c;
    final Activity d;
    final AccountManager e;

    public e(AccountManager accountmanager, Activity activity, Handler handler, AccountManagerCallback accountmanagercallback)
    {
        e = accountmanager;
        super(new f(accountmanager));
        b = handler;
        c = accountmanagercallback;
        d = activity;
    }

    private Bundle a(Long long1, TimeUnit timeunit)
    {
        if (!isDone())
        {
            AccountManager.a(e);
        }
        if (long1 != null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        Bundle bundle1 = (Bundle)get();
        cancel(true);
        return bundle1;
        Bundle bundle = (Bundle)get(long1.longValue(), timeunit);
        cancel(true);
        return bundle;
        CancellationException cancellationexception;
        cancellationexception;
        throw new OperationCanceledException();
        Exception exception;
        exception;
        cancel(true);
        throw exception;
        TimeoutException timeoutexception;
        timeoutexception;
        cancel(true);
_L2:
        throw new OperationCanceledException();
        InterruptedException interruptedexception;
        interruptedexception;
        cancel(true);
        if (true) goto _L2; else goto _L1
_L1:
        ExecutionException executionexception;
        executionexception;
        Throwable throwable = executionexception.getCause();
        if (throwable instanceof IOException)
        {
            throw (IOException)throwable;
        }
        if (throwable instanceof UnsupportedOperationException)
        {
            throw new AuthenticatorException(throwable);
        }
        if (throwable instanceof AuthenticatorException)
        {
            throw (AuthenticatorException)throwable;
        }
        if (throwable instanceof RuntimeException)
        {
            throw (RuntimeException)throwable;
        }
        if (throwable instanceof Error)
        {
            throw (Error)throwable;
        } else
        {
            throw new IllegalStateException(throwable);
        }
    }

    public Bundle a(long l, TimeUnit timeunit)
    {
        return a(Long.valueOf(l), timeunit);
    }

    public abstract void a();

    public final AccountManagerFuture b()
    {
        try
        {
            a();
        }
        catch (RemoteException remoteexception)
        {
            setException(remoteexception);
            return this;
        }
        return this;
    }

    public Bundle c()
    {
        return a(((Long) (null)), null);
    }

    public Object getResult()
    {
        return c();
    }

    public Object getResult(long l, TimeUnit timeunit)
    {
        return a(l, timeunit);
    }
}
