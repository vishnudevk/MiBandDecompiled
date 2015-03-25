.class public abstract Lcom/xiaomi/infra/galaxy/common/model/Request;
.super Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;
    .locals 1

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;->validate()V

    invoke-virtual {p0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/model/Request;->internalGetGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    move-result-object v0

    return-object v0
.end method

.method protected abstract internalGetGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;
.end method

.method public setRequestContent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)V
    .locals 2

    const-string v0, "Content-Type"

    const-string v1, "application/x-xiaomi-json-1.0"

    invoke-virtual {p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/HttpMethodName;->POST:Lcom/xiaomi/infra/galaxy/common/HttpMethodName;

    invoke-virtual {p1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->setHttpMethod(Lcom/xiaomi/infra/galaxy/common/HttpMethodName;)V

    :try_start_0
    const-string v0, "UTF-8"

    invoke-virtual {p2, v0}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    new-instance v1, Ljava/io/ByteArrayInputStream;

    invoke-direct {v1, v0}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    invoke-virtual {p1, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->setContent(Ljava/io/InputStream;)V

    const-string v1, "Content-Length"

    array-length v0, v0

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0
.end method

.method public abstract validate()V
.end method
