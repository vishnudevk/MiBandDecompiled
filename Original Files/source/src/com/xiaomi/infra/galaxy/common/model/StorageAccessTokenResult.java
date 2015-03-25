// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


// Referenced classes of package com.xiaomi.infra.galaxy.common.model:
//            Result

public class StorageAccessTokenResult extends Result
{

    private long expiresIn;
    private String storageAccessToken;

    public StorageAccessTokenResult()
    {
    }

    public StorageAccessTokenResult(String s, long l)
    {
        setStorageAccessToken(s);
        setExpiresIn(l);
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag1 = flag;
_L4:
        return flag1;
_L2:
        flag1 = false;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag2 = obj instanceof StorageAccessTokenResult;
        flag1 = false;
        if (!flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        StorageAccessTokenResult storageaccesstokenresult = (StorageAccessTokenResult)obj;
        boolean flag3;
        boolean flag4;
        int i;
        boolean flag5;
        if (storageaccesstokenresult.getStorageAccessToken() == null)
        {
            flag3 = flag;
        } else
        {
            flag3 = false;
        }
        if (getStorageAccessToken() != null)
        {
            flag = false;
        }
        flag4 = flag3 ^ flag;
        flag1 = false;
        if (flag4)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (storageaccesstokenresult.getStorageAccessToken() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = storageaccesstokenresult.getStorageAccessToken().equals(getStorageAccessToken());
        flag1 = false;
        if (!flag5) goto _L4; else goto _L3
_L3:
        i = storageaccesstokenresult.getExpiresIn() != getExpiresIn();
        flag1 = false;
        if (i == 0)
        {
            return super.equals(obj);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public long getExpiresIn()
    {
        return expiresIn;
    }

    public String getStorageAccessToken()
    {
        return storageAccessToken;
    }

    public int hashCode()
    {
        int i = 31 * super.hashCode();
        int j;
        int k;
        int l;
        int i1;
        if (getStorageAccessToken() == null)
        {
            j = 0;
        } else
        {
            j = getStorageAccessToken().hashCode();
        }
        k = 31 * (j + i);
        l = getExpiresIn() != 0L;
        i1 = 0;
        if (l != 0)
        {
            i1 = (int)getExpiresIn();
        }
        return k + i1;
    }

    public void setExpiresIn(long l)
    {
        expiresIn = l;
    }

    public void setStorageAccessToken(String s)
    {
        storageAccessToken = s;
    }
}
