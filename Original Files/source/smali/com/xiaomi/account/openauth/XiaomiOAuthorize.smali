.class public Lcom/xiaomi/account/openauth/XiaomiOAuthorize;
.super Ljava/lang/Object;


# static fields
.field private static final a:Ljava/lang/String; = "code"

.field private static final b:Ljava/lang/String; = "token"

.field private static c:Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;

.field private static d:Ljava/util/concurrent/ThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const/4 v1, 0x1

    const/4 v2, 0x5

    const-wide/16 v3, 0x1e

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    sput-object v0, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->d:Ljava/util/concurrent/ThreadPoolExecutor;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic a()Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;
    .locals 1

    sget-object v0, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->c:Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;

    return-object v0
.end method

.method private static a(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I)V
    .locals 9

    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v1, "com.xiaomi"

    invoke-virtual {v0, v1}, Landroid/accounts/AccountManager;->getAccountsByType(Ljava/lang/String;)[Landroid/accounts/Account;

    move-result-object v8

    array-length v0, v8

    if-lez v0, :cond_0

    new-instance v0, Lcom/xiaomi/account/openauth/c;

    move-object v1, p0

    move-wide v2, p1

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move v7, p6

    invoke-direct/range {v0 .. v8}, Lcom/xiaomi/account/openauth/c;-><init>(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I[Landroid/accounts/Account;)V

    sget-object v1, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->d:Ljava/util/concurrent/ThreadPoolExecutor;

    invoke-virtual {v1, v0}, Ljava/util/concurrent/ThreadPoolExecutor;->execute(Ljava/lang/Runnable;)V

    :goto_0
    return-void

    :cond_0
    const-string v0, "scope"

    invoke-virtual {p5, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v0, "state"

    invoke-virtual {p5, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move-object v4, p4

    move v7, p6

    invoke-static/range {v0 .. v7}, Lcom/xiaomi/account/openauth/AuthorizeHelper;->startAuthorizeActivityForResult(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public static setOnOAuthInterface(Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;)V
    .locals 0

    sput-object p0, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->c:Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;

    return-void
.end method

.method public static startGetAccessToken(Landroid/app/Activity;JLjava/lang/String;Landroid/os/Bundle;I)V
    .locals 7

    if-nez p4, :cond_0

    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    :goto_0
    const-string v4, "token"

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move v6, p5

    invoke-static/range {v0 .. v6}, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->a(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I)V

    return-void

    :cond_0
    move-object v5, p4

    goto :goto_0
.end method

.method public static startGetOAuthCode(Landroid/app/Activity;JLjava/lang/String;Landroid/os/Bundle;I)V
    .locals 7

    if-nez p4, :cond_0

    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    :goto_0
    const-string v4, "code"

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move v6, p5

    invoke-static/range {v0 .. v6}, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->a(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I)V

    return-void

    :cond_0
    move-object v5, p4

    goto :goto_0
.end method
