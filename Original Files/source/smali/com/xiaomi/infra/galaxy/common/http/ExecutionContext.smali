.class public Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;
.super Ljava/lang/Object;


# instance fields
.field private contextUserAgent:Ljava/lang/String;

.field private credentials:Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

.field private marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

.field private signer:Lcom/xiaomi/infra/galaxy/common/auth/Signer;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getContextUserAgent()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->contextUserAgent:Ljava/lang/String;

    return-object v0
.end method

.method public getCredentials()Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->credentials:Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

    return-object v0
.end method

.method public getMarshaller()Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    return-object v0
.end method

.method public getSigner()Lcom/xiaomi/infra/galaxy/common/auth/Signer;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Signer;

    return-object v0
.end method

.method public setContextUserAgent(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->contextUserAgent:Ljava/lang/String;

    return-void
.end method

.method public setCredentials(Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->credentials:Lcom/xiaomi/infra/galaxy/common/auth/GalaxyCredentials;

    return-void
.end method

.method public setMarshaller(Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->marshaller:Lcom/xiaomi/infra/galaxy/common/model/GalaxyMarshaller;

    return-void
.end method

.method public setSigner(Lcom/xiaomi/infra/galaxy/common/auth/Signer;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/http/ExecutionContext;->signer:Lcom/xiaomi/infra/galaxy/common/auth/Signer;

    return-void
.end method
