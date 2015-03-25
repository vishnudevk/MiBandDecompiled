.class public Lcom/xiaomi/infra/galaxy/common/model/RowKey;
.super Ljava/lang/Object;


# static fields
.field public static final BEGIN_USER_ID:Ljava/lang/String; = ""

.field public static final END_USER_ID:Ljava/lang/String; = ""


# instance fields
.field private key:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation
.end field

.field private userId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    return-void
.end method

.method public static getBeginRowKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-object v0
.end method

.method public static getEndRowKey()Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 2

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    invoke-direct {v0}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    return-object v0
.end method


# virtual methods
.method public addKey(Ljava/lang/String;Ljava/lang/Object;)Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    if-nez v0, :cond_0

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    invoke-static {v0, p1, p2}, Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;->putAttributeValueInMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V

    return-object p0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    if-nez p1, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-eq v2, v3, :cond_3

    move v0, v1

    goto :goto_0

    :cond_3
    check-cast p1, Lcom/xiaomi/infra/galaxy/common/model/RowKey;

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    if-nez v2, :cond_4

    iget-object v2, p1, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    if-eqz v2, :cond_5

    move v0, v1

    goto :goto_0

    :cond_4
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    iget-object v3, p1, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    move v0, v1

    goto :goto_0

    :cond_5
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    if-nez v2, :cond_6

    iget-object v2, p1, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0

    :cond_6
    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    iget-object v3, p1, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method public getKey()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    return-object v0
.end method

.method public getUserId()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    add-int/lit8 v0, v0, 0x1f

    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    if-nez v2, :cond_1

    :goto_1
    add-int/2addr v0, v1

    return v0

    :cond_0
    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    goto :goto_1
.end method

.method public setKey(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)V"
        }
    .end annotation

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->key:Ljava/util/Map;

    return-void
.end method

.method public setUserId(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->userId:Ljava/lang/String;

    return-void
.end method

.method public withKey(Ljava/util/Map;)Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/xiaomi/infra/galaxy/common/model/AttributeValue;",
            ">;)",
            "Lcom/xiaomi/infra/galaxy/common/model/RowKey;"
        }
    .end annotation

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->setKey(Ljava/util/Map;)V

    return-object p0
.end method

.method public withUserId(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/RowKey;
    .locals 0

    invoke-virtual {p0, p1}, Lcom/xiaomi/infra/galaxy/common/model/RowKey;->setUserId(Ljava/lang/String;)V

    return-object p0
.end method
