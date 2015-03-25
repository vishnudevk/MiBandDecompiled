.class public Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
.super Ljava/lang/Object;


# static fields
.field public static final DEFAULT_MAX_CONNECTIONS:I = 0x32

.field public static final DEFAULT_MAX_RETRIES:I = 0x3

.field public static final DEFAULT_SOCKET_TIMEOUT:I = 0xc350

.field public static final DEFAULT_USER_AGENT:Ljava/lang/String;


# instance fields
.field private appId:Ljava/lang/String;

.field private connectionTimeout:I

.field private endpoint:Ljava/lang/String;

.field private final keepAlive:Z

.field private maxConnections:I

.field private maxErrorRetry:I

.field private protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

.field private proxyDomain:Ljava/lang/String;

.field private proxyHost:Ljava/lang/String;

.field private proxyPassword:Ljava/lang/String;

.field private proxyPort:I

.field private proxyUsername:Ljava/lang/String;

.field private proxyWorkstation:Ljava/lang/String;

.field private socketReceiveBufferSizeHint:I

.field private socketSendBufferSizeHint:I

.field private socketTimeout:I

.field private trustStore:Ljava/io/InputStream;

.field private trustStorePassword:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/GalaxyVersion;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->DEFAULT_USER_AGENT:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Z)V
    .locals 4

    const v3, 0xc350

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->DEFAULT_USER_AGENT:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    const/4 v0, 0x3

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    const/4 v0, -0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    const/16 v0, 0x32

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    iput v3, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    iput v3, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    iput v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    iput v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    const-string v0, "https://sds.api.xiaomi.com"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    iget v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->appId:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->appId:Ljava/lang/String;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStore:Ljava/io/InputStream;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStore:Ljava/io/InputStream;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStorePassword:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStorePassword:Ljava/lang/String;

    iget-object v0, p1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    iput-boolean p2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->keepAlive:Z

    return-void
.end method

.method public constructor <init>(Z)V
    .locals 4

    const v3, 0xc350

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->DEFAULT_USER_AGENT:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    const/4 v0, 0x3

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    const/4 v0, -0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    const/16 v0, 0x32

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    iput v3, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    iput v3, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    iput v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    iput v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    const-string v0, "https://sds.api.xiaomi.com"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    iput-boolean p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->keepAlive:Z

    return-void
.end method


# virtual methods
.method public getAppId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->appId:Ljava/lang/String;

    return-object v0
.end method

.method public getConnectionTimeout()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    return v0
.end method

.method public getEndpoint()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    return-object v0
.end method

.method public getMaxConnections()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    return v0
.end method

.method public getMaxErrorRetry()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    return v0
.end method

.method public getProtocol()Lcom/xiaomi/infra/galaxy/common/Protocol;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    return-object v0
.end method

.method public getProxyDomain()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getProxyHost()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    return-object v0
.end method

.method public getProxyPassword()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    return-object v0
.end method

.method public getProxyPort()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    return v0
.end method

.method public getProxyUsername()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    return-object v0
.end method

.method public getProxyWorkstation()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    return-object v0
.end method

.method public getSocketBufferSizeHints()[I
    .locals 3

    const/4 v0, 0x2

    new-array v0, v0, [I

    const/4 v1, 0x0

    iget v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    aput v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    aput v2, v0, v1

    return-object v0
.end method

.method public getSocketTimeout()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    return v0
.end method

.method public getTrustStore()Ljava/io/InputStream;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStore:Ljava/io/InputStream;

    return-object v0
.end method

.method public getTrustStorePassword()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStorePassword:Ljava/lang/String;

    return-object v0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method public isKeepAlive()Z
    .locals 1

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->keepAlive:Z

    return v0
.end method

.method public setAppId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->appId:Ljava/lang/String;

    return-void
.end method

.method public setConnectionTimeout(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->connectionTimeout:I

    return-void
.end method

.method public setEndpoint(Ljava/lang/String;)V
    .locals 6

    const/4 v1, 0x1

    const/4 v2, 0x0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v3, "https://"

    const-string v0, "https://"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    :cond_0
    const-string v3, "http://"

    const-string v0, "http://"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    move-object v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTP:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    :cond_1
    return-void
.end method

.method public setMaxConnections(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxConnections:I

    return-void
.end method

.method public setMaxErrorRetry(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->maxErrorRetry:I

    return-void
.end method

.method public setProtocol(Lcom/xiaomi/infra/galaxy/common/Protocol;)V
    .locals 6

    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    const-string v3, "https://"

    const-string v4, "https://"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTPS:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->endpoint:Ljava/lang/String;

    const-string v3, "http://"

    const-string v4, "http://"

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/Protocol;->HTTP:Lcom/xiaomi/infra/galaxy/common/Protocol;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    goto :goto_0

    :cond_1
    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->protocol:Lcom/xiaomi/infra/galaxy/common/Protocol;

    goto :goto_0
.end method

.method public setProxyDomain(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyDomain:Ljava/lang/String;

    return-void
.end method

.method public setProxyHost(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyHost:Ljava/lang/String;

    return-void
.end method

.method public setProxyPassword(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPassword:Ljava/lang/String;

    return-void
.end method

.method public setProxyPort(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyPort:I

    return-void
.end method

.method public setProxyUsername(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyUsername:Ljava/lang/String;

    return-void
.end method

.method public setProxyWorkstation(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->proxyWorkstation:Ljava/lang/String;

    return-void
.end method

.method public setSocketBufferSizeHints(II)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketSendBufferSizeHint:I

    iput p2, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketReceiveBufferSizeHint:I

    return-void
.end method

.method public setSocketTimeout(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->socketTimeout:I

    return-void
.end method

.method public setTrustStore(Ljava/io/InputStream;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStore:Ljava/io/InputStream;

    return-void
.end method

.method public setTrustStorePassword(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->trustStorePassword:Ljava/lang/String;

    return-void
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->userAgent:Ljava/lang/String;

    return-void
.end method

.method public withAppId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V

    return-object p0
.end method

.method public withConnectionTimeout(I)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setConnectionTimeout(I)V

    return-object p0
.end method

.method public withMaxConnections(I)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setMaxConnections(I)V

    return-object p0
.end method

.method public withMaxErrorRetry(I)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setMaxErrorRetry(I)V

    return-object p0
.end method

.method public withProtocol(Lcom/xiaomi/infra/galaxy/common/Protocol;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProtocol(Lcom/xiaomi/infra/galaxy/common/Protocol;)V

    return-object p0
.end method

.method public withProxyDomain(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyDomain(Ljava/lang/String;)V

    return-object p0
.end method

.method public withProxyHost(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyHost(Ljava/lang/String;)V

    return-object p0
.end method

.method public withProxyPassword(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyPassword(Ljava/lang/String;)V

    return-object p0
.end method

.method public withProxyPort(I)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyPort(I)V

    return-object p0
.end method

.method public withProxyUsername(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyUsername(Ljava/lang/String;)V

    return-object p0
.end method

.method public withProxyWorkstation(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setProxyWorkstation(Ljava/lang/String;)V

    return-object p0
.end method

.method public withSocketBufferSizeHints(II)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setSocketBufferSizeHints(II)V

    return-object p0
.end method

.method public withSocketTimeout(I)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setSocketTimeout(I)V

    return-object p0
.end method

.method public withUserAgent(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setUserAgent(Ljava/lang/String;)V

    return-object p0
.end method
