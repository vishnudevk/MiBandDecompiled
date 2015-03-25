.class public abstract Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;
.super Ljava/lang/Object;


# static fields
.field private static final log:Lorg/apache/commons/logging/Log;


# instance fields
.field protected clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

.field protected marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

.field protected serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->APP_ID_IS_BLANK:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "appId is empty"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_0
    return-void
.end method


# virtual methods
.method public batch(Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;)Lcom/xiaomi/infra/galaxy/common/model/BatchResult;
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    const-class v1, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;

    invoke-virtual {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_2
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "operation failed"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OPERATION_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0
.end method

.method public delete(Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;)Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;
    .locals 3

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->USER_ID_IS_UNNECESSARY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    const-class v1, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    invoke-virtual {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_2
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "operation failed"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OPERATION_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0
.end method

.method public get(Lcom/xiaomi/infra/galaxy/common/model/GetRequest;)Lcom/xiaomi/infra/galaxy/common/model/GetResult;
    .locals 3

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/GetRequest;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->USER_ID_IS_UNNECESSARY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/GetRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    const-class v1, Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    invoke-virtual {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/GetResult;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_2
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "operation failed"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OPERATION_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/GetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0
.end method

.method protected abstract invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;
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
.end method

.method public scan(Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;)Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    .locals 3

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->USER_ID_IS_UNNECESSARY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ScanRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    const-class v1, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-virtual {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_2
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "operation failed"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OPERATION_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/ScanResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0
.end method

.method public set(Lcom/xiaomi/infra/galaxy/common/model/SetRequest;)Lcom/xiaomi/infra/galaxy/common/model/SetResult;
    .locals 3

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getUserId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isNotBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->USER_ID_IS_UNNECESSARY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    const-class v1, Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    invoke-virtual {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/SetResult;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/SessionExpiredException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_1
    move-exception v0

    move-object v1, v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;-><init>()V

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0

    :catch_2
    move-exception v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "operation failed"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;-><init>()V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OPERATION_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/SetResult;->setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V

    goto :goto_0
.end method

.method public shutdown()V
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->shutdown()V

    :cond_0
    return-void
.end method
