.class public final Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;
.super Ljava/util/AbstractList;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/AbstractList",
        "<TE;>;"
    }
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private data:[Ljava/lang/Object;

.field private final initialHash:[I

.field private latestPushResult:Z

.field private next:[I

.field private size:I

.field private useIdentity:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>()V
    .locals 2

    const/16 v1, 0x10

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/util/AbstractList;-><init>()V

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    iput-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->latestPushResult:Z

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->useIdentity:Z

    const/16 v0, 0x11

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    new-array v0, v1, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    new-array v0, v1, [I

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    return-void
.end method

.method private expandCapacity()V
    .locals 5

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    array-length v0, v0

    mul-int/lit8 v1, v0, 0x2

    new-array v2, v1, [Ljava/lang/Object;

    new-array v1, v1, [I

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    invoke-static {v3, v4, v2, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    invoke-static {v3, v4, v1, v4, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    iput-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iput-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    return-void
.end method

.method private findDuplicate(Ljava/lang/Object;I)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;I)Z"
        }
    .end annotation

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    aget v1, v1, p2

    :goto_0
    if-eqz v1, :cond_3

    add-int/lit8 v1, v1, -0x1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    aget-object v2, v2, v1

    iget-boolean v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->useIdentity:Z

    if-eqz v3, :cond_1

    if-ne v2, p1, :cond_2

    :cond_0
    :goto_1
    return v0

    :cond_1
    invoke-virtual {p1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_2
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    aget v1, v2, v1

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private hash(Ljava/lang/Object;)I
    .locals 2

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->useIdentity:Z

    if-eqz v0, :cond_0

    invoke-static {p1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v0

    :goto_0
    const v1, 0x7fffffff

    and-int/2addr v0, v1

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    array-length v1, v1

    rem-int/2addr v0, v1

    return v0

    :cond_0
    invoke-virtual {p1}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0
.end method


# virtual methods
.method public findDuplicate(Ljava/lang/Object;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->hash(Ljava/lang/Object;)I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->findDuplicate(Ljava/lang/Object;I)Z

    move-result v0

    return v0
.end method

.method public get(I)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)TE;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getCycleString()Ljava/lang/String;
    .locals 4

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->get(I)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    :cond_0
    const-string v3, " -> "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v0, -0x1

    invoke-virtual {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    if-ne v2, v3, :cond_0

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLatestPushResult()Z
    .locals 1

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->latestPushResult:Z

    return v0
.end method

.method public getUseIdentity()Z
    .locals 1

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->useIdentity:Z

    return v0
.end method

.method public peek()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v1, v1, -0x1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public pop()Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TE;"
        }
    .end annotation

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iget v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    const/4 v3, 0x0

    aput-object v3, v1, v2

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    iget v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    aget v1, v1, v2

    if-gez v1, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, v0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->hash(Ljava/lang/Object;)I

    move-result v2

    sget-boolean v3, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->$assertionsDisabled:Z

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    aget v3, v3, v2

    iget v4, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v4, v4, 0x1

    if-eq v3, v4, :cond_1

    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    :cond_1
    iget-object v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    aput v1, v3, v2

    goto :goto_0
.end method

.method public push(Ljava/lang/Object;)Z
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)Z"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    array-length v0, v0

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    if-ne v0, v1, :cond_0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->expandCapacity()V

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    aput-object p1, v0, v1

    invoke-direct {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->hash(Ljava/lang/Object;)I

    move-result v0

    invoke-direct {p0, p1, v0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->findDuplicate(Ljava/lang/Object;I)Z

    move-result v1

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    iget v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    iget-object v4, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    aget v4, v4, v0

    aput v4, v2, v3

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    iget v3, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v3, v3, 0x1

    aput v3, v2, v0

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    iput-boolean v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->latestPushResult:Z

    iget-boolean v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->latestPushResult:Z

    return v0
.end method

.method public pushNocheck(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)V"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    array-length v0, v0

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    if-ne v0, v1, :cond_0

    invoke-direct {p0}, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->expandCapacity()V

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->data:[Ljava/lang/Object;

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    aput-object p1, v0, v1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->next:[I

    iget v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    const/4 v2, -0x1

    aput v2, v0, v1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    return-void
.end method

.method public reset()V
    .locals 2

    const/4 v1, 0x0

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    if-lez v0, :cond_0

    iput v1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->initialHash:[I

    invoke-static {v0, v1}, Ljava/util/Arrays;->fill([II)V

    :cond_0
    return-void
.end method

.method public setUseIdentity(Z)V
    .locals 0

    iput-boolean p1, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->useIdentity:Z

    return-void
.end method

.method public size()I
    .locals 1

    iget v0, p0, Lcom/xiaomi/infra/galaxy/common/model/CollisionCheckStack;->size:I

    return v0
.end method
