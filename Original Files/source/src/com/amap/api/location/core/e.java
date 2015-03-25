// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amap.api.location.core;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class e
{

    public e()
    {
    }

    static PublicKey a(Context context)
    {
        AssetManager assetmanager = context.getAssets();
        PublicKey publickey;
        InputStream inputstream = assetmanager.open("location_public_key.der");
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        KeyFactory keyfactory = KeyFactory.getInstance("RSA");
        Certificate certificate = certificatefactory.generateCertificate(inputstream);
        inputstream.close();
        publickey = keyfactory.generatePublic(new X509EncodedKeySpec(certificate.getPublicKey().getEncoded()));
        return publickey;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        throw new Exception("\u65E0\u6B64\u7B97\u6CD5");
        InvalidKeySpecException invalidkeyspecexception;
        invalidkeyspecexception;
        throw new Exception("\u516C\u94A5\u975E\u6CD5");
        NullPointerException nullpointerexception;
        nullpointerexception;
        throw new Exception("\u516C\u94A5\u6570\u636E\u4E3A\u7A7A");
        CertificateException certificateexception;
        certificateexception;
_L2:
        return null;
        IOException ioexception;
        ioexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static byte[] a(byte abyte0[], Key key)
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, key);
        return cipher.doFinal(abyte0);
    }

    static byte[] a(byte abyte0[], byte abyte1[])
    {
        byte abyte2[];
        try
        {
            SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretkeyspec);
            abyte2 = cipher.doFinal(abyte1);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        catch (NoSuchPaddingException nosuchpaddingexception)
        {
            nosuchpaddingexception.printStackTrace();
            return null;
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            return null;
        }
        return abyte2;
    }
}
