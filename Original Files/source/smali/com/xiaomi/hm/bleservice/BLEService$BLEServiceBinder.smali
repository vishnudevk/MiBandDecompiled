.class public final Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;
.super Landroid/os/Binder;


# instance fields
.field final synthetic a:Lcom/xiaomi/hm/bleservice/BLEService;


# direct methods
.method public constructor <init>(Lcom/xiaomi/hm/bleservice/BLEService;)V
    .locals 0

    iput-object p1, p0, Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method


# virtual methods
.method public getService()Lcom/xiaomi/hm/bleservice/BLEService;
    .locals 1

    iget-object v0, p0, Lcom/xiaomi/hm/bleservice/BLEService$BLEServiceBinder;->a:Lcom/xiaomi/hm/bleservice/BLEService;

    return-object v0
.end method
