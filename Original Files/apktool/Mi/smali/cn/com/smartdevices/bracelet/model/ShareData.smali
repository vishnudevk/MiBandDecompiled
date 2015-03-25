.class public Lcn/com/smartdevices/bracelet/model/ShareData;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field private static final COLOR_ACTIVITY_STEP:I = -0xe7673c

.field private static final COLOR_CONTINUE_SUCC:I = -0x1ac3bc

.field private static final COLOR_CONTINUE_SUCC_NEW_RECORD:I = -0xa8ed0

.field private static final COLOR_GOAL_FAILED:I = -0xe7673c

.field private static final COLOR_GOAL_SUCC:I = -0xa8ed0

.field private static final COLOR_LAST_NIGHT_SLEEP:I = -0xc8c28c

.field private static final COLOR_MONTH_SLEEP:I = -0xb6d594

.field private static final COLOR_MONTH_STEP:I = -0xe85d9e

.field private static final COLOR_NEW_RECORD:I = -0x11a8cc

.field private static final COLOR_WEEK_SLEEP:I = -0xb6d594

.field private static final COLOR_WEEK_STEP:I = -0xe85d9e

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcn/com/smartdevices/bracelet/model/ShareData;",
            ">;"
        }
    .end annotation
.end field

.field public static final SHARE_TYPE_ACTIVITY_STEP:I = 0x9

.field public static final SHARE_TYPE_CONTINUE_SUCC:I = 0x8

.field public static final SHARE_TYPE_CONTINUE_SUCC_NEW_RECORD:I = 0xa

.field public static final SHARE_TYPE_EVENT:I = 0xb

.field public static final SHARE_TYPE_GOAL_FAILED:I = 0x1

.field public static final SHARE_TYPE_GOAL_SUCC:I = 0x0

.field public static final SHARE_TYPE_LAST_NIGHT_SLEEP:I = 0x2

.field public static final SHARE_TYPE_MONTH_AVE_STEPS:I = 0x6

.field public static final SHARE_TYPE_MONTH_SLEEP:I = 0x4

.field public static final SHARE_TYPE_NEW_RECORD:I = 0x5

.field public static final SHARE_TYPE_WEEK_AVE_STEPS:I = 0x7

.field public static final SHARE_TYPE_WEEK_SLEEP:I = 0x3


# instance fields
.field public color:I

.field public content:Ljava/lang/String;

.field public contentUnit:Ljava/lang/String;

.field public description:Ljava/lang/String;

.field public time:Ljava/lang/String;

.field public time_tips:Ljava/lang/String;

.field public title:Ljava/lang/String;

.field public type:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcn/com/smartdevices/bracelet/model/ShareData$1;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/model/ShareData$1;-><init>()V

    sput-object v0, Lcn/com/smartdevices/bracelet/model/ShareData;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->content:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time_tips:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    return-void
.end method

.method public constructor <init>(I)V
    .locals 2

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->content:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time_tips:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    invoke-virtual {p0, p1}, Lcn/com/smartdevices/bracelet/model/ShareData;->setType(I)V

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public isSleepType()Z
    .locals 2

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setType(I)V
    .locals 4

    const v3, -0xa8ed0

    const v2, -0xb6d594

    const v1, -0xe7673c

    const v0, -0xe85d9e

    iput p1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    packed-switch p1, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iput v3, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_1
    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_2
    const v0, -0xc8c28c

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_3
    iput v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_4
    iput v2, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_5
    const v0, -0x11a8cc

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_6
    iput v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_7
    iput v2, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_8
    const v0, -0x1ac3bc

    iput v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_9
    iput v3, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_a
    iput v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_7
        :pswitch_4
        :pswitch_5
        :pswitch_3
        :pswitch_6
        :pswitch_8
        :pswitch_a
        :pswitch_9
    .end packed-switch
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "type:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "title:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "content:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->content:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "contentUnit:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "time:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "time_tips:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time_tips:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "description:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "color:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->content:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->contentUnit:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->time_tips:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->description:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->color:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/model/ShareData;->type:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    return-void
.end method
