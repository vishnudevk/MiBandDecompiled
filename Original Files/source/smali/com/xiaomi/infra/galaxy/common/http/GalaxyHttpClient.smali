.class public Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;
.super Ljava/lang/Object;


# static fields
.field private static final MAX_BACKOFF_IN_MILLISECONDS:I = 0x4e20

.field private static galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

.field private static httpClientFactory:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

.field private static httpRequestFactory:Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;

.field public static final log:Lorg/apache/commons/logging/Log;


# instance fields
.field private final config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

.field public isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private keepAliveHttpClient:Lorg/apache/http/client/HttpClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;-><init>()V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpRequestFactory:Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;->getInstance()Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->isKeepAlive()Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpClientFactory:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;->createHttpClient(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->keepAliveHttpClient:Lorg/apache/http/client/HttpClient;

    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    :goto_0
    return-void

    :cond_0
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    goto :goto_0
.end method

.method private executeHelper(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;Lorg/apache/http/client/HttpClient;)Ljava/lang/Object;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;",
            "Lorg/apache/http/client/HttpClient;",
            ")TT;"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->setUserAgent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V

    const/4 v2, 0x0

    const/4 v9, 0x0

    const/4 v7, 0x0

    const/4 v10, 0x0

    new-instance v11, Ljava/util/HashMap;

    invoke-direct {v11}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getParameters()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v11, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    new-instance v12, Ljava/util/HashMap;

    invoke-direct {v12}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v12, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    move v8, v2

    :goto_0
    if-lez v8, :cond_0

    invoke-virtual {p1, v11}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->setParameters(Ljava/util/Map;)V

    invoke-virtual {p1, v12}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->setHeaders(Ljava/util/Map;)V

    :cond_0
    const/4 v4, 0x0

    :try_start_0
    invoke-virtual/range {p3 .. p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getSigner()Lcom/xiaomi/infra/galaxy/common/auth/Signer;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual/range {p3 .. p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getCredentials()Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual/range {p3 .. p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getSigner()Lcom/xiaomi/infra/galaxy/common/auth/Signer;

    move-result-object v1

    invoke-virtual/range {p3 .. p3}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getCredentials()Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

    move-result-object v2

    invoke-interface {v1, p1, v2}, Lcom/xiaomi/infra/galaxy/common/auth/Signer;->sign(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V

    :cond_1
    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpRequestFactory:Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    move-object/from16 v0, p3

    invoke-virtual {v1, p1, v2, v7, v0}, Lcom/xiaomi/infra/galaxy/common/http/HttpRequestFactory;->createHttpRequest(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lorg/apache/http/HttpEntity;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Lorg/apache/http/client/methods/HttpRequestBase;

    move-result-object v4

    instance-of v1, v4, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-eqz v1, :cond_2

    move-object v0, v4

    check-cast v0, Lorg/apache/http/HttpEntityEnclosingRequest;

    move-object v1, v0

    invoke-interface {v1}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v7

    :cond_2
    if-eqz v9, :cond_3

    invoke-virtual {v4, v9}, Lorg/apache/http/client/methods/HttpRequestBase;->setURI(Ljava/net/URI;)V

    :cond_3
    if-lez v8, :cond_4

    invoke-direct {p0, v8, v10}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->pauseExponentially(ILcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)V

    :cond_4
    if-eqz v7, :cond_5

    invoke-interface {v7}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    if-lez v8, :cond_6

    invoke-virtual {v1}, Ljava/io/InputStream;->markSupported()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-virtual {v1}, Ljava/io/InputStream;->reset()V

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Ljava/io/InputStream;->mark(I)V

    :cond_5
    :goto_1
    move-object/from16 v0, p4

    invoke-interface {v0, v4}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isRequestSuccessful(Lorg/apache/http/HttpResponse;)Z

    move-result v1

    if-eqz v1, :cond_7

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object/from16 v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->handleResponse(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/HttpResponse;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v2, v8, 0x1

    :goto_2
    return-object v1

    :cond_6
    invoke-virtual {v1}, Ljava/io/InputStream;->markSupported()Z

    move-result v2

    if-eqz v2, :cond_5

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Ljava/io/InputStream;->mark(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v1

    move-object v2, v1

    move-object v1, v7

    :try_start_1
    sget-object v3, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unable to execute HTTP request: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5, v2}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    invoke-direct {p0, v4, v2, v8}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shouldRetry(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Exception;I)Z

    move-result v3

    if-nez v3, :cond_9

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to execute HTTP request: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v1, v3, v4, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :catchall_0
    move-exception v1

    add-int/lit8 v2, v8, 0x1

    throw v1

    :cond_7
    :try_start_2
    invoke-direct {p0, v4, v10, v8}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shouldRetry(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Exception;I)Z

    move-result v1

    if-nez v1, :cond_8

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object/from16 v6, p3

    invoke-direct/range {v1 .. v6}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->handleResponse(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/HttpResponse;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v1

    add-int/lit8 v2, v8, 0x1

    goto :goto_2

    :cond_8
    invoke-direct {p0, p1, v10}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->resetRequestAfterError(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    add-int/lit8 v1, v8, 0x1

    move v2, v1

    move-object v1, v7

    :goto_3
    move-object v7, v1

    move v8, v2

    goto/16 :goto_0

    :cond_9
    :try_start_3
    invoke-direct {p0, p1, v2}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->resetRequestAfterError(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    add-int/lit8 v2, v8, 0x1

    goto :goto_3
.end method

.method private handleResponse(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lorg/apache/http/client/methods/HttpRequestBase;Lorg/apache/http/HttpResponse;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;",
            "Ljava/lang/Class",
            "<TT;>;",
            "Lorg/apache/http/client/methods/HttpRequestBase;",
            "Lorg/apache/http/HttpResponse;",
            "Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;",
            ")TT;"
        }
    .end annotation

    invoke-virtual {p5}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->getMarshaller()Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    move-result-object v1

    invoke-interface {p4}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    new-instance v2, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v2}, Ljava/io/ByteArrayOutputStream;-><init>()V

    const/16 v3, 0x400

    new-array v3, v3, [B

    :goto_0
    invoke-virtual {v0, v3}, Ljava/io/InputStream;->read([B)I

    move-result v4

    if-gtz v4, :cond_0

    new-instance v0, Ljava/lang/String;

    const-string v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    const-class v2, Ljava/lang/String;

    invoke-virtual {p2, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v2

    if-eqz v2, :cond_1

    :goto_1
    return-object v0

    :cond_0
    const/4 v5, 0x0

    invoke-virtual {v2, v3, v5, v4}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    goto :goto_0

    :cond_1
    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->RESPONSE_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v0

    invoke-interface {v1, v0}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, p2, v0}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->unmarshall(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_1

    :cond_2
    invoke-interface {v1, p2, v0}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->unmarshall(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_1
.end method

.method public static isRequestEntityTooLargeException(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)Z
    .locals 2

    if-nez p0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const-string v0, "Request entity too large"

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method private isRequestSuccessful(Lorg/apache/http/HttpResponse;)Z
    .locals 2

    invoke-interface {p1}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    div-int/lit8 v0, v0, 0x64

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isThrottlingException(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)Z
    .locals 3

    const/4 v0, 0x0

    if-nez p0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "Throttling"

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "ThrottlingException"

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "ProvisionedThroughputExceededException"

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private pauseExponentially(ILcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)V
    .locals 5

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->galaxyBackoffStrategy:Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;

    invoke-virtual {v0, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyBackoffStrategy;->getBackoffPeriod(I)I

    move-result v0

    int-to-long v0, v0

    const-wide/16 v2, 0x4e20

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Retriable error detected, will retry in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "ms, attempt number: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_0
    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "thread interrupted!"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private resetRequestAfterError(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Exception;)V
    .locals 3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/InputStream;->markSupported()Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Encountered an exception and stream is not resettable"

    invoke-direct {v0, v1, v2, p2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0

    :cond_1
    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->HTTP_ERROR:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Encountered an exception and couldn\'t reset the stream to retry"

    invoke-direct {v0, v1, v2, p2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v0
.end method

.method public static setHttpClientFactory(Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;)V
    .locals 0

    sput-object p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpClientFactory:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

    return-void
.end method

.method private setUserAgent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V
    .locals 2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->DEFAULT_USER_AGENT:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->DEFAULT_USER_AGENT:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    if-eqz v0, :cond_1

    const-string v1, "User-Agent"

    invoke-virtual {p1, v1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    return-void
.end method

.method private shouldRetry(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Exception;I)Z
    .locals 4

    const/4 v0, 0x0

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getMaxErrorRetry()I

    move-result v2

    if-lt p3, v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v2, p1, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-eqz v2, :cond_2

    check-cast p1, Lorg/apache/http/HttpEntityEnclosingRequest;

    invoke-interface {p1}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-interface {v2}, Lorg/apache/http/HttpEntity;->isRepeatable()Z

    move-result v2

    if-nez v2, :cond_2

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "Entity not repeatable"

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    goto :goto_0

    :cond_2
    instance-of v2, p2, Ljava/io/IOException;

    if-eqz v2, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Retrying on "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_3
    move v0, v1

    goto :goto_0

    :cond_4
    instance-of v2, p2, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;

    if-eqz v2, :cond_0

    check-cast p2, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;

    invoke-virtual {p2}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getStatusCode()I

    move-result v2

    const/16 v3, 0x1f4

    if-eq v2, v3, :cond_5

    invoke-virtual {p2}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getStatusCode()I

    move-result v2

    const/16 v3, 0x1f7

    if-ne v2, v3, :cond_6

    :cond_5
    move v0, v1

    goto :goto_0

    :cond_6
    invoke-static {p2}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isThrottlingException(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)Z

    move-result v2

    if-eqz v2, :cond_7

    move v0, v1

    goto :goto_0

    :cond_7
    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isClockSkewError(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto/16 :goto_0
.end method

.method private shutdown(Lorg/apache/http/client/HttpClient;)V
    .locals 1

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    :cond_0
    return-void
.end method


# virtual methods
.method public execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;
    .locals 3
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

    if-nez p3, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->PARAMETER_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Internal SDK Error: No execution context parameter specified."

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->isKeepAlive()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpClientFactory:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;->createHttpClient(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->keepAliveHttpClient:Lorg/apache/http/client/HttpClient;

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->keepAliveHttpClient:Lorg/apache/http/client/HttpClient;

    move-object v1, v0

    :goto_0
    :try_start_0
    invoke-direct {p0, p1, p2, p3, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->executeHelper(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;Lorg/apache/http/client/HttpClient;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->isKeepAlive()Z

    move-result v2

    if-nez v2, :cond_2

    invoke-direct {p0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shutdown(Lorg/apache/http/client/HttpClient;)V

    :cond_2
    return-object v0

    :cond_3
    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->httpClientFactory:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;->createHttpClient(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)Lorg/apache/http/client/HttpClient;

    move-result-object v0

    move-object v1, v0

    goto :goto_0

    :catch_0
    move-exception v0

    :try_start_1
    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->config:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->isKeepAlive()Z

    move-result v2

    if-nez v2, :cond_4

    invoke-direct {p0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shutdown(Lorg/apache/http/client/HttpClient;)V

    :cond_4
    throw v0
.end method

.method public getKeepAliveHttpClient()Lorg/apache/http/client/HttpClient;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->keepAliveHttpClient:Lorg/apache/http/client/HttpClient;

    return-object v0
.end method

.method public isClockSkewError(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;)Z
    .locals 3

    const/4 v0, 0x0

    if-nez p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "RequestTimeTooSkewed"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "RequestExpired"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "InvalidSignatureException"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    const-string v1, "SignatureDoesNotMatch"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public shutdown()V
    .locals 3

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->isShutdown:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->keepAliveHttpClient:Lorg/apache/http/client/HttpClient;

    invoke-direct {p0, v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyHttpClient;->shutdown(Lorg/apache/http/client/HttpClient;)V

    :cond_0
    return-void
.end method
