.class public Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;


# instance fields
.field private macAlgorithm:Ljava/lang/String;

.field private macKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;-><init>()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->setOauthProvider(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getMacAlgorithm()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->macAlgorithm:Ljava/lang/String;

    return-object v0
.end method

.method public getMacKey()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->macKey:Ljava/lang/String;

    return-object v0
.end method

.method public setMacAlgorithm(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->macAlgorithm:Ljava/lang/String;

    return-void
.end method

.method public setMacKey(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->macKey:Ljava/lang/String;

    return-void
.end method

.method public setOauthProvider(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->XiaoMi:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->name()Ljava/lang/String;

    move-result-object v0

    invoke-super {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->setOauthProvider(Ljava/lang/String;)V

    return-void
.end method

.method public withMacAlgorithm(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->setMacAlgorithm(Ljava/lang/String;)V

    return-object p0
.end method

.method public withMacKey(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->setMacKey(Ljava/lang/String;)V

    return-object p0
.end method

.method public withOauthProvider(Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;)Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->XiaoMi:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->setOauthProvider(Ljava/lang/String;)V

    return-object p0
.end method
