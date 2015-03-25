.class public Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private appId:Ljava/lang/String;

.field private authMethods:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    return-void
.end method


# virtual methods
.method public getAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthMethods()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->authMethods:Ljava/util/Map;

    return-object v0
.end method

.method protected internalGetGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;
    .locals 3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    const-string v1, "Galaxy"

    invoke-direct {v0, p0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;-><init>(Lcom/xiaomi/infra/galaxy/common/model/Request;Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/TargetAction;

    invoke-direct {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;-><init>()V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/GalaxyVersion;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setApiVersion(Ljava/lang/String;)V

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setLevel(Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)V

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->AlterAppInfo:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setOperation(Lcom/xiaomi/infra/galaxy/common/constants/Operation;)V

    const-string v2, "Galaxy"

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setServiceName(Ljava/lang/String;)V

    const-string v2, "X-XiaoMi-Action"

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->format()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-super {p0, v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Request;->setRequestContent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)V

    return-object v0
.end method

.method public setAppId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->appId:Ljava/lang/String;

    return-void
.end method

.method public setAuthMethods(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->authMethods:Ljava/util/Map;

    return-void
.end method

.method public validate()V
    .locals 2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->appId:Ljava/lang/String;

    if-eqz v0, :cond_0

    const-string v0, ""

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->appId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->APP_ID_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_1
    return-void
.end method

.method public withAppId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->setAppId(Ljava/lang/String;)V

    return-object p0
.end method

.method public withAuthMethods(Ljava/util/Map;)Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/AlterAppInfoRequest;->setAuthMethods(Ljava/util/Map;)V

    return-object p0
.end method
