.class public Lcom/xiaomi/infra/galaxy/common/model/Condition;
.super Ljava/lang/Object;


# instance fields
.field private attributeName:Ljava/lang/String;

.field private attributeValues:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation
.end field

.field private comparator:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addAttributeValue(Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/Condition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    invoke-static {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->putAttributeValueInList(Ljava/util/List;Ljava/lang/Object;)V

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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/Condition;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/Condition;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_5

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_6

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v3

    if-nez v3, :cond_7

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

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

.method public getAttributeName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeName:Ljava/lang/String;

    return-object v0
.end method

.method public getAttributeValues()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    return-object v0
.end method

.method public getComparator()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->comparator:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v2

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getComparator()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->getAttributeValues()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public setAttributeName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeName:Ljava/lang/String;

    return-void
.end method

.method public setAttributeValues(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    return-void
.end method

.method public setComparator(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->comparator:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 6

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->comparator:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    move-result-object v1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v2, 0x1

    if-eq v0, v2, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->UNEXPECTED_NUMBER_OF_OPERANDS:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "comparator can only use one attribute value"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeName:Ljava/lang/String;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Condition;->attributeValues:Ljava/util/List;

    invoke-interface {v0, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-static {v3, v0, v4}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeValue(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;Z)V

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Condition$1;->$SwitchMap$com$xiaomi$infra$galaxy$common$model$Comparator:[I

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->ordinal()I

    move-result v3

    aget v0, v0, v3

    packed-switch v0, :pswitch_data_0

    :cond_2
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->UNEXPECTED_OPERAND_TYPE:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->name()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "(comparator:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " ,attributeType"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v3, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_0
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-ne v0, v2, :cond_2

    :cond_3
    :goto_0
    :pswitch_1
    return-void

    :pswitch_2
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-ne v0, v2, :cond_2

    goto :goto_0

    :pswitch_3
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-ne v0, v2, :cond_2

    goto :goto_0

    :pswitch_4
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-eq v0, v2, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-ne v0, v2, :cond_2

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public withAttributeValues(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/Condition;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/Condition;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->setAttributeValues(Ljava/util/List;)V

    return-object p0
.end method

.method public withComparator(Lcom/xiaomi/infra/galaxy/common/model/Comparator;)Lcom/xiaomi/infra/galaxy/common/model/Condition;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->setComparator(Ljava/lang/String;)V

    return-object p0
.end method
