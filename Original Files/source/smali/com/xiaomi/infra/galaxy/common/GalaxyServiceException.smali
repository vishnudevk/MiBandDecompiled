.class public Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;
.super Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private errorCode:Ljava/lang/String;

.field private errorType:Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;

.field private serviceName:Ljava/lang/String;

.field private statusCode:I


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V
    .locals 1

    invoke-direct {p0, p1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;->Unknown:Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->errorType:Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;

    return-void
.end method


# virtual methods
.method public getErrorCode()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->errorCode:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorType()Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->errorType:Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->serviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->statusCode:I

    return v0
.end method

.method public setErrorCode(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->errorCode:Ljava/lang/String;

    return-void
.end method

.method public setErrorType(Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->errorType:Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException$ErrorType;

    return-void
.end method

.method public setServiceName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->serviceName:Ljava/lang/String;

    return-void
.end method

.method public setStatusCode(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->statusCode:I

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Status Code: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getStatusCode()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", Galaxy Service: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getServiceName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", Galaxy Error Code: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getErrorCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Galaxy Error Message: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/GalaxyServiceException;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
