.class public Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;
.super Ljava/lang/Object;


# instance fields
.field private delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

.field private get:Lcom/xiaomi/infra/galaxy/common/model/GetResult;

.field private set:Lcom/xiaomi/infra/galaxy/common/model/SetResult;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDelete()Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    return-object v0
.end method

.method public getGet()Lcom/xiaomi/infra/galaxy/common/model/GetResult;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->get:Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    return-object v0
.end method

.method public getSet()Lcom/xiaomi/infra/galaxy/common/model/SetResult;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->set:Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    return-object v0
.end method

.method public setDelete(Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->delete:Lcom/xiaomi/infra/galaxy/common/model/DeleteResult;

    return-void
.end method

.method public setGet(Lcom/xiaomi/infra/galaxy/common/model/GetResult;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->get:Lcom/xiaomi/infra/galaxy/common/model/GetResult;

    return-void
.end method

.method public setSet(Lcom/xiaomi/infra/galaxy/common/model/SetResult;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;->set:Lcom/xiaomi/infra/galaxy/common/model/SetResult;

    return-void
.end method
