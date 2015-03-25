.class public Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;
.super Ljava/lang/Object;


# instance fields
.field private attributeName:Ljava/lang/String;

.field private attributeType:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-virtual {p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->setAttributeName(Ljava/lang/String;)V

    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->setAttributeType(Ljava/lang/String;)V

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

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_5

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_6

    move v0, v1

    :goto_3
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_7

    move v3, v1

    :goto_4
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

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

.method public getAttributeName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    return-object v0
.end method

.method public getAttributeType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->getAttributeType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public setAttributeName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    return-void
.end method

.method public setAttributeType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    return-void
.end method

.method public validate()V
    .locals 4

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xff

    if-le v0, v1, :cond_1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_TOO_LONG:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Constants;->AttributeNamePattern:Ljava/util/regex/Pattern;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_TYPE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "("

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ")"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0
.end method

.method public withAttributeName(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeName:Ljava/lang/String;

    return-object p0
.end method

.method public withAttributeType(Lcom/xiaomi/infra/galaxy/common/model/AttributeType;)Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    return-object p0
.end method

.method public withAttributeType(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeDefinition;->attributeType:Ljava/lang/String;

    return-object p0
.end method
