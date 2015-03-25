.class Lcn/com/smartdevices/bracelet/chart/deprecated/i;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/view/GestureDetector$OnGestureListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 5

    const/4 v1, 0x1

    const/4 v0, 0x0

    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v2

    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_2

    const/high16 v2, 0x447a0000    # 1000.0f

    cmpl-float v2, p3, v2

    if-lez v2, :cond_2

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    const/4 v4, -0x1

    invoke-virtual {v3, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    sget-object v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->sRefreshHander:Landroid/os/Handler;

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    :cond_0
    :goto_0
    move v0, v1

    :cond_1
    return v0

    :cond_2
    invoke-static {p3}, Ljava/lang/Math;->abs(F)F

    move-result v2

    invoke-static {p4}, Ljava/lang/Math;->abs(F)F

    move-result v3

    cmpl-float v2, v2, v3

    if-lez v2, :cond_1

    const/high16 v2, -0x3b860000    # -1000.0f

    cmpg-float v2, p3, v2

    if-gez v2, :cond_1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/i;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    invoke-virtual {v3, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v3

    invoke-static {v2, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    sget-object v2, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->sRefreshHander:Landroid/os/Handler;

    invoke-virtual {v2, v0}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 0

    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 0

    return-void
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 1

    const/4 v0, 0x0

    return v0
.end method
