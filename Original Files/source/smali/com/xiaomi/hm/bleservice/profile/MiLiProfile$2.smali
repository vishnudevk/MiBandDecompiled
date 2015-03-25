.class Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$2;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$INotifyCallback;


# instance fields
.field final synthetic this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;


# direct methods
.method constructor <init>(Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$2;->this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public notify([B)V
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    array-length v2, p1

    if-ne v2, v0, :cond_0

    :goto_0
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->ASSERT_TRUE(Z)V

    const-string v0, "================================================="

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "========== NOTIFICATION STATUS CHANGED =========="

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    const-string v0, "================================================="

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->INFO(Ljava/lang/String;)V

    new-instance v0, Landroid/content/Intent;

    sget-object v2, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_DEVICE_STATUS_CHANGED:Ljava/lang/String;

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v2, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_EXTRA_DEVICE:Ljava/lang/String;

    iget-object v3, p0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$2;->this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-virtual {v3}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    sget-object v2, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_EXTRA_PARAM:Ljava/lang/String;

    aget-byte v1, p1, v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;B)Landroid/content/Intent;

    invoke-static {}, Lcom/xiaomi/hm/bleservice/BLEService;->getBroadcastManager()Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    return-void

    :cond_0
    move v0, v1

    goto :goto_0
.end method
