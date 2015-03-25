// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;


public final class  extends Enum
{

    private static final .VALUES $VALUES[];
    public static final .VALUES Count;
    public static final .VALUES Delete;
    public static final .VALUES DeleteAll;
    public static final .VALUES DeleteByKey;
    public static final .VALUES DeleteInTxArray;
    public static final .VALUES DeleteInTxIterable;
    public static final .VALUES Insert;
    public static final .VALUES InsertInTxArray;
    public static final .VALUES InsertInTxIterable;
    public static final .VALUES InsertOrReplace;
    public static final .VALUES InsertOrReplaceInTxArray;
    public static final .VALUES InsertOrReplaceInTxIterable;
    public static final .VALUES Load;
    public static final .VALUES LoadAll;
    public static final .VALUES QueryList;
    public static final .VALUES QueryUnique;
    public static final .VALUES Refresh;
    public static final .VALUES TransactionCallable;
    public static final .VALUES TransactionRunnable;
    public static final .VALUES Update;
    public static final .VALUES UpdateInTxArray;
    public static final .VALUES UpdateInTxIterable;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(de/greenrobot/dao/async/AsyncOperation$OperationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Insert = new <init>("Insert", 0);
        InsertInTxIterable = new <init>("InsertInTxIterable", 1);
        InsertInTxArray = new <init>("InsertInTxArray", 2);
        InsertOrReplace = new <init>("InsertOrReplace", 3);
        InsertOrReplaceInTxIterable = new <init>("InsertOrReplaceInTxIterable", 4);
        InsertOrReplaceInTxArray = new <init>("InsertOrReplaceInTxArray", 5);
        Update = new <init>("Update", 6);
        UpdateInTxIterable = new <init>("UpdateInTxIterable", 7);
        UpdateInTxArray = new <init>("UpdateInTxArray", 8);
        Delete = new <init>("Delete", 9);
        DeleteInTxIterable = new <init>("DeleteInTxIterable", 10);
        DeleteInTxArray = new <init>("DeleteInTxArray", 11);
        DeleteByKey = new <init>("DeleteByKey", 12);
        DeleteAll = new <init>("DeleteAll", 13);
        TransactionRunnable = new <init>("TransactionRunnable", 14);
        TransactionCallable = new <init>("TransactionCallable", 15);
        QueryList = new <init>("QueryList", 16);
        QueryUnique = new <init>("QueryUnique", 17);
        Load = new <init>("Load", 18);
        LoadAll = new <init>("LoadAll", 19);
        Count = new <init>("Count", 20);
        Refresh = new <init>("Refresh", 21);
        e_3B_.clone aclone[] = new <init>[22];
        aclone[0] = Insert;
        aclone[1] = InsertInTxIterable;
        aclone[2] = InsertInTxArray;
        aclone[3] = InsertOrReplace;
        aclone[4] = InsertOrReplaceInTxIterable;
        aclone[5] = InsertOrReplaceInTxArray;
        aclone[6] = Update;
        aclone[7] = UpdateInTxIterable;
        aclone[8] = UpdateInTxArray;
        aclone[9] = Delete;
        aclone[10] = DeleteInTxIterable;
        aclone[11] = DeleteInTxArray;
        aclone[12] = DeleteByKey;
        aclone[13] = DeleteAll;
        aclone[14] = TransactionRunnable;
        aclone[15] = TransactionCallable;
        aclone[16] = QueryList;
        aclone[17] = QueryUnique;
        aclone[18] = Load;
        aclone[19] = LoadAll;
        aclone[20] = Count;
        aclone[21] = Refresh;
        $VALUES = aclone;
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
