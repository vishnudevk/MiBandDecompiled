.class public Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;
.super Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;


# static fields
.field private static final log:Lorg/apache/commons/logging/Log;


# instance fields
.field private sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

.field private signer:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 2

    invoke-direct {p0, p1, p2, p3}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    const-string v1, "Galaxy"

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->setServiceName(Ljava/lang/String;)V

    invoke-virtual {p2, p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->setConfiguration(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 1

    if-nez p1, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-direct {p0, v0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    return-void

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->getConfiguration()Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public getStorageAccessTokenResult()Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->getStorageAccessTokenResult()Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized getstorageAccessToken(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;)Z
    .locals 8

    const/4 v3, 0x1

    const/4 v2, 0x0

    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v4

    :try_start_1
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "storage access token request\'s appId is null"

    invoke-interface {v1, v5}, Lorg/apache/commons/logging/Log;->info(Ljava/lang/Object;)V

    invoke-virtual {p1, v4}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->setAppId(Ljava/lang/String;)V

    :goto_0
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-interface {v1, p1}, Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;->marshall(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    sget-object v5, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {p1, v1, v5}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v5

    const-string v1, "appid"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAppId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v1, v6}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "storage access token request\'s access token is null"

    invoke-interface {v1, v3}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move v1, v2

    :goto_1
    monitor-exit p0

    return v1

    :cond_0
    :try_start_2
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAppId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    :try_start_3
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "get storage access token failed!"

    invoke-interface {v3, v5, v1}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;Ljava/lang/Throwable;)V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1, v4}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move v1, v2

    goto :goto_1

    :cond_1
    :try_start_4
    const-string v1, "accessToken"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAccessToken()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v1, v6}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthAppId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "storage access token request\'s oauth appId is null"

    invoke-interface {v1, v3}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    move v1, v2

    goto :goto_1

    :cond_2
    const-string v1, "oauth_appid"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthAppId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v1, v6}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    const-string v6, "oauth_version"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthVersion()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_3

    const-string v1, ""

    :goto_2
    invoke-virtual {v5, v6, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthProvider()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    move-result-object v1

    sget-object v6, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->QQ:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    if-ne v1, v6, :cond_6

    instance-of v1, p1, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1, v4}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OAUTH_ACCESSTOKEN_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "should use "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-class v6, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " class with qq oauth "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v3, v5}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    :cond_3
    :try_start_5
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthVersion()Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    :cond_4
    const-string v6, "oauth_qq_openid"

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;

    move-object v1, v0

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->getOpenid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v6, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    const-string v6, "oauth_qq_oauth_type"

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;

    move-object v1, v0

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/QQSatRequest;->getOauthType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v6, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    :cond_5
    :goto_3
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthProvider()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1, v4}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "storage access token request\'s oauth provider is null"

    invoke-interface {v1, v3}, Lorg/apache/commons/logging/Log;->error(Ljava/lang/Object;)V

    move v1, v2

    goto/16 :goto_1

    :cond_6
    sget-object v6, Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;->XiaoMi:Lcom/xiaomi/infra/galaxy/common/model/OAuthProvider;

    if-ne v1, v6, :cond_5

    instance-of v1, p1, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1, v4}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v3, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->OAUTH_ACCESSTOKEN_IS_INVALID:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "should use "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-class v6, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " class with xiaomi oauth "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v1, v3, v5}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v1

    :cond_7
    const-string v6, "oauth_xiaomi_mackey"

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;

    move-object v1, v0

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->getMacKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v6, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    const-string v6, "oauht_xiaomi_mac_algorithm"

    move-object v0, p1

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;

    move-object v1, v0

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/MiSatRequest;->getMacAlgorithm()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v6, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    :cond_8
    const-string v1, "oauth_provider"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getOauthProvider()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v1, v6}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addParameter(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "X-XiaoMi-Appid"

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAppId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v1, v6}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;

    invoke-direct {v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;-><init>()V

    iget-object v6, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    invoke-virtual {v1, v6}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setSigner(Lcom/xiaomi/infra/galaxy/common/auth/Signer;)V

    new-instance v6, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenRequest;->getAppId()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v6}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V

    iget-object v6, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-virtual {v1, v6}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setMarshaller(Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    iget-object v6, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    const-class v7, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    invoke-virtual {v6, v5, v7, v1}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;->getCode()I

    move-result v5

    if-eq v5, v3, :cond_9

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1, v4}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->setAppId(Ljava/lang/String;)V

    move v1, v2

    goto/16 :goto_1

    :cond_9
    iget-object v5, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v5, v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->setStorageAccessTokenResult(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    move v1, v3

    goto/16 :goto_1
.end method

.method protected invoke(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 3
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

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->getGalaxyAppId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;-><init>()V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setSigner(Lcom/xiaomi/infra/galaxy/common/auth/Signer;)V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setMarshaller(Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->isLogin()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V

    :goto_0
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->serviceClient:Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;

    invoke-virtual {v1, p1, p2, v0}, Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;->execute(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/Class;Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    :cond_0
    new-instance v1, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->setCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V

    goto :goto_0
.end method

.method public isLogin()Z
    .locals 2

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->getGalaxySecretKey()Ljava/lang/String;
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/SessionExpiredException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->logout()V

    goto :goto_0
.end method

.method public declared-synchronized logout()V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->setStorageAccessTokenResult(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setStorageAccessTokenResult(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;)V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    invoke-virtual {v0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;->setStorageAccessTokenResult(Lcom/xiaomi/infra/galaxy/common/model/StorageAccessTokenResult;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->clientConfiguration:Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->getAppId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxyOAuthClient;->sessionCredentials:Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
