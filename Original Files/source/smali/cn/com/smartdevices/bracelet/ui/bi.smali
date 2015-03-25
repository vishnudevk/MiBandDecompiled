.class Lcn/com/smartdevices/bracelet/ui/bi;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/bh;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/bh;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/bi;->a:Lcn/com/smartdevices/bracelet/ui/bh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bi;->a:Lcn/com/smartdevices/bracelet/ui/bh;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/bh;->a:Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;->b(Lcn/com/smartdevices/bracelet/ui/PersonInfoFragment;)V

    return-void
.end method
