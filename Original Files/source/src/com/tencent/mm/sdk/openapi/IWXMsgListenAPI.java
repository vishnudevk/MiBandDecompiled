// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.openapi;


public interface IWXMsgListenAPI
{

    public abstract boolean isWXAppSupportMsgListener();

    public abstract boolean registerMsgListener(String s, long l, long l1, int i);

    public abstract boolean unregisterMsgListener();
}
