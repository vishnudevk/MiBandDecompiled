.class Lcn/com/smartdevices/bracelet/ui/j;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4

    iget v1, p1, Landroid/os/Message;->what:I

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    sparse-switch v1, :sswitch_data_0

    :cond_0
    :goto_0
    return-void

    :sswitch_0
    if-eqz v0, :cond_0

    check-cast v0, Landroid/bluetooth/BluetoothDevice;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "MSG_BRACELET_FOUND:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    iget v2, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v1, v0, v2}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceFound(Landroid/bluetooth/BluetoothDevice;I)V

    goto :goto_0

    :sswitch_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_INITIALIZATION_SUCCESS"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_INITIALIZATION_SUCCESS"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onInitializationSuccess()V

    goto :goto_0

    :sswitch_2
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_INITIALIZATION_FAILED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_INITIALIZATION_FAILED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onInitializationFailed()V

    goto :goto_0

    :sswitch_3
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_CONNECTED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_CONNECTED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceConnected()V

    goto/16 :goto_0

    :sswitch_4
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_CONNECTION_FAILED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_CONNECTION_FAILED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceConnectionFailed()V

    goto/16 :goto_0

    :sswitch_5
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_DISCONNECTED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_DISCONNECTED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceDisconnected()V

    goto/16 :goto_0

    :sswitch_6
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_STATUS_CHANGED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_STATUS_CHANGED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    iget v1, p1, Landroid/os/Message;->arg1:I

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;I)V

    goto/16 :goto_0

    :sswitch_7
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_BT_ON"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_BT_ON"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onBtOn()V

    goto/16 :goto_0

    :sswitch_8
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_BT_OFF"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_BT_OFF"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onBtOff()V

    goto/16 :goto_0

    :sswitch_9
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    const-wide/16 v1, -0x1

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;J)J

    goto/16 :goto_0

    :sswitch_a
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "MSG_DEVICE_BATTERY_STATUS_CHANGED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/j;->a:Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

    iget v1, p1, Landroid/os/Message;->arg1:I

    int-to-byte v1, v1

    iget v2, p1, Landroid/os/Message;->arg2:I

    invoke-virtual {v0, v1, v2}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceBatteryStatusChanged(BI)V

    goto/16 :goto_0

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x3 -> :sswitch_2
        0x4 -> :sswitch_3
        0x5 -> :sswitch_5
        0x8 -> :sswitch_4
        0xa -> :sswitch_6
        0xb -> :sswitch_7
        0xc -> :sswitch_8
        0xd -> :sswitch_a
        0x208 -> :sswitch_9
    .end sparse-switch
.end method
