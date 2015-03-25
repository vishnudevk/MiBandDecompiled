.class Lcn/com/smartdevices/bracelet/ui/w;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/v;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/v;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/w;->a:Lcn/com/smartdevices/bracelet/ui/v;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/w;->a:Lcn/com/smartdevices/bracelet/ui/v;

    iget-object v0, v0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/ui/w;->a:Lcn/com/smartdevices/bracelet/ui/v;

    iget-boolean v1, v1, Lcn/com/smartdevices/bracelet/ui/v;->a:Z

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->updateDynamicList(Z)V

    return-void
.end method
