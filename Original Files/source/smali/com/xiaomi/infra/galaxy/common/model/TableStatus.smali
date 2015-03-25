.class public final enum Lcom/xiaomi/infra/galaxy/common/model/TableStatus;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/TableStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

.field public static final enum CREATING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

.field public static final enum DISABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

.field public static final enum DISABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

.field public static final enum ENABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

.field public static final enum ENABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const-string v1, "CREATING"

    const-string v2, "CREATING"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->CREATING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const-string v1, "DISABLING"

    const-string v2, "DISABLING"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const-string v1, "ENABLING"

    const-string v2, "ENABLING"

    invoke-direct {v0, v1, v5, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const-string v1, "DISABLED"

    const-string v2, "DISABLED"

    invoke-direct {v0, v1, v6, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const-string v1, "ENABLED"

    const-string v2, "ENABLED"

    invoke-direct {v0, v1, v7, v2}, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->CREATING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    aput-object v1, v0, v7

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableStatus;
    .locals 3

    if-eqz p0, :cond_0

    const-string v0, ""

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Value cannot be null or empty!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    const-string v0, "CREATING"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->CREATING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "DISABLING"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    goto :goto_0

    :cond_3
    const-string v0, "ENABLING"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLING:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    goto :goto_0

    :cond_4
    const-string v0, "DISABLED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->DISABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    goto :goto_0

    :cond_5
    const-string v0, "ENABLED"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->ENABLED:Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    goto :goto_0

    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Cannot create enum from "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " value!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/TableStatus;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/TableStatus;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/TableStatus;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/TableStatus;->value:Ljava/lang/String;

    return-object v0
.end method
