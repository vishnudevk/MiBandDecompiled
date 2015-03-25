.class public Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private attributes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

.field private limit:I

.field private reverse:Z

.field private startKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

.field private stopKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

.field private tableName:Ljava/lang/String;

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->reverse:Z

    return-void
.end method


# virtual methods
.method public addAttribute(Ljava/lang/String;)V
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_7

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_8

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_b

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    if-nez v3, :cond_c

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    if-nez v0, :cond_d

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v3

    if-nez v3, :cond_e

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    if-nez v0, :cond_f

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v3

    if-nez v3, :cond_10

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_6
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getLimit()I

    move-result v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getLimit()I

    move-result v3

    if-ne v0, v3, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getReverse()Z

    move-result v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getReverse()Z

    move-result v3

    if-ne v0, v3, :cond_0

    move v2, v1

    goto/16 :goto_0

    :cond_7
    move v0, v2

    goto/16 :goto_1

    :cond_8
    move v3, v2

    goto/16 :goto_2

    :cond_9
    move v0, v2

    goto/16 :goto_3

    :cond_a
    move v3, v2

    goto/16 :goto_4

    :cond_b
    move v0, v2

    goto/16 :goto_5

    :cond_c
    move v3, v2

    goto/16 :goto_6

    :cond_d
    move v0, v2

    goto :goto_7

    :cond_e
    move v3, v2

    goto :goto_8

    :cond_f
    move v0, v2

    goto :goto_9

    :cond_10
    move v3, v2

    goto :goto_a
.end method

.method public getAttributes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    return-object v0
.end method

.method public getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    return-object v0
.end method

.method public getLimit()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->limit:I

    return v0
.end method

.method public getReverse()Z
    .locals 1

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->reverse:Z

    return v0
.end method

.method public getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->startKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-object v0
.end method

.method public getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->stopKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-object v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v2

    if-nez v2, :cond_4

    :goto_4
    add-int/2addr v0, v1

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getLimit()I

    move-result v1

    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getAttributes()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStartKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getStopKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->hashCode()I

    move-result v1

    goto :goto_4
.end method

.method public internalGetGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;
    .locals 3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    const-string v1, "Galaxy"

    invoke-direct {v0, p0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;-><init>(Lcom/xiaomi/infra/galaxy/common/model/Request;Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/TargetAction;

    invoke-direct {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;-><init>()V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/GalaxyVersion;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setApiVersion(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setLevel(Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)V

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setOperation(Lcom/xiaomi/infra/galaxy/common/constants/Operation;)V

    const-string v2, "Galaxy"

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setServiceName(Ljava/lang/String;)V

    const-string v2, "X-XiaoMi-Action"

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->format()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-super {p0, v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Request;->setRequestContent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)V

    return-object v0
.end method

.method public setAttributes(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    return-void
.end method

.method public setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    return-void
.end method

.method public setLimit(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->limit:I

    return-void
.end method

.method public setReverse(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->reverse:Z

    return-void
.end method

.method public setStartKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->startKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-void
.end method

.method public setStopKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->stopKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-void
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->tableName:Ljava/lang/String;

    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->userId:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->tableName:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateTableName(Ljava/lang/String;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->startKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    invoke-static {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateKeyValues(Lcom/xiaomi/infra/galaxy/common/model/RowKey;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->stopKey:Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    invoke-static {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateKeyValues(Lcom/xiaomi/infra/galaxy/common/model/RowKey;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->attributes:Ljava/util/List;

    invoke-static {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeNames(Ljava/util/Collection;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;

    invoke-direct {v1}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;-><init>()V

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->check(Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;)V

    :cond_0
    return-void
.end method

.method public withAttributes(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setAttributes(Ljava/util/List;)V

    return-object p0
.end method

.method public withCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V

    return-object p0
.end method

.method public withLimit(I)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setLimit(I)V

    return-object p0
.end method

.method public withReverse(Z)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setReverse(Z)V

    return-object p0
.end method

.method public withStartKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setStartKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V

    return-object p0
.end method

.method public withStopKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setStopKey(Lcom/xiaomi/infra/galaxy/common/model/RowKey;)V

    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setTableName(Ljava/lang/String;)V

    return-object p0
.end method

.method public withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->setUserId(Ljava/lang/String;)V

    return-object p0
.end method
