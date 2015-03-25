.class Lcn/com/smartdevices/bracelet/chart/deprecated/j;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/j;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/j;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Landroid/view/GestureDetector;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method
