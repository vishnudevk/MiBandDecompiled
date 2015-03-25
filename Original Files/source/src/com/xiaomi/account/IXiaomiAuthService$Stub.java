// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.xiaomi.account:
//            IXiaomiAuthService, a

public abstract class attachInterface extends Binder
    implements IXiaomiAuthService
{

    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    private static final String e = "com.xiaomi.account.IXiaomiAuthService";

    public static IXiaomiAuthService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.xiaomi.account.IXiaomiAuthService");
        if (iinterface != null && (iinterface instanceof IXiaomiAuthService))
        {
            return (IXiaomiAuthService)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.xiaomi.account.IXiaomiAuthService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
            Account account3;
            Bundle bundle5;
            Bundle bundle6;
            if (parcel.readInt() != 0)
            {
                account3 = (Account)Account.CREATOR.eFromParcel(parcel);
            } else
            {
                account3 = null;
            }
            if (parcel.readInt() != 0)
            {
                bundle5 = (Bundle)Bundle.CREATOR.eFromParcel(parcel);
            } else
            {
                bundle5 = null;
            }
            bundle6 = getMiCloudUserInfo(account3, bundle5);
            parcel1.writeNoException();
            if (bundle6 != null)
            {
                parcel1.writeInt(1);
                bundle6.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
            Account account2;
            Bundle bundle3;
            Bundle bundle4;
            if (parcel.readInt() != 0)
            {
                account2 = (Account)Account.CREATOR.eFromParcel(parcel);
            } else
            {
                account2 = null;
            }
            if (parcel.readInt() != 0)
            {
                bundle3 = (Bundle)Bundle.CREATOR.eFromParcel(parcel);
            } else
            {
                bundle3 = null;
            }
            bundle4 = getMiCloudAccessToken(account2, bundle3);
            parcel1.writeNoException();
            if (bundle4 != null)
            {
                parcel1.writeInt(1);
                bundle4.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
            Account account1;
            Bundle bundle1;
            Bundle bundle2;
            if (parcel.readInt() != 0)
            {
                account1 = (Account)Account.CREATOR.eFromParcel(parcel);
            } else
            {
                account1 = null;
            }
            if (parcel.readInt() != 0)
            {
                bundle1 = (Bundle)Bundle.CREATOR.eFromParcel(parcel);
            } else
            {
                bundle1 = null;
            }
            bundle2 = getSnsAccessToken(account1, bundle1);
            parcel1.writeNoException();
            if (bundle2 != null)
            {
                parcel1.writeInt(1);
                bundle2.writeToParcel(parcel1, 1);
            } else
            {
                parcel1.writeInt(0);
            }
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
            break;
        }
        Account account;
        Bundle bundle;
        if (parcel.readInt() != 0)
        {
            account = (Account)Account.CREATOR.eFromParcel(parcel);
        } else
        {
            account = null;
        }
        if (parcel.readInt() != 0)
        {
            bundle = (Bundle)Bundle.CREATOR.eFromParcel(parcel);
        } else
        {
            bundle = null;
        }
        invalidateAccessToken(account, bundle);
        parcel1.writeNoException();
        return true;
    }

    public ()
    {
        attachInterface(this, "com.xiaomi.account.IXiaomiAuthService");
    }
}
