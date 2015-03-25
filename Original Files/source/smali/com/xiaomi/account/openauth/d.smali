.class Lcom/xiaomi/account/openauth/d;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/xiaomi/account/openauth/c;

.field private final synthetic b:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/xiaomi/account/openauth/c;Landroid/os/Bundle;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/account/openauth/d;->a:Lcom/xiaomi/account/openauth/c;

    iput-object p2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "access_token"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    const-string v3, "extra_access_token"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "token_type"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    const-string v3, "extra_token_type"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "expires_in"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    const-string v3, "extra_expires_in"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "mac_key"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    const-string v3, "extra_mac_key"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "mac_algorithm"

    iget-object v2, p0, Lcom/xiaomi/account/openauth/d;->b:Landroid/os/Bundle;

    const-string v3, "extra_mac_algorithm"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/xiaomi/account/openauth/XiaomiOAuthorize;->a()Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/xiaomi/account/openauth/XiaomiOAuthorize$OnOAuthInterface;->onGetAccessTokenDirectly(Landroid/os/Bundle;)V

    return-void
.end method
