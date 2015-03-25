.class Lcn/com/smartdevices/bracelet/chart/deprecated/v;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/v;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageScrollStateChanged(I)V
    .locals 0

    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0

    return-void
.end method

.method public onPageSelected(I)V
    .locals 5

    const v4, 0x7f0a0151

    const v3, 0x7f0a014e

    const/4 v2, 0x4

    const/4 v1, 0x0

    if-nez p1, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/v;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/v;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/v;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/v;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
