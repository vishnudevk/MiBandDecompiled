// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public interface ResponseHandlerInterface
{

    public abstract Header[] getRequestHeaders();

    public abstract URI getRequestURI();

    public abstract boolean getUseSynchronousMode();

    public abstract void sendCancelMessage();

    public abstract void sendFailureMessage(int i, Header aheader[], byte abyte0[], Throwable throwable);

    public abstract void sendFinishMessage();

    public abstract void sendProgressMessage(int i, int j);

    public abstract void sendResponseMessage(HttpResponse httpresponse);

    public abstract void sendRetryMessage(int i);

    public abstract void sendStartMessage();

    public abstract void sendSuccessMessage(int i, Header aheader[], byte abyte0[]);

    public abstract void setRequestHeaders(Header aheader[]);

    public abstract void setRequestURI(URI uri);

    public abstract void setUseSynchronousMode(boolean flag);
}
