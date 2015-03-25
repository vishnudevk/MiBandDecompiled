.class Lcn/com/smartdevices/bracelet/activity/i;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/activity/i;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/activity/i;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    const-class v2, Lcn/com/smartdevices/bracelet/ui/SearchSingleBraceletActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/activity/i;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    invoke-virtual {v1, v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->startActivity(Landroid/content/Intent;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/activity/i;->a:Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/activity/PersonInfoFinishedActivity;->finish()V

    return-void
.end method
