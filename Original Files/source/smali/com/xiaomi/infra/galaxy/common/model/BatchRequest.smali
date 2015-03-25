.class public Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;
.super Lcom/xiaomi/infra/galaxy/common/model/Request;


# instance fields
.field private batchCells:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Request;-><init>()V

    return-void
.end method


# virtual methods
.method public getBatchCells()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->batchCells:Ljava/util/List;

    return-object v0
.end method

.method protected internalGetGalaxyRequest(Ljava/lang/String;Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;
    .locals 3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;

    const-string v1, "Galaxy"

    invoke-direct {v0, p0, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;-><init>(Lcom/xiaomi/infra/galaxy/common/model/Request;Ljava/lang/String;)V

    new-instance v1, Lcom/xiaomi/infra/galaxy/common/TargetAction;

    invoke-direct {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;-><init>()V

    invoke-static {}, Lcom/xiaomi/infra/galaxy/common/GalaxyVersion;->getVersion()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setApiVersion(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setLevel(Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)V

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setOperation(Lcom/xiaomi/infra/galaxy/common/constants/Operation;)V

    const-string v2, "Galaxy"

    invoke-virtual {v1, v2}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->setServiceName(Ljava/lang/String;)V

    const-string v2, "X-XiaoMi-Action"

    invoke-virtual {v1}, Lcom/xiaomi/infra/galaxy/common/TargetAction;->format()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    invoke-super {p0, v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/Request;->setRequestContent(Lcom/xiaomi/infra/galaxy/common/BasicGalaxyRequest;Ljava/lang/String;)V

    return-object v0
.end method

.method public setBatchCells(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->batchCells:Ljava/util/List;

    return-void
.end method

.method public validate()V
    .locals 2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->batchCells:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->batchCells:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->BATCH_CELLS_IS_EMPTY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    invoke-direct {v0, v1}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;)V

    throw v0

    :cond_1
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->batchCells:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->validate()V

    goto :goto_0

    :cond_2
    return-void
.end method

.method public withBatchCells(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/BatchRequest;->setBatchCells(Ljava/util/List;)V

    return-object p0
.end method
