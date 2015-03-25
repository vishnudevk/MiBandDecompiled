// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;

import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.query.Query;
import java.util.concurrent.Callable;

// Referenced classes of package de.greenrobot.dao.async:
//            AsyncOperationExecutor, AsyncOperation, AsyncOperationListener

public class AsyncSession
{

    private final AbstractDaoSession daoSession;
    private final AsyncOperationExecutor executor = new AsyncOperationExecutor();

    public AsyncSession(AbstractDaoSession abstractdaosession)
    {
        daoSession = abstractdaosession;
    }

    private AsyncOperation enqueEntityOperation(AsyncOperation.OperationType operationtype, Class class1, Object obj, int i)
    {
        AsyncOperation asyncoperation = new AsyncOperation(operationtype, daoSession.getDao(class1), obj, i);
        executor.enqueue(asyncoperation);
        return asyncoperation;
    }

    private AsyncOperation enqueueDatabaseOperation(AsyncOperation.OperationType operationtype, Object obj, int i)
    {
        AsyncOperation asyncoperation = new AsyncOperation(operationtype, daoSession.getDatabase(), obj, i);
        executor.enqueue(asyncoperation);
        return asyncoperation;
    }

    private AsyncOperation enqueueEntityOperation(AsyncOperation.OperationType operationtype, Object obj, int i)
    {
        return enqueEntityOperation(operationtype, obj.getClass(), obj, i);
    }

    public AsyncOperation callInTx(Callable callable)
    {
        return callInTx(callable, 0);
    }

