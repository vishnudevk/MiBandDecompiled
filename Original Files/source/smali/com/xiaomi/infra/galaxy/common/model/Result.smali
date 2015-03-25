.class public Lcom/xiaomi/infra/galaxy/common/model/Result;
.super Ljava/lang/Object;


# static fields
.field public static final SUCCESS:I = 0x1


# instance fields
.field protected code:I

.field protected message:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->code:I

    const-string v0, "success"

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->message:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->code:I

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->message:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/model/Result;)V
    .locals 2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/Result;-><init>(ILjava/lang/String;)V

    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v1, 0x1

    const/4 v2, 0x0

    if-ne p0, p1, :cond_1

    move v2, v1

    :cond_0
    :goto_0
    return v2

    :cond_1
    if-eqz p1, :cond_0

    instance-of v0, p1, Lcom/xiaomi/infra/galaxy/common/model/Result;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/Result;

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v3

    if-ne v0, v3, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_4

    move v3, v1

    :goto_2
    xor-int/2addr v0, v3

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    :cond_2
    move v2, v1

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_1

    :cond_4
    move v3, v2

    goto :goto_2
.end method

.method public getCode()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->code:I

    return v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->message:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v0

    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v1, v0, 0x1f

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    add-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    goto :goto_0
.end method

.method public setCode(I)V
    .locals 0

    iput p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->code:I

    return-void
.end method

.method public setMessage(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/Result;->message:Ljava/lang/String;

    return-void
.end method

.method public setResult(Lcom/xiaomi/infra/galaxy/common/model/Result;)V
    .locals 1

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getCode()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->setCode(I)V

    invoke-virtual {p1}, Lcom/xiaomi/infra/galaxy/common/model/Result;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/Result;->setMessage(Ljava/lang/String;)V

    return-void
.end method
