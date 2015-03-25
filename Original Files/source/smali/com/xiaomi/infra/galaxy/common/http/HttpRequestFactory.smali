.class Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;
.super Ljava/lang/Object;


# static fields
.field private static final DEFAULT_ENCODING:Ljava/lang/String; = "UTF-8"

.field public static final log:Lorg/apache/commons/logging/Log;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private configureHeaders(Lorg/apache/http/client/methods/HttpRequestBase;Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 4

    invoke-virtual {p2}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getEndpoint()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->isUsingNonDefaultPort(Ljava/net/URI;)Z

    move-result v2

    if-eqz v2, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Ljava/net/URI;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    const-string v1, "Host"

    invoke-virtual {p1, v1, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p2}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v3, "Content-Length"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    const-string v3, "Host"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p1, v1, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const-string v0, "Content-Type"

    invoke-virtual {p1, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v0

    if-eqz v0, :cond_3

    const-string v0, "Content-Type"

    invoke-virtual {p1, v0}, Lorg/apache/http/client/methods/HttpRequestBase;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v0

    array-length v0, v0

    if-nez v0, :cond_4

    :cond_3
    const-string v0, "Content-Type"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "application/x-www-form-urlencoded; charset="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "UTF-8"

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    if-eqz p3, :cond_5

    invoke-virtual {p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getContextUserAgent()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    const-string v0, "User-Agent"

    invoke-virtual {p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getContextUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, p4, v1}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->createUserAgentString(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    return-void
.end method

.method private createUserAgentString(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getUserAgent()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private newBufferedHttpEntity(Lorg/apache/http/HttpEntity;)Lorg/apache/http/HttpEntity;
    .locals 5

    :try_start_0
    new-instance v0, Lorg/apache/http/entity/BufferedHttpEntity;

    invoke-direct {v0, p1}, Lorg/apache/http/entity/BufferedHttpEntity;-><init>(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to create HTTP entity: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private newStringEntity(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    .locals 5

    :try_start_0
    new-instance v0, Lorg/apache/http/entity/StringEntity;

    invoke-direct {v0, p1}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to create HTTP entity: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method createHttpRequest(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lorg/apache/http/HttpEntity;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Lorg/apache/http/client/methods/HttpRequestBase;
    .locals 7

    const/4 v3, 0x0

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getEndpoint()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_6

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v1

    const-string v4, "/"

    invoke-virtual {v1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    :cond_0
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->urlEncode(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_1
    :goto_1
    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->encodeParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v1

    if-eqz v1, :cond_7

    move v1, v2

    :goto_2
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v4

    sget-object v6, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v4, v6, :cond_8

    move v4, v2

    :goto_3
    if-eqz v4, :cond_2

    if-eqz v1, :cond_3

    :cond_2
    move v3, v2

    :cond_3
    if-eqz v5, :cond_4

    if-eqz v3, :cond_4

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_4
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v1, v3, :cond_a

    new-instance v1, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    if-nez v0, :cond_9

    if-eqz v5, :cond_9

    invoke-direct {p0, v5}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->newStringEntity(Ljava/lang/String;)Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-virtual {v1, v0}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    :goto_4
    move-object v0, v1

    :goto_5
    invoke-direct {p0, v0, p1, p4, p2}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->configureHeaders(Lorg/apache/http/client/methods/HttpRequestBase;Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    return-object v0

    :cond_5
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_6
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    :cond_7
    move v1, v3

    goto/16 :goto_2

    :cond_8
    move v4, v3

    goto :goto_3

    :cond_9
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;-><init>(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V

    invoke-virtual {v1, v0}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    goto :goto_4

    :cond_a
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->PUT:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v1, v3, :cond_e

    new-instance v1, Lorg/apache/http/client/methods/HttpPut;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Lorg/apache/http/client/methods/HttpPut;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v0

    const-string v3, "http.protocol.expect-continue"

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-interface {v0, v3, v2}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    if-eqz p3, :cond_c

    invoke-virtual {v1, p3}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V

    :cond_b
    :goto_6
    move-object v0, v1

    goto :goto_5

    :cond_c
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    if-eqz v0, :cond_b

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;-><init>(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v2

    const-string v3, "Content-Length"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    if-nez v2, :cond_d

    invoke-direct {p0, v0}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->newBufferedHttpEntity(Lorg/apache/http/HttpEntity;)Lorg/apache/http/HttpEntity;

    move-result-object v0

    :cond_d
    invoke-virtual {v1, v0}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V

    goto :goto_6

    :cond_e
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->GET:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v1, v2, :cond_f

    new-instance v1, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    move-object v0, v1

    goto/16 :goto_5

    :cond_f
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->DELETE:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v1, v2, :cond_10

    new-instance v1, Lorg/apache/http/client/methods/HttpDelete;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    move-object v0, v1

    goto/16 :goto_5

    :cond_10
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->HEAD:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    if-ne v1, v2, :cond_11

    new-instance v1, Lorg/apache/http/client/methods/HttpHead;

    invoke-direct {v1, v0}, Lorg/apache/http/client/methods/HttpHead;-><init>(Ljava/lang/String;)V

    move-object v0, v1

    goto/16 :goto_5

    :cond_11
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unknown HTTP method name: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0
.end method
