// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.model;


public class UserInfo
{

    private int count;
    private String userId;

    public UserInfo()
    {
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = false;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = obj instanceof UserInfo;
        flag = false;
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        UserInfo userinfo = (UserInfo)obj;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        int i;
        int j;
        boolean flag5;
        if (userinfo.getUserId() == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (getUserId() == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        flag4 = flag2 ^ flag3;
        flag = false;
        if (flag4)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (userinfo.getUserId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
        flag5 = userinfo.getUserId().equals(getUserId());
        flag = false;
        if (!flag5) goto _L4; else goto _L3
_L3:
        i = userinfo.getCount();
        j = getCount();
        flag = false;
        if (i == j)
        {
            return true;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public int getCount()
    {
        return count;
    }

    public String getUserId()
    {
        return userId;
    }

    public int hashCode()
    {
        int i = 31 * super.hashCode();
        int j;
        if (getUserId() == null)
        {
            j = 0;
        } else
        {
            j = getUserId().hashCode();
        }
        return 31 * (j + i) + getCount();
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setUserId(String s)
    {
        userId = s;
    }
}
