.class public Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;
.super Landroid/app/Fragment;


# static fields
.field private static final a:Ljava/lang/String; = "Chart.StatisticBaseFragment"


# instance fields
.field private b:I

.field protected mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

.field protected mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

.field protected mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

.field protected mDayCountSleep:I

.field protected mDayCountStep:I

.field protected mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

.field protected mSleepAchievement:I

.field protected mSleepDeepTime:I

.field protected mSleepRiseTime:I

.field protected mSleepShallowTime:I

.field protected mSleepStartTime:I

.field protected mSleepTime:I

.field protected mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

.field protected mStatSleepAchievement:Landroid/widget/TextView;

.field protected mStatSleepDeepHour:Landroid/widget/TextView;

.field protected mStatSleepDeepMin:Landroid/widget/TextView;

.field protected mStatSleepHour:Landroid/widget/TextView;

.field protected mStatSleepMin:Landroid/widget/TextView;

.field protected mStatSleepRiseTime:Landroid/widget/TextView;

.field protected mStatSleepShallowHour:Landroid/widget/TextView;

.field protected mStatSleepShallowMin:Landroid/widget/TextView;

.field protected mStatSleepStartTime:Landroid/widget/TextView;

.field protected mStatStepAchievement:Landroid/widget/TextView;

.field protected mStatStepActiveHour:Landroid/widget/TextView;

.field protected mStatStepActiveMin:Landroid/widget/TextView;

.field protected mStatStepCalorie:Landroid/widget/TextView;

.field protected mStatStepContinueHour:Landroid/widget/TextView;

.field protected mStatStepContinueMin:Landroid/widget/TextView;

.field protected mStatStepCount:Landroid/widget/TextView;

.field protected mStatStepDistance:Landroid/widget/TextView;

.field protected mStatStepDistanceUnit:Landroid/widget/TextView;

.field protected mStepAchievement:I

.field protected mStepActiveTime:I

.field protected mStepCalorie:I

.field protected mStepContinueTime:I

.field protected mStepCount:I

.field protected mStepDistance:I

.field protected mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

.field protected mToday:Lcn/com/smartdevices/bracelet/model/SportDay;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method private a(Landroid/view/View;)V
    .locals 1

    const v0, 0x7f0a012e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    const v0, 0x7f0a0130

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepCount:Landroid/widget/TextView;

    const v0, 0x7f0a0133

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepDistance:Landroid/widget/TextView;

    const v0, 0x7f0a0132

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepDistanceUnit:Landroid/widget/TextView;

    const v0, 0x7f0a0136

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepCalorie:Landroid/widget/TextView;

    const v0, 0x7f0a013e

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepAchievement:Landroid/widget/TextView;

    const v0, 0x7f0a0138

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepActiveHour:Landroid/widget/TextView;

    const v0, 0x7f0a0139

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepActiveMin:Landroid/widget/TextView;

    const v0, 0x7f0a013b

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepContinueHour:Landroid/widget/TextView;

    const v0, 0x7f0a013c

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepContinueMin:Landroid/widget/TextView;

    const v0, 0x7f0a0140

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepHour:Landroid/widget/TextView;

    const v0, 0x7f0a0141

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepMin:Landroid/widget/TextView;

    const v0, 0x7f0a0143

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepDeepHour:Landroid/widget/TextView;

    const v0, 0x7f0a0144

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepDeepMin:Landroid/widget/TextView;

    const v0, 0x7f0a0146

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepShallowHour:Landroid/widget/TextView;

    const v0, 0x7f0a0147

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepShallowMin:Landroid/widget/TextView;

    const v0, 0x7f0a014d

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepAchievement:Landroid/widget/TextView;

    const v0, 0x7f0a0149

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepStartTime:Landroid/widget/TextView;

    const v0, 0x7f0a014b

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepRiseTime:Landroid/widget/TextView;

    return-void
.end method

