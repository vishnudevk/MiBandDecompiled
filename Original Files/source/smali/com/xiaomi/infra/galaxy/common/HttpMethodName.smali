.class public final enum Lcom/xiaomi/infra/galaxy/common/HttpMethodName;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/HttpMethodName;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

.field public static final enum DELETE:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

.field public static final enum GET:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

.field public static final enum HEAD:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

.field public static final enum POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

.field public static final enum PUT:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const-string v1, "GET"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->GET:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const-string v1, "POST"

    invoke-direct {v0, v1, v3}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const-string v1, "PUT"

    invoke-direct {v0, v1, v4}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->PUT:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const-string v1, "DELETE"

    invoke-direct {v0, v1, v5}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->DELETE:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const-string v1, "HEAD"

    invoke-direct {v0, v1, v6}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->HEAD:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->GET:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->PUT:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->DELETE:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->HEAD:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    aput-object v1, v0, v6

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/HttpMethodName;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/HttpMethodName;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    return-object v0
.end method
