// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class SerializableCookie
    implements Serializable
{

    private static final long serialVersionUID = 0x58765a8013aeb70cL;
    private final transient Cookie a;
    private transient BasicClientCookie b;

    public SerializableCookie(Cookie cookie)
    {
        a = cookie;
    }

    private void readObject(ObjectInputStream objectinputstream)
    {
        b = new BasicClientCookie((String)objectinputstream.readObject(), (String)objectinputstream.readObject());
        b.setComment((String)objectinputstream.readObject());
        b.setDomain((String)objectinputstream.readObject());
        b.setExpiryDate((Date)objectinputstream.readObject());
        b.setPath((String)objectinputstream.readObject());
        b.setVersion(objectinputstream.readInt());
        b.setSecure(objectinputstream.readBoolean());
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
    {
        objectoutputstream.writeObject(a.getName());
        objectoutputstream.writeObject(a.getValue());
        objectoutputstream.writeObject(a.getComment());
        objectoutputstream.writeObject(a.getDomain());
        objectoutputstream.writeObject(a.getExpiryDate());
        objectoutputstream.writeObject(a.getPath());
        objectoutputstream.writeInt(a.getVersion());
        objectoutputstream.writeBoolean(a.isSecure());
    }

    public Cookie getCookie()
    {
        Object obj = a;
        if (b != null)
        {
            obj = b;
        }
        return ((Cookie) (obj));
    }
}
