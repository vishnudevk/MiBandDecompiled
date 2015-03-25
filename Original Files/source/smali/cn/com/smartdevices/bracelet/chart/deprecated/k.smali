.class Lcn/com/smartdevices/bracelet/chart/deprecated/k;
.super Ljava/lang/Object;

# interfaces
.implements Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$LoadCallback;


# instance fields
.field final synthetic a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;


# direct methods
.method constructor <init>(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private a(Ljava/util/Calendar;)I
    .locals 2

    const/16 v0, 0xb

    invoke-virtual {p1, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    rsub-int/lit8 v0, v0, 0x18

    add-int/lit8 v0, v0, -0x1

    mul-int/lit8 v0, v0, 0x3c

    const/16 v1, 0xc

    invoke-virtual {p1, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    rsub-int/lit8 v1, v1, 0x3c

    add-int/2addr v0, v1

    neg-int v0, v0

    return v0
.end method

.method private b(Ljava/util/Calendar;)I
    .locals 2

    const/16 v0, 0xb

    invoke-virtual {p1, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v0, v0, 0x3c

    const/16 v1, 0xc

    invoke-virtual {p1, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method


# virtual methods
.method public hasData(I)Z
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    const-string v1, "DDDD"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Has Day : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->before(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->c(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/model/SportDay;->after(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "DDDD"

    const-string v1, "False!!"

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->w(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public loadData(I)Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    const-string v0, "DDDD"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Load Data : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/DataManager;->load(Lcn/com/smartdevices/bracelet/model/SportDay;)I

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/DataManager;->get(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->a(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/DaySportData;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    move-result-object v0

    :goto_0
    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v2

    if-eqz v2, :cond_1

    const-string v1, "\u4eca\u5929"

    :goto_1
    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->date:Ljava/lang/String;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    add-int/lit8 v3, p1, -0x1

    invoke-virtual {v2, v3}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;->prevDate:Ljava/lang/String;

    return-object v0

    :cond_0
    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld$DynamicDetailChartData;-><init>()V

    goto :goto_0

    :cond_1
    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->f(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Lcn/com/smartdevices/bracelet/model/SportDay;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "\u6628\u5929"

    goto :goto_1

    :cond_2
    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public onDataLoaded(Lcn/com/smartdevices/bracelet/chart/data/ChartDataLoader$ItemData;)V
    .locals 0

    return-void
.end method

.method public onToItem(I)V
    .locals 11

    const/4 v0, 0x0

    const/16 v10, 0xc

    const/4 v6, -0x1

    const/16 v9, 0xb

    const/4 v8, 0x0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->b(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    const-string v1, "DDDD"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "On To : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v3}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->e(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v1

    invoke-virtual {v1, v2}, Lcn/com/smartdevices/bracelet/DataManager;->get(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData;

    move-result-object v3

    if-eqz v3, :cond_6

    invoke-virtual {v3}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getSleepInfo()Lcn/com/smartdevices/bracelet/analysis/SleepInfo;

    move-result-object v1

    invoke-virtual {v3}, Lcn/com/smartdevices/bracelet/model/DaySportData;->getStepsInfo()Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    move-result-object v0

    :goto_0
    if-nez v1, :cond_0

    new-instance v1, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;

    invoke-direct {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;-><init>()V

    :cond_0
    if-nez v0, :cond_1

    new-instance v0, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;-><init>()V

    :cond_1
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v3

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStartDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    invoke-virtual {v1}, Lcn/com/smartdevices/bracelet/analysis/SleepInfo;->getStopDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v1

    invoke-virtual {v1, v8}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setOffset(I)V

    invoke-virtual {v3, v4}, Ljava/util/Calendar;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {v3, v9}, Ljava/util/Calendar;->get(I)I

    move-result v1

    invoke-virtual {v2, v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Ljava/util/Calendar;)Z

    move-result v5

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v5

    rsub-int/lit8 v1, v1, 0x18

    neg-int v1, v1

    invoke-virtual {v5, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setOffset(I)V

    invoke-direct {p0, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a(Ljava/util/Calendar;)I

    move-result v1

    :goto_1
    invoke-virtual {v2, v6}, Lcn/com/smartdevices/bracelet/model/SportDay;->addDay(I)Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcn/com/smartdevices/bracelet/model/SportDay;->equals(Ljava/util/Calendar;)Z

    move-result v2

    if-eqz v2, :cond_4

    invoke-direct {p0, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a(Ljava/util/Calendar;)I

    move-result v2

    :goto_2
    iget-object v5, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v5}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v5

    iget-object v6, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-virtual {v3, v9}, Ljava/util/Calendar;->get(I)I

    move-result v7

    invoke-virtual {v3, v10}, Ljava/util/Calendar;->get(I)I

    move-result v3

    invoke-virtual {v6, v7, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->formatTime(II)Ljava/lang/String;

    move-result-object v3

    const-string v6, " \u4f11\u517b\u751f\u606f"

    invoke-virtual {v5, v1, v3, v6}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setSleepStartTime(ILjava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v1

    iget-object v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-virtual {v4, v9}, Ljava/util/Calendar;->get(I)I

    move-result v5

    invoke-virtual {v4, v10}, Ljava/util/Calendar;->get(I)I

    move-result v4

    invoke-virtual {v3, v5, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->formatTime(II)Ljava/lang/String;

    move-result-object v3

    const-string v4, " \u65b0\u7684\u4e00\u5929"

    invoke-virtual {v1, v2, v3, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setSleepRiseTime(ILjava/lang/String;Ljava/lang/String;)V

    :cond_2
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1}, Ljava/lang/String;-><init>()V

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/analysis/StepsInfo;->getActMinutes()I

    move-result v0

    invoke-virtual {v2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->formatTimeHourMin(I)[Ljava/lang/String;

    move-result-object v2

    aget-object v0, v2, v8

    if-eqz v0, :cond_5

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    aget-object v1, v2, v8

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u5c0f\u65f6"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v1, 0x1

    aget-object v1, v2, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u5206\u949f"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v1

    const-string v2, "\u603b\u6d3b\u52a8\u65f6\u95f4"

    invoke-virtual {v1, v2, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->setStepTime(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->a:Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;

    invoke-static {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;->g(Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailFragmentOld;)Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/DynamicDetailChartViewOld;->notifyChanged()V

    return-void

    :cond_3
    invoke-direct {p0, v3}, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->b(Ljava/util/Calendar;)I

    move-result v1

    goto/16 :goto_1

    :cond_4
    invoke-direct {p0, v4}, Lcn/com/smartdevices/bracelet/chart/deprecated/k;->b(Ljava/util/Calendar;)I

    move-result v2

    goto/16 :goto_2

    :cond_5
    move-object v0, v1

    goto :goto_3

    :cond_6
    move-object v1, v0

    goto/16 :goto_0
.end method
