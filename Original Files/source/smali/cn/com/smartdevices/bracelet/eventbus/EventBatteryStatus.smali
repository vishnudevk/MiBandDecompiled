.class public Lcn/com/smartdevices/bracelet/eventbus/EventBatteryStatus;
.super Ljava/lang/Object;


# instance fields
.field public level:I

.field public status:B


# direct methods
.method public constructor <init>(BI)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-byte v0, p0, Lcn/com/smartdevices/bracelet/eventbus/EventBatteryStatus;->status:B

    iput v0, p0, Lcn/com/smartdevices/bracelet/eventbus/EventBatteryStatus;->level:I

    iput-byte p1, p0, Lcn/com/smartdevices/bracelet/eventbus/EventBatteryStatus;->status:B

    iput p2, p0, Lcn/com/smartdevices/bracelet/eventbus/EventBatteryStatus;->level:I

    return-void
.end method
