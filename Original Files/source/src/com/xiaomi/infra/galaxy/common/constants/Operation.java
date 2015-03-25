// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.infra.galaxy.common.constants;


public final class Operation extends Enum
{

    private static final Operation $VALUES[];
    public static final Operation AlterAppInfo;
    public static final Operation AlterTable;
    public static final Operation Auth;
    public static final Operation Batch;
    public static final Operation CreateTable;
    public static final Operation Delete;
    public static final Operation DeleteTable;
    public static final Operation DescribeTable;
    public static final Operation Get;
    public static final Operation GetAppInfo;
    public static final Operation Scan;
    public static final Operation ScanAppUser;
    public static final Operation Set;
    public static final Operation ShowTables;
    private String value;

    private Operation(String s, int i, String s1)
    {
        super(s, i);
        value = s1;
    }

    public static Operation fromValue(String s)
    {
        if (s == null || "".equals(s))
        {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if ("CreateTable".equals(s))
        {
            return CreateTable;
        }
        if ("DeleteTable".equals(s))
        {
            return DeleteTable;
        }
        if ("DescribeTable".equals(s))
        {
            return DescribeTable;
        }
        if ("Get".equals(s))
        {
            return Get;
        }
        if ("Set".equals(s))
        {
            return Set;
        }
        if ("Scan".equals(s))
        {
            return Scan;
        }
        if ("Delete".equals(s))
        {
            return Delete;
        }
        if ("Batch".equals(s))
        {
            return Batch;
        }
        if ("Auth".equals(s))
        {
            return Auth;
        }
        if ("ShowTables".equals(s))
        {
            return ShowTables;
        }
        if ("AlterTable".equals(s))
        {
            return AlterTable;
        }
        if ("GetAppInfo".equals(s))
        {
            return GetAppInfo;
        }
        if ("AlterAppInfo".equals(s))
        {
            return AlterAppInfo;
        }
        if ("ScanAppUser".equals(s))
        {
            return ScanAppUser;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot create enum from ").append(s).append(" value!").toString());
        }
    }

    public static Operation valueOf(String s)
    {
        return (Operation)Enum.valueOf(com/xiaomi/infra/galaxy/common/constants/Operation, s);
    }

    public static Operation[] values()
    {
        return (Operation[])$VALUES.clone();
    }

    public String toString()
    {
        return value;
    }

    static 
    {
        CreateTable = new Operation("CreateTable", 0, "CreateTable");
        DeleteTable = new Operation("DeleteTable", 1, "DeleteTable");
        DescribeTable = new Operation("DescribeTable", 2, "DescribeTable");
        Get = new Operation("Get", 3, "Get");
        Set = new Operation("Set", 4, "Set");
        Scan = new Operation("Scan", 5, "Scan");
        Delete = new Operation("Delete", 6, "Delete");
        Batch = new Operation("Batch", 7, "Batch");
        Auth = new Operation("Auth", 8, "Auth");
        ShowTables = new Operation("ShowTables", 9, "ShowTables");
        AlterTable = new Operation("AlterTable", 10, "AlterTable");
        AlterAppInfo = new Operation("AlterAppInfo", 11, "AlterAppInfo");
        GetAppInfo = new Operation("GetAppInfo", 12, "GetAppInfo");
        ScanAppUser = new Operation("ScanAppUser", 13, "ScanAppUser");
        Operation aoperation[] = new Operation[14];
        aoperation[0] = CreateTable;
        aoperation[1] = DeleteTable;
        aoperation[2] = DescribeTable;
        aoperation[3] = Get;
        aoperation[4] = Set;
        aoperation[5] = Scan;
        aoperation[6] = Delete;
        aoperation[7] = Batch;
        aoperation[8] = Auth;
        aoperation[9] = ShowTables;
        aoperation[10] = AlterTable;
        aoperation[11] = AlterAppInfo;
        aoperation[12] = GetAppInfo;
        aoperation[13] = ScanAppUser;
        $VALUES = aoperation;
    }
}
