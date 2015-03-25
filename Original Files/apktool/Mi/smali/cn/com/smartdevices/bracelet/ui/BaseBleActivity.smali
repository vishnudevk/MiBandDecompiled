.class public abstract Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;
.super Lcn/com/smartdevices/bracelet/ui/SystemBarTintActivity;


# static fields
.field public static final MSG_UPDATE_PRESSED_TIME:I = 0x208

.field public static final UPDATE_PRESSED_TIMEOUT:I = 0x7d0

.field private static final a:I = 0x1

.field private static final b:I = 0x2

.field private static final c:I = 0x3

.field private static final d:I = 0x4

.field private static final e:I = 0x5

.field private static final f:I = 0x8

.field private static final g:I = 0xa

.field private static final h:I = 0xb

.field private static final i:I = 0xc

.field private static final j:I = 0xd

.field private static o:I


# instance fields
.field private k:J

.field private l:Landroid/os/Handler;

.field private m:Landroid/content/BroadcastReceiver;

.field private n:Ljava/lang/String;

.field private p:Z

.field private q:I

.field private r:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, -0x1

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    const/4 v2, 0x0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SystemBarTintActivity;-><init>()V

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    const-string v0, "BaseBleActivity"

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->q:I

    const/4 v0, -0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->r:I

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;J)J
    .locals 0

    iput-wide p1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    return-wide p1
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    return-object v0
.end method

.method private a()V
    .locals 3

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/j;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/j;-><init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/k;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/k;-><init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sget-object v1, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_ACTION_DEVICE_FOUND:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_DEVICE_STATUS_CHANGED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_ACTION_DEVICE_CONNECTED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_INITIALIZATION_SUCCESS:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_INITIALIZATION_FAILED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_ACTION_DEVICE_DISCONNECTED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/BLEService;->INTENT_ACTION_DEVICE_CONNECTION_FAILED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    sget-object v1, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    const-string v1, "android.bluetooth.adapter.action.STATE_CHANGED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    return-void
.end method

