.class public Lcn/com/smartdevices/bracelet/model/NetDataInfo;
.super Ljava/lang/Object;


# static fields
.field public static final DATA_HAVE:I = 0x2

.field public static final DATA_NONE:I = 0x1

.field public static final DATA_UNKNOW:I


# instance fields
.field public dataState:I

.field public startDate:Ljava/lang/String;

.field public stopDate:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/NetDataInfo;->dataState:I

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/model/NetDataInfo;->startDate:Ljava/lang/String;

    iput-object v1, p0, Lcn/com/smartdevices/bracelet/model/NetDataInfo;->stopDate:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public hasData()Z
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/NetDataInfo;->dataState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isUnknow()Z
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/NetDataInfo;->dataState:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
