.class public Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# instance fields
.field private items:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Record;",
            ">;"
        }
    .end annotation
.end field

.field private lastEvaluatedKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

.field private scannedCount:I

.field private tableName:Ljava/lang/String;


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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_5

    move v1, v2

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_6

    move v4, v2

    :goto_2
    xor-int/2addr v1, v4

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getScannedCount()I

    move-result v1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getScannedCount()I

    move-result v4

    if-ne v1, v4, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v1

    if-nez v1, :cond_7

    move v1, v2

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v4

    if-nez v4, :cond_8

    move v4, v2

    :goto_4
    xor-int/2addr v1, v4

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_3
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v1

    if-nez v1, :cond_9

    move v1, v2

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v4

    if-nez v4, :cond_a

    :goto_6
    xor-int/2addr v1, v2

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-super {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->equals(Ljava/lang/Object;)Z

    move-result v3

    goto/16 :goto_0

    :cond_5
    move v1, v3

    goto :goto_1

    :cond_6
    move v4, v3

    goto :goto_2

    :cond_7
    move v1, v3

    goto :goto_3

    :cond_8
    move v4, v3

    goto :goto_4

    :cond_9
    move v1, v3

    goto :goto_5

    :cond_a
    move v2, v3

    goto :goto_6
.end method

.method public getItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Record;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->items:Ljava/util/List;

    return-object v0
.end method

.method public getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->lastEvaluatedKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-object v0
.end method

.method public getScannedCount()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->scannedCount:I

    return v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-super {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->hashCode()I

    move-result v0

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getScannedCount()I

    move-result v2

    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v2

    if-nez v2, :cond_2

    :goto_2
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getItems()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->getLastEvaluatedKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->hashCode()I

    move-result v1

    goto :goto_2
.end method

.method public setItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Record;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->items:Ljava/util/List;

    return-void
.end method

.method public setLastEvaluatedKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->lastEvaluatedKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-void
.end method

.method public setScannedCount(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->scannedCount:I

    return-void
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->tableName:Ljava/lang/String;

    return-void
.end method

.method public withItems(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Record;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/ScanResult;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setItems(Ljava/util/List;)V

    return-object p0
.end method

.method public withLastEvaluatedKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setLastEvaluatedKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V

    return-object p0
.end method

.method public withScannedCount(I)Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setScannedCount(I)V

    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setTableName(Ljava/lang/String;)V

    return-object p0
.end method