.method private a(I)V
    .locals 5

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onBatteryLowNotification:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->r:I

    if-ne v0, p1, :cond_0

    :goto_0
    return-void

    :cond_0
    iput p1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->r:I

    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    const v1, 0x7f0d0111

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v1, 0x7f0d010f

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    if-nez p1, :cond_1

    const v1, 0x7f0d0112

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    const v1, 0x7f0d0110

    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    :cond_1
    new-instance v3, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v3, p0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    const v4, 0x7f020004

    invoke-virtual {v3, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    const/4 v2, 0x4

    new-array v2, v2, [J

    fill-array-data v2, :array_0

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setVibrate([J)Landroid/support/v4/app/NotificationCompat$Builder;

    new-instance v2, Landroid/content/Intent;

    const-string v3, "ACTION_BATTERY_LOW"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/4 v3, 0x0

    const/high16 v4, 0x10000000

    invoke-static {p0, v3, v2, v4}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->q:I

    invoke-virtual {v1}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto :goto_0

    :array_0
    .array-data 8
        0x64
        0x1f4
        0x1f4
        0x1f4
    .end array-data
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;I)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->c(I)V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)Landroid/os/Handler;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    return-object v0
.end method

.method private b()V
    .locals 2

    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iget v1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->q:I

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V

    return-void
.end method

.method private b(I)V
    .locals 5

    const-string v0, ""

    packed-switch p1, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    const v0, 0x7f0d011a

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    :goto_1
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    const v2, 0x7f0d0113

    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/support/v4/app/NotificationCompat$Builder;

    invoke-direct {v3, p0}, Landroid/support/v4/app/NotificationCompat$Builder;-><init>(Landroid/content/Context;)V

    const v4, 0x7f020004

    invoke-virtual {v3, v4}, Landroid/support/v4/app/NotificationCompat$Builder;->setSmallIcon(I)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentTitle(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentText(Ljava/lang/CharSequence;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/NotificationCompat$Builder;->setAutoCancel(Z)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->q:I

    invoke-virtual {v1}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    goto :goto_0

    :pswitch_1
    const v0, 0x7f0d0117

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_2
    const v0, 0x7f0d0118

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_3
    const v0, 0x7f0d011c

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_4
    const v0, 0x7f0d0114

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_5
    const v0, 0x7f0d0119

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_6
    const v0, 0x7f0d0115

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_7
    const v0, 0x7f0d011b

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_8
    const v0, 0x7f0d0116

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto :goto_1

    :pswitch_9
    const v0, 0x7f0d011d

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    goto/16 :goto_1

    :pswitch_data_0
    .packed-switch 0xd
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method private c()V
    .locals 3

    new-instance v0, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readPersonInfo()Lcn/com/smartdevices/bracelet/model/PersonInfo;

    move-result-object v1

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/l;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/l;-><init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;)V

    invoke-direct {v0, v1, v2}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;-><init>(Lcn/com/smartdevices/bracelet/model/PersonInfo;Lcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->work()V

    return-void
.end method

.method private c(I)V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onDeviceStatusChanged:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onDeviceStatusChanged:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v0, 0xd

    if-lt p1, v0, :cond_0

    const/16 v0, 0x16

    if-gt p1, v0, :cond_0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->b(I)V

    :goto_0
    return-void

    :cond_0
    packed-switch p1, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    :pswitch_1
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onFwUpgradeFailed()V

    goto :goto_0

    :pswitch_2
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceSetLatencySuccess()V

    goto :goto_0

    :pswitch_3
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onFwUpgradeSuccess()V

    goto :goto_0

    :pswitch_4
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onAuthenticationFailed()V

    goto :goto_0

    :pswitch_5
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onAuthenticationSuccess()V

    goto :goto_0

    :pswitch_6
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onSendFwInfoFailed()V

    goto :goto_0

    :pswitch_7
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onSendFwInfoSuccess()V

    goto :goto_0

    :pswitch_8
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onResetAuthenticationFailed()V

    goto :goto_0

    :pswitch_9
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onResetAuthentiacationSuccess()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_2
        :pswitch_8
        :pswitch_9
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static getDeviceStatus()I
    .locals 2

    const/4 v1, -0x1

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->getDefaultPeripheral()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    if-eqz v0, :cond_0

    sget v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_0
.end method

.method public static getProfileStatus()I
    .locals 4

    const/4 v1, 0x1

    const/4 v2, -0x1

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_2

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->getDefaultPeripheral()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    if-eqz v0, :cond_2

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->getProfileState()I

    move-result v0

    if-ne v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v3, 0x2

    if-ne v0, v3, :cond_1

    move v0, v1

    goto :goto_0

    :cond_1
    if-nez v0, :cond_2

    move v0, v2

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_0
.end method


# virtual methods
.method public onAuthenticationFailed()V
    .locals 1

    const/4 v0, 0x6

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotify(Ljava/lang/Object;)V

    return-void
.end method

.method public onAuthenticationSuccess()V
    .locals 1

    const/4 v0, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotify(Ljava/lang/Object;)V

    const/16 v0, 0x27

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->setLatency(I)V

    return-void
.end method

.method public onBackPressed()V
    .locals 8

    const-wide/16 v6, 0x7d0

    const-wide/16 v4, -0x1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    const v2, 0x7f0d0018

    const/4 v3, 0x0

    invoke-static {p0, v2, v3}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    iput-wide v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    const/16 v1, 0x208

    invoke-virtual {v0, v1, v6, v7}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    sub-long/2addr v0, v2

    cmp-long v0, v0, v6

    if-gez v0, :cond_0

    iput-wide v4, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->k:J

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onHideApp()V

    goto :goto_0
.end method

.method public onBtOff()V
    .locals 0

    return-void
.end method

.method public onBtOn()V
    .locals 0

    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/ui/SystemBarTintActivity;->onCreate(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    const-string v1, "onCreate"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a()V

    return-void
.end method

.method protected onDestroy()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, -0x1

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/SystemBarTintActivity;->onDestroy()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    const-string v1, "onDestory"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->m:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iput-object v3, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->l:Landroid/os/Handler;

    sput v2, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    iput v2, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->r:I

    return-void
.end method

.method public onDeviceBatteryStatusChanged(BI)V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onDeviceBatteryStatusChanged:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onDeviceBatteryStatusChanged:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    invoke-direct {p0, p2}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->a(I)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->b()V

    goto :goto_0
.end method

.method public onDeviceConnected()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x4

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    return-void
.end method

.method public onDeviceConnectionFailed()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x5

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    return-void
.end method

.method public onDeviceDisconnected()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x6

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    return-void
.end method

.method public abstract onDeviceFound(Landroid/bluetooth/BluetoothDevice;I)V
.end method

.method public onDeviceSetLatencySuccess()V
    .locals 1

    const/16 v0, 0x8

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->waitingNotify(Ljava/lang/Object;)V

    return-void
.end method

.method public onFwUpgradeFailed()V
    .locals 1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleFwUpgradeTask;->waitingNotifyFwUpdate(Ljava/lang/Object;)V

    return-void
.end method

.method public onFwUpgradeSuccess()V
    .locals 1

    const/4 v0, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleFwUpgradeTask;->waitingNotifyFwUpdate(Ljava/lang/Object;)V

    return-void
.end method

.method protected onHideApp()V
    .locals 1

    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->moveTaskToBack(Z)Z

    return-void
.end method

.method public onInitializationFailed()V
    .locals 1

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x1

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    return-void
.end method

.method public onInitializationSuccess()V
    .locals 1

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->p:Z

    const/4 v0, 0x0

    sput v0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->o:I

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->c()V

    :cond_0
    return-void
.end method

.method public onResetAuthentiacationSuccess()V
    .locals 1

    const/16 v0, 0xa

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotifyReset(Ljava/lang/Object;)V

    const/16 v0, 0x27

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->setLatency(I)V

    return-void
.end method

.method public onResetAuthenticationFailed()V
    .locals 1

    const/16 v0, 0x9

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotifyReset(Ljava/lang/Object;)V

    return-void
.end method

.method public onSendFwInfoFailed()V
    .locals 1

    const/16 v0, 0xb

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleFwUpgradeTask;->waitingNotify(Ljava/lang/Object;)V

    return-void
.end method

.method public onSendFwInfoSuccess()V
    .locals 1

    const/16 v0, 0xc

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleFwUpgradeTask;->waitingNotify(Ljava/lang/Object;)V

    return-void
.end method

.method public onTogglePairProgress(I)V
    .locals 0

    return-void
.end method

.method public onTogglePairResult(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V
    .locals 0

    return-void
.end method

.method protected setLatency(I)V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "current latency level set level:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "power"

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    const/4 v1, 0x1

    const-string v2, "setLatency"

    invoke-virtual {v0, v1, v2}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->n:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "waklock acquire......"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/os/PowerManager$WakeLock;->acquire()V

    new-instance v1, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/m;

    invoke-direct {v2, p0, p1, v0}, Lcn/com/smartdevices/bracelet/ui/m;-><init>(Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;ILandroid/os/PowerManager$WakeLock;)V

    invoke-direct {v1, p1, v2}, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;-><init>(ILcn/com/smartdevices/bracelet/BleTask/BleCallBack;)V

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/BleTask/BleSetDesiredLatency;->workX()V

    return-void
.end method
