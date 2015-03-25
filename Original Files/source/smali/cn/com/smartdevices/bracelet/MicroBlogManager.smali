.class public Lcn/com/smartdevices/bracelet/MicroBlogManager;
.super Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;


# static fields
.field private static a:Lcn/com/smartdevices/bracelet/MicroBlogManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-object v0, Lcn/com/smartdevices/bracelet/MicroBlogManager;->a:Lcn/com/smartdevices/bracelet/MicroBlogManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcn/com/smartdevices/bracelet/BaseMicroBlogManager;-><init>()V

    return-void
.end method

.method public static getInstance()Lcn/com/smartdevices/bracelet/MicroBlogManager;
    .locals 1

    sget-object v0, Lcn/com/smartdevices/bracelet/MicroBlogManager;->a:Lcn/com/smartdevices/bracelet/MicroBlogManager;

    if-nez v0, :cond_0

    new-instance v0, Lcn/com/smartdevices/bracelet/MicroBlogManager;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/MicroBlogManager;-><init>()V

    sput-object v0, Lcn/com/smartdevices/bracelet/MicroBlogManager;->a:Lcn/com/smartdevices/bracelet/MicroBlogManager;

    :cond_0
    sget-object v0, Lcn/com/smartdevices/bracelet/MicroBlogManager;->a:Lcn/com/smartdevices/bracelet/MicroBlogManager;

    return-object v0
.end method
