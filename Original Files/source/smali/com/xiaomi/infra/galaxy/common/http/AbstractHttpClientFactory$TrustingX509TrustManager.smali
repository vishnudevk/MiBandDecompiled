.class public Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory$TrustingX509TrustManager;
.super Ljava/lang/Object;

# interfaces
.implements Ljavax/net/ssl/X509TrustManager;


# static fields
.field private static final X509_CERTIFICATES:[Ljava/security/cert/X509Certificate;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Ljava/security/cert/X509Certificate;

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory$TrustingX509TrustManager;->X509_CERTIFICATES:[Ljava/security/cert/X509Certificate;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public checkClientTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public checkServerTrusted([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V
    .locals 0

    return-void
.end method

.method public getAcceptedIssuers()[Ljava/security/cert/X509Certificate;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/http/AbstractHttpClientFactory$TrustingX509TrustManager;->X509_CERTIFICATES:[Ljava/security/cert/X509Certificate;

    return-object v0
.end method
