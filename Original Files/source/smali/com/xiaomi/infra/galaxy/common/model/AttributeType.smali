.class public final enum Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/AttributeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum BOOL:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum DOUBLE:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum FLOAT:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field public static final enum STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

.field static final lookupMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeType;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v0, 0x0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "BOOL"

    const-string v3, "BOOL"

    invoke-direct {v1, v2, v0, v3}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BOOL:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "INT8"

    const-string v3, "INT8"

    invoke-direct {v1, v2, v5, v3}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "INT16"

    const-string v3, "INT16"

    invoke-direct {v1, v2, v6, v3}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "INT32"

    const-string v3, "INT32"

    invoke-direct {v1, v2, v7, v3}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "INT64"

    const-string v3, "INT64"

    invoke-direct {v1, v2, v8, v3}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "FLOAT"

    const/4 v3, 0x5

    const-string v4, "FLOAT"

    invoke-direct {v1, v2, v3, v4}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->FLOAT:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "DOUBLE"

    const/4 v3, 0x6

    const-string v4, "DOUBLE"

    invoke-direct {v1, v2, v3, v4}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->DOUBLE:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "STRING"

    const/4 v3, 0x7

    const-string v4, "STRING"

    invoke-direct {v1, v2, v3, v4}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const-string v2, "BINARY"

    const/16 v3, 0x8

    const-string v4, "BINARY"

    invoke-direct {v1, v2, v3, v4}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    const/16 v1, 0x9

    new-array v1, v1, [Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BOOL:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v2, v1, v0

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT8:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v2, v1, v5

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT16:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v2, v1, v6

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT32:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v2, v1, v7

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->INT64:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v2, v1, v8

    const/4 v2, 0x5

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->FLOAT:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v3, v1, v2

    const/4 v2, 0x6

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->DOUBLE:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v3, v1, v2

    const/4 v2, 0x7

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->STRING:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v3, v1, v2

    const/16 v2, 0x8

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->BINARY:Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    aput-object v3, v1, v2

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    sput-object v1, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->lookupMap:Ljava/util/Map;

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->values()[Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    move-result-object v1

    array-length v2, v1

    :goto_0
    if-ge v0, v2, :cond_1

    aget-object v3, v1, v0

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->lookupMap:Ljava/util/Map;

    iget-object v5, v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->value:Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Duplicated enum value"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    sget-object v4, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->lookupMap:Ljava/util/Map;

    iget-object v5, v3, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->value:Ljava/lang/String;

    invoke-interface {v4, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    .locals 2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->lookupMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    if-nez v0, :cond_2

    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_TYPE_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_1
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->ATTRIBUTE_TYPE_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1, p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/AttributeType;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/AttributeType;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AttributeType;->value:Ljava/lang/String;

    return-object v0
.end method
