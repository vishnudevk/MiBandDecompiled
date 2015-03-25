.class public final Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory$LocationHeaderNotRequiredRedirectStrategy;
.super Lorg/apache/http/impl/client/DefaultRedirectStrategy;


# instance fields
.field final synthetic this$0:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory$LocationHeaderNotRequiredRedirectStrategy;->this$0:Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory;

    invoke-direct {p0}, Lorg/apache/http/impl/client/DefaultRedirectStrategy;-><init>()V

    return-void
.end method


# virtual methods
.method public isRedirected(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)Z
    .locals 2

    invoke-interface {p2}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    const-string v1, "location"

    invoke-interface {p2, v1}, Lorg/apache/http/HttpResponse;->getFirstHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v1

    if-nez v1, :cond_0

    const/16 v1, 0x12d

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Lorg/apache/http/impl/client/DefaultRedirectStrategy;->isRedirected(Lorg/apache/http/HttpRequest;Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)Z

    move-result v0

    goto :goto_0
.end method
