.class public Lcom/xiaomi/infra/galaxy/common/model/AlterTableResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 2

    const/4 v0, 0x0

    if-ne p0, p1, :cond_1

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-eqz p1, :cond_0

    instance-of v1, p1, Lcom/xiaomi/infra/galaxy/common/model/AlterTableResult;

    if-eqz v1, :cond_0

    invoke-super {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method
