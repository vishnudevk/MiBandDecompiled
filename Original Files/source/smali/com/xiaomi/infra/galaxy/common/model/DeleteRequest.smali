.class public Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

.field private key:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation
.end field

.field private tableName:Ljava/lang/String;

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    return-void
.end method


# virtual methods
.method public addKey(Ljava/lang/String;Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    invoke-static {v0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->putAttributeValueInMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V

    return-object p0
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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_5

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_6

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_7

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    if-nez v3, :cond_8

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    move v2, v1

    goto :goto_0

    :cond_5
    move v0, v2

    goto :goto_1

    :cond_6
    move v3, v2

    goto :goto_2

    :cond_7
    move v0, v2

    goto :goto_3

    :cond_8
    move v3, v2

    goto :goto_4

    :cond_9
    move v0, v2

    goto :goto_5

    :cond_a
    move v3, v2

    goto :goto_6
.end method

.method public getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    return-object v0
.end method

.method public getKey()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    return-object v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v2

    if-nez v2, :cond_2

    :goto_2
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getKey()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_2
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

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

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

.method public setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    return-void
.end method

.method public setKey(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    return-void
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->tableName:Ljava/lang/String;

    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->userId:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 4

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->tableName:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateTableName(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->KEY_VALUES_IS_EMPTY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->key:Ljava/util/Map;

    invoke-static {v0, v2}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateKeyValues(Ljava/util/Map;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getComplexConditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->COMPLEX_CONDITION_NOT_SUPPORTED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "delete action expected 0 or 1 simple condition"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->UNEXPECTED_NUMBER_OF_SIMPLE_CONDITIONS:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "delete action expected 0 or 1, but got "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " simple condition"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/Condition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->validate()V

    :cond_4
    return-void
.end method

.method public withCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V

    return-object p0
.end method

.method public withKey(Ljava/util/Map;)Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->setKey(Ljava/util/Map;)V

    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->setTableName(Ljava/lang/String;)V

    return-object p0
.end method

.method public withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->setUserId(Ljava/lang/String;)V

    return-object p0
.end method
