.class Lcn/com/smartdevices/bracelet/chart/deprecated/m;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/Animator$AnimatorListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->dismissLoading()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->rotate(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->postInvalidateOnAnimation()V

    return-void
.end method

.method public onAnimationRepeat(Landroid/animation/Animator;)V
    .locals 0

    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->showLoading()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->rotate(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/m;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->postInvalidateOnAnimation()V

    return-void
.end method
