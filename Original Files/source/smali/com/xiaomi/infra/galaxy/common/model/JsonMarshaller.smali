.class public Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;


# static fields
.field private static final marshaller:Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;


# instance fields
.field private mapper:Lorg/codehaus/jackson/map/ObjectMapper;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;-><init>()V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-direct {v0}, Lorg/codehaus/jackson/map/ObjectMapper;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    sget-object v1, Lorg/codehaus/jackson/JsonParser$Feature;->ALLOW_SINGLE_QUOTES:Lorg/codehaus/jackson/JsonParser$Feature;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lorg/codehaus/jackson/map/ObjectMapper;->configure(Lorg/codehaus/jackson/JsonParser$Feature;Z)Lorg/codehaus/jackson/map/ObjectMapper;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-virtual {v0}, Lorg/codehaus/jackson/map/ObjectMapper;->getSerializationConfig()Lorg/codehaus/jackson/map/SerializationConfig;

    move-result-object v0

    sget-object v1, Lorg/codehaus/jackson/map/annotate/JsonSerialize$Inclusion;->NON_NULL:Lorg/codehaus/jackson/map/annotate/JsonSerialize$Inclusion;

    invoke-virtual {v0, v1}, Lorg/codehaus/jackson/map/SerializationConfig;->setSerializationInclusion(Lorg/codehaus/jackson/map/annotate/JsonSerialize$Inclusion;)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-virtual {v0}, Lorg/codehaus/jackson/map/ObjectMapper;->getDeserializationConfig()Lorg/codehaus/jackson/map/DeserializationConfig;

    move-result-object v0

    sget-object v1, Lorg/codehaus/jackson/map/DeserializationConfig$Feature;->FAIL_ON_UNKNOWN_PROPERTIES:Lorg/codehaus/jackson/map/DeserializationConfig$Feature;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lorg/codehaus/jackson/map/DeserializationConfig;->set(Lorg/codehaus/jackson/map/DeserializationConfig$Feature;Z)V

    return-void
.end method

.method public static getInstance()Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;

    return-object v0
.end method


# virtual methods
.method public marshall(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Ljava/lang/String;"
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-virtual {v0, p1}, Lorg/codehaus/jackson/map/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public marshallBytes(Ljava/lang/Object;)[B
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)[B"
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-virtual {v0, p1}, Lorg/codehaus/jackson/map/ObjectMapper;->writeValueAsBytes(Ljava/lang/Object;)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public unmarshall(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/JsonMarshaller;->mapper:Lorg/codehaus/jackson/map/ObjectMapper;

    invoke-virtual {v0, p2, p1}, Lorg/codehaus/jackson/map/ObjectMapper;->readValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/RuntimeException;

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
