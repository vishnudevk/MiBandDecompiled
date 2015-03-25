.class public Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;
.super Ljava/lang/Object;


# static fields
.field private static final galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;-><init>()V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;->galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getInstance()Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;->galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    return-object v0
.end method


# virtual methods
.method public getBackoffPeriod(I)I
    .locals 4

    if-gtz p1, :cond_1

    const/4 v0, 0x0

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-wide/high16 v0, 0x4000

    add-int/lit8 v2, p1, -0x1

    int-to-double v2, v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->pow(DD)D

    move-result-wide v0

    double-to-int v0, v0

    mul-int/lit8 v0, v0, 0x32

    if-gez v0, :cond_0

    const v0, 0x7fffffff

    goto :goto_0
.end method
