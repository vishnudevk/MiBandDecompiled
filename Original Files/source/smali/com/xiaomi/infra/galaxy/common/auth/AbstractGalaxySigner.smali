.class public abstract Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/infra/galaxy/common/auth/Signer;


# static fields
.field protected static final DEFAULT_ENCODING:Ljava/lang/String; = "UTF-8"


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected getBinaryRequestPayload(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)[B
    .locals 3

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->usePayloadForQueryParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->encodeParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    new-array v0, v0, [B

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    const-string v1, "UTF-8"

    invoke-virtual {v0, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Unable to encode string into bytes"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getBinaryRequestPayloadWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)[B

    move-result-object v0

    goto :goto_0
.end method

.method protected getBinaryRequestPayloadStream(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/io/InputStream;
    .locals 3

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->usePayloadForQueryParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->encodeParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    new-instance v0, Ljava/io/ByteArrayInputStream;

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    :goto_0
    return-object v0

    :cond_0
    :try_start_0
    new-instance v0, Ljava/io/ByteArrayInputStream;

    const-string v2, "UTF-8"

    invoke-virtual {v1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Unable to encode string into bytes"

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_1
    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getBinaryRequestPayloadStreamWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0
.end method

.method protected getBinaryRequestPayloadStreamWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/io/InputStream;
    .locals 5

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v0

    if-nez v0, :cond_1

    new-instance v0, Ljava/io/ByteArrayInputStream;

    const/4 v1, 0x0

    new-array v1, v1, [B

    invoke-direct {v0, v1}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    instance-of v1, v0, Lcom/xiaomi/infra/galaxy/common/util/StringInputStream;

    if-nez v1, :cond_0

    invoke-virtual {v0}, Ljava/io/InputStream;->markSupported()Z

    move-result v0

    if-nez v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, "Unable to read request payload to sign request."

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to read request payload to sign request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    :cond_2
    :try_start_1
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v0

    goto :goto_0
.end method

.method protected getBinaryRequestPayloadWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)[B
    .locals 6

    const/4 v5, -0x1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getBinaryRequestPayloadStreamWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/io/InputStream;

    move-result-object v0

    const/4 v1, -0x1

    :try_start_0
    invoke-virtual {v0, v1}, Ljava/io/InputStream;->mark(I)V

    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    const/16 v2, 0x1400

    new-array v2, v2, [B

    :goto_0
    invoke-virtual {v0, v2}, Ljava/io/InputStream;->read([B)I

    move-result v3

    if-ne v3, v5, :cond_0

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V

    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4, v3}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to read request payload to sign request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected getCanonicalizedEndpoint(Ljava/net/URI;)Ljava/lang/String;
    .locals 2

    invoke-virtual {p1}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->isUsingNonDefaultPort(Ljava/net/URI;)Z

    move-result v1

    if-eqz v1, :cond_0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/net/URI;->getPort()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method protected getCanonicalizedQueryString(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;
    .locals 1

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->usePayloadForQueryParameters(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getParameters()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getCanonicalizedQueryString(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getCanonicalizedQueryString(Ljava/util/Map;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    const/4 v4, 0x0

    new-instance v2, Ljava/util/TreeMap;

    invoke-direct {v2}, Ljava/util/TreeMap;-><init>()V

    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->urlEncode(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v4}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->urlEncode(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v1, v0}, Ljava/util/SortedMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v2}, Ljava/util/SortedMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "="

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "&"

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getCanonicalizedResourcePath(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    :cond_0
    const-string v0, "/"

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/xiaomi/infra/galaxy/common/util/HttpUtils;->urlEncode(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "/"

    invoke-virtual {v1, v0}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected getRequestPayload(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getBinaryRequestPayload(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->newString([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getRequestPayloadWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)Ljava/lang/String;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->getBinaryRequestPayloadWithoutQueryParams(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)[B

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->newString([B)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected hash(Ljava/io/InputStream;)[B
    .locals 5

    :try_start_0
    const-string v0, "SHA-256"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    new-instance v1, Ljava/security/DigestInputStream;

    invoke-direct {v1, p1, v0}, Ljava/security/DigestInputStream;-><init>(Ljava/io/InputStream;Ljava/security/MessageDigest;)V

    const/16 v0, 0x400

    new-array v0, v0, [B

    :cond_0
    invoke-virtual {v1, v0}, Ljava/security/DigestInputStream;->read([B)I

    move-result v2

    const/4 v3, -0x1

    if-gt v2, v3, :cond_0

    invoke-virtual {v1}, Ljava/security/DigestInputStream;->getMessageDigest()Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to compute hash while signing request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public hash(Ljava/lang/String;)[B
    .locals 5

    :try_start_0
    const-string v0, "SHA-256"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    const-string v1, "UTF-8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/security/MessageDigest;->update([B)V

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to compute hash while signing request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method public hash([B)[B
    .locals 5

    :try_start_0
    const-string v0, "SHA-256"

    invoke-static {v0}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/security/MessageDigest;->update([B)V

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to compute hash while signing request: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected newString([B)Ljava/lang/String;
    .locals 4

    :try_start_0
    new-instance v0, Ljava/lang/String;

    const-string v1, "UTF-8"

    invoke-direct {v0, p1, v1}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v3, "Unable to encode bytes to String"

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected sanitizeCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;
    .locals 3

    monitor-enter p1

    :try_start_0
    invoke-interface {p1}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxyAppId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1}, Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;->getGalaxySecretKey()Ljava/lang/String;

    move-result-object v1

    monitor-exit p1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    :cond_1
    new-instance v2, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;

    invoke-direct {v2, v0, v1}, Lcom/xiaomi/infra/galaxy/common/auth/BasicGalaxyCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public sign(Ljava/lang/String;[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B
    .locals 5

    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->sign([B[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to calculate a request signature: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected sign([B[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B
    .locals 5

    :try_start_0
    invoke-virtual {p3}, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v0

    new-instance v1, Ljavax/crypto/spec/SecretKeySpec;

    invoke-virtual {p3}, Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, p2, v2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    invoke-virtual {v0, v1}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    invoke-virtual {v0, p1}, Ljavax/crypto/Mac;->doFinal([B)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to calculate a request signature: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method protected signAndBase64Encode(Ljava/lang/String;Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)Ljava/lang/String;
    .locals 5

    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p1, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->signAndBase64Encode([BLjava/lang/String;Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to calculate a request signature: "

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

.method protected signAndBase64Encode([BLjava/lang/String;Lcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)Ljava/lang/String;
    .locals 5

    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p2, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    invoke-virtual {p0, p1, v0, p3}, Lcom/xiaomi/infra/galaxy/common/auth/AbstractGalaxySigner;->sign([B[BLcom/xiaomi/infra/galaxy/common/auth/SigningAlgorithm;)[B

    move-result-object v0

    new-instance v1, Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/util/Base64Utils;->encode([B)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/String;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    :catch_0
    move-exception v0

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->SIGNATURE_FAILED:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Unable to calculate a request signature: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3, v0}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method