    public AsyncOperation callInTx(Callable callable, int i)
    {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionCallable, callable, i);
    }

    public AsyncOperation count(Class class1)
    {
        return count(class1, 0);
    }

    public AsyncOperation count(Class class1, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.Count, class1, null, i);
    }

    public AsyncOperation delete(Object obj)
    {
        return delete(obj, 0);
    }

    public AsyncOperation delete(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.Delete, obj, i);
    }

    public AsyncOperation deleteAll(Class class1)
    {
        return deleteAll(class1, 0);
    }

    public AsyncOperation deleteAll(Class class1, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteAll, class1, null, i);
    }

    public AsyncOperation deleteByKey(Object obj)
    {
        return deleteByKey(obj, 0);
    }

    public AsyncOperation deleteByKey(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.DeleteByKey, obj, i);
    }

    public transient AsyncOperation deleteInTx(Class class1, int i, Object aobj[])
    {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxArray, class1, ((Object) (aobj)), i);
    }

    public AsyncOperation deleteInTx(Class class1, Iterable iterable)
    {
        return deleteInTx(class1, iterable, 0);
    }

    public AsyncOperation deleteInTx(Class class1, Iterable iterable, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.DeleteInTxIterable, class1, iterable, i);
    }

    public transient AsyncOperation deleteInTx(Class class1, Object aobj[])
    {
        return deleteInTx(class1, 0, aobj);
    }

    public AsyncOperationListener getListener()
    {
        return executor.getListener();
    }

    public AsyncOperationListener getListenerMainThread()
    {
        return executor.getListenerMainThread();
    }

    public int getMaxOperationCountToMerge()
    {
        return executor.getMaxOperationCountToMerge();
    }

    public int getWaitForMergeMillis()
    {
        return executor.getWaitForMergeMillis();
    }

    public AsyncOperation insert(Object obj)
    {
        return insert(obj, 0);
    }

    public AsyncOperation insert(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.Insert, obj, i);
    }

    public transient AsyncOperation insertInTx(Class class1, int i, Object aobj[])
    {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxArray, class1, ((Object) (aobj)), i);
    }

    public AsyncOperation insertInTx(Class class1, Iterable iterable)
    {
        return insertInTx(class1, iterable, 0);
    }

    public AsyncOperation insertInTx(Class class1, Iterable iterable, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertInTxIterable, class1, iterable, i);
    }

    public transient AsyncOperation insertInTx(Class class1, Object aobj[])
    {
        return insertInTx(class1, 0, aobj);
    }

    public AsyncOperation insertOrReplace(Object obj)
    {
        return insertOrReplace(obj, 0);
    }

    public AsyncOperation insertOrReplace(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.InsertOrReplace, obj, i);
    }

    public transient AsyncOperation insertOrReplaceInTx(Class class1, int i, Object aobj[])
    {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxArray, class1, ((Object) (aobj)), i);
    }

    public AsyncOperation insertOrReplaceInTx(Class class1, Iterable iterable)
    {
        return insertOrReplaceInTx(class1, iterable, 0);
    }

    public AsyncOperation insertOrReplaceInTx(Class class1, Iterable iterable, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, class1, iterable, i);
    }

    public transient AsyncOperation insertOrReplaceInTx(Class class1, Object aobj[])
    {
        return insertOrReplaceInTx(class1, 0, aobj);
    }

    public boolean isCompleted()
    {
        return executor.isCompleted();
    }

    public AsyncOperation load(Class class1, Object obj)
    {
        return load(class1, obj, 0);
    }

    public AsyncOperation load(Class class1, Object obj, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.Load, class1, obj, i);
    }

    public AsyncOperation loadAll(Class class1)
    {
        return loadAll(class1, 0);
    }

    public AsyncOperation loadAll(Class class1, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.LoadAll, class1, null, i);
    }

    public AsyncOperation queryList(Query query)
    {
        return queryList(query, 0);
    }

    public AsyncOperation queryList(Query query, int i)
    {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryList, query, i);
    }

    public AsyncOperation queryUnique(Query query)
    {
        return queryUnique(query, 0);
    }

    public AsyncOperation queryUnique(Query query, int i)
    {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.QueryUnique, query, i);
    }

    public AsyncOperation refresh(Object obj)
    {
        return refresh(obj, 0);
    }

    public AsyncOperation refresh(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.Refresh, obj, i);
    }

    public AsyncOperation runInTx(Runnable runnable)
    {
        return runInTx(runnable, 0);
    }

    public AsyncOperation runInTx(Runnable runnable, int i)
    {
        return enqueueDatabaseOperation(AsyncOperation.OperationType.TransactionRunnable, runnable, i);
    }

    public void setListener(AsyncOperationListener asyncoperationlistener)
    {
        executor.setListener(asyncoperationlistener);
    }

    public void setListenerMainThread(AsyncOperationListener asyncoperationlistener)
    {
        executor.setListenerMainThread(asyncoperationlistener);
    }

    public void setMaxOperationCountToMerge(int i)
    {
        executor.setMaxOperationCountToMerge(i);
    }

    public void setWaitForMergeMillis(int i)
    {
        executor.setWaitForMergeMillis(i);
    }

    public AsyncOperation update(Object obj)
    {
        return update(obj, 0);
    }

    public AsyncOperation update(Object obj, int i)
    {
        return enqueueEntityOperation(AsyncOperation.OperationType.Update, obj, i);
    }

    public transient AsyncOperation updateInTx(Class class1, int i, Object aobj[])
    {
        return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxArray, class1, ((Object) (aobj)), i);
    }

    public AsyncOperation updateInTx(Class class1, Iterable iterable)
    {
        return updateInTx(class1, iterable, 0);
    }

    public AsyncOperation updateInTx(Class class1, Iterable iterable, int i)
    {
        return enqueEntityOperation(AsyncOperation.OperationType.UpdateInTxIterable, class1, iterable, i);
    }

    public transient AsyncOperation updateInTx(Class class1, Object aobj[])
    {
        return updateInTx(class1, 0, aobj);
    }

    public void waitForCompletion()
    {
        executor.waitForCompletion();
    }

    public boolean waitForCompletion(int i)
    {
        return executor.waitForCompletion(i);
    }
}
