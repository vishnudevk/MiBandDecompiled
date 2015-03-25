.class Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;
.super Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 3

    const/4 v1, 0x3

    new-instance v0, Lcom/xiaomi/infra/galaxy/android/http/HttpAndroidClientFactory;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/android/http/HttpAndroidClientFactory;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->APP_ID_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "galaxy appId is empty"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getMaxErrorRetry()I

    move-result v0

    if-le v0, v1, :cond_1

    invoke-virtual {p1, v1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setMaxErrorRetry(I)V

    :cond_1
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getEndpoint()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;->setEndpoint(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public setConfiguration(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 1

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    return-void
.end method

.method public shutdown()V
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->getKeepAliveHttpClient()Lorg/apache/http/client/HttpClient;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;->client:Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shutdown()V

    :cond_0
    return-void
.end method
