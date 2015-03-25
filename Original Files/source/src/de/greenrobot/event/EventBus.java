// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package de.greenrobot.event:
//            ThreadMode, HandlerPoster, BackgroundPoster, AsyncPoster, 
//            SubscriberMethodFinder, NoSubscriberEvent, SubscriberExceptionEvent, Subscription, 
//            SubscriberMethod, EventBusException, PendingPost

public final class EventBus
{

    private static int $SWITCH_TABLE$de$greenrobot$event$ThreadMode[];
    public static String TAG = "Event";
    private static volatile EventBus defaultInstance;
    private static final Map eventTypesCache = new HashMap();
    static ExecutorService executorService = Executors.newCachedThreadPool();
    private final AsyncPoster asyncPoster = new AsyncPoster(this);
    private final BackgroundPoster backgroundPoster = new BackgroundPoster(this);
    private final ThreadLocal currentThreadEventQueue = new _cls1();
    private final ThreadLocal currentThreadIsPosting = new _cls2();
    private String defaultMethodName;
    private boolean logSubscriberExceptions;
    private final HandlerPoster mainThreadPoster = new HandlerPoster(this, Looper.getMainLooper(), 10);
    private final Map stickyEvents = new ConcurrentHashMap();
    private boolean subscribed;
    private final SubscriberMethodFinder subscriberMethodFinder = new SubscriberMethodFinder();
    private final Map subscriptionsByEventType = new HashMap();
    private final Map typesBySubscriber = new HashMap();

