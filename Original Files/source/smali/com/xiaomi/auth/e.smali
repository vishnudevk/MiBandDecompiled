.class Lcom/xiaomi/auth/e;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field private final synthetic a:Landroid/content/Context;

.field private final synthetic b:Landroid/accounts/Account;

.field private final synthetic c:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Landroid/content/Context;Landroid/accounts/Account;Landroid/os/Bundle;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/auth/e;->a:Landroid/content/Context;

    iput-object p2, p0, Lcom/xiaomi/auth/e;->b:Landroid/accounts/Account;

    iput-object p3, p0, Lcom/xiaomi/auth/e;->c:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3

    :try_start_0
    invoke-static {p2}, Lcom/xiaomi/account/IXiaomiAuthService$Stub;->asInterface(Landroid/os/IBinder;)Lcom/xiaomi/account/IXiaomiAuthService;

    move-result-object v0

    iget-object v1, p0, Lcom/xiaomi/auth/e;->b:Landroid/accounts/Account;

    iget-object v2, p0, Lcom/xiaomi/auth/e;->c:Landroid/os/Bundle;

    invoke-interface {v0, v1, v2}, Lcom/xiaomi/account/IXiaomiAuthService;->invalidateAccessToken(Landroid/accounts/Account;Landroid/os/Bundle;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    iget-object v0, p0, Lcom/xiaomi/auth/e;->a:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    :goto_0
    return-void

    :catch_0
    move-exception v0

    :try_start_1
    invoke-static {p2}, Lmiui/net/IXiaomiAuthService$Stub;->asInterface(Landroid/os/IBinder;)Lmiui/net/IXiaomiAuthService;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    :try_start_2
    iget-object v1, p0, Lcom/xiaomi/auth/e;->b:Landroid/accounts/Account;

    iget-object v2, p0, Lcom/xiaomi/auth/e;->c:Landroid/os/Bundle;

    invoke-interface {v0, v1, v2}, Lmiui/net/IXiaomiAuthService;->invalidateAccessToken(Landroid/accounts/Account;Landroid/os/Bundle;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    :goto_1
    iget-object v0, p0, Lcom/xiaomi/auth/e;->a:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    goto :goto_0

    :catch_1
    move-exception v0

    :try_start_3
    const-string v1, "XiaomiAuthUtil"

    const-string v2, "miui.net.IXiaomiAuthService invalidateAccessToken "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/xiaomi/auth/e;->a:Landroid/content/Context;

    invoke-virtual {v1, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    throw v0

    :catch_2
    move-exception v0

    :try_start_4
    const-string v1, "XiaomiAuthUtil"

    const-string v2, "com.xiaomi.account.IXiaomiAuthService invalidateAccessToken "

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    iget-object v0, p0, Lcom/xiaomi/auth/e;->a:Landroid/content/Context;

    invoke-virtual {v0, p0}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    goto :goto_0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 0

    return-void
.end method
