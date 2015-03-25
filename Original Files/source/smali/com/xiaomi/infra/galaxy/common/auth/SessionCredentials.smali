.class public Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;


# instance fields
.field private final appId:Ljava/lang/String;

.field private storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "appId cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->appId:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getGalaxyAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getGalaxySecretKey()Ljava/lang/String;
    .locals 4

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getExpiresIn()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->STORAGEACCESS_TOKEN_IS_EXPIRED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "storage access token is expired, you should get a new one from galaxy server"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getStorageAccessTokenResult()Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    return-object v0
.end method

.method public setStorageAccessTokenResult(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->storageAccessTokenResult:Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    return-void
.end method
