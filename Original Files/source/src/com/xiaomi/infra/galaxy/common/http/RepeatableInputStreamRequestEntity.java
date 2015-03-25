// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

public class RepeatableInputStreamRequestEntity extends BasicHttpEntity
{

    private static final Log log = LogFactory.getLog(com/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity);
    private InputStream content;
    private boolean firstAttempt;
    private InputStreamEntity inputStreamRequestEntity;
    private IOException originalException;

    public RepeatableInputStreamRequestEntity(BasicGalaxyRequest basicgalaxyrequest)
    {
        long l;
        firstAttempt = true;
        setChunked(false);
        l = -1L;
        String s1 = (String)basicgalaxyrequest.getHeaders().get("Content-Length");
        if (s1 == null) goto _L2; else goto _L1
_L1:
        long l1 = Long.parseLong(s1);
        long l2 = l1;
_L5:
        l = l2;
_L3:
        String s = (String)basicgalaxyrequest.getHeaders().get("Content-Type");
        inputStreamRequestEntity = new InputStreamEntity(basicgalaxyrequest.getContent(), l);
        inputStreamRequestEntity.setContentType(s);
        content = basicgalaxyrequest.getContent();
        setContent(content);
        setContentType(s);
        setContentLength(l);
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        if (true) goto _L3; else goto _L2
_L2:
        l2 = l;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isChunked()
    {
        return false;
    }

    public boolean isRepeatable()
    {
        return content.markSupported() || inputStreamRequestEntity.isRepeatable();
    }

    public void writeTo(OutputStream outputstream)
    {
        try
        {
            if (!firstAttempt && isRepeatable())
            {
                content.reset();
            }
            firstAttempt = false;
            inputStreamRequestEntity.writeTo(outputstream);
            return;
        }
        catch (IOException ioexception)
        {
            if (originalException == null)
            {
                originalException = ioexception;
            }
        }
        throw originalException;
    }

}
