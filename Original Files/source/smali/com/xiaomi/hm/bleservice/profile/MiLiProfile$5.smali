.class Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$5;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$INotifyCallback;


# instance fields
.field final synthetic this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;


# direct methods
.method constructor <init>(Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$5;->this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public notify([B)V
    .locals 5

    const/4 v1, 0x0

    array-length v0, p1

    const/16 v2, 0xa

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->ASSERT_TRUE(Z)V

    const/16 v0, 0x9

    aget-byte v0, p1, v0

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    packed-switch v0, :pswitch_data_0

    const-string v0, ">>> UNEXPECTED <<<"

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->WARN(Ljava/lang/String;)V

    :goto_1
    return-void

    :cond_0
    move v0, v1

    goto :goto_0

    :pswitch_0
    const-string v2, ">>> UNEXPECTED <<<"

    invoke-static {v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->WARN(Ljava/lang/String;)V

    :goto_2
    new-instance v2, Landroid/content/Intent;

    sget-object v3, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED:Ljava/lang/String;

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    sget-object v3, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_EXTRA_DEVICE:Ljava/lang/String;

    iget-object v4, p0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile$5;->this$0:Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    invoke-virtual {v4}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->getDevice()Landroid/bluetooth/BluetoothDevice;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    sget-object v3, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_EXTRA_PARAM:Ljava/lang/String;

    invoke-virtual {v2, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;B)Landroid/content/Intent;

    sget-object v0, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_EXTRA_PARAM_EXT:Ljava/lang/String;

    invoke-virtual {v2, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    invoke-static {}, Lcom/xiaomi/hm/bleservice/BLEService;->getBroadcastManager()Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/support/v4/content/LocalBroadcastManager;->sendBroadcast(Landroid/content/Intent;)Z

    goto :goto_1

    :pswitch_1
    const-string v2, "Battery low"

    invoke-static {v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->DEBUG(Ljava/lang/String;)V

    goto :goto_2

    :pswitch_2
    const-string v2, "Battery charging"

    invoke-static {v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->DEBUG(Ljava/lang/String;)V

    goto :goto_2

    :pswitch_3
    const-string v2, "Battery full (charging)"

    invoke-static {v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->DEBUG(Ljava/lang/String;)V

    goto :goto_2

    :pswitch_4
    const-string v2, "Battery charger off"

    invoke-static {v2}, Lcom/xiaomi/hm/bleservice/util/Debug;->DEBUG(Ljava/lang/String;)V

    goto :goto_2

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
