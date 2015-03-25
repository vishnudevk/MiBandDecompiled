// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;


public interface MainListener
{

    public abstract void onBraceletConnectedFailed();

    public abstract void onBraceletConnectedSucc();

    public abstract void onBraceletConnecting();

    public abstract void onBraceletDisconnected();

    public abstract void onBraceletSearchedFailed();

    public abstract void onBraceletSearching();

    public abstract void onFwUpgradeProgress(int i);

    public abstract void onFwUpgradeStart(int i);

    public abstract void onFwUpgradeStop(int i);

    public abstract void onLoadLocalDataComplete();

    public abstract void onSyncDataProgress(int i);

    public abstract void onSyncDataStart();

    public abstract void onSyncDataStop(boolean flag);
}
