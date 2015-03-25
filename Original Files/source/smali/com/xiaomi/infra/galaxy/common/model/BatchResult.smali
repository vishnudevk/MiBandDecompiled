.class public Lcom/xiaomi/infra/galaxy/common/model/BatchResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# instance fields
.field private batchCells:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>()V

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
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;->batchCells:Ljava/util/List;

    return-object v0
.end method

.method public setBatchCells(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/BatchCellResult;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/BatchResult;->batchCells:Ljava/util/List;

    return-void
.end method
