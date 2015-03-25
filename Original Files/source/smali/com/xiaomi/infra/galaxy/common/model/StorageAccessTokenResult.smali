.class public Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# instance fields
.field private expiresIn:J

.field private storageAccessToken:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>()V

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->setStorageAccessToken(Ljava/lang/String;)V

    invoke-virtual {p0, p2, p3}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->setExpiresIn(J)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 6

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne p0, p1, :cond_1

    move v3, v2

    :cond_0
    :goto_0
    return v3

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    if-eqz v0, :cond_0

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    move v1, v2

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_4

    :goto_2
    xor-int/2addr v1, v2

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getExpiresIn()J

    move-result-wide v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getExpiresIn()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->equals(Ljava/lang/Object;)Z

    move-result v3

    goto :goto_0

    :cond_3
    move v1, v3

    goto :goto_1

    :cond_4
    move v2, v3

    goto :goto_2
.end method

.method public getExpiresIn()J
    .locals 2

    iget-wide v0, p0, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->expiresIn:J

    return-wide v0
.end method

.method public getStorageAccessToken()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->storageAccessToken:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 6

    const/4 v1, 0x0

    invoke-super {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->hashCode()I

    move-result v0

    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/2addr v0, v2

    mul-int/lit8 v0, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getExpiresIn()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getStorageAccessToken()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getExpiresIn()J

    move-result-wide v1

    long-to-int v1, v1

    goto :goto_1
.end method

.method public setExpiresIn(J)V
    .locals 0

    iput-wide p1, p0, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->expiresIn:J

    return-void
.end method

.method public setStorageAccessToken(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->storageAccessToken:Ljava/lang/String;

    return-void
.end method
