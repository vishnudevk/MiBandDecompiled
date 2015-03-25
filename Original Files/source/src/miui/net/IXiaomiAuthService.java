// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package miui.net;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;

public interface IXiaomiAuthService
    extends IInterface
{

    public abstract Bundle getMiCloudAccessToken(Account account, Bundle bundle);

    public abstract Bundle getMiCloudUserInfo(Account account, Bundle bundle);

    public abstract Bundle getSnsAccessToken(Account account, Bundle bundle);

    public abstract void invalidateAccessToken(Account account, Bundle bundle);
}
