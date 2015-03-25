.class Lcom/xiaomi/account/openauth/c;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private final synthetic a:Landroid/app/Activity;

.field private final synthetic b:J

.field private final synthetic c:Ljava/lang/String;

.field private final synthetic d:Ljava/lang/String;

.field private final synthetic e:Landroid/os/Bundle;

.field private final synthetic f:I

.field private final synthetic g:[Landroid/accounts/Account;


# direct methods
.method constructor <init>(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;I[Landroid/accounts/Account;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    iput-wide p2, p0, Lcom/xiaomi/account/openauth/c;->b:J

    iput-object p4, p0, Lcom/xiaomi/account/openauth/c;->c:Ljava/lang/String;

    iput-object p5, p0, Lcom/xiaomi/account/openauth/c;->d:Ljava/lang/String;

    iput-object p6, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    iput p7, p0, Lcom/xiaomi/account/openauth/c;->f:I

    iput-object p8, p0, Lcom/xiaomi/account/openauth/c;->g:[Landroid/accounts/Account;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    iget-object v0, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    invoke-static {v0}, Lcom/xiaomi/auth/XiaomiAuthUtil;->isServiceSupport(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    iget-wide v1, p0, Lcom/xiaomi/account/openauth/c;->b:J

    iget-object v3, p0, Lcom/xiaomi/account/openauth/c;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/xiaomi/account/openauth/c;->d:Ljava/lang/String;

    iget-object v5, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    const-string v6, "scope"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    const-string v7, "state"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iget v7, p0, Lcom/xiaomi/account/openauth/c;->f:I

    invoke-static/range {v0 .. v7}, Lcom/xiaomi/account/openauth/AuthorizeHelper;->startAuthorizeActivityForResult(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    :goto_0
    return-void

    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "extra_client_id"

    iget-wide v2, p0, Lcom/xiaomi/account/openauth/c;->b:J

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "extra_redirect_uri"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/c;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "extra_response_type"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/c;->d:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    :cond_1
    iget-object v1, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    iget-object v2, p0, Lcom/xiaomi/account/openauth/c;->g:[Landroid/accounts/Account;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-static {v1, v2, v0}, Lcom/xiaomi/auth/XiaomiAuthUtil;->getAccessToken(Landroid/content/Context;Landroid/accounts/Account;Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "extra_error_code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    if-nez v1, :cond_2

    invoke-static {}, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->a()Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    new-instance v2, Lcom/xiaomi/account/openauth/d;

    invoke-direct {v2, p0, v0}, Lcom/xiaomi/account/openauth/d;-><init>(Lcom/xiaomi/account/openauth/c;Landroid/os/Bundle;)V

    invoke-virtual {v1, v2}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0

    :cond_2
    const-string v1, "extra_error_code"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    const/16 v2, -0x3e9

    if-ne v1, v2, :cond_3

    const-string v1, "extra_intent"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    iget v2, p0, Lcom/xiaomi/account/openauth/c;->f:I

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/xiaomi/account/openauth/c;->a:Landroid/app/Activity;

    iget-wide v1, p0, Lcom/xiaomi/account/openauth/c;->b:J

    iget-object v3, p0, Lcom/xiaomi/account/openauth/c;->c:Ljava/lang/String;

    iget-object v4, p0, Lcom/xiaomi/account/openauth/c;->d:Ljava/lang/String;

    iget-object v5, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    const-string v6, "scope"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/xiaomi/account/openauth/c;->e:Landroid/os/Bundle;

    const-string v7, "state"

    invoke-virtual {v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iget v7, p0, Lcom/xiaomi/account/openauth/c;->f:I

    invoke-static/range {v0 .. v7}, Lcom/xiaomi/account/openauth/AuthorizeHelper;->startAuthorizeActivityForResult(Landroid/app/Activity;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_0
.end method
