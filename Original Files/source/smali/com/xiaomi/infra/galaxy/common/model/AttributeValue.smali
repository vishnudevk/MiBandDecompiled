.class public Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;
.super Ljava/lang/Object;


# instance fields
.field private type:Ljava/lang/String;

.field private value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createAttributeValue(Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;
    .locals 3

    if-nez p0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->PARAMETER_IS_NULL:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;-><init>()V

    instance-of v1, p0, Ljava/lang/Boolean;

    if-eqz v1, :cond_1

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BOOL:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    :goto_0
    return-object v0

    :cond_1
    instance-of v1, p0, Ljava/lang/Byte;

    if-eqz v1, :cond_2

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_2
    instance-of v1, p0, Ljava/lang/Short;

    if-eqz v1, :cond_3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_3
    instance-of v1, p0, Ljava/lang/Integer;

    if-eqz v1, :cond_4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_4
    instance-of v1, p0, Ljava/lang/Long;

    if-eqz v1, :cond_5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_5
    instance-of v1, p0, Ljava/lang/Float;

    if-eqz v1, :cond_6

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->FLOAT:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_6
    instance-of v1, p0, Ljava/lang/Double;

    if-eqz v1, :cond_7

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->DOUBLE:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_7
    instance-of v1, p0, Ljava/lang/String;

    if-eqz v1, :cond_8

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    check-cast p0, Ljava/lang/String;

    invoke-virtual {v1, p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto :goto_0

    :cond_8
    instance-of v1, p0, [B

    if-eqz v1, :cond_9

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v1

    check-cast p0, [B

    check-cast p0, [B

    invoke-static {p0}, Lcom/xiaomi/infra/galaxy/common/util/Base64Utils;->encode([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    goto/16 :goto_0

    :cond_9
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->PARAMETER_TYPE_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0
.end method

.method protected static putAttributeValueInList(Ljava/util/List;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->createAttributeValue(Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v0

    invoke-interface {p0, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method protected static putAttributeValueInMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    invoke-static {p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->createAttributeValue(Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    move-result-object v0

    invoke-interface {p0, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_5

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_6

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_7

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_3
    move v2, v1

    goto :goto_0

    :cond_4
    move v0, v2

    goto :goto_1

    :cond_5
    move v3, v2

    goto :goto_2

    :cond_6
    move v0, v2

    goto :goto_3

    :cond_7
    move v3, v2

    goto :goto_4
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->value:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->type:Ljava/lang/String;

    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->value:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "AttributeValue [type="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->type:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", value="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->value:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public withType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->setType(Ljava/lang/String;)V

    return-object p0
.end method

.method public withValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->setValue(Ljava/lang/String;)V

    return-object p0
.end method
