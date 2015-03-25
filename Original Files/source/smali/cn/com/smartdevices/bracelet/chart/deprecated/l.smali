.class Lcn/com/smartdevices/bracelet/chart/deprecated/l;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/DataManager;->getToday()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    :cond_0
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/DataManager;->getCurDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    :cond_1
    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->d(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/DataManager;->getStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/DataManager;->getStopDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/SportDay;

    const-string v0, "DDDD"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Today : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StartDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StopDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , CurrentDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->h(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->clearData()V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/l;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->loadDayActiveData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;

    return-void
.end method
