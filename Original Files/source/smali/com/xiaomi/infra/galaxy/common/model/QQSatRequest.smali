.class public Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;


# static fields
.field public static final OAUTHTYPE_OPEN:Ljava/lang/String; = "open"

.field public static final OAUTHTYPE_WEIBO:Ljava/lang/String; = "weibo"


# instance fields
.field private oauthType:Ljava/lang/String;

.field private openid:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;-><init>()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->setOauthProvider(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public getOauthType()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->oauthType:Ljava/lang/String;

    return-object v0
.end method

.method public getOpenid()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->openid:Ljava/lang/String;

    return-object v0
.end method

.method public setOauthProvider(Ljava/lang/String;)V
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->QQ:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->name()Ljava/lang/String;

    move-result-object v0

    invoke-super {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->setOauthProvider(Ljava/lang/String;)V

    return-void
.end method

.method public setOauthType(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->oauthType:Ljava/lang/String;

    return-void
.end method

.method public setOpenid(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->openid:Ljava/lang/String;

    return-void
.end method

.method public withOauthProvider(Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;)Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->QQ:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->setOauthProvider(Ljava/lang/String;)V

    return-object p0
.end method

.method public withOauthType(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->setOauthType(Ljava/lang/String;)V

    return-object p0
.end method

.method public withOpenid(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->setOpenid(Ljava/lang/String;)V

    return-object p0
.end method
