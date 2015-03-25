.class public Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;
.super Ljava/lang/Object;


# instance fields
.field private delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

.field private get:Lcom/xiaomi/infra/galaxy/common/model/GetRequest;

.field private set:Lcom/xiaomi/infra/galaxy/common/model/SetRequest;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelete()Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    return-object v0
.end method

.method public getGet()Lcom/xiaomi/infra/galaxy/common/model/GetRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->get:Lcom/xiaomi/infra/galaxy/common/model/GetRequest;

    return-object v0
.end method

.method public getSet()Lcom/xiaomi/infra/galaxy/common/model/SetRequest;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->set:Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    return-object v0
.end method

.method public setDelete(Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    return-void
.end method

.method public setGet(Lcom/xiaomi/infra/galaxy/common/model/GetRequest;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->get:Lcom/xiaomi/infra/galaxy/common/model/GetRequest;

    return-void
.end method

.method public setSet(Lcom/xiaomi/infra/galaxy/common/model/SetRequest;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->set:Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    return-void
.end method

.method public validate()V
    .locals 3

    const/4 v1, 0x1

    const/4 v0, 0x0

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->set:Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    if-eqz v2, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->set:Lcom/xiaomi/infra/galaxy/common/model/SetRequest;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/SetRequest;->validate()V

    move v0, v1

    :cond_0
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;->validate()V

    add-int/lit8 v0, v0, 0x1

    :cond_1
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->get:Lcom/xiaomi/infra/galaxy/common/model/GetRequest;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->get:Lcom/xiaomi/infra/galaxy/common/model/GetRequest;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/model/GetRequest;->validate()V

    add-int/lit8 v0, v0, 0x1

    :cond_2
    if-eq v0, v1, :cond_3

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->BATCH_CELLS_IS_NOT_ONLY:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    const-string v2, ""

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_3
    return-void
.end method

.method public withDelete(Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;)Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->setDelete(Lcom/xiaomi/infra/galaxy/common/model/DeleteRequest;)V

    return-object p0
.end method

.method public withGet(Lcom/xiaomi/infra/galaxy/common/model/GetRequest;)Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->setGet(Lcom/xiaomi/infra/galaxy/common/model/GetRequest;)V

    return-object p0
.end method

.method public withSet(Lcom/xiaomi/infra/galaxy/common/model/SetRequest;)Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/BatchCellRequest;->setSet(Lcom/xiaomi/infra/galaxy/common/model/SetRequest;)V

    return-object p0
.end method
