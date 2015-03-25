.class public final enum Lcom/xiaomi/infra/galaxy/common/constants/APILevel;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/constants/APILevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

.field public static final enum Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

.field public static final enum User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    const-string v1, "User"

    const-string v2, "User"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    const-string v1, "Developer"

    const-string v2, "Developer"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

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

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/APILevel;
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
    const-string v0, "User"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->User:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "Developer"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->Developer:Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    goto :goto_0

    :cond_3
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

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/constants/APILevel;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/constants/APILevel;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/constants/APILevel;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/constants/APILevel;->value:Ljava/lang/String;

    return-object v0
.end method
