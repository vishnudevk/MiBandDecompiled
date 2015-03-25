.class public Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# instance fields
.field private table:Lcom/xiaomi/infra/galaxy/common/model/TableDescription;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne p0, p1, :cond_1

    move v3, v2

    :cond_0
    :goto_0
    return v3

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v1

    if-nez v1, :cond_3

    move v1, v2

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v4

    if-nez v4, :cond_4

    :goto_2
    xor-int/2addr v1, v2

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-super {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->equals(Ljava/lang/Object;)Z

    move-result v3

    goto :goto_0

    :cond_3
    move v1, v3

    goto :goto_1

    :cond_4
    move v2, v3

    goto :goto_2
.end method

.method public getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->table:Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    invoke-super {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->hashCode()I

    move-result v0

    mul-int/lit8 v1, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->getTable()Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public setTable(Lcom/xiaomi/infra/galaxy/common/model/TableDescription;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->table:Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    return-void
.end method

.method public withTable(Lcom/xiaomi/infra/galaxy/common/model/TableDescription;)Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DescribeTableResult;->table:Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    return-object p0
.end method
