.class public Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;
.super Ljava/lang/Exception;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private additionMessage:Ljava/lang/String;

.field private returnCode:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->returnCode:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->returnCode:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->additionMessage:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->getResult()Lcom/xiaomi/infra/galaxy/common/model/Result;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->returnCode:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->additionMessage:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAdditionMessage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->additionMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getReturnCode()Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;->returnCode:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    return-object v0
.end method
