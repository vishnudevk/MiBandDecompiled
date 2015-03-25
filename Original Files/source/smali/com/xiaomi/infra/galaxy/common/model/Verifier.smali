.class public Lcom/xiaomi/infra/galaxy/common/model/Verifier;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static validateAttributeName(Ljava/lang/String;Z)V
    .locals 2

    invoke-static {p0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xff

    if-le v0, v1, :cond_1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_TOO_LONG:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    if-eqz p1, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Constants;->AttributeNamePattern:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_NAME_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    return-void
.end method

.method public static validateAttributeNames(Ljava/util/Collection;Z)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    if-eqz p0, :cond_0

    invoke-interface {p0}, Ljava/util/Collection;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    return-void

    :cond_1
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeName(Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public static validateAttributeValue(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;Z)V
    .locals 2

    invoke-static {p0, p2}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeName(Ljava/lang/String;Z)V

    if-nez p1, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_NULL:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public static validateKeyValues(Lcom/xiaomi/infra/galaxy/common/model/RowKey;Z)V
    .locals 1

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->getKey()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateKeyValues(Ljava/util/Map;Z)V

    :cond_0
    return-void
.end method

.method public static validateKeyValues(Ljava/util/Map;Z)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;Z)V"
        }
    .end annotation

    const/4 v0, -0x1

    if-eqz p0, :cond_1

    invoke-interface {p0}, Ljava/util/Map;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {p0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v2, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;

    invoke-static {v1, v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateAttributeValue(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;Z)V

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    move-result-object v1

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/model/Verifier$1;->$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType:[I

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->ordinal()I

    move-result v1

    aget v1, v4, v1

    packed-switch v1, :pswitch_data_0

    move v0, v2

    :goto_1
    move v2, v0

    goto :goto_0

    :pswitch_0
    move v0, v2

    goto :goto_1

    :pswitch_1
    add-int/lit8 v2, v2, 0x1

    move v0, v2

    goto :goto_1

    :pswitch_2
    add-int/lit8 v2, v2, 0x2

    move v0, v2

    goto :goto_1

    :pswitch_3
    add-int/lit8 v2, v2, 0x4

    move v0, v2

    goto :goto_1

    :pswitch_4
    add-int/lit8 v2, v2, 0x8

    move v0, v2

    goto :goto_1

    :pswitch_5
    add-int/lit8 v2, v2, 0x4

    move v0, v2

    goto :goto_1

    :pswitch_6
    add-int/lit8 v2, v2, 0x8

    move v0, v2

    goto :goto_1

    :pswitch_7
    :try_start_0
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v0

    const-string v1, "utf-8"

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    array-length v0, v0
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    add-int/2addr v2, v0

    move v0, v2

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    move v0, v2

    goto :goto_1

    :pswitch_8
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    mul-int/lit8 v0, v0, 0x3

    div-int/lit8 v0, v0, 0x4

    add-int/2addr v2, v0

    move v0, v2

    goto :goto_1

    :cond_0
    move v0, v2

    :cond_1
    const/16 v1, 0x400

    if-le v0, v1, :cond_2

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->KEY_IS_TOO_LONG:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v1

    :cond_2
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public static validateTableName(Ljava/lang/String;)V
    .locals 1

    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/Verifier;->validateTableName(Ljava/lang/String;Z)V

    return-void
.end method

.method public static validateTableName(Ljava/lang/String;Z)V
    .locals 2

    invoke-static {p0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_NAME_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0xff

    if-le v0, v1, :cond_1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_NAME_TOO_LONG:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    if-eqz p1, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/Constants;->TableNamePattern:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->TABLE_NAME_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    return-void
.end method

.method private static validateValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    :try_start_0
    invoke-static {p0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Verifier$1;->$SwitchMap$com$xiaomi$infra$galaxy$common$model$AttributeType:[I

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "unused attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :catch_0
    move-exception v0

    throw v0

    :pswitch_0
    const-string v0, "true"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "false"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected \'true\' or \'false\' for boolean attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_1
    :try_start_1
    invoke-static {p1}, Ljava/lang/Byte;->parseByte(Ljava/lang/String;)B
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    :cond_0
    :goto_0
    :pswitch_2
    return-void

    :catch_1
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected [-128,127] for int8 attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_3
    :try_start_2
    invoke-static {p1}, Ljava/lang/Short;->parseShort(Ljava/lang/String;)S
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_0

    :catch_2
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected [-32768,32767] for int16 attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_4
    :try_start_3
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_0

    :catch_3
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected [-2147483648,2147483647] for int32 attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :pswitch_5
    :try_start_4
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    goto :goto_0

    :catch_4
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_VALUE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "expected [-9223372036854775808,9223372036854775807] for int64 attribute type of "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "@"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method