.method private a(Landroid/widget/TextView;Landroid/widget/TextView;I)V
    .locals 4

    const/4 v3, 0x0

    invoke-static {p3}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTimeLengthHourMin(I)[Ljava/lang/String;

    move-result-object v1

    aget-object v0, v1, v3

    const-string v2, "0"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    aget-object v0, v1, v3

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    invoke-virtual {p1}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    :goto_0
    const/4 v0, 0x1

    aget-object v0, v1, v0

    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void

    :cond_0
    invoke-virtual {p1}, Landroid/widget/TextView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private a(Landroid/content/Context;I)[Ljava/lang/String;
    .locals 6

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/high16 v3, 0x42c80000    # 100.0f

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    int-to-float v1, p2

    const/16 v2, 0x3e8

    if-lt p2, v2, :cond_0

    const/high16 v2, 0x447a0000    # 1000.0f

    div-float/2addr v1, v2

    mul-float/2addr v1, v3

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    int-to-float v1, v1

    div-float/2addr v1, v3

    invoke-static {v1}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v4

    const v1, 0x7f0d01c0

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v5

    :goto_0
    return-object v0

    :cond_0
    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v4

    const v1, 0x7f0d01c1

    invoke-virtual {p1, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v0, v5

    goto :goto_0
.end method

.method private b(Landroid/content/Context;I)[Ljava/lang/String;
    .locals 5

    const/4 v0, 0x2

    new-array v1, v0, [Ljava/lang/String;

    const/4 v2, 0x0

    const/16 v0, 0x64

    if-ge p2, v0, :cond_0

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    aput-object v0, v1, v2

    return-object v1

    :cond_0
    int-to-long v3, p2

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected cleanStatisticData()V
    .locals 1

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCount:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepDistance:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCalorie:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepAchievement:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepActiveTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepContinueTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepDeepTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepShallowTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepAchievement:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepStartTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepRiseTime:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    return-void
.end method

.method protected formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected formatDateShort(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected millisToMins(J)I
    .locals 3

    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/util/Calendar;->setTimeInMillis(J)V

    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    const/16 v2, 0xc

    invoke-virtual {v0, v2}, Ljava/util/Calendar;->get(I)I

    move-result v0

    mul-int/lit8 v1, v1, 0x3c

    add-int/2addr v0, v1

    return v0
.end method

.method protected newStatisticChartData(IIII)Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;
    .locals 2

    new-instance v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;

    invoke-direct {v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;-><init>()V

    if-lez p3, :cond_0

    div-int v1, p1, p3

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->stepValue:I

    :cond_0
    if-lez p4, :cond_1

    div-int v1, p2, p4

    iput v1, v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld$StatisticChartData;->sleepValue:I

    :cond_1
    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    invoke-super {p0, p1}, Landroid/app/Fragment;->onActivityCreated(Landroid/os/Bundle;)V

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mActiveStatisticChart:Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->b:I

    invoke-virtual {v0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticChartViewOld;->setStepGoal(I)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStatisticInfo()V

    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->register(Ljava/lang/Object;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/DataManager;->getInstance()Lcn/com/smartdevices/bracelet/DataManager;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getToday()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getCurDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mInitDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getStartDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/DataManager;->getStopDay()Lcn/com/smartdevices/bracelet/model/SportDay;

    move-result-object v0

    iput-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    const-string v0, "Chart.StatisticBaseFragment"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Today : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mToday:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StartDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStartDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , StopDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStopDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " , CurrentDay : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcn/com/smartdevices/bracelet/Keeper;->readPersonInfo()Lcn/com/smartdevices/bracelet/model/PersonInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcn/com/smartdevices/bracelet/model/PersonInfo;->getDaySportGoalSteps()I

    move-result v0

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->b:I

    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    const v0, 0x7f030049

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/view/View;)V

    return-object v0
.end method

.method public onDestroy()V
    .locals 1

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lde/greenrobot/event/EventBus;->unregister(Ljava/lang/Object;)V

    invoke-super {p0}, Landroid/app/Fragment;->onDestroy()V

    return-void
.end method

.method public onEvent(Lcn/com/smartdevices/bracelet/eventbus/EventSwitchViewMode;)V
    .locals 0

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStatisticInfo()V

    return-void
.end method

.method public setUserVisibleHint(Z)V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    invoke-super {p0, p1}, Landroid/app/Fragment;->setUserVisibleHint(Z)V

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mCurrentDay:Lcn/com/smartdevices/bracelet/model/SportDay;

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateDateTitle(Lcn/com/smartdevices/bracelet/model/SportDay;)V

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStatisticInfo()V

    :cond_0
    return-void
.end method

.method protected totalStatisticData(Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDataManager:Lcn/com/smartdevices/bracelet/DataManager;

    invoke-virtual {v0, p1}, Lcn/com/smartdevices/bracelet/DataManager;->getSummary(Lcn/com/smartdevices/bracelet/model/SportDay;)Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;

    move-result-object v0

    const-string v1, "Chart.StatisticBaseFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Summary : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v0, :cond_1

    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v1

    if-lez v1, :cond_0

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->totalStatisticDataStep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    :cond_0
    invoke-interface {v0}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v1

    if-lez v1, :cond_1

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->totalStatisticDataSleep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    :cond_1
    return-void
.end method

.method protected totalStatisticDataSleep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepTime:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepDeepTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleepDeepTime()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepDeepTime:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepShallowTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleepShallowTime()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepShallowTime:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepAchievement:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleep()I

    move-result v1

    mul-int/lit8 v1, v1, 0x64

    div-int/lit16 v1, v1, 0x1e0

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepAchievement:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepStartTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleepStartTime()J

    move-result-wide v1

    invoke-virtual {p0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->millisToMins(J)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepStartTime:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepRiseTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSleepRiseTime()J

    move-result-wide v1

    invoke-virtual {p0, v1, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->millisToMins(J)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepRiseTime:I

    return-void
.end method

.method protected totalStatisticDataStep(Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;)V
    .locals 3

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCount:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCount:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepDistance:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getStepDistance()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepDistance:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCalorie:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getStepCalorie()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCalorie:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepAchievement:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getSteps()I

    move-result v1

    mul-int/lit8 v1, v1, 0x64

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->b:I

    div-int/2addr v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepAchievement:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepActiveTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getStepActiveTime()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepActiveTime:I

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepContinueTime:I

    invoke-interface {p1}, Lcn/com/smartdevices/bracelet/model/DaySportData$Summary;->getStepContinueTime()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepContinueTime:I

    return-void
.end method

.method protected updateDateTitle(Lcn/com/smartdevices/bracelet/model/SportDay;)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->getUserVisibleHint()Z

    move-result v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->formatDate(Lcn/com/smartdevices/bracelet/model/SportDay;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "Chart.StatisticBaseFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "UpdateTitle : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcn/com/smartdevices/bracelet/Debug;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lde/greenrobot/event/EventBus;->getDefault()Lde/greenrobot/event/EventBus;

    move-result-object v1

    new-instance v2, Lcn/com/smartdevices/bracelet/eventbus/EventUpdateTitle;

    invoke-direct {v2, v0}, Lcn/com/smartdevices/bracelet/eventbus/EventUpdateTitle;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lde/greenrobot/event/EventBus;->post(Ljava/lang/Object;)V

    :cond_0
    return-void
.end method

.method protected updateSleepAchievement(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepAchievement:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateSleepDeepTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepDeepHour:Landroid/widget/TextView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepDeepMin:Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/widget/TextView;Landroid/widget/TextView;I)V

    return-void
.end method

.method protected updateSleepRiseTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepRiseTime:Landroid/widget/TextView;

    invoke-static {p1}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTime(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateSleepShallow(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepShallowHour:Landroid/widget/TextView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepShallowMin:Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/widget/TextView;Landroid/widget/TextView;I)V

    return-void
.end method

.method protected updateSleepStartTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepStartTime:Landroid/widget/TextView;

    invoke-static {p1}, Lcn/com/smartdevices/bracelet/chart/util/ChartData;->formatTime(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateSleepTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepHour:Landroid/widget/TextView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatSleepMin:Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/widget/TextView;Landroid/widget/TextView;I)V

    return-void
.end method

.method protected updateStatisticInfo()V
    .locals 4

    const/4 v1, 0x1

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    sget v0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticHostFragment;->sMode:I

    and-int/lit16 v0, v0, 0x100

    if-lez v0, :cond_3

    move v0, v1

    :goto_1
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    if-nez v2, :cond_1

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    :cond_1
    if-eqz v0, :cond_4

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCount:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    div-int/2addr v2, v3

    :goto_2
    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepCount(I)V

    if-eqz v0, :cond_5

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepDistance:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    div-int/2addr v2, v3

    :goto_3
    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepDistance(I)V

    if-eqz v0, :cond_6

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCalorie:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    div-int/2addr v2, v3

    :goto_4
    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepCalorie(I)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepAchievement:I

    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepAchievement(I)V

    if-eqz v0, :cond_7

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepActiveTime:I

    iget v3, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountStep:I

    div-int/2addr v2, v3

    :goto_5
    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepActiveTime(I)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepContinueTime:I

    invoke-virtual {p0, v2}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateStepContinueTime(I)V

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    if-nez v2, :cond_2

    iput v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    :cond_2
    if-eqz v0, :cond_8

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepTime:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    div-int/2addr v1, v2

    :goto_6
    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepTime(I)V

    if-eqz v0, :cond_9

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepDeepTime:I

    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    div-int/2addr v1, v2

    :goto_7
    invoke-virtual {p0, v1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepDeepTime(I)V

    if-eqz v0, :cond_a

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepShallowTime:I

    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mDayCountSleep:I

    div-int/2addr v0, v1

    :goto_8
    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepShallow(I)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepAchievement:I

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepAchievement(I)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepStartTime:I

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepStartTime(I)V

    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepRiseTime:I

    invoke-virtual {p0, v0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->updateSleepRiseTime(I)V

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_1

    :cond_4
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCount:I

    goto :goto_2

    :cond_5
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepDistance:I

    goto :goto_3

    :cond_6
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepCalorie:I

    goto :goto_4

    :cond_7
    iget v2, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStepActiveTime:I

    goto :goto_5

    :cond_8
    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepTime:I

    goto :goto_6

    :cond_9
    iget v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepDeepTime:I

    goto :goto_7

    :cond_a
    iget v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mSleepShallowTime:I

    goto :goto_8
.end method

.method protected updateStepAchievement(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepAchievement:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateStepActiveTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepActiveHour:Landroid/widget/TextView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepActiveMin:Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/widget/TextView;Landroid/widget/TextView;I)V

    return-void
.end method

.method protected updateStepCalorie(I)V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepCalorie:Landroid/widget/TextView;

    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, ",###"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateStepContinueTime(I)V
    .locals 2

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepContinueHour:Landroid/widget/TextView;

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepContinueMin:Landroid/widget/TextView;

    invoke-direct {p0, v0, v1, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/widget/TextView;Landroid/widget/TextView;I)V

    return-void
.end method

.method protected updateStepCount(I)V
    .locals 4

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepCount:Landroid/widget/TextView;

    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, ",###"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    int-to-long v2, p1

    invoke-virtual {v1, v2, v3}, Ljava/text/DecimalFormat;->format(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method

.method protected updateStepDistance(I)V
    .locals 3

    invoke-virtual {p0}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->a(Landroid/content/Context;I)[Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepDistance:Landroid/widget/TextView;

    const/4 v2, 0x0

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    iget-object v1, p0, Lcn/com/smartdevices/bracelet/chart/deprecated/StatisticBaseFragment;->mStatStepDistanceUnit:Landroid/widget/TextView;

    const/4 v2, 0x1

    aget-object v0, v0, v2

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    return-void
.end method
