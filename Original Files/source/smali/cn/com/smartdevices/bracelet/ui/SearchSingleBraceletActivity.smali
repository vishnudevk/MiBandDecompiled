.class public Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;
.super Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field public static final CONNECT_TIME_OUT:J = 0xea60L

.field public static final MSG_DEVICE_CONNECTION_FAILED:I = 0x1013

.field public static final NEED_EXIT:I = 0x1

.field public static final NEED_RESEARCH:I = 0x0

.field public static final REF_NOT_KNOCKED:Ljava/lang/String; = "REF_NOT_KNOCKED"

.field private static final a:Ljava/lang/String; = "SearchSingleBraceletActivity"

.field private static final b:I = 0x7d0

.field private static final f:I = 0x1007

.field private static final g:I = 0x1015

.field private static h:Landroid/os/Handler; = null

.field private static final p:J = 0x2710L

.field private static final q:J = 0x3e8L

.field private static final r:I = 0xea60


# instance fields
.field private A:Z

.field private B:Z

.field private C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

.field private D:Landroid/widget/ImageView;

.field private E:Z

.field private F:Landroid/widget/ImageButton;

.field private G:Landroid/view/View;

.field private H:Z

.field private final c:I

.field private final d:I

.field private final e:I

.field private i:Landroid/widget/ListView;

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcn/com/smartdevices/bracelet/ui/bu;",
            ">;"
        }
    .end annotation
.end field

.field private k:Lcn/com/smartdevices/bracelet/ui/bv;

.field private l:Landroid/content/Context;

.field private m:I

.field public mDevMode:Z

.field private final n:I

.field private o:Landroid/bluetooth/BluetoothDevice;

.field private s:Lcn/com/smartdevices/bracelet/ui/bu;

.field private t:Landroid/widget/TextView;

.field private u:Landroid/widget/TextView;

.field private v:Landroid/widget/TextView;

.field private w:Landroid/widget/TextView;

.field private x:Landroid/view/View;

.field private y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

