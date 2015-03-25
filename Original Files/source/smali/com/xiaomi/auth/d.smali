.class Lcom/xiaomi/auth/d;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field private final synthetic a:Landroid/accounts/Account;

.field private final synthetic b:Landroid/os/Bundle;

.field private final synthetic c:Lcom/xiaomi/auth/f;


# direct methods
.method constructor <init>(Landroid/accounts/Account;Landroid/os/Bundle;Lcom/xiaomi/auth/f;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/auth/d;->a:Landroid/accounts/Account;

    iput-object p2, p0, Lcom/xiaomi/auth/d;->b:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/xiaomi/auth/d;->c:Lcom/xiaomi/auth/f;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 4

    const/4 v0, 0x0

    :try_start_0
    invoke-static {p2}, Lcom/xiaomi/account/IXiaomiAuthService$Stub;->asInterface(Landroid/os/IBinder;)Lcom/xiaomi/account/IXiaomiAuthService;

    move-result-object v1

    iget-object v2, p0, Lcom/xiaomi/auth/d;->a:Landroid/accounts/Account;

    iget-object v3, p0, Lcom/xiaomi/auth/d;->b:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3}, Lcom/xiaomi/account/IXiaomiAuthService;->getSnsAccessToken(Landroid/accounts/Account;Landroid/os/Bundle;)Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v0

    :goto_0
    iget-object v1, p0, Lcom/xiaomi/auth/d;->c:Lcom/xiaomi/auth/f;

    invoke-virtual {v1, v0}, Lcom/xiaomi/auth/f;->a(Ljava/lang/Object;)V

    return-void

    :catch_0
    move-exception v1

    invoke-static {p2}, Lmiui/net/IXiaomiAuthService$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/IXiaomiAuthService;

    move-result-object v1

    :try_start_1
    iget-object v2, p0, Lcom/xiaomi/auth/d;->a:Landroid/accounts/Account;

    iget-object v3, p0, Lcom/xiaomi/auth/d;->b:Landroid/os/Bundle;

    invoke-interface {v1, v2, v3}, Lmiui/net/IXiaomiAuthService;->getMiCloudAccessToken(Landroid/accounts/Account;Landroid/os/Bundle;)Landroid/os/Bundle;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    goto :goto_0

    :catch_1
    move-exception v1

    const-string v2, "XiaomiAuthUtil"

    const-string v3, "miui.net.IXiaomiAuthService.getSNSInfo "

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    :catch_2
    move-exception v1

    const-string v2, "XiaomiAuthUtil"

    const-string v3, "com.xiaomi.account.IXiaomiAuthService.getSNSInfo "

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 0

    return-void
.end method
