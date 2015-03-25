.class public Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private accessMethod:Ljava/lang/String;

.field private attributeDefinitions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;"
        }
    .end annotation
.end field

.field private keySchema:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private tableName:Ljava/lang/String;

.field private tableType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setTableName(Ljava/lang/String;)V

    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setKeySchema(Ljava/util/List;)V

    return-void
.end method


# virtual methods
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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_7

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    if-nez v3, :cond_8

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_b

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v3

    if-nez v3, :cond_c

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_d

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_e

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_f

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_10

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

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

.method public getAccessMethod()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->accessMethod:Ljava/lang/String;

    return-object v0
.end method

.method public getAttributeDefinitions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    return-object v0
.end method

.method public getKeySchema()Ljava/util/List;
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

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    return-object v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public getTableType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableType:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_4

    :goto_4
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getTableType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAccessMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

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

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setLevel(Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)V

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->CreateTable:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

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

.method public setAccessMethod(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->accessMethod:Ljava/lang/String;

    return-void
.end method

.method public setAttributeDefinitions(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;)V"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    goto :goto_0
.end method

.method public setAttributeDefinitions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    return-void
.end method

.method public setKeySchema(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    goto :goto_0
.end method

.method public setKeySchema(Ljava/util/List;)V
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

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    return-void
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableName:Ljava/lang/String;

    return-void
.end method

.method public setTableType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableType:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 5

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableName:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateTableName(Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableType:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/TableType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableType;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :try_start_1
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->accessMethod:Ljava/lang/String;

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v1

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/TableType;->USER:Lcom/xiaomi/infra/galaxy/common/model/TableType;

    if-ne v0, v2, :cond_0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    if-eq v1, v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ACCESS_METHOD_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "user table can only be accessed by "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->LoginReadLoginWrite:Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " access method, actuly :"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->accessMethod:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_TYPE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableType:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :catch_1
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ACCESS_METHOD_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->accessMethod:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_DEFINITIONS_IS_NULL:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_2
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->validate()V

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->DUPLICATE_ATTRIBUTE_NAME:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, v3}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_3
    const/4 v4, 0x0

    :try_start_2
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    invoke-interface {v1, v3}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :catch_2
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_TYPE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_4
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    if-nez v0, :cond_6

    :cond_5
    return-void

    :cond_6
    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_7

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->KEY_NAME_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_7
    invoke-interface {v1, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_8

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->KEY_NAME_IS_UNDEFINED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v1, v2, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v1

    :cond_8
    invoke-interface {v2, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->DUPLICATE_KEY_NAME:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v1, v2, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v1

    :cond_9
    invoke-interface {v2, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1
.end method

.method public withAccessMethod(Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setAccessMethod(Ljava/lang/String;)V

    return-object p0
.end method

.method public withAttributeDefinitions(Ljava/util/Collection;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->attributeDefinitions:Ljava/util/List;

    goto :goto_0
.end method

.method public varargs withAttributeDefinitions([Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 4

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    array-length v1, p1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setAttributeDefinitions(Ljava/util/List;)V

    :cond_0
    array-length v1, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p1, v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-object p0
.end method

.method public withKeySchema(Ljava/util/Collection;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->keySchema:Ljava/util/List;

    goto :goto_0
.end method

.method public varargs withKeySchema([Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 4

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    array-length v1, p1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setKeySchema(Ljava/util/List;)V

    :cond_0
    array-length v1, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p1, v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->getKeySchema()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->tableName:Ljava/lang/String;

    return-object p0
.end method

.method public withTableType(Lcom/xiaomi/infra/galaxy/common/model/TableType;)Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CreateTableRequest;->setTableType(Ljava/lang/String;)V

    return-object p0
.end method