    static int[] $SWITCH_TABLE$de$greenrobot$event$ThreadMode()
    {
        int ai[] = $SWITCH_TABLE$de$greenrobot$event$ThreadMode;
        if (ai != null)
        {
            return ai;
        }
        int ai1[] = new int[ThreadMode.values().length];
        try
        {
            ai1[ThreadMode.Async.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            ai1[ThreadMode.BackgroundThread.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            ai1[ThreadMode.MainThread.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            ai1[ThreadMode.PostThread.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SWITCH_TABLE$de$greenrobot$event$ThreadMode = ai1;
        return ai1;
    }

    public EventBus()
    {
        defaultMethodName = "onEvent";
        logSubscriberExceptions = true;
    }

    static void addInterfaces(List list, Class aclass[])
    {
        int i = aclass.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                return;
            }
            Class class1 = aclass[j];
            if (!list.contains(class1))
            {
                list.add(class1);
                addInterfaces(list, class1.getInterfaces());
            }
            j++;
        } while (true);
    }

    public static void clearCaches()
    {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static void clearSkipMethodNameVerifications()
    {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    private List findEventTypes(Class class1)
    {
        Map map = eventTypesCache;
        map;
        JVM INSTR monitorenter ;
        Object obj = (List)eventTypesCache.get(class1);
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = new ArrayList();
        Class class2 = class1;
_L6:
        if (class2 != null) goto _L4; else goto _L3
_L3:
        eventTypesCache.put(class1, obj);
_L2:
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj));
_L4:
        ((List) (obj)).add(class2);
        addInterfaces(((List) (obj)), class2.getInterfaces());
        class2 = class2.getSuperclass();
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static EventBus getDefault()
    {
        if (defaultInstance != null) goto _L2; else goto _L1
_L1:
        de/greenrobot/event/EventBus;
        JVM INSTR monitorenter ;
        if (defaultInstance == null)
        {
            defaultInstance = new EventBus();
        }
        de/greenrobot/event/EventBus;
        JVM INSTR monitorexit ;
_L2:
        return defaultInstance;
        Exception exception;
        exception;
        de/greenrobot/event/EventBus;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void postSingleEvent(Object obj, boolean flag)
    {
        Class class1;
        List list;
        int i;
        int j;
        boolean flag1;
        class1 = obj.getClass();
        list = findEventTypes(class1);
        i = list.size();
        j = 0;
        flag1 = false;
_L3:
        if (j >= i)
        {
            if (!flag1)
            {
                Log.d(TAG, (new StringBuilder("No subscripers registered for event ")).append(class1).toString());
                if (class1 != de/greenrobot/event/NoSubscriberEvent && class1 != de/greenrobot/event/SubscriberExceptionEvent)
                {
                    post(new NoSubscriberEvent(this, obj));
                }
            }
            return;
        }
        Class class2 = (Class)list.get(j);
        this;
        JVM INSTR monitorenter ;
        CopyOnWriteArrayList copyonwritearraylist = (CopyOnWriteArrayList)subscriptionsByEventType.get(class2);
        this;
        JVM INSTR monitorexit ;
        Iterator iterator;
        if (copyonwritearraylist == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        iterator = copyonwritearraylist.iterator();
_L4:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        boolean flag2 = true;
_L5:
        j++;
        flag1 = flag2;
          goto _L3
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        postToSubscription((Subscription)iterator.next(), obj, flag);
          goto _L4
        flag2 = flag1;
          goto _L5
    }

    private void postToSubscription(Subscription subscription, Object obj, boolean flag)
    {
        switch ($SWITCH_TABLE$de$greenrobot$event$ThreadMode()[subscription.subscriberMethod.threadMode.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unknown thread mode: ")).append(subscription.subscriberMethod.threadMode).toString());

        case 1: // '\001'
            invokeSubscriber(subscription, obj);
            return;

        case 2: // '\002'
            if (flag)
            {
                invokeSubscriber(subscription, obj);
                return;
            } else
            {
                mainThreadPoster.enqueue(subscription, obj);
                return;
            }

        case 3: // '\003'
            if (flag)
            {
                backgroundPoster.enqueue(subscription, obj);
                return;
            } else
            {
                invokeSubscriber(subscription, obj);
                return;
            }

        case 4: // '\004'
            asyncPoster.enqueue(subscription, obj);
            return;
        }
    }

    private void register(Object obj, String s, boolean flag)
    {
        Iterator iterator = subscriberMethodFinder.findSubscriberMethods(obj.getClass(), s).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            subscribe(obj, (SubscriberMethod)iterator.next(), flag);
        } while (true);
    }

    private transient void register(Object obj, String s, boolean flag, Class class1, Class aclass[])
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator;
        Class class2 = obj.getClass();
        iterator = subscriberMethodFinder.findSubscriberMethods(class2, s).iterator();
_L1:
        boolean flag1 = iterator.hasNext();
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        SubscriberMethod subscribermethod;
        subscribermethod = (SubscriberMethod)iterator.next();
        if (class1 != subscribermethod.eventType)
        {
            continue; /* Loop/switch isn't completed */
        }
        subscribe(obj, subscribermethod, flag);
          goto _L1
        Exception exception;
        exception;
        throw exception;
        if (aclass == null) goto _L1; else goto _L2
_L2:
        int i = aclass.length;
        int j = 0;
_L5:
        if (j >= i) goto _L1; else goto _L3
_L3:
label0:
        {
            if (aclass[j] != subscribermethod.eventType)
            {
                break label0;
            }
            subscribe(obj, subscribermethod, flag);
        }
        if (true) goto _L1; else goto _L4
_L4:
        j++;
          goto _L5
    }

    public static void skipMethodNameVerificationFor(Class class1)
    {
        SubscriberMethodFinder.skipMethodNameVerificationFor(class1);
    }

    private void subscribe(Object obj, SubscriberMethod subscribermethod, boolean flag)
    {
        Class class1;
        CopyOnWriteArrayList copyonwritearraylist;
        Subscription subscription;
        subscribed = true;
        class1 = subscribermethod.eventType;
        copyonwritearraylist = (CopyOnWriteArrayList)subscriptionsByEventType.get(class1);
        subscription = new Subscription(obj, subscribermethod);
        if (copyonwritearraylist != null) goto _L2; else goto _L1
_L1:
        copyonwritearraylist = new CopyOnWriteArrayList();
        subscriptionsByEventType.put(class1, copyonwritearraylist);
_L4:
        subscribermethod.method.setAccessible(true);
        copyonwritearraylist.add(subscription);
        Object obj1 = (List)typesBySubscriber.get(obj);
        if (obj1 == null)
        {
            obj1 = new ArrayList();
            typesBySubscriber.put(obj, obj1);
        }
        ((List) (obj1)).add(class1);
        if (flag)
        {
            Object obj2;
            synchronized (stickyEvents)
            {
                obj2 = stickyEvents.get(class1);
            }
            if (obj2 != null)
            {
                boolean flag1;
                Iterator iterator;
                if (Looper.getMainLooper() == Looper.myLooper())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                postToSubscription(subscription, obj2, flag1);
            }
        }
        return;
_L2:
        iterator = copyonwritearraylist.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (!((Subscription)iterator.next()).equals(subscription)) goto _L6; else goto _L5
_L5:
        throw new EventBusException((new StringBuilder("Subscriber ")).append(obj.getClass()).append(" already registered to event ").append(class1).toString());
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void unubscribeByEventType(Object obj, Class class1)
    {
        List list = (List)subscriptionsByEventType.get(class1);
        if (list == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        i = list.size();
        j = 0;
_L5:
        if (j < i) goto _L3; else goto _L2
_L2:
        return;
_L3:
        int k;
        int l;
        int i1;
        if (((Subscription)list.get(j)).subscriber == obj)
        {
            list.remove(j);
            k = j - 1;
            l = i - 1;
        } else
        {
            k = j;
            l = i;
        }
        i1 = k + 1;
        i = l;
        j = i1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void configureLogSubscriberExceptions(boolean flag)
    {
        if (subscribed)
        {
            throw new EventBusException("This method must be called before any registration");
        } else
        {
            logSubscriberExceptions = flag;
            return;
        }
    }

    public Object getStickyEvent(Class class1)
    {
        Object obj;
        synchronized (stickyEvents)
        {
            obj = stickyEvents.get(class1);
        }
        return obj;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void invokeSubscriber(PendingPost pendingpost)
    {
        Object obj = pendingpost.event;
        Subscription subscription = pendingpost.subscription;
        PendingPost.releasePendingPost(pendingpost);
        invokeSubscriber(subscription, obj);
    }

    void invokeSubscriber(Subscription subscription, Object obj)
    {
        try
        {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, new Object[] {
                obj
            });
            return;
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            Throwable throwable = invocationtargetexception.getCause();
            if (obj instanceof SubscriberExceptionEvent)
            {
                Log.e(TAG, (new StringBuilder("SubscriberExceptionEvent subscriber ")).append(subscription.subscriber.getClass()).append(" threw an exception").toString(), throwable);
                SubscriberExceptionEvent subscriberexceptionevent = (SubscriberExceptionEvent)obj;
                Log.e(TAG, (new StringBuilder("Initial event ")).append(subscriberexceptionevent.causingEvent).append(" caused exception in ").append(subscriberexceptionevent.causingSubscriber).toString(), subscriberexceptionevent.throwable);
                return;
            }
            if (logSubscriberExceptions)
            {
                Log.e(TAG, (new StringBuilder("Could not dispatch event: ")).append(obj.getClass()).append(" to subscribing class ").append(subscription.subscriber.getClass()).toString(), throwable);
            }
            post(new SubscriberExceptionEvent(this, throwable, obj, subscription.subscriber));
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new IllegalStateException("Unexpected exception", illegalaccessexception);
        }
    }

    public void post(Object obj)
    {
        List list;
        BooleanWrapper booleanwrapper;
        boolean flag;
        list = (List)currentThreadEventQueue.get();
        list.add(obj);
        booleanwrapper = (BooleanWrapper)currentThreadIsPosting.get();
        if (booleanwrapper.value)
        {
            return;
        }
        boolean flag1;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        booleanwrapper.value = true;
_L1:
        flag1 = list.isEmpty();
        if (flag1)
        {
            booleanwrapper.value = false;
            return;
        }
        postSingleEvent(list.remove(0), flag);
          goto _L1
        Exception exception;
        exception;
        booleanwrapper.value = false;
        throw exception;
    }

    public void postSticky(Object obj)
    {
        post(obj);
        synchronized (stickyEvents)
        {
            stickyEvents.put(obj.getClass(), obj);
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void register(Object obj)
    {
        register(obj, defaultMethodName, false);
    }

    public transient void register(Object obj, Class class1, Class aclass[])
    {
        register(obj, defaultMethodName, false, class1, aclass);
    }

    public void register(Object obj, String s)
    {
        register(obj, s, false);
    }

    public transient void register(Object obj, String s, Class class1, Class aclass[])
    {
        this;
        JVM INSTR monitorenter ;
        register(obj, s, false, class1, aclass);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void registerSticky(Object obj)
    {
        register(obj, defaultMethodName, true);
    }

    public transient void registerSticky(Object obj, Class class1, Class aclass[])
    {
        register(obj, defaultMethodName, true, class1, aclass);
    }

    public void registerSticky(Object obj, String s)
    {
        register(obj, s, true);
    }

    public transient void registerSticky(Object obj, String s, Class class1, Class aclass[])
    {
        this;
        JVM INSTR monitorenter ;
        register(obj, s, true, class1, aclass);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public Object removeStickyEvent(Class class1)
    {
        Object obj;
        synchronized (stickyEvents)
        {
            obj = stickyEvents.remove(class1);
        }
        return obj;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean removeStickyEvent(Object obj)
    {
        Map map = stickyEvents;
        map;
        JVM INSTR monitorenter ;
        Class class1 = obj.getClass();
        if (!obj.equals(stickyEvents.get(class1)))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        stickyEvents.remove(class1);
        return true;
        map;
        JVM INSTR monitorexit ;
        return false;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void unregister(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        List list = (List)typesBySubscriber.get(obj);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Iterator iterator = list.iterator();
_L3:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        typesBySubscriber.remove(obj);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        unubscribeByEventType(obj, (Class)iterator.next());
          goto _L3
        Exception exception;
        exception;
        throw exception;
        Log.w(TAG, (new StringBuilder("Subscriber to unregister was not registered before: ")).append(obj.getClass()).toString());
          goto _L4
    }

    public transient void unregister(Object obj, Class aclass[])
    {
        this;
        JVM INSTR monitorenter ;
        if (aclass.length == 0)
        {
            throw new IllegalArgumentException("Provide at least one event class");
        }
        break MISSING_BLOCK_LABEL_23;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        List list = (List)typesBySubscriber.get(obj);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        int i = aclass.length;
        int j = 0;
_L3:
        if (j < i) goto _L2; else goto _L1
_L1:
        if (list.isEmpty())
        {
            typesBySubscriber.remove(obj);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Class class1 = aclass[j];
        unubscribeByEventType(obj, class1);
        list.remove(class1);
        j++;
          goto _L3
        Log.w(TAG, (new StringBuilder("Subscriber to unregister was not registered before: ")).append(obj.getClass()).toString());
          goto _L4
    }


    private class _cls1 extends ThreadLocal
    {

        final EventBus this$0;

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected List initialValue()
        {
            return new ArrayList();
        }

        _cls1()
        {
            this$0 = EventBus.this;
            super();
        }
    }


    private class _cls2 extends ThreadLocal
    {

        final EventBus this$0;

        protected BooleanWrapper initialValue()
        {
            return new BooleanWrapper();
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        _cls2()
        {
            this$0 = EventBus.this;
            super();
        }
    }


    private class BooleanWrapper
    {

        boolean value;

        BooleanWrapper()
        {
        }
    }

}
