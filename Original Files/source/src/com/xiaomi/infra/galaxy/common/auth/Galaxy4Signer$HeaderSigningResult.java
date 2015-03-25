// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;


// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            Galaxy4Signer

public class signature
{

    private String dateTime;
    private byte kSigning[];
    private String scope;
    private byte signature[];
    final Galaxy4Signer this$0;

    public String getDateTime()
    {
        return dateTime;
    }

    public byte[] getKSigning()
    {
        byte abyte0[] = new byte[kSigning.length];
        System.arraycopy(kSigning, 0, abyte0, 0, kSigning.length);
        return abyte0;
    }

    public String getScope()
    {
        return scope;
    }

    public byte[] getSignature()
    {
        byte abyte0[] = new byte[signature.length];
        System.arraycopy(signature, 0, abyte0, 0, signature.length);
        return abyte0;
    }

    public (String s, String s1, byte abyte0[], byte abyte1[])
    {
        this$0 = Galaxy4Signer.this;
        super();
        dateTime = s;
        scope = s1;
        kSigning = abyte0;
        signature = abyte1;
    }
}
