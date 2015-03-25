// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import com.xiaomi.infra.galaxy.common.util.Base64Utils;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.xiaomi.infra.galaxy.common.auth:
//            Signer, GalaxyCredentials

public class MiSSOSigner
    implements Signer
{

    private static final MiSSOSigner miSSOSigner = new MiSSOSigner();

    private MiSSOSigner()
    {
    }

    public static MiSSOSigner getInstance()
    {
        return miSSOSigner;
    }

    private String signature(String s, String s1, TreeMap treemap, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s.toUpperCase());
        if (StringUtils.isNotBlank(s1))
        {
            stringbuilder.append("&").append(s1);
        }
        if (treemap != null && !treemap.isEmpty())
        {
            Iterator iterator = treemap.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s4 = (String)iterator.next();
                String s5 = (String)treemap.get(s4);
                if (!StringUtils.isBlank(s5))
                {
                    stringbuilder.append("&").append(s4).append("=").append(s5);
                }
            } while (true);
        }
        if (StringUtils.isNotBlank(s2))
        {
            stringbuilder.append("&").append(s2);
        }
        String s3;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA");
            messagedigest.update(stringbuilder.toString().getBytes());
            s3 = Base64Utils.encode(messagedigest.digest());
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return "";
        }
        return s3;
    }

    public void sign(BasicGalaxyRequest basicgalaxyrequest, GalaxyCredentials galaxycredentials)
    {
        String s;
        String s1;
        TreeMap treemap;
        if (StringUtils.isBlank(basicgalaxyrequest.getResourcePath()))
        {
            s = "/";
        } else
        {
            s = basicgalaxyrequest.getResourcePath();
        }
        s1 = galaxycredentials.getGalaxySecretKey();
        treemap = new TreeMap();
        treemap.putAll(basicgalaxyrequest.getParameters());
        basicgalaxyrequest.addParameter("signature", signature(basicgalaxyrequest.getHttpMethod().name(), s, treemap, s1));
    }

}
