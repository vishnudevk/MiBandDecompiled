// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.query.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package de.greenrobot.dao.async:
//            AsyncOperation, AsyncOperationListener

class AsyncOperationExecutor
    implements android.os.Handler.Callback, Runnable
{

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private int countOperationsCompleted;
    private int countOperationsEnqueued;
    private volatile boolean executorRunning;
    private Handler handlerMainThread;
    private int lastSequenceNumber;
    private volatile AsyncOperationListener listener;
    private volatile AsyncOperationListener listenerMainThread;
    private volatile int maxOperationCountToMerge;
    private final BlockingQueue queue = new LinkedBlockingQueue();
    private volatile int waitForMergeMillis;

    AsyncOperationExecutor()
    {
        maxOperationCountToMerge = 50;
        waitForMergeMillis = 50;
    }

    private void executeOperation(AsyncOperation asyncoperation)
    {
        asyncoperation.timeStarted = System.currentTimeMillis();
        _cls1..SwitchMap.de.greenrobot.dao.async.AsyncOperation.OperationType[asyncoperation.type.ordinal()];
        JVM INSTR tableswitch 1 22: default 120
    //                   1 164
    //                   2 178
    //                   3 195
    //                   4 215
    //                   5 230
    //                   6 247
    //                   7 267
    //                   8 282
    //                   9 299
    //                   10 319
    //                   11 333
    //                   12 350
    //                   13 370
    //                   14 378
    //                   15 386
    //                   16 403
    //                   17 420
    //                   18 434
    //                   19 444
    //                   20 462
    //                   21 476
    //                   22 493;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23
_L23:
        break MISSING_BLOCK_LABEL_493;
_L1:
        Throwable throwable;
        throw new DaoException((new StringBuilder()).append("Unsupported operation: ").append(asyncoperation.type).toString());
_L24:
        asyncoperation.timeCompleted = System.currentTimeMillis();
        return;
_L2:
        try
        {
            asyncoperation.dao.delete(asyncoperation.parameter);
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            asyncoperation.throwable = throwable;
        }
          goto _L24
_L3:
        asyncoperation.dao.deleteInTx((Iterable)asyncoperation.parameter);
          goto _L24
_L4:
        asyncoperation.dao.deleteInTx((Object[])(Object[])asyncoperation.parameter);
          goto _L24
_L5:
        asyncoperation.dao.insert(asyncoperation.parameter);
          goto _L24
_L6:
        asyncoperation.dao.insertInTx((Iterable)asyncoperation.parameter);
          goto _L24
_L7:
        asyncoperation.dao.insertInTx((Object[])(Object[])asyncoperation.parameter);
          goto _L24
_L8:
        asyncoperation.dao.insertOrReplace(asyncoperation.parameter);
          goto _L24
_L9:
        asyncoperation.dao.insertOrReplaceInTx((Iterable)asyncoperation.parameter);
          goto _L24
_L10:
        asyncoperation.dao.insertOrReplaceInTx((Object[])(Object[])asyncoperation.parameter);
          goto _L24
_L11:
        asyncoperation.dao.update(asyncoperation.parameter);
          goto _L24
_L12:
        asyncoperation.dao.updateInTx((Iterable)asyncoperation.parameter);
          goto _L24
_L13:
        asyncoperation.dao.updateInTx((Object[])(Object[])asyncoperation.parameter);
          goto _L24
_L14:
        executeTransactionRunnable(asyncoperation);
          goto _L24
_L15:
        executeTransactionCallable(asyncoperation);
          goto _L24
_L16:
        asyncoperation.result = ((Query)asyncoperation.parameter).list();
          goto _L24
_L17:
        asyncoperation.result = ((Query)asyncoperation.parameter).unique();
          goto _L24
_L18:
        asyncoperation.dao.deleteByKey(asyncoperation.parameter);
          goto _L24
_L19:
        asyncoperation.dao.deleteAll();
          goto _L24
_L20:
        asyncoperation.result = asyncoperation.dao.load(asyncoperation.parameter);
          goto _L24
_L21:
        asyncoperation.result = asyncoperation.dao.loadAll();
          goto _L24
_L22:
        asyncoperation.result = Long.valueOf(asyncoperation.dao.count());
          goto _L24
        asyncoperation.dao.refresh(asyncoperation.parameter);
          goto _L24
    }

    private void executeOperationAndPostCompleted(AsyncOperation asyncoperation)
    {
        executeOperation(asyncoperation);
        handleOperationCompleted(asyncoperation);
    }

    private void executeTransactionCallable(AsyncOperation asyncoperation)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = asyncoperation.getDatabase();
        sqlitedatabase.beginTransaction();
        asyncoperation.result = ((Callable)asyncoperation.parameter).call();
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    private void executeTransactionRunnable(AsyncOperation asyncoperation)
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = asyncoperation.getDatabase();
        sqlitedatabase.beginTransaction();
        ((Runnable)asyncoperation.parameter).run();
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    private void handleOperationCompleted(AsyncOperation asyncoperation)
    {
        asyncoperation.setCompleted();
        AsyncOperationListener asyncoperationlistener = listener;
        if (asyncoperationlistener != null)
        {
            asyncoperationlistener.onAsyncOperationCompleted(asyncoperation);
        }
        if (listenerMainThread != null)
        {
            if (handlerMainThread == null)
            {
                handlerMainThread = new Handler(Looper.getMainLooper(), this);
            }
            Message message = handlerMainThread.obtainMessage(1, asyncoperation);
            handlerMainThread.sendMessage(message);
        }
        this;
        JVM INSTR monitorenter ;
        countOperationsCompleted = 1 + countOperationsCompleted;
        if (countOperationsCompleted == countOperationsEnqueued)
        {
            notifyAll();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void mergeTxAndExecute(AsyncOperation asyncoperation, AsyncOperation asyncoperation1)
    {
        ArrayList arraylist;
        SQLiteDatabase sqlitedatabase;
        int i;
        arraylist = new ArrayList();
        arraylist.add(asyncoperation);
        arraylist.add(asyncoperation1);
        sqlitedatabase = asyncoperation.getDatabase();
        sqlitedatabase.beginTransaction();
        i = 0;
_L6:
        if (i >= arraylist.size()) goto _L2; else goto _L1
_L1:
        AsyncOperation asyncoperation4;
        boolean flag1;
        asyncoperation4 = (AsyncOperation)arraylist.get(i);
        executeOperation(asyncoperation4);
        flag1 = asyncoperation4.isFailed();
        boolean flag;
        if (flag1)
        {
            flag = true;
            break MISSING_BLOCK_LABEL_75;
        }
        if (i != -1 + arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        asyncoperation5 = (AsyncOperation)queue.peek();
        if (i >= maxOperationCountToMerge || !asyncoperation4.isMergeableWith(asyncoperation5))
        {
            break MISSING_BLOCK_LABEL_230;
        }
        asyncoperation6 = (AsyncOperation)queue.remove();
        if (asyncoperation6 == asyncoperation5)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        throw new DaoException("Internal error: peeked op did not match removed op");
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
        arraylist.add(asyncoperation6);
        break; /* Loop/switch isn't completed */
        sqlitedatabase.setTransactionSuccessful();
        break; /* Loop/switch isn't completed */
_L4:
        sqlitedatabase.endTransaction();
        Exception exception;
        AsyncOperation asyncoperation5;
        AsyncOperation asyncoperation6;
        if (flag)
        {
            DaoLog.i("Revered merged transaction because one of the operations failed. Executing operations one by one instead...");
            AsyncOperation asyncoperation3;
            for (Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); executeOperationAndPostCompleted(asyncoperation3))
            {
                asyncoperation3 = (AsyncOperation)iterator1.next();
                asyncoperation3.reset();
            }

        } else
        {
            int j = arraylist.size();
            AsyncOperation asyncoperation2;
            for (Iterator iterator = arraylist.iterator(); iterator.hasNext(); handleOperationCompleted(asyncoperation2))
            {
                asyncoperation2 = (AsyncOperation)iterator.next();
                asyncoperation2.mergedOperationsCount = j;
            }

        }
        return;
_L2:
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void enqueue(AsyncOperation asyncoperation)
    {
        this;
        JVM INSTR monitorenter ;
        int i = 1 + lastSequenceNumber;
        lastSequenceNumber = i;
        asyncoperation.sequenceNumber = i;
        queue.add(asyncoperation);
        countOperationsEnqueued = 1 + countOperationsEnqueued;
        if (!executorRunning)
        {
            executorRunning = true;
            executorService.execute(this);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public AsyncOperationListener getListener()
    {
        return listener;
    }

    public AsyncOperationListener getListenerMainThread()
    {
        return listenerMainThread;
    }

    public int getMaxOperationCountToMerge()
    {
        return maxOperationCountToMerge;
    }

    public int getWaitForMergeMillis()
    {
        return waitForMergeMillis;
    }

    public boolean handleMessage(Message message)
    {
        AsyncOperationListener asyncoperationlistener = listenerMainThread;
        if (asyncoperationlistener != null)
        {
            asyncoperationlistener.onAsyncOperationCompleted((AsyncOperation)message.obj);
        }
        return false;
    }

    public boolean isCompleted()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = countOperationsEnqueued;
        j = countOperationsCompleted;
        boolean flag;
        if (i == j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void run()
    {
_L1:
        AsyncOperation asyncoperation = (AsyncOperation)queue.poll(1L, TimeUnit.SECONDS);
        if (asyncoperation != null)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        this;
        JVM INSTR monitorenter ;
        AsyncOperation asyncoperation1 = (AsyncOperation)queue.poll();
        if (asyncoperation1 != null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        executorRunning = false;
        this;
        JVM INSTR monitorexit ;
        executorRunning = false;
        return;
        this;
        JVM INSTR monitorexit ;
        AsyncOperation asyncoperation2 = asyncoperation1;
_L2:
        AsyncOperation asyncoperation3;
        if (!asyncoperation2.isMergeTx())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        asyncoperation3 = (AsyncOperation)queue.poll(waitForMergeMillis, TimeUnit.MILLISECONDS);
        if (asyncoperation3 == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (!asyncoperation2.isMergeableWith(asyncoperation3))
        {
            break MISSING_BLOCK_LABEL_171;
        }
        mergeTxAndExecute(asyncoperation2, asyncoperation3);
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        DaoLog.w((new StringBuilder()).append(Thread.currentThread().getName()).append(" was interruppted").toString(), interruptedexception);
        executorRunning = false;
        return;
        Exception exception1;
        exception1;
        this;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        executorRunning = false;
        throw exception;
        executeOperationAndPostCompleted(asyncoperation2);
        executeOperationAndPostCompleted(asyncoperation3);
          goto _L1
        executeOperationAndPostCompleted(asyncoperation2);
          goto _L1
        asyncoperation2 = asyncoperation;
          goto _L2
    }

    public void setListener(AsyncOperationListener asyncoperationlistener)
    {
        listener = asyncoperationlistener;
    }

    public void setListenerMainThread(AsyncOperationListener asyncoperationlistener)
    {
        listenerMainThread = asyncoperationlistener;
    }

    public void setMaxOperationCountToMerge(int i)
    {
        maxOperationCountToMerge = i;
    }

    public void setWaitForMergeMillis(int i)
    {
        waitForMergeMillis = i;
    }

    public void waitForCompletion()
    {
        this;
        JVM INSTR monitorenter ;
_L1:
        boolean flag = isCompleted();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        wait();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        throw new DaoException("Interrupted while waiting for all operations to complete", interruptedexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public boolean waitForCompletion(int i)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = isCompleted();
        long l;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l = i;
        wait(l);
        boolean flag1 = isCompleted();
        this;
        JVM INSTR monitorexit ;
        return flag1;
        InterruptedException interruptedexception;
        interruptedexception;
        throw new DaoException("Interrupted while waiting for all operations to complete", interruptedexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }


    private class _cls1
    {

        static final int $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[];

        static 
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType = new int[AsyncOperation.OperationType.values().length];
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Delete.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxIterable.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteInTxArray.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Insert.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxIterable.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertInTxArray.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplace.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxIterable.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.InsertOrReplaceInTxArray.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Update.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxIterable.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.UpdateInTxArray.ordinal()] = 12;
            }
            catch (NoSuchFieldError nosuchfielderror11) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionRunnable.ordinal()] = 13;
            }
            catch (NoSuchFieldError nosuchfielderror12) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.TransactionCallable.ordinal()] = 14;
            }
            catch (NoSuchFieldError nosuchfielderror13) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryList.ordinal()] = 15;
            }
            catch (NoSuchFieldError nosuchfielderror14) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.QueryUnique.ordinal()] = 16;
            }
            catch (NoSuchFieldError nosuchfielderror15) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteByKey.ordinal()] = 17;
            }
            catch (NoSuchFieldError nosuchfielderror16) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.DeleteAll.ordinal()] = 18;
            }
            catch (NoSuchFieldError nosuchfielderror17) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Load.ordinal()] = 19;
            }
            catch (NoSuchFieldError nosuchfielderror18) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.LoadAll.ordinal()] = 20;
            }
            catch (NoSuchFieldError nosuchfielderror19) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Count.ordinal()] = 21;
            }
            catch (NoSuchFieldError nosuchfielderror20) { }
            try
            {
                $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[AsyncOperation.OperationType.Refresh.ordinal()] = 22;
            }
            catch (NoSuchFieldError nosuchfielderror21)
            {
                return;
            }
        }
    }

}
