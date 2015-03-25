// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public interface IRequestListener
{

    public abstract void onComplete(JSONObject jsonobject);

    public abstract void onConnectTimeoutException(ConnectTimeoutException connecttimeoutexception);

    public abstract void onHttpStatusException(com.tencent.utils.HttpUtils.HttpStatusException httpstatusexception);

    public abstract void onIOException(IOException ioexception);

    public abstract void onJSONException(JSONException jsonexception);

    public abstract void onMalformedURLException(MalformedURLException malformedurlexception);

    public abstract void onNetworkUnavailableException(com.tencent.utils.HttpUtils.NetworkUnavailableException networkunavailableexception);

    public abstract void onSocketTimeoutException(SocketTimeoutException sockettimeoutexception);

    public abstract void onUnknowException(Exception exception);
}
