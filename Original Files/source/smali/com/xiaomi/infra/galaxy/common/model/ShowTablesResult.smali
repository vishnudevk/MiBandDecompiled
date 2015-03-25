.class public Lcom/xiaomi/infra/galaxy/common/model/ShowTablesResult;
.super Lcom/xiaomi/infra/galaxy/common/model/Result;


# instance fields
.field private tables:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
            ">;"
        }
    .end annotation
.end field

.field private unusedTables:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
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
.method public getTables()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ShowTablesResult;->tables:Ljava/util/List;

    return-object v0
.end method

.method public getUnusedTables()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ShowTablesResult;->unusedTables:Ljava/util/List;

    return-object v0
.end method

.method public setTables(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ShowTablesResult;->tables:Ljava/util/List;

    return-void
.end method

.method public setUnusedTables(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/TableDescription;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ShowTablesResult;->unusedTables:Ljava/util/List;

    return-void
.end method
