.class public final Lcom/xiaomi/infra/galaxy/android/GalaxySSOClient;
.super Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V
    .locals 2

    new-instance v0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;

    invoke-direct {v0, p1}, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;->getInstance()Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 3

    new-instance v0, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;-><init>(Z)V

    invoke-virtual {v1, p1}, Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;->withAppId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/android/GalaxyServiceProxy;-><init>(Lcom/xiaomi/infra/galaxy/common/http/ClientConfiguration;)V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;->getInstance()Lcom/xiaomi/infra/galaxy/common/model/GSonMarshaller;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/http/BasicGalaxySSOClient;-><init>(Lcom/xiaomi/infra/galaxy/common/http/GalaxyServiceClient;Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V

    return-void
.end method

.method public static createInstance(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/android/GalaxySSOClient;
    .locals 1

    :try_start_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/android/GalaxySSOClient;

    invoke-direct {v0, p0}, Lcom/xiaomi/infra/galaxy/android/GalaxySSOClient;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/xiaomi/infra/galaxy/common/GalaxyClientException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method
