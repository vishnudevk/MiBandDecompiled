.class public Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
.super Ljava/lang/Object;


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

.field private creationDateTime:Ljava/lang/Long;

.field private grantedApps:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private itemCount:Ljava/lang/Long;

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

.field private tableSizeBytes:Ljava/lang/Long;

.field private tableStatus:Ljava/lang/String;

.field private tableType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 7

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_9

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    if-nez v3, :cond_a

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_b

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_c

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_d

    move v0, v1

    :goto_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_e

    move v3, v1

    :goto_6
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_4
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getCreationDateTime()J

    move-result-wide v3

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getCreationDateTime()J

    move-result-wide v5

    cmp-long v0, v3, v5

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_f

    move v0, v1

    :goto_7
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v3

    if-nez v3, :cond_10

    move v3, v1

    :goto_8
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_5
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_11

    move v0, v1

    :goto_9
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v3

    if-nez v3, :cond_12

    move v3, v1

    :goto_a
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v0

    if-eqz v0, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Long;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_6
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_13

    move v0, v1

    :goto_b
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_14

    move v3, v1

    :goto_c
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_7
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_15

    move v0, v1

    :goto_d
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_16

    move v3, v1

    :goto_e
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_8

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_8
    move v2, v1

    goto/16 :goto_0

    :cond_9
    move v0, v2

    goto/16 :goto_1

    :cond_a
    move v3, v2

    goto/16 :goto_2

    :cond_b
    move v0, v2

    goto/16 :goto_3

    :cond_c
    move v3, v2

    goto/16 :goto_4

    :cond_d
    move v0, v2

    goto/16 :goto_5

    :cond_e
    move v3, v2

    goto/16 :goto_6

    :cond_f
    move v0, v2

    goto/16 :goto_7

    :cond_10
    move v3, v2

    goto/16 :goto_8

    :cond_11
    move v0, v2

    goto/16 :goto_9

    :cond_12
    move v3, v2

    goto :goto_a

    :cond_13
    move v0, v2

    goto :goto_b

    :cond_14
    move v3, v2

    goto :goto_c

    :cond_15
    move v0, v2

    goto :goto_d

    :cond_16
    move v3, v2

    goto :goto_e
.end method

.method public getAccessMethod()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->accessMethod:Ljava/lang/String;

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

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->attributeDefinitions:Ljava/util/List;

    return-object v0
.end method

.method public getCreationDateTime()J
    .locals 2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->creationDateTime:Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getGrantedApps()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->grantedApps:Ljava/util/Set;

    return-object v0
.end method

.method public getItemCount()Ljava/lang/Long;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->itemCount:Ljava/lang/Long;

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

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->keySchema:Ljava/util/List;

    return-object v0
.end method

.method public getTableName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableName:Ljava/lang/String;

    return-object v0
.end method

.method public getTableSizeBytes()Ljava/lang/Long;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableSizeBytes:Ljava/lang/Long;

    return-object v0
.end method

.method public getTableStatus()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableStatus:Ljava/lang/String;

    return-object v0
.end method

.method public getTableType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableType:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_2
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getCreationDateTime()J

    move-result-wide v2

    long-to-int v2, v2

    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_3
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_4
    add-int/2addr v0, v2

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_5

    move v0, v1

    :goto_5
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_6

    :goto_6
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableSizeBytes()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->hashCode()I

    move-result v0

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getItemCount()Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->hashCode()I

    move-result v0

    goto :goto_4

    :cond_5
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getTableType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_5

    :cond_6
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAccessMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_6
.end method

.method public setAccessMethod(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->accessMethod:Ljava/lang/String;

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

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->attributeDefinitions:Ljava/util/List;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->attributeDefinitions:Ljava/util/List;

    goto :goto_0
.end method

.method public setCreationDateTime(J)V
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->creationDateTime:Ljava/lang/Long;

    return-void
.end method

.method public setGrantedApps(Ljava/util/Set;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->grantedApps:Ljava/util/Set;

    return-void
.end method

.method public setItemCount(Ljava/lang/Long;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->itemCount:Ljava/lang/Long;

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

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->keySchema:Ljava/util/List;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->keySchema:Ljava/util/List;

    goto :goto_0
.end method

.method public setTableName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableName:Ljava/lang/String;

    return-void
.end method

.method public setTableSizeBytes(Ljava/lang/Long;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableSizeBytes:Ljava/lang/Long;

    return-void
.end method

.method public setTableStatus(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableStatus:Ljava/lang/String;

    return-void
.end method

.method public setTableType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableType:Ljava/lang/String;

    return-void
.end method

.method public withAccessMethod(Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AccessMethod;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->setAccessMethod(Ljava/lang/String;)V

    return-object p0
.end method

.method public withAttributeDefinitions(Ljava/util/Collection;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->attributeDefinitions:Ljava/util/List;

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->attributeDefinitions:Ljava/util/List;

    goto :goto_0
.end method

.method public varargs withAttributeDefinitions([Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 4

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    array-length v1, p1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->setAttributeDefinitions(Ljava/util/Collection;)V

    :cond_0
    array-length v1, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p1, v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getAttributeDefinitions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-object p0
.end method

.method public withCreationDateTime(J)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->creationDateTime:Ljava/lang/Long;

    return-object p0
.end method

.method public withGrantedApps(Ljava/util/Set;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->setGrantedApps(Ljava/util/Set;)V

    return-object p0
.end method

.method public withItemCount(Ljava/lang/Long;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->itemCount:Ljava/lang/Long;

    return-object p0
.end method

.method public withKeySchema(Ljava/util/Collection;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;"
        }
    .end annotation

    if-nez p1, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->keySchema:Ljava/util/List;

    :goto_0
    return-object p0

    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->keySchema:Ljava/util/List;

    goto :goto_0
.end method

.method public varargs withKeySchema([Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 4

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getKeySchema()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    array-length v1, p1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->setKeySchema(Ljava/util/Collection;)V

    :cond_0
    array-length v1, p1

    const/4 v0, 0x0

    :goto_0
    if-ge v0, v1, :cond_1

    aget-object v2, p1, v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->getKeySchema()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-object p0
.end method

.method public withTableName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableName:Ljava/lang/String;

    return-object p0
.end method

.method public withTableSizeBytes(Ljava/lang/Long;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableSizeBytes:Ljava/lang/Long;

    return-object p0
.end method

.method public withTableStatus(Lcom/xiaomi/infra/galaxy/common/model/TableStatus;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableStatus:Ljava/lang/String;

    return-object p0
.end method

.method public withTableStatus(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->tableStatus:Ljava/lang/String;

    return-object p0
.end method

.method public withTableType(Lcom/xiaomi/infra/galaxy/common/model/TableType;)Lcom/xiaomi/infra/galaxy/common/model/TableDescription;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/TableType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/TableDescription;->setTableType(Ljava/lang/String;)V

    return-object p0
.end method
