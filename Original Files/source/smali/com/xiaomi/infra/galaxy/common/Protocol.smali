.class public final enum Lcom/xiaomi/infra/galaxy/common/Protocol;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/Protocol;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/Protocol;

.field public static final enum HTTP:Lcom/xiaomi/infra/galaxy/common/Protocol;

.field public static final enum HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;


# instance fields
.field private final protocol:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/Protocol;

    const-string v1, "HTTP"

    const-string v2, "http"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/Protocol;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTP:Lcom/xiaomi/infra/galaxy/common/Protocol;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/Protocol;

    const-string v1, "HTTPS"

    const-string v2, "https"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/Protocol;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/Protocol;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTP:Lcom/xiaomi/infra/galaxy/common/Protocol;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/Protocol;

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

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/Protocol;->protocol:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/Protocol;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/Protocol;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/Protocol;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/Protocol;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/Protocol;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/Protocol;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/Protocol;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/Protocol;->protocol:Ljava/lang/String;

    return-object v0
.end method
