.class public Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;


# static fields
.field private static final marshaller:Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;-><init>()V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;

    return-object v0
.end method


# virtual methods
.method public marshall(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(TT;)",
            "Ljava/lang/String;"
        }
    .end annotation

    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v0, p1}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unmarshall(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
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

    new-instance v0, Lcom/google/gson/Gson;

    invoke-direct {v0}, Lcom/google/gson/Gson;-><init>()V

    invoke-virtual {v0, p2, p1}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
