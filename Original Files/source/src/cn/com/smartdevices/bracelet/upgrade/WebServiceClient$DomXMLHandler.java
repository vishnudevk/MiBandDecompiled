// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.upgrade;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class I
{

    private DocumentBuilder a;

    private DocumentBuilder a()
    {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    public Element parseXml(InputStream inputstream)
    {
        Element element;
        try
        {
            if (a == null)
            {
                a = a();
            }
            element = a.parse(new BufferedInputStream(inputstream)).getDocumentElement();
        }
        catch (ParserConfigurationException parserconfigurationexception)
        {
            parserconfigurationexception.printStackTrace();
            return null;
        }
        catch (SAXException saxexception)
        {
            saxexception.printStackTrace();
            return null;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return null;
        }
        return element;
    }

    public I()
    {
    }
}
