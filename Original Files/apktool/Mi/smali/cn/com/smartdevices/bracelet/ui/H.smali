.class Lcn/com/smartdevices/bracelet/ui/H;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/H;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1

    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/H;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;->a(Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;)V

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1002
        :pswitch_0
    .end packed-switch
.end method
