.class public final enum Lcom/xiaomi/infra/galaxy/common/constants/Operation;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/constants/Operation;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum AlterAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum AlterTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Auth:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum CreateTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum DeleteTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum DescribeTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Get:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum GetAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum ScanAppUser:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field public static final enum ShowTables:Lcom/xiaomi/infra/galaxy/common/constants/Operation;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "CreateTable"

    const-string v2, "CreateTable"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->CreateTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "DeleteTable"

    const-string v2, "DeleteTable"

    invoke-direct {v0, v1, v5, v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DeleteTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "DescribeTable"

    const-string v2, "DescribeTable"

    invoke-direct {v0, v1, v6, v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DescribeTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Get"

    const-string v2, "Get"

    invoke-direct {v0, v1, v7, v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Get:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Set"

    const-string v2, "Set"

    invoke-direct {v0, v1, v8, v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Scan"

    const/4 v2, 0x5

    const-string v3, "Scan"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Delete"

    const/4 v2, 0x6

    const-string v3, "Delete"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Batch"

    const/4 v2, 0x7

    const-string v3, "Batch"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "Auth"

    const/16 v2, 0x8

    const-string v3, "Auth"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Auth:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "ShowTables"

    const/16 v2, 0x9

    const-string v3, "ShowTables"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ShowTables:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "AlterTable"

    const/16 v2, 0xa

    const-string v3, "AlterTable"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "AlterAppInfo"

    const/16 v2, 0xb

    const-string v3, "AlterAppInfo"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "GetAppInfo"

    const/16 v2, 0xc

    const-string v3, "GetAppInfo"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->GetAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const-string v1, "ScanAppUser"

    const/16 v2, 0xd

    const-string v3, "ScanAppUser"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ScanAppUser:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    const/16 v0, 0xe

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->CreateTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DeleteTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DescribeTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Get:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v1, v0, v7

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Auth:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ShowTables:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->GetAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ScanAppUser:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/Operation;
    .locals 3

    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Value cannot be null or empty!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const-string v0, "CreateTable"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->CreateTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "DeleteTable"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DeleteTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_3
    const-string v0, "DescribeTable"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->DescribeTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_4
    const-string v0, "Get"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Get:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_5
    const-string v0, "Set"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_6
    const-string v0, "Scan"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_7
    const-string v0, "Delete"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_8
    const-string v0, "Batch"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_9
    const-string v0, "Auth"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Auth:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_a
    const-string v0, "ShowTables"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ShowTables:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_b
    const-string v0, "AlterTable"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_c
    const-string v0, "GetAppInfo"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->GetAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto :goto_0

    :cond_d
    const-string v0, "AlterAppInfo"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto/16 :goto_0

    :cond_e
    const-string v0, "ScanAppUser"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->ScanAppUser:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    goto/16 :goto_0

    :cond_f
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Cannot create enum from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " value!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/Operation;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/constants/Operation;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/constants/Operation;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->value:Ljava/lang/String;

    return-object v0
.end method
