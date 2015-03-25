// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

// Referenced classes of package de.greenrobot.dao.async:
//            AsyncDaoException

public class AsyncOperation
{

    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    private volatile boolean completed;
    final AbstractDao dao;
    private final SQLiteDatabase database;
    final int flags;
    volatile int mergedOperationsCount;
    final Object parameter;
    volatile Object result;
    int sequenceNumber;
    volatile Throwable throwable;
    volatile long timeCompleted;
    volatile long timeStarted;
    final OperationType type;

    AsyncOperation(OperationType operationtype, SQLiteDatabase sqlitedatabase, Object obj, int i)
    {
        type = operationtype;
        database = sqlitedatabase;
        flags = i;
        dao = null;
        parameter = obj;
    }

    AsyncOperation(OperationType operationtype, AbstractDao abstractdao, Object obj, int i)
    {
        type = operationtype;
        flags = i;
        dao = abstractdao;
        database = null;
        parameter = obj;
    }

    SQLiteDatabase getDatabase()
    {
        if (database != null)
        {
            return database;
        } else
        {
            return dao.getDatabase();
        }
    }

    public long getDuration()
    {
        if (timeCompleted == 0L)
        {
            throw new DaoException("This operation did not yet complete");
        } else
        {
            return timeCompleted - timeStarted;
        }
    }

    public int getMergedOperationsCount()
    {
        return mergedOperationsCount;
    }

    public Object getParameter()
    {
        return parameter;
    }

    public Object getResult()
    {
        this;
        JVM INSTR monitorenter ;
        if (!completed)
        {
            waitForCompletion();
        }
        if (throwable != null)
        {
            throw new AsyncDaoException(this, throwable);
        }
        break MISSING_BLOCK_LABEL_39;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj = result;
        this;
        JVM INSTR monitorexit ;
        return obj;
    }

    public int getSequenceNumber()
    {
        return sequenceNumber;
    }

    public Throwable getThrowable()
    {
        return throwable;
    }

    public long getTimeCompleted()
    {
        return timeCompleted;
    }

    public long getTimeStarted()
    {
        return timeStarted;
    }

    public OperationType getType()
    {
        return type;
    }

    public boolean isCompleted()
    {
        return completed;
    }

    public boolean isCompletedSucessfully()
    {
        return completed && throwable == null;
    }

    public boolean isFailed()
    {
        return throwable != null;
    }

    public boolean isMergeTx()
    {
        return (1 & flags) != 0;
    }

    boolean isMergeableWith(AsyncOperation asyncoperation)
    {
        return asyncoperation != null && isMergeTx() && asyncoperation.isMergeTx() && getDatabase() == asyncoperation.getDatabase();
    }

    void reset()
    {
        timeStarted = 0L;
        timeCompleted = 0L;
        completed = false;
        throwable = null;
        result = null;
        mergedOperationsCount = 0;
    }

    void setCompleted()
    {
        this;
        JVM INSTR monitorenter ;
        completed = true;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setThrowable(Throwable throwable1)
    {
        throwable = throwable1;
    }

    public Object waitForCompletion()
    {
        this;
        JVM INSTR monitorenter ;
_L1:
        boolean flag = completed;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        wait();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        throw new DaoException("Interrupted while waiting for operation to complete", interruptedexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj = result;
        this;
        JVM INSTR monitorexit ;
        return obj;
    }

    public boolean waitForCompletion(int i)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = completed;
        long l;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        l = i;
        wait(l);
        boolean flag1 = completed;
        this;
        JVM INSTR monitorexit ;
        return flag1;
        InterruptedException interruptedexception;
        interruptedexception;
        throw new DaoException("Interrupted while waiting for operation to complete", interruptedexception);
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
