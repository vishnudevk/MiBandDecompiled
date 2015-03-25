.class public Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;
.super Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;


# static fields
.field protected static final ALGORITHM:Ljava/lang/String; = "Galaxy-HMAC-SHA256"

.field protected static final TERMINATOR:Ljava/lang/String; = "galaxy_request"

.field protected static final log:Lorg/apache/commons/logging/Log;


# instance fields
.field protected dateStampFormat:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/text/SimpleDateFormat;",
            ">;"
        }
    .end annotation
.end field

.field protected dateTimeFormat:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/text/SimpleDateFormat;",
            ">;"
        }
    .end annotation
.end field

.field protected overriddenDate:Ljava/util/Date;

.field protected serviceName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;-><init>()V

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$1;

    invoke-direct {v0, p0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$1;-><init>(Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->dateTimeFormat:Ljava/lang/ThreadLocal;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$2;

    invoke-direct {v0, p0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$2;-><init>(Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;)V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->dateStampFormat:Ljava/lang/ThreadLocal;

    return-void
.end method


# virtual methods
.method protected addHostHeader(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V
    .locals 2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getEndpoint()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getEndpoint()Ljava/net/URI;

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->isUsingNonDefaultPort(Ljava/net/URI;)Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getEndpoint()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    const-string v1, "Host"

    invoke-virtual {p1, v1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method protected calculateContentHash(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;
    .locals 4

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getBinaryRequestPayloadStream(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/io/InputStream;

    move-result-object v0

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Ljava/io/InputStream;->mark(I)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->hash(Ljava/io/InputStream;)[B

    move-result-object v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/util/BinaryUtils;->toHex([B)Ljava/lang/String;

    move-result-object v1

    :try_start_0
    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v3, "Unable to reset stream after calculating galaxy signature"

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected computeSignature(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;
    .locals 8

    const-string v0, "Galaxy"

    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getDateTimeStamp(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getDateStamp(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "galaxy_request"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0, p1, p4}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getCanonicalRequest(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0, p3, v2, v3, v4}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getStringToSign(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v5

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Galaxy"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-interface {p5}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxySecretKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    sget-object v6, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->HmacSHA256:Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;

    invoke-virtual {p0, v1, v4, v6}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->sign(Ljava/lang/String;[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B

    move-result-object v1

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->HmacSHA256:Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;

    invoke-virtual {p0, v0, v1, v4}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->sign(Ljava/lang/String;[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B

    move-result-object v0

    const-string v1, "galaxy_request"

    sget-object v4, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->HmacSHA256:Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;

    invoke-virtual {p0, v1, v0, v4}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->sign(Ljava/lang/String;[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B

    move-result-object v4

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->HmacSHA256:Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;

    invoke-virtual {p0, v0, v4, v1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->sign([B[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B

    move-result-object v5

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;-><init>(Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;Ljava/lang/String;Ljava/lang/String;[B[B)V

    return-object v0
.end method

.method protected getCanonicalRequest(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)Ljava/lang/StringBuilder;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHttpMethod()Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getResourcePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getCanonicalizedResourcePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getCanonicalizedQueryString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getCanonicalizedHeaderString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getSignedHeadersString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Galaxy Canonical Request: \'\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_0
    return-object v0
.end method

.method protected getCanonicalizedHeaderString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;
    .locals 7

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    sget-object v1, Ljava/lang/String;->CASE_INSENSITIVE_ORDER:Ljava/util/Comparator;

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    const-string v5, "\\s+"

    const-string v6, " "

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ":"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v4

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v4, "\\s+"

    const-string v5, " "

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "\n"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDateStamp(Ljava/util/Date;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->dateStampFormat:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/text/SimpleDateFormat;

    invoke-virtual {v0, p1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getDateTimeStamp(Ljava/util/Date;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->dateTimeFormat:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/text/SimpleDateFormat;

    invoke-virtual {v0, p1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getScope(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/util/Date;)Ljava/lang/StringBuilder;
    .locals 3

    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getDateStamp(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->serviceName:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "galaxy_request"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    return-object v1
.end method

.method protected getSignedHeadersString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/StringBuilder;
    .locals 4

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    sget-object v1, Ljava/lang/String;->CASE_INSENSITIVE_ORDER:Ljava/util/Comparator;

    invoke-static {v0, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_0

    const-string v3, ";"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    :cond_1
    return-object v1
.end method

.method protected getStringToSign(Ljava/lang/String;Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->hash(Ljava/lang/String;)[B

    move-result-object v2

    invoke-static {v2}, Lcom/xiaomi/infra/galaxy/common/util/BinaryUtils;->toHex([B)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Galaxy String to Sign: \'\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_0
    return-object v0
.end method

.method overrideDate(Ljava/util/Date;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->overriddenDate:Ljava/util/Date;

    return-void
.end method

.method protected processRequestPayload(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;)V
    .locals 0

    return-void
.end method

.method public setServiceName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->serviceName:Ljava/lang/String;

    return-void
.end method

.method public sign(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V
    .locals 7

    instance-of v0, p2, Lcom/xiaomi/infra/galaxy/common/auth/AnonymousGalaxyCredentials;

    if-eqz v0, :cond_0

    const-string v0, "X-XiaoMi-Access-Method"

    const-string v1, "anonymous"

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    instance-of v0, p2, Lcom/xiaomi/infra/galaxy/common/auth/AppSecretCredentials;

    if-eqz v0, :cond_1

    const-string v0, "X-XiaoMi-Access-Method"

    const-string v1, "appsecrettoken"

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "X-XiaoMi-Token"

    invoke-interface {p2}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxySecretKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    invoke-virtual {p0, p2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->sanitizeCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

    move-result-object v5

    instance-of v0, p2, Lcom/xiaomi/infra/galaxy/common/auth/SessionCredentials;

    if-eqz v0, :cond_2

    const-string v0, "X-XiaoMi-Token"

    invoke-interface {p2}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxySecretKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_2
    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->addHostHeader(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {p0, p1, v2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getScope(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/util/Date;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->calculateContentHash(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v4

    const-string v0, "X-XiaoMi-Date"

    invoke-virtual {p0, v2}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getDateTimeStamp(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v0, v3}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v0

    const-string v3, "X-XiaoMi-Content-Sha256"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v0

    const-string v3, "X-XiaoMi-Content-Sha256"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v3, "required"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "X-XiaoMi-Content-Sha256"

    invoke-virtual {p1, v0, v4}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    :cond_3
    const-string v0, "X-XiaoMi-Content-Sha256"

    invoke-virtual {p1, v0, v4}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v5}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxyAppId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    const-string v3, "Galaxy-HMAC-SHA256"

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->computeSignature(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Credential="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "SignedHeaders="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->getSignedHeadersString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Signature="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->getSignature()[B

    move-result-object v5

    invoke-static {v5}, Lcom/xiaomi/infra/galaxy/common/util/BinaryUtils;->toHex([B)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Galaxy-HMAC-SHA256"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ", "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;

    const-string v1, "Authorization"

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, p1, v0}, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;->processRequestPayload(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;)V

    goto/16 :goto_0
.end method
