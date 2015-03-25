.class public final enum Lcom/xiaomi/infra/galaxy/common/model/Operator;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/Operator;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Operator;

.field public static final enum AND:Lcom/xiaomi/infra/galaxy/common/model/Operator;

.field public static final enum OR:Lcom/xiaomi/infra/galaxy/common/model/Operator;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;

    const-string v1, "AND"

    const-string v2, "AND"

    invoke-direct {v0, v1, v3, v2}, Lcom/xiaomi/infra/galaxy/common/model/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->AND:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;

    const-string v1, "OR"

    const-string v2, "OR"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/model/Operator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->OR:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/model/Operator;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Operator;->AND:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Operator;->OR:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Operator;

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

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Operator;
    .locals 3

    invoke-static {p0}, Lcom/xiaomi/infra/galaxy/common/util/StringUtils;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Value cannot be null or empty!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    const-string v0, "AND"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->AND:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    :goto_0
    return-object v0

    :cond_1
    const-string v0, "OR"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->OR:Lcom/xiaomi/infra/galaxy/common/model/Operator;

    goto :goto_0

    :cond_2
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

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Operator;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/Operator;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Operator;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/Operator;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/Operator;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Operator;->value:Ljava/lang/String;

    return-object v0
.end method
