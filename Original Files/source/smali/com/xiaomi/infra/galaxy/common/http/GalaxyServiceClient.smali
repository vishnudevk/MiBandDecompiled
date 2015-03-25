.class public abstract Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;
.super Ljava/lang/Object;


# instance fields
.field protected client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

.field protected clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

.field protected endpoint:Ljava/net/URI;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-static {p2}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->setHttpClientFactory(Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    return-void
.end method


# virtual methods
.method public execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;",
            ")TT;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->endpoint:Ljava/net/URI;

    invoke-virtual {p1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->setEndpoint(Ljava/net/URI;)V

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-virtual {v0, p1, p2, p3}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getConfiguration()Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    return-object v0
.end method

.method public getEndpoint()Ljava/net/URI;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->endpoint:Ljava/net/URI;

    return-object v0
.end method

.method public setConfiguration(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    return-void
.end method

.method public setEndpoint(Ljava/lang/String;)V
    .locals 2

    const-string v0, "://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getProtocol()Lcom/xiaomi/infra/galaxy/common/Protocol;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/Protocol;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    :cond_0
    :try_start_0
    new-instance v0, Ljava/net/URI;

    invoke-direct {v0, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->endpoint:Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public abstract shutdown()V
.end method
