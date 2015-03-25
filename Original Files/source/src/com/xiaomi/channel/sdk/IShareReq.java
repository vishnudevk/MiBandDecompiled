// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.channel.sdk;

import android.os.Bundle;

// Referenced classes of package com.xiaomi.channel.sdk:
//            MLExtraInfo

public interface IShareReq
{

    public abstract MLExtraInfo getJumpBackInfo();

    public abstract void parseFromBundle(Bundle bundle);

    public abstract Bundle toBundle();
}
