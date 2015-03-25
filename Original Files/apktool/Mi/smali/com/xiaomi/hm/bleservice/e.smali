.class Lcom/xiaomi/hm/bleservice/e;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/xiaomi/hm/bleservice/BLEService;


# direct methods
.method constructor <init>(Lcom/xiaomi/hm/bleservice/BLEService;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_GattPeripheral:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->access$300(Lcom/xiaomi/hm/bleservice/BLEService;)Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_GattPeripheral:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->access$300(Lcom/xiaomi/hm/bleservice/BLEService;)Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    invoke-interface {v0}, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;->getState()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;->CONNECTED:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_GattPeripheral:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->access$300(Lcom/xiaomi/hm/bleservice/BLEService;)Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    invoke-interface {v0}, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;->getState()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;

    move-result-object v0

    sget-object v1, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;->CONNECTING:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;

    if-ne v0, v1, :cond_1

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Quiting HandlerThread postponed for 500ms... (due to m_State="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_GattPeripheral:Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;
    invoke-static {v1}, Lcom/xiaomi/hm/bleservice/BLEService;->access$300(Lcom/xiaomi/hm/bleservice/BLEService;)Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v1

    invoke-interface {v1}, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;->getState()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback$STATE;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->WARN(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_Handler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->access$200(Lcom/xiaomi/hm/bleservice/BLEService;)Landroid/os/Handler;

    move-result-object v0

    const-wide/16 v1, 0x1f4

    invoke-virtual {v0, p0, v1, v2}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    :goto_0
    return-void

    :cond_1
    const-string v0, "Quiting HandlerThread..."

    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/util/Debug;->DEBUG(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/e;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    # getter for: Lcom/xiaomi/hm/bleservice/BLEService;->m_HandlerThread:Landroid/os/HandlerThread;
    invoke-static {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->access$400(Lcom/xiaomi/hm/bleservice/BLEService;)Landroid/os/HandlerThread;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/HandlerThread;->quitSafely()Z

    goto :goto_0
.end method
