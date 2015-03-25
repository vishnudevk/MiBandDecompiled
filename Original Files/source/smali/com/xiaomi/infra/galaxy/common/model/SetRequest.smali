.class public Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private action:Ljava/lang/String;

.field private attributeValues:Ljava/util/Map;
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
.method public addAttributeValue(Ljava/lang/String;Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    invoke-static {v0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->putAttributeValueInMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V

    return-object p0
.end method

.method public addKey(Ljava/lang/String;Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_7

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_8

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_b

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v3

    if-nez v3, :cond_c

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_d

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    if-nez v3, :cond_e

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_f

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v3

    if-nez v3, :cond_10

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_6
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

    goto :goto_5

    :cond_c
    move v3, v2

    goto :goto_6

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

.method public getAction()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->action:Ljava/lang/String;

    return-object v0
.end method

.method public getAttributeValues()Ljava/util/Map;
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

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    return-object v0
.end method

.method public getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

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

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

    return-object v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v2

    if-nez v2, :cond_4

    :goto_4
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAction()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getAttributeValues()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getCondition()Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getKey()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

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

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

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

.method public setAction(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->action:Ljava/lang/String;

    return-void
.end method

.method public setAttributeValues(Ljava/util/Map;)V
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

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    return-void
.end method

.method public setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

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

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

    return-void
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->tableName:Ljava/lang/String;

    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->userId:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 7

    const/4 v6, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->tableName:Ljava/lang/String;

    invoke-static {v0, v6}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateTableName(Ljava/lang/String;Z)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->key:Ljava/util/Map;

    invoke-static {v0, v6}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateKeyValues(Ljava/util/Map;Z)V

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->action:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/Action;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Action;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->attributeValues:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :pswitch_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-static {v1, v0, v6}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeValue(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;Z)V

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/model/Action;->ADD:Lcom/xiaomi/infra/galaxy/common/model/Action;

    if-ne v2, v4, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    move-result-object v0

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/model/SetRequest$1;->$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType:[I

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    new-instance v2, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->NEED_INTEGER_ATTRIBUTE_VALUE:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "("

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v2

    :catch_0
    move-exception v0

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    if-eqz v0, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Action;->PUT:Lcom/xiaomi/infra/galaxy/common/model/Action;

    if-ne v2, v0, :cond_5

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getComplexConditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->COMPLEX_CONDITION_NOT_SUPPORTED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "put action expected 0 or 1 simple condition"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

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

    const-string v3, "put action expected 0 or 1, but got "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " condition"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->condition:Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->getConditions()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/Condition;

    if-eqz v0, :cond_4

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->validate()V

    :cond_4
    return-void

    :cond_5
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Action;->ADD:Lcom/xiaomi/infra/galaxy/common/model/Action;

    if-ne v2, v0, :cond_4

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->CONDITION_NOT_SUPPORTED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "add action not use condition"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public withAction(Lcom/xiaomi/infra/galaxy/common/model/Action;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Action;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setAction(Ljava/lang/String;)V

    return-object p0
.end method

.method public withAttributeValues(Ljava/util/Map;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/SetRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setAttributeValues(Ljava/util/Map;)V

    return-object p0
.end method

.method public withCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)V

    return-object p0
.end method

.method public withKey(Ljava/util/Map;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/SetRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setKey(Ljava/util/Map;)V

    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setTableName(Ljava/lang/String;)V

    return-object p0
.end method

.method public withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->setUserId(Ljava/lang/String;)V

    return-object p0
.end method
