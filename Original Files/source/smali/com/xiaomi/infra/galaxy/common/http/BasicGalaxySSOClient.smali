.class public Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;
.super Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;


# instance fields
.field private miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

.field private ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 1

    invoke-direct {p0, p1, p2, p3}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;->getInstance()Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-direct {p0, v0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->getConfiguration()Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<X:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;",
            "Ljava/lang/Class",
            "<TX;>;)TX;"
        }
    .end annotation

    const-string v0, "X-XiaoMi-Appid"

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;-><init>()V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setMarshaller(Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->getServiceToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const-string v1, "X-XiaoMi-Access-Method"

    const-string v2, "anonymous"

    invoke-virtual {p1, v1, v2}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    invoke-virtual {v1, p1, p2, v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_1
    new-instance v1, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;

    const-string v2, ""

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->getSecurity()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->miSSOSigner:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOSigner;

    invoke-virtual {v0, v2}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setSigner(Lcom/xiaomi/infra/galaxy/common/auth/Signer;)V

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V

    const-string v1, "X-XiaoMi-Access-Method"

    const-string v2, "misso"

    invoke-virtual {p1, v1, v2}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "userId="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "; "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "serviceToken="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    invoke-virtual {v3}, Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;->getServiceToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "Cookie"

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v2, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setSSOToken(Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;->ssoToken:Lcom/xiaomi/infra/galaxy/common/auth/MiSSOToken;

    return-void
.end method
