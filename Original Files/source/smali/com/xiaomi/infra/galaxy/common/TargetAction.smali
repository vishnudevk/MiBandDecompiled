.class public Lcom/xiaomi/infra/galaxy/common/TargetAction;
.super Ljava/lang/Object;


# static fields
.field private static final REGULAR_UNDERSCORE:Ljava/lang/String; = "[_]"

.field private static final UNDERSCORE:Ljava/lang/String; = "_"


# instance fields
.field private apiVersion:Ljava/lang/String;

.field private level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

.field private operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

.field private serviceName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_0
    const-string v0, "[_]"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    array-length v1, v0

    const/4 v2, 0x4

    if-eq v1, v2, :cond_1

    :cond_1
    const/4 v1, 0x0

    aget-object v1, v0, v1

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->serviceName:Ljava/lang/String;

    const/4 v1, 0x1

    aget-object v1, v0, v1

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->apiVersion:Ljava/lang/String;

    const/4 v1, 0x2

    aget-object v1, v0, v1

    invoke-static {v1}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    move-result-object v1

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Batch:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Get:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Set:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Scan:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->Delete:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    if-eq v0, v1, :cond_2

    :cond_2
    return-void
.end method


# virtual methods
.method public format()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->serviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->apiVersion:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getApiVersion()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->apiVersion:Ljava/lang/String;

    return-object v0
.end method

.method public getLevel()Lcom/xiaomi/infra/galaxy/common/constants/APILevel;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    return-object v0
.end method

.method public getOperation()Lcom/xiaomi/infra/galaxy/common/constants/Operation;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-object v0
.end method

.method public getServiceName()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->serviceName:Ljava/lang/String;

    return-object v0
.end method

.method public setApiVersion(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->apiVersion:Ljava/lang/String;

    return-void
.end method

.method public setLevel(Lcom/xiaomi/infra/galaxy/common/constants/APILevel;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    return-void
.end method

.method public setOperation(Lcom/xiaomi/infra/galaxy/common/constants/Operation;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-void
.end method

.method public setServiceName(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->serviceName:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->serviceName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->apiVersion:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    invoke-virtual {v2}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public withAPILevel(Ljava/lang/String;)V
    .locals 1

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->level:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    return-void
.end method

.method public withOperation(Ljava/lang/String;)V
    .locals 1

    invoke-static {p1}, Lcom/xiaomi/infra/galaxy/common/constants/Operation;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/TargetAction;->operation:Lcom/xiaomi/infra/galaxy/common/constants/Operation;

    return-void
.end method
