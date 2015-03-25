// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.xiaomi.account:
//            IXiaomiAuthService

class a
    implements IXiaomiAuthService
{

    private IBinder a;

    a(IBinder ibinder)
    {
        a = ibinder;
    }

    public String a()
    {
        return "com.xiaomi.account.IXiaomiAuthService";
    }

    public IBinder asBinder()
    {
        return a;
    }

    public Bundle getMiCloudAccessToken(Account account, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (account == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        account.writeToParcel(parcel, 0);
_L5:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        Bundle bundle1;
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L7:
        parcel1.recycle();
        parcel.recycle();
        return bundle1;
_L2:
        parcel.writeInt(0);
          goto _L5
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
_L4:
        parcel.writeInt(0);
          goto _L6
        bundle1 = null;
          goto _L7
    }

    public Bundle getMiCloudUserInfo(Account account, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (account == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        account.writeToParcel(parcel, 0);
_L5:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        Bundle bundle1;
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L7:
        parcel1.recycle();
        parcel.recycle();
        return bundle1;
_L2:
        parcel.writeInt(0);
          goto _L5
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
_L4:
        parcel.writeInt(0);
          goto _L6
        bundle1 = null;
          goto _L7
    }

    public Bundle getSnsAccessToken(Account account, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (account == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        account.writeToParcel(parcel, 0);
_L5:
        if (bundle == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L6:
        Bundle bundle1;
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        bundle1 = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
_L7:
        parcel1.recycle();
        parcel.recycle();
        return bundle1;
_L2:
        parcel.writeInt(0);
          goto _L5
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
_L4:
        parcel.writeInt(0);
          goto _L6
        bundle1 = null;
          goto _L7
    }

    public void invalidateAccessToken(Account account, Bundle bundle)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (account == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        account.writeToParcel(parcel, 0);
_L3:
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
_L4:
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
        parcel.writeInt(0);
          goto _L4
    }
}
