.class public Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
.super Ljava/lang/Object;


# instance fields
.field private complexConditions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;",
            ">;"
        }
    .end annotation
.end field

.field private conditions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Condition;",
            ">;"
        }
    .end annotation
.end field

.field private operator:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public addComplexCondition(Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;)Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public addCondition(Lcom/xiaomi/infra/galaxy/common/model/Condition;)Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-object p0
.end method

.method public check(Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;",
            ">;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->operator:Ljava/lang/String;

    invoke-static {v0}, Lcom/xiaomi/infra/galaxy/common/model/Operator;->fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Operator;

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/Condition;

    invoke-virtual {v0}, Lcom/xiaomi/infra/galaxy/common/model/Condition;->validate()V

    goto :goto_0

    :cond_0
    if-nez p1, :cond_1

    new-instance p1, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;

    invoke-direct {p1}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;-><init>()V

    :cond_1
    invoke-virtual {p1, p0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->push(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;->CONDITION_CYCLE_REFERENCE:Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "cycle in marshaller, "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->getCycleString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xiaomi/infra/galaxy/common/GalaxyClientException;-><init>(Lcom/xiaomi/infra/galaxy/common/constants/ReturnCode;Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;

    invoke-virtual {v0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->check(Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;)V

    goto :goto_1

    :cond_3
    return-void
.end method

.method public getComplexConditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    return-object v0
.end method

.method public getConditions()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Condition;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    return-object v0
.end method

.method public getOperator()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->operator:Ljava/lang/String;

    return-object v0
.end method

.method public setComplexConditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->complexConditions:Ljava/util/List;

    return-void
.end method

.method public setConditions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Condition;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->conditions:Ljava/util/List;

    return-void
.end method

.method public setOperator(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->operator:Ljava/lang/String;

    return-void
.end method

.method public withComplexConditions(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->setComplexConditions(Ljava/util/List;)V

    return-object p0
.end method

.method public withConditions(Ljava/util/List;)Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xiaomi/infra/galaxy/common/model/Condition;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->setConditions(Ljava/util/List;)V

    return-object p0
.end method

.method public withOperator(Lcom/xiaomi/infra/galaxy/common/model/Operator;)Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Operator;->name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/ComplexCondition;->setOperator(Ljava/lang/String;)V

    return-object p0
.end method
