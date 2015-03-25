.class public Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;


# instance fields
.field private final appId:Ljava/lang/String;

.field private final secretKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "appId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Secret key cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;->appId:Ljava/lang/String;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;->secretKey:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getGalaxyAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getGalaxySecretKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;->secretKey:Ljava/lang/String;

    return-object v0
.end method
