.class public Lcn/com/smartdevices/bracelet/weather/WeatherInfo;
.super Ljava/lang/Object;


# static fields
.field public static final AQI_LEVEL_1:[I

.field public static final AQI_LEVEL_2:[I

.field public static final AQI_LEVEL_3:[I

.field public static final AQI_LEVEL_4:[I

.field public static final AQI_LEVEL_5:[I

.field public static final AQI_LEVEL_6:[I

.field private static sWeatherCloudy:[Ljava/lang/String;

.field private static sWeatherFine:[Ljava/lang/String;

.field private static sWeatherFog:[Ljava/lang/String;

.field private static sWeatherHaze:[Ljava/lang/String;

.field private static sWeatherOvercast:[Ljava/lang/String;

.field private static sWeatherRainSnows:[Ljava/lang/String;

.field private static sWeatherRains:[Ljava/lang/String;

.field private static sWeatherSands:[Ljava/lang/String;

.field private static sWeatherSnows:[Ljava/lang/String;


# instance fields
.field private aqi:I

.field private aqiDescription:Ljava/lang/String;

.field private aqiLevel:I

.field private time:J

.field private weather:Ljava/lang/String;

.field private weatherDescription:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x2

    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_1:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_1

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_2:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_2

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_3:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_3

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_4:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_4

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_5:[I

    new-array v0, v1, [I

    fill-array-data v0, :array_5

    sput-object v0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_6:[I

    return-void

    :array_0
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0x32t 0x0t 0x0t 0x0t
    .end array-data

    :array_1
    .array-data 0x4
        0x33t 0x0t 0x0t 0x0t
        0x64t 0x0t 0x0t 0x0t
    .end array-data

    :array_2
    .array-data 0x4
        0x64t 0x0t 0x0t 0x0t
        0x96t 0x0t 0x0t 0x0t
    .end array-data

    :array_3
    .array-data 0x4
        0x97t 0x0t 0x0t 0x0t
        0xc8t 0x0t 0x0t 0x0t
    .end array-data

    :array_4
    .array-data 0x4
        0xc9t 0x0t 0x0t 0x0t
        0x2ct 0x1t 0x0t 0x0t
    .end array-data

    :array_5
    .array-data 0x4
        0x2ct 0x1t 0x0t 0x0t
        0xf4t 0x1t 0x0t 0x0t
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, -0x1

    iput v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqi:I

    const/4 v0, 0x0

    iput v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiLevel:I

    return-void
.end method

.method private static has([Ljava/lang/String;Ljava/lang/String;)Z
    .locals 4

    const/4 v0, 0x0

    array-length v2, p0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, p0, v1

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v0, 0x1

    :cond_0
    return v0

    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public static toAqiDescription(Landroid/content/Context;I)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070003

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    if-lez p1, :cond_0

    add-int/lit8 v0, p1, -0x1

    aget-object v0, v1, v0

    :cond_0
    return-object v0
.end method

.method public static toAqiLevel(I)I
    .locals 3

    const/4 v0, 0x1

    const/4 v1, 0x0

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_1:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_0

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_1:[I

    aget v2, v2, v0

    if-gt p0, v2, :cond_0

    :goto_0
    return v0

    :cond_0
    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_2:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_1

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_2:[I

    aget v2, v2, v0

    if-gt p0, v2, :cond_1

    const/4 v0, 0x2

    goto :goto_0

    :cond_1
    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_3:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_2

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_3:[I

    aget v2, v2, v0

    if-gt p0, v2, :cond_2

    const/4 v0, 0x3

    goto :goto_0

    :cond_2
    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_4:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_3

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_4:[I

    aget v2, v2, v0

    if-gt p0, v2, :cond_3

    const/4 v0, 0x4

    goto :goto_0

    :cond_3
    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_5:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_4

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_5:[I

    aget v2, v2, v0

    if-gt p0, v2, :cond_4

    const/4 v0, 0x5

    goto :goto_0

    :cond_4
    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_6:[I

    aget v2, v2, v1

    if-lt p0, v2, :cond_5

    sget-object v2, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->AQI_LEVEL_6:[I

    aget v0, v2, v0

    if-gt p0, v0, :cond_5

    const/4 v0, 0x6

    goto :goto_0

    :cond_5
    move v0, v1

    goto :goto_0
.end method

.method public static toWeatherDescription(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    const/4 v0, 0x0

    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRains:[Ljava/lang/String;

    if-nez v1, :cond_0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f07000a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRains:[Ljava/lang/String;

    :cond_0
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRains:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const v0, 0x7f0d01e9

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRainSnows:[Ljava/lang/String;

    if-nez v1, :cond_3

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070009

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRainSnows:[Ljava/lang/String;

    :cond_3
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherRainSnows:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    const v0, 0x7f0d01ea

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_4
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSnows:[Ljava/lang/String;

    if-nez v1, :cond_5

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f07000c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSnows:[Ljava/lang/String;

    :cond_5
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSnows:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    const v0, 0x7f0d01ec

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_6
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSands:[Ljava/lang/String;

    if-nez v1, :cond_7

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f07000b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSands:[Ljava/lang/String;

    :cond_7
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherSands:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    const v0, 0x7f0d01eb

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_8
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFine:[Ljava/lang/String;

    if-nez v1, :cond_9

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFine:[Ljava/lang/String;

    :cond_9
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFine:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    const v0, 0x7f0d01e5

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_a
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherCloudy:[Ljava/lang/String;

    if-nez v1, :cond_b

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070004

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherCloudy:[Ljava/lang/String;

    :cond_b
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherCloudy:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    const v0, 0x7f0d01e4

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_c
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherOvercast:[Ljava/lang/String;

    if-nez v1, :cond_d

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070008

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherOvercast:[Ljava/lang/String;

    :cond_d
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherOvercast:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_e

    const v0, 0x7f0d01e8

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_e
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFog:[Ljava/lang/String;

    if-nez v1, :cond_f

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070006

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFog:[Ljava/lang/String;

    :cond_f
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherFog:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_10

    const v0, 0x7f0d01e6

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    :cond_10
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherHaze:[Ljava/lang/String;

    if-nez v1, :cond_11

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f070007

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherHaze:[Ljava/lang/String;

    :cond_11
    sget-object v1, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->sWeatherHaze:[Ljava/lang/String;

    invoke-static {v1, p1}, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->has([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    const v0, 0x7f0d01e7

    invoke-virtual {p0, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method


# virtual methods
.method public getAqi()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqi:I

    return v0
.end method

.method public getAqiDescription()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getAqiLevel()I
    .locals 1

    iget v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiLevel:I

    return v0
.end method

.method public getTime()J
    .locals 2

    iget-wide v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->time:J

    return-wide v0
.end method

.method public getWeather()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->weather:Ljava/lang/String;

    return-object v0
.end method

.method public getWeatherDescription()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->weatherDescription:Ljava/lang/String;

    return-object v0
.end method

.method public setAqi(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqi:I

    return-void
.end method

.method public setAqiDescription(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiDescription:Ljava/lang/String;

    return-void
.end method

.method public setAqiLevel(I)V
    .locals 0

    iput p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiLevel:I

    return-void
.end method

.method public setTime(J)V
    .locals 0

    iput-wide p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->time:J

    return-void
.end method

.method public setWeather(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->weather:Ljava/lang/String;

    return-void
.end method

.method public setWeatherDescription(Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->weatherDescription:Ljava/lang/String;

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v1, Ljava/util/Date;

    iget-wide v2, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->time:J

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    invoke-static {}, Ljava/text/DateFormat;->getTimeInstance()Ljava/text/DateFormat;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Time : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "Weather : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->weather:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "AQI : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqi:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "AQI Level : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiLevel:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "AQI Description : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcn/com/smartdevices/bracelet/weather/WeatherInfo;->aqiDescription:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
