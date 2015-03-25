// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.dao.async;


class ype
{

    static final int $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[];

    static 
    {
        $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType = new int[ype.values().length];
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Delete.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.DeleteInTxIterable.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.DeleteInTxArray.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Insert.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.InsertInTxIterable.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.InsertInTxArray.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.InsertOrReplace.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.InsertOrReplaceInTxIterable.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.InsertOrReplaceInTxArray.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Update.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.UpdateInTxIterable.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.UpdateInTxArray.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.TransactionRunnable.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.TransactionCallable.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.QueryList.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.QueryUnique.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.DeleteByKey.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.DeleteAll.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Load.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.LoadAll.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Count.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            $SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[ype.Refresh.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror21)
        {
            return;
        }
    }
}
