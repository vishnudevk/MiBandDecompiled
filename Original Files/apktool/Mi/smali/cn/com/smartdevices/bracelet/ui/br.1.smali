.class Lcn/com/smartdevices/bracelet/ui/br;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 9

    const/16 v8, 0x1007

    const/4 v7, 0x0

    const/4 v6, 0x1

    iget v0, p1, Landroid/os/Message;->what:I

    const-string v1, "WPJ"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "search bracelet message:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "0x%x"

    new-array v4, v6, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    sparse-switch v0, :sswitch_data_0

    :cond_0
    :goto_0
    return-void

    :sswitch_0
    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, " connection failed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->b(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "StartUpConnectBracelet"

    const-string v2, "Failed"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0d004a

    invoke-static {v0, v1, v6}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->d(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->e(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)I

    move-result v0

    const/4 v1, 0x3

    if-gt v0, v1, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "\u901a\u8baf\u670d\u52a1\u6709\u95ee\u9898\uff0c\u8bf7\u91cd\u542f\u7a0b\u5e8f\uff01"

    invoke-static {v0, v1, v7}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;Ljava/lang/String;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    goto :goto_0

    :sswitch_3
    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "MSG_FIRST_TIMEOUT_SCAN_BRACELET"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0, v6}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;Z)Z

    invoke-virtual {p0, v8}, Lcn/com/smartdevices/bracelet/ui/br;->removeMessages(I)V

    const-wide/16 v0, 0x3e8

    invoke-virtual {p0, v8, v0, v1}, Lcn/com/smartdevices/bracelet/ui/br;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    :sswitch_4
    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "STOP_SCAN_BRACELET"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v8}, Lcn/com/smartdevices/bracelet/ui/br;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_2

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->stopScan()V

    :cond_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v6, :cond_4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "\u672a\u626b\u63cf\u5230\u8bbe\u5907\uff01"

    invoke-static {v0, v1, v7}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;Ljava/lang/String;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "StartUpScanBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endEvent(Landroid/content/Context;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "StartUpFoundBracelet"

    invoke-static {v0, v1, v7}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    :cond_4
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Lcn/com/smartdevices/bracelet/ui/bu;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    iget-boolean v0, v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f0d0141

    invoke-static {v0, v1, v6}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_5
    const-string v0, "SearchSingleBraceletActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Connect device,Found:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Lcn/com/smartdevices/bracelet/ui/bu;

    move-result-object v2

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", signal= "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Lcn/com/smartdevices/bracelet/ui/bu;

    move-result-object v2

    iget v2, v2, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "StartUpScanBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endEvent(Landroid/content/Context;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "StartUpFoundBracelet"

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/br;->a:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Lcn/com/smartdevices/bracelet/ui/bu;

    move-result-object v1

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;Landroid/bluetooth/BluetoothDevice;)V

    goto/16 :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x1001 -> :sswitch_1
        0x1004 -> :sswitch_2
        0x1007 -> :sswitch_4
        0x1013 -> :sswitch_0
        0x1015 -> :sswitch_3
    .end sparse-switch
.end method
