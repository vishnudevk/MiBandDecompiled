.class public Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;
.super Ljava/lang/Object;


# instance fields
.field private dateTime:Ljava/lang/String;

.field private kSigning:[B

.field private scope:Ljava/lang/String;

.field private signature:[B

.field final synthetic this$0:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;


# direct methods
.method public constructor <init>(Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;Ljava/lang/String;Ljava/lang/String;[B[B)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->this$0:Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p2, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->dateTime:Ljava/lang/String;

    iput-object p3, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->scope:Ljava/lang/String;

    iput-object p4, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->kSigning:[B

    iput-object p5, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->signature:[B

    return-void
.end method


# virtual methods
.method public getDateTime()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->dateTime:Ljava/lang/String;

    return-object v0
.end method

.method public getKSigning()[B
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->kSigning:[B

    array-length v0, v0

    new-array v0, v0, [B

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->kSigning:[B

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->kSigning:[B

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v0
.end method

.method public getScope()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->scope:Ljava/lang/String;

    return-object v0
.end method

.method public getSignature()[B
    .locals 4

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->signature:[B

    array-length v0, v0

    new-array v0, v0, [B

    iget-object v1, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->signature:[B

    iget-object v2, p0, Lcom/xiaomi/infra/galaxy/common/auth/Galaxy4Signer$HeaderSigningResult;->signature:[B

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v0
.end method
