.class Lcn/com/smartdevices/bracelet/ui/bF;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/bF;->a:Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bF;->a:Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/bF;->a:Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/ui/SettingFeedbackFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    :cond_0
    return-void
.end method
