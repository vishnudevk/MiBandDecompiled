.class Lcn/com/smartdevices/bracelet/ui/J;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/ui/J;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/ui/J;->a:Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;->b(Lcn/com/smartdevices/bracelet/ui/BraceletSettingsFragment;)V

    return-void
.end method
