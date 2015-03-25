// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.model.BasePushItem;
import java.util.ArrayList;
import java.util.Iterator;

public class PushMsgManager
{

    private static PushMsgManager c = null;
    private ArrayList a;
    private ArrayList b;

    private PushMsgManager()
    {
        a = new ArrayList();
        b = new ArrayList();
    }

    public static PushMsgManager getInstance()
    {
        if (c == null)
        {
            c = new PushMsgManager();
        }
        return c;
    }

    public void addItem(BasePushItem basepushitem)
    {
        a.add(basepushitem);
        if (!basepushitem.hasRead)
        {
            b.add(basepushitem);
        }
    }

    public ArrayList getAllMsgs()
    {
        return a;
    }

    public ArrayList getUnReadMsgs()
    {
        return b;
    }

    public void setAllRead()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            ((BasePushItem)iterator.next()).hasRead = true;
        }

        a.addAll(b);
        b.clear();
    }

    public int sizeOfUnreadMsgs()
    {
        return b.size();
    }

}
