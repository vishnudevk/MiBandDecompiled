.class Lcn/com/smartdevices/bracelet/chart/deprecated/n;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/n;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 2

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Float;

    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v0

    const/high16 v1, 0x43b4

    mul-float/2addr v1, v0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/n;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;)Lcn/com/smartdevices/bracelet/chart/base/BaseChart;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartOld;->rotate(F)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/n;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicPieChartViewOld;->postInvalidateOnAnimation()V

    return-void
.end method
