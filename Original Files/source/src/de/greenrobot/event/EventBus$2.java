// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


// Referenced classes of package de.greenrobot.event:
//            EventBus

class this._cls0 extends ThreadLocal
{

    final EventBus this$0;

    protected oleanWrapper initialValue()
    {
        return new oleanWrapper();
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    oleanWrapper()
    {
        this$0 = EventBus.this;
        super();
    }
}
