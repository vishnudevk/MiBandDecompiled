.class public Lcn/com/smartdevices/bracelet/ui/AppExitFragment;
.super Lcn/com/smartdevices/bracelet/ui/DimPanelFragment;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/ui/DimPanelFragment;-><init>()V

    return-void
.end method


# virtual methods
.method protected inflateLayout()I
    .locals 1

    const v0, 0x7f03001f

    return v0
.end method

.method protected onRightButtomClicked()V
    .locals 1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/ui/AppExitFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/BraceletApp;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/BraceletApp;->finishBLEService()V

    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    return-void
.end method
