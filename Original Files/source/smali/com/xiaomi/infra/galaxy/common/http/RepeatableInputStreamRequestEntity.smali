.class public Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;
.super Lorg/apache/http/entity/BasicHttpEntity;


# static fields
.field private static final log:Lorg/apache/commons/logging/Log;


# instance fields
.field private content:Ljava/io/InputStream;

.field private firstAttempt:Z

.field private inputStreamRequestEntity:Lorg/apache/http/entity/InputStreamEntity;

.field private originalException:Ljava/io/IOException;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->log:Lorg/apache/commons/logging/Log;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;)V
    .locals 5

    invoke-direct {p0}, Lorg/apache/http/entity/BasicHttpEntity;-><init>()V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->firstAttempt:Z

    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->setChunked(Z)V

    const-wide/16 v1, -0x1

    :try_start_0
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v0

    const-string v3, "Content-Length"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    :goto_0
    move-wide v1, v0

    :goto_1
    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getHeaders()Ljava/util/Map;

    move-result-object v0

    const-string v3, "Content-Type"

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    new-instance v3, Lorg/apache/http/entity/InputStreamEntity;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v3, v4, v1, v2}, Lorg/apache/http/entity/InputStreamEntity;-><init>(Ljava/io/InputStream;J)V

    iput-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->inputStreamRequestEntity:Lorg/apache/http/entity/InputStreamEntity;

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->inputStreamRequestEntity:Lorg/apache/http/entity/InputStreamEntity;

    invoke-virtual {v3, v0}, Lorg/apache/http/entity/InputStreamEntity;->setContentType(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->getContent()Ljava/io/InputStream;

    move-result-object v3

    iput-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->content:Ljava/io/InputStream;

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->content:Ljava/io/InputStream;

    invoke-virtual {p0, v3}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->setContent(Ljava/io/InputStream;)V

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->setContentType(Ljava/lang/String;)V

    invoke-virtual {p0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->setContentLength(J)V

    return-void

    :catch_0
    move-exception v0

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Unable to parse content length from request.  Buffering contents in memory."

    invoke-interface {v0, v3}, Lorg/apache/commons/logging/Log;->warn(Ljava/lang/Object;)V

    goto :goto_1

    :cond_0
    move-wide v0, v1

    goto :goto_0
.end method


# virtual methods
.method public isChunked()Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public isRepeatable()Z
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->content:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->markSupported()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->inputStreamRequestEntity:Lorg/apache/http/entity/InputStreamEntity;

    invoke-virtual {v0}, Lorg/apache/http/entity/InputStreamEntity;->isRepeatable()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 2

    :try_start_0
    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->firstAttempt:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->isRepeatable()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->content:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V

    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->firstAttempt:Z

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->inputStreamRequestEntity:Lorg/apache/http/entity/InputStreamEntity;

    invoke-virtual {v0, p1}, Lorg/apache/http/entity/InputStreamEntity;->writeTo(Ljava/io/OutputStream;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->originalException:Ljava/io/IOException;

    if-nez v1, :cond_1

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->originalException:Ljava/io/IOException;

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/RepeatableInputStreamRequestEntity;->originalException:Ljava/io/IOException;

    throw v0
.end method
