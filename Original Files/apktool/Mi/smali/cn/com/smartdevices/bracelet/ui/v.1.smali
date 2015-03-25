.class Lcn/com/smartdevices/bracelet/ui/v;
.super Ljava/lang/Object;

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;Z)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    iput-boolean p2, p0, Lcn/com/smartdevices/bracelet/ui/v;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/v;->a:Z

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->c(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/v;->a:Z

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->d(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->generateSleepReport()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->generateActivitiesReport()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->p(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    iget-boolean v1, p0, Lcn/com/smartdevices/bracelet/ui/v;->a:Z

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->a(Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;Z)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/v;->b:Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;

    new-instance v1, Lcn/com/smartdevices/bracelet/ui/w;

    invoke-direct {v1, p0}, Lcn/com/smartdevices/bracelet/ui/w;-><init>(Lcn/com/smartdevices/bracelet/ui/v;)V

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/ui/BaseSCActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method
