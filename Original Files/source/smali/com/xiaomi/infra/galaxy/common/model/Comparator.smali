.class public final enum Lcom/xiaomi/infra/galaxy/common/model/Comparator;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xiaomi/infra/galaxy/common/model/Comparator;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum EQ:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum GE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum GT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum LE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum LT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

.field public static final enum NE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;


# instance fields
.field private value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "EQ"

    const-string v2, "EQ"

    invoke-direct {v0, v1, v4, v2}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->EQ:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "NE"

    const-string v2, "NE"

    invoke-direct {v0, v1, v5, v2}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->NE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "GT"

    const-string v2, "GT"

    invoke-direct {v0, v1, v6, v2}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "GE"

    const-string v2, "GE"

    invoke-direct {v0, v1, v7, v2}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "LT"

    const-string v2, "LT"

    invoke-direct {v0, v1, v8, v2}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    new-instance v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const-string v1, "LE"

    const/4 v2, 0x5

    const-string v3, "LE"

    invoke-direct {v0, v1, v2, v3}, Lcom/xiaomi/infra/galaxy/common/model/Comparator;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    const/4 v0, 0x6

    new-array v0, v0, [Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->EQ:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v1, v0, v4

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->NE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v1, v0, v5

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v1, v0, v6

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v1, v0, v7

    sget-object v1, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    aput-object v2, v0, v1

    sput-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Comparator;

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

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->value:Ljava/lang/String;

    return-void
.end method

.method public static fromValue(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Comparator;
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
    const-string v0, "EQ"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->EQ:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    :goto_0
    return-object v0

    :cond_2
    const-string v0, "NE"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->NE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    goto :goto_0

    :cond_3
    const-string v0, "GT"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    goto :goto_0

    :cond_4
    const-string v0, "GE"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->GE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    goto :goto_0

    :cond_5
    const-string v0, "LT"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LT:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    goto :goto_0

    :cond_6
    const-string v0, "LE"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->LE:Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    goto :goto_0

    :cond_7
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

.method public static valueOf(Ljava/lang/String;)Lcom/xiaomi/infra/galaxy/common/model/Comparator;
    .locals 1

    const-class v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    return-object v0
.end method

.method public static values()[Lcom/xiaomi/infra/galaxy/common/model/Comparator;
    .locals 1

    sget-object v0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->$VALUES:[Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    invoke-virtual {v0}, [Lcom/xiaomi/infra/galaxy/common/model/Comparator;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xiaomi/infra/galaxy/common/model/Comparator;

    return-object v0
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/model/Comparator;->value:Ljava/lang/String;

    return-object v0
.end method
