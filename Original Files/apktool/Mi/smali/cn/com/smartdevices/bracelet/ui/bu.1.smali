.class Lcn/com/smartdevices/bracelet/ui/bu;
.super Ljava/lang/Object;


# instance fields
.field a:Landroid/bluetooth/BluetoothDevice;

.field b:I

.field final synthetic c:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;)V
    .locals 1

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/bu;->c:Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bu;->a:Landroid/bluetooth/BluetoothDevice;

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/ui/bu;->b:I

    return-void
.end method