.field private z:Lcom/xiaomi/hm/view/GifView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;-><init>()V

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    const/16 v0, 0x2001

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c:I

    const/16 v0, 0x1001

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->d:I

    const/16 v0, 0x1004

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->e:I

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i:Landroid/widget/ListView;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->m:I

    const/4 v0, 0x3

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->n:I

    iput-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->o:Landroid/bluetooth/BluetoothDevice;

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->A:Z

    iput-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Ljava/util/ArrayList;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a()V
    .locals 4

    const/4 v3, 0x0

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bv;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bv;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    const v0, 0x7f0a0064

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->G:Landroid/view/View;

    const v0, 0x7f0a0065

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i:Landroid/widget/ListView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i:Landroid/widget/ListView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i:Landroid/widget/ListView;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bq;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bq;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    const v0, 0x7f0a0061

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/xiaomi/hm/view/GifView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    const v0, 0x7f0a005e

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->x:Landroid/view/View;

    const v0, 0x7f0a005c

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->t:Landroid/widget/TextView;

    const v0, 0x7f0a005d

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->u:Landroid/widget/TextView;

    const v0, 0x7f0a0062

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "<u>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const v2, 0x7f0d0069

    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</u>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    const v0, 0x7f0a0063

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    invoke-virtual {v0, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    const v0, 0x7f0a0060

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->D:Landroid/widget/ImageView;

    const v0, 0x7f0a005b

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->F:Landroid/widget/ImageButton;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->F:Landroid/widget/ImageButton;

    invoke-virtual {v0, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    const v0, 0x7f0a005f

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0, v3}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->setMode(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->showLoading()V

    const v0, 0x7f0a0034

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private a(Landroid/bluetooth/BluetoothDevice;)V
    .locals 4

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->o:Landroid/bluetooth/BluetoothDevice;

    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcn/com/smartdevices/bracelet/Utils;->connect(Landroid/bluetooth/BluetoothDevice;Z)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1001

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1013

    const-wide/32 v2, 0xea60

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpConnectBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startEvent(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;Landroid/bluetooth/BluetoothDevice;)V
    .locals 0

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Landroid/bluetooth/BluetoothDevice;)V

    return-void
.end method

.method private a(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V
    .locals 6

    const/4 v5, 0x0

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readLoginData()Lcn/com/smartdevices/bracelet/model/LoginData;

    move-result-object v0

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readBraceletBtInfo()Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    move-result-object v1

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readDeviceId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;

    invoke-direct {v3}, Lcn/com/smartdevices/bracelet/model/SystemInfo;-><init>()V

    iput-object v2, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->deviceId:Ljava/lang/String;

    iget-object v1, v1, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;->address:Ljava/lang/String;

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->braceletMacAddress:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Utils;->getMiuiVersionCode(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->miuiVersionCode:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Utils;->getMiuiVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->miuiVersionName:Ljava/lang/String;

    sget-object v1, Landroid/os/Build;->BRAND:Ljava/lang/String;

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->phoneBrand:Ljava/lang/String;

    sget-object v1, Landroid/os/Build;->MODEL:Ljava/lang/String;

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->phoneModel:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->phoneSystem:Ljava/lang/String;

    :try_start_0
    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getPackageName()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    iget-object v1, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->softVersion:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    invoke-virtual {p1}, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;->getFirmwareVersionStr()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v3, Lcn/com/smartdevices/bracelet/model/SystemInfo;->fwVersion:Ljava/lang/String;

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "updateSystemInfo:\n"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v3}, Lcn/com/smartdevices/bracelet/model/SystemInfo;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/bs;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/bs;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    invoke-static {v0, v3, v5, v1}, Lcn/com/smartdevices/bracelet/webapi/WebAPI;->updateSystemInfo(Lcn/com/smartdevices/bracelet/model/LoginData;Lcn/com/smartdevices/bracelet/model/SystemInfo;ILcom/loopj/android/http/AsyncHttpResponseHandler;)V

    return-void

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private a(Z)V
    .locals 4

    const/4 v3, 0x4

    const/4 v2, 0x0

    if-eqz p1, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->b()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->t:Landroid/widget/TextView;

    const v1, 0x7f0d0023

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->u:Landroid/widget/TextView;

    const v1, 0x7f0d00a2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    const-string v1, "<u>\u6211\u7684\u624b\u73af\u600e\u4e48\u6ca1\u6709\u4eae\u706f</u>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0, v3}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->D:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->E:Z

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->c()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->t:Landroid/widget/TextView;

    const v1, 0x7f0d0143

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->u:Landroid/widget/TextView;

    const v1, 0x7f0d0142

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->w:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0, v2}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->D:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->E:Z

    goto :goto_0
.end method

.method static synthetic a(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->A:Z

    return p1
.end method

.method private b()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    const v1, 0x7f02001d

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImage(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    invoke-virtual {v0, p0}, Lcom/xiaomi/hm/view/GifView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    sget-object v1, Lcom/xiaomi/hm/view/GifImageType;->COVER:Lcom/xiaomi/hm/view/GifImageType;

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setGifImageType(Lcom/xiaomi/hm/view/GifImageType;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    const/16 v1, 0x1000

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setLoopNumber(I)V

    return-void
.end method

.method static synthetic b(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    return-void
.end method

.method static synthetic c(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    return-object v0
.end method

.method private c()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/view/GifView;->setVisibility(I)V

    return-void
.end method

.method static synthetic d(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)I
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->m:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->m:I

    return v0
.end method

.method private d()Z
    .locals 2

    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/16 v1, 0x2001

    invoke-virtual {p0, v0, v1}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->startActivityForResult(Landroid/content/Intent;I)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method static synthetic e(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->m:I

    return v0
.end method

.method private e()V
    .locals 3

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/br;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/br;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    sput-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const-string v0, "SearchSingleBraceletActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "mHandler = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private f()V
    .locals 2

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_0

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->stopScan()V

    :cond_0
    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    if-eqz v0, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1004

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1007

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1015

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const/16 v1, 0x1013

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    :goto_0
    return-void

    :cond_1
    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "mHandler is NULL!!!!!!!!!!!!!!!!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic f(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h()V

    return-void
.end method

.method private g()V
    .locals 3

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->getDefaultPeripheral()Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;

    move-result-object v1

    if-eqz v1, :cond_0

    move-object v0, v1

    check-cast v0, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->setAutoReconnect(Z)V

    invoke-interface {v1}, Lcom/xiaomi/hm/bleservice/gatt/IGattCallback;->disconnect()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "\n    =============== disconnect BLE =============== \n"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method static synthetic g(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j()V

    return-void
.end method

.method static synthetic h(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)Lcn/com/smartdevices/bracelet/ui/bu;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    return-object v0
.end method

.method private h()V
    .locals 6

    const/16 v5, 0x1015

    const/16 v4, 0x1007

    const/16 v3, 0x1004

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_1

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "startScanBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/bv;->notifyDataSetChanged()V

    :cond_0
    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v3}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/util/UUID;

    const/4 v2, 0x0

    sget-object v3, Lcom/xiaomi/hm/bleservice/profile/MiLiProfile;->UUID_SERVICE_MILI_SERVICE:Ljava/util/UUID;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/bleservice/BLEService;->setServiceFilter([Ljava/util/UUID;)V

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    const v1, 0xea60

    invoke-virtual {v0, v1}, Lcom/xiaomi/hm/bleservice/BLEService;->startScan(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const-wide/32 v1, 0xea60

    invoke-virtual {v0, v4, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v5}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const-wide/16 v1, 0x2710

    invoke-virtual {v0, v5, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    const-string v0, "StartUpScanBracelet"

    invoke-static {p0, v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startEvent(Landroid/content/Context;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_1
    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const-wide/16 v1, 0xc8

    invoke-virtual {v0, v3, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0
.end method

.method private i()V
    .locals 3

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g()V

    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-class v2, Lcn/com/smartdevices/bracelet/activity/MultiBraceletErrActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const/high16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->B:Z

    if-eqz v1, :cond_0

    const-string v1, "REF_NOT_KNOCKED"

    const v2, 0x7f0d0063

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    :cond_0
    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->startActivity(Landroid/content/Intent;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    return-void
.end method

.method private j()V
    .locals 3

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g()V

    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-class v2, Lcn/com/smartdevices/bracelet/activity/BraceletNotFoundActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->startActivity(Landroid/content/Intent;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3

    const-string v0, "SearchSingleBraceletActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "requestCode ="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", resultCode="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/16 v0, 0x2001

    if-ne p1, v0, :cond_0

    packed-switch p2, :pswitch_data_0

    :cond_0
    :goto_0
    invoke-super {p0, p1, p2, p3}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onActivityResult(IILandroid/content/Intent;)V

    return-void

    :pswitch_0
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h()V

    goto :goto_0

    :pswitch_1
    const v0, 0x7f0d0098

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;Ljava/lang/String;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    goto :goto_0

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onAuthenticationFailed()V
    .locals 3

    const/4 v2, 0x1

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onAuthenticationFailed()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onAuthenticationFailed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v2}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Z)V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const v1, 0x7f0d0128

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    new-instance v0, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;-><init>()V

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/Keeper;->keepBraceletBtInfo(Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;)V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onBackPressed()V

    :goto_0
    return-void

    :cond_0
    const/16 v0, 0xef

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotify(Ljava/lang/Object;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    :cond_0
    :goto_0
    return-void

    :sswitch_0
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    goto :goto_0

    :sswitch_1
    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->stopScan()V

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    :cond_2
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-nez v0, :cond_3

    const/4 v0, 0x1

    :goto_1
    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->setDevelopUI(Z)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h()V

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    :sswitch_2
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    const/16 v0, 0xef

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/BleTask/BleTogglePairTask;->waitingNotify(Ljava/lang/Object;)V

    goto :goto_0

    :sswitch_3
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcn/com/smartdevices/bracelet/ui/MainUIActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->startActivity(Landroid/content/Intent;)V

    const-string v0, "StartUpNotBindBracelet"

    invoke-static {p0, v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a0034 -> :sswitch_0
        0x7f0a005b -> :sswitch_1
        0x7f0a0062 -> :sswitch_3
        0x7f0a0063 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3

    const/4 v2, 0x0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onCreate(Landroid/os/Bundle;)V

    const v0, 0x7f03000f

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->setContentView(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const v1, 0x7f0e0015

    invoke-virtual {v0, v1}, Landroid/view/Window;->setWindowAnimations(I)V

    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onCreate"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object p0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->e()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v1, "REF_SEARCH_DEV_MODE"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    const-string v0, "SearchSingleBraceletActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "mDevMode = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->setDevelopUI(Z)V

    return-void

    :cond_0
    iput-boolean v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1

    const/4 v0, 0x1

    return v0
.end method

.method protected onDestroy()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDestroy()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onDestroy"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    if-eqz v0, :cond_0

    :try_start_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    invoke-virtual {v0}, Lcom/xiaomi/hm/view/GifView;->destroy()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    :cond_0
    return-void

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public onDeviceConnected()V
    .locals 3

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceConnected()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "search single \u5df2\u8fde\u4e0a\u8bbe\u5907! MSG_DEVICE_CONNECTED"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpConnectBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endEvent(Landroid/content/Context;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpConnectBracelet"

    const-string v2, "Successed"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onDeviceConnectionFailed()V
    .locals 3

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceConnectionFailed()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onDeviceConnectionFailed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpConnectBracelet"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endEvent(Landroid/content/Context;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpConnectBracelet"

    const-string v2, "Failed"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onDeviceDisconnected()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onDeviceDisconnected()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onDeviceDisconnected"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    return-void
.end method

.method public onDeviceFound(Landroid/bluetooth/BluetoothDevice;I)V
    .locals 5

    const/16 v4, 0x1007

    new-instance v0, Lcn/com/smartdevices/bracelet/ui/bu;

    invoke-direct {v0, p0}, Lcn/com/smartdevices/bracelet/ui/bu;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    iput-object p1, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    iput p2, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "found mili:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", divice count:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "found mili:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", divice count:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", mBtDevice = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->f(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bw;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcn/com/smartdevices/bracelet/ui/bw;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;Lcn/com/smartdevices/bracelet/ui/bq;)V

    invoke-static {v1, v2}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/ui/bv;->notifyDataSetChanged()V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    if-eqz v1, :cond_1

    iget-object v1, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    iget-object v2, v2, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;->address:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "FOUND last device:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    iget-object v3, v3, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;->address:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_0

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->stopScan()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    if-nez v1, :cond_3

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    :cond_2
    :goto_1
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->A:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    const-wide/16 v1, 0x3e8

    invoke-virtual {v0, v4, v1, v2}, Landroid/os/Handler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0

    :cond_3
    iget v1, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    if-nez v1, :cond_4

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Found a connect device : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->removeMessages(I)V

    sget-object v0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0

    :cond_4
    iget v1, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    iget v2, v2, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    if-le v1, v2, :cond_2

    const-string v1, "SearchSingleBraceletActivity"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Found a bigger signal : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget v3, v0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->s:Lcn/com/smartdevices/bracelet/ui/bu;

    goto :goto_1
.end method

.method protected onHideApp()V
    .locals 2

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onHideApp: finish()"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g()V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->finish()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "**********************************************************"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "*************** Bracelet app, Exit whole process"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "**********************************************************"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    return-void
.end method

.method public onInitializationFailed()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onInitializationFailed()V

    invoke-static {}, Lcn/com/smartdevices/bracelet/view/Util;->hideProgressDialog()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onInitializationFailed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    return-void
.end method

.method public onInitializationSuccess()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onInitializationSuccess()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onInitializationSuccess"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2

    const/4 v1, 0x1

    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :cond_0
    :goto_0
    return v1

    :pswitch_0
    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    if-eqz v0, :cond_1

    sget-object v0, Lcn/com/smartdevices/bracelet/BraceletApp;->BLEService:Lcom/xiaomi/hm/bleservice/BLEService;

    invoke-virtual {v0}, Lcom/xiaomi/hm/bleservice/BLEService;->stopScan()V

    :cond_1
    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-nez v0, :cond_2

    move v0, v1

    :goto_1
    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->setDevelopUI(Z)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h()V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    goto :goto_1

    :pswitch_data_0
    .packed-switch 0x7f0a0209
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onPause()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onPause"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "PageSearchSingleBracelet"

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v1, :cond_0

    const-string v0, "PageSearchMultiBracelet"

    :cond_0
    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->endSession(Landroid/content/Context;)V

    return-void
.end method

.method public onResetAuthentiacationSuccess()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onResetAuthentiacationSuccess()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onResetAuthentiacationSuccess"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public onResetAuthenticationFailed()V
    .locals 3

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onResetAuthenticationFailed()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onResetAuthentiacationFailed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const v1, 0x7f0d0063

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/view/CustomToast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->B:Z

    return-void
.end method

.method protected onResume()V
    .locals 2

    invoke-super {p0}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onResume()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->B:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->z:Lcom/xiaomi/hm/view/GifView;

    invoke-virtual {v0}, Lcom/xiaomi/hm/view/GifView;->restartGifAnimation()V

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onResume"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-string v0, "PageSearchSingleBracelet"

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v1, :cond_0

    const-string v0, "PageSearchMultiBracelet"

    :cond_0
    invoke-static {v0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startPage(Ljava/lang/String;)V

    invoke-static {p0}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->startSession(Landroid/content/Context;)V

    return-void
.end method

.method public onTogglePairProgress(I)V
    .locals 0

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onTogglePairProgress(I)V

    return-void
.end method

.method public onTogglePairResult(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V
    .locals 5

    const/16 v3, 0x8

    const/4 v2, 0x1

    invoke-super {p0, p1}, Lcn/com/smartdevices/bracelet/ui/BaseBleActivity;->onTogglePairResult(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V

    if-nez p1, :cond_0

    const-string v0, "SearchSingleBraceletActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onTogglePairResult : DeviceInfo = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->i()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpPairingBracelet"

    const-string v2, "Failed"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onTogglePairResult: Compaire OK!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    if-eqz v0, :cond_1

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onTogglePairResult: Compaire OK!, But the activity has been destroyed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    new-instance v0, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;-><init>()V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->o:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;->name:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->o:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;->address:Ljava/lang/String;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/Keeper;->keepBraceletBtInfo(Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;)V

    iget-object v0, p1, Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;->deviceID:Ljava/lang/String;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/Keeper;->keepDeviceId(Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->a(Lcom/xiaomi/hm/bleservice/profile/IMiLiProfile$DeviceInfo;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/lua/LuaEvent;->getInstance(Landroid/content/Context;)Lcn/com/smartdevices/bracelet/lua/LuaEvent;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/lua/LuaEvent;->setDefaultMsgs()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->dismissLoading()V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    if-eqz v0, :cond_2

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onTogglePairResult: Compaire OK!, But the activity has been destroyed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const/4 v0, 0x0

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->E:Z

    if-nez v1, :cond_3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->C:Lcn/com/smartdevices/bracelet/chart/LinePieChartView;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/LinePieChartView;->showNormalLine()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->t:Landroid/widget/TextView;

    const v1, 0x7f0d0024

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->u:Landroid/widget/TextView;

    const v1, 0x7f0d01ee

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->D:Landroid/widget/ImageView;

    const v1, 0x7f020094

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->F:Landroid/widget/ImageButton;

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->v:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    const/16 v0, 0x7d0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Keeper;->keepIsPlayEnterAnimation(Ljava/lang/Boolean;)V

    const/4 v1, 0x2

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Keeper;->keepPlayEnterAnimationType(I)V

    :goto_1
    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->H:Z

    if-eqz v1, :cond_4

    const-string v0, "SearchSingleBraceletActivity"

    const-string v1, "onTogglePairResult: Compaire OK!, But the activity has been destroyed"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_3
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/Keeper;->keepIsPlayEnterAnimation(Ljava/lang/Boolean;)V

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/Keeper;->keepPlayEnterAnimationType(I)V

    goto :goto_1

    :cond_4
    sget-object v1, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h:Landroid/os/Handler;

    new-instance v2, Lcn/com/smartdevices/bracelet/ui/bt;

    invoke-direct {v2, p0}, Lcn/com/smartdevices/bracelet/ui/bt;-><init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V

    int-to-long v3, v0

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->l:Landroid/content/Context;

    const-string v1, "StartUpPairingBracelet"

    const-string v2, "Successed"

    invoke-static {v0, v1, v2}, Lcn/com/smartdevices/bracelet/UmengAnalytics;->event(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method protected setDevelopUI(Z)V
    .locals 3

    const/16 v2, 0x8

    const/4 v1, 0x0

    iput-boolean p1, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->k:Lcn/com/smartdevices/bracelet/ui/bv;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/bv;->notifyDataSetChanged()V

    iget-boolean v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->mDevMode:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->x:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->G:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    :goto_0
    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->g()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->f()V

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->h()V

    :cond_0
    return-void

    :cond_1
    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readBraceletBtInfo()Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->y:Lcn/com/smartdevices/bracelet/model/BraceletBtInfo;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->x:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;->G:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
