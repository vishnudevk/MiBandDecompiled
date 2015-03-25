// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;


// Referenced classes of package de.greenrobot.event:
//            SubscriberMethod

final class Subscription
{

    final Object subscriber;
    final SubscriberMethod subscriberMethod;

    Subscription(Object obj, SubscriberMethod subscribermethod)
    {
        subscriber = obj;
        subscriberMethod = subscribermethod;
    }

    public boolean equals(Object obj)
    {
        boolean flag = obj instanceof Subscription;
        boolean flag1 = false;
        if (flag)
        {
            Subscription subscription = (Subscription)obj;
            Object obj1 = subscriber;
            Object obj2 = subscription.subscriber;
            flag1 = false;
            if (obj1 == obj2)
            {
                boolean flag2 = subscriberMethod.equals(subscription.subscriberMethod);
                flag1 = false;
                if (flag2)
                {
                    flag1 = true;
                }
            }
        }
        return flag1;
    }

    public int hashCode()
    {
        return subscriber.hashCode() + subscriberMethod.methodString.hashCode();
    }
}
