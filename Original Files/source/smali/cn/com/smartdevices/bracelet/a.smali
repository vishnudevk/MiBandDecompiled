.class Lcn/com/smartdevices/bracelet/a;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/BraceletApp;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/BraceletApp;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/a;->a:Lcn/com/smartdevices/bracelet/BraceletApp;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 1

    instance-of v0, p2, Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;

    if-eqz v0, :cond_0

    check-cast p2, Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;

    invoke-virtual {p2}, Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;->getService()Lcom/xiaomi/hm/bleservice/BLEService;

    move-result-object v0

    sput-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    :cond_0
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    return-void
.end method
