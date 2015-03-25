.class public final Lcom/tencent/b/b/s;
.super Ljava/lang/Object;


# static fields
.field public static a:Ljava/lang/String;

.field public static b:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const-string v0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567"

    sput-object v0, Lcom/tencent/b/b/s;->a:Ljava/lang/String;

    const/16 v0, 0x100

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lcom/tencent/b/b/s;->b:[I

    const/16 v0, 0x8

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x16dbd

    aput v2, v0, v1

    const/4 v1, 0x1

    const v2, 0x18627

    aput v2, v0, v1

    const/4 v1, 0x2

    const v2, 0x137e3

    aput v2, v0, v1

    const/4 v1, 0x3

    const v2, 0x12515

    aput v2, v0, v1

    const/4 v1, 0x4

    const v2, 0xe933

    aput v2, v0, v1

    const/4 v1, 0x5

    const v2, 0xd973

    aput v2, v0, v1

    const/4 v1, 0x6

    const v2, 0xb713

    aput v2, v0, v1

    const/4 v1, 0x7

    const v2, 0x9497

    aput v2, v0, v1

    return-void

    :array_0
    .array-data 0x4
        0x0t 0x0t 0x0t 0x0t
        0xc1t 0xc0t 0x0t 0x0t
        0x81t 0xc1t 0x0t 0x0t
        0x40t 0x1t 0x0t 0x0t
        0x1t 0xc3t 0x0t 0x0t
        0xc0t 0x3t 0x0t 0x0t
        0x80t 0x2t 0x0t 0x0t
        0x41t 0xc2t 0x0t 0x0t
        0x1t 0xc6t 0x0t 0x0t
        0xc0t 0x6t 0x0t 0x0t
        0x80t 0x7t 0x0t 0x0t
        0x41t 0xc7t 0x0t 0x0t
        0x0t 0x5t 0x0t 0x0t
        0xc1t 0xc5t 0x0t 0x0t
        0x81t 0xc4t 0x0t 0x0t
        0x40t 0x4t 0x0t 0x0t
        0x1t 0xcct 0x0t 0x0t
        0xc0t 0xct 0x0t 0x0t
        0x80t 0xdt 0x0t 0x0t
        0x41t 0xcdt 0x0t 0x0t
        0x0t 0xft 0x0t 0x0t
        0xc1t 0xcft 0x0t 0x0t
        0x81t 0xcet 0x0t 0x0t
        0x40t 0xet 0x0t 0x0t
        0x0t 0xat 0x0t 0x0t
        0xc1t 0xcat 0x0t 0x0t
        0x81t 0xcbt 0x0t 0x0t
        0x40t 0xbt 0x0t 0x0t
        0x1t 0xc9t 0x0t 0x0t
        0xc0t 0x9t 0x0t 0x0t
        0x80t 0x8t 0x0t 0x0t
        0x41t 0xc8t 0x0t 0x0t
        0x1t 0xd8t 0x0t 0x0t
        0xc0t 0x18t 0x0t 0x0t
        0x80t 0x19t 0x0t 0x0t
        0x41t 0xd9t 0x0t 0x0t
        0x0t 0x1bt 0x0t 0x0t
        0xc1t 0xdbt 0x0t 0x0t
        0x81t 0xdat 0x0t 0x0t
        0x40t 0x1at 0x0t 0x0t
        0x0t 0x1et 0x0t 0x0t
        0xc1t 0xdet 0x0t 0x0t
        0x81t 0xdft 0x0t 0x0t
        0x40t 0x1ft 0x0t 0x0t
        0x1t 0xddt 0x0t 0x0t
        0xc0t 0x1dt 0x0t 0x0t
        0x80t 0x1ct 0x0t 0x0t
        0x41t 0xdct 0x0t 0x0t
        0x0t 0x14t 0x0t 0x0t
        0xc1t 0xd4t 0x0t 0x0t
        0x81t 0xd5t 0x0t 0x0t
        0x40t 0x15t 0x0t 0x0t
        0x1t 0xd7t 0x0t 0x0t
        0xc0t 0x17t 0x0t 0x0t
        0x80t 0x16t 0x0t 0x0t
        0x41t 0xd6t 0x0t 0x0t
        0x1t 0xd2t 0x0t 0x0t
        0xc0t 0x12t 0x0t 0x0t
        0x80t 0x13t 0x0t 0x0t
        0x41t 0xd3t 0x0t 0x0t
        0x0t 0x11t 0x0t 0x0t
        0xc1t 0xd1t 0x0t 0x0t
        0x81t 0xd0t 0x0t 0x0t
        0x40t 0x10t 0x0t 0x0t
        0x1t 0xf0t 0x0t 0x0t
        0xc0t 0x30t 0x0t 0x0t
        0x80t 0x31t 0x0t 0x0t
        0x41t 0xf1t 0x0t 0x0t
        0x0t 0x33t 0x0t 0x0t
        0xc1t 0xf3t 0x0t 0x0t
        0x81t 0xf2t 0x0t 0x0t
        0x40t 0x32t 0x0t 0x0t
        0x0t 0x36t 0x0t 0x0t
        0xc1t 0xf6t 0x0t 0x0t
        0x81t 0xf7t 0x0t 0x0t
        0x40t 0x37t 0x0t 0x0t
        0x1t 0xf5t 0x0t 0x0t
        0xc0t 0x35t 0x0t 0x0t
        0x80t 0x34t 0x0t 0x0t
        0x41t 0xf4t 0x0t 0x0t
        0x0t 0x3ct 0x0t 0x0t
        0xc1t 0xfct 0x0t 0x0t
        0x81t 0xfdt 0x0t 0x0t
        0x40t 0x3dt 0x0t 0x0t
        0x1t 0xfft 0x0t 0x0t
        0xc0t 0x3ft 0x0t 0x0t
        0x80t 0x3et 0x0t 0x0t
        0x41t 0xfet 0x0t 0x0t
        0x1t 0xfat 0x0t 0x0t
        0xc0t 0x3at 0x0t 0x0t
        0x80t 0x3bt 0x0t 0x0t
        0x41t 0xfbt 0x0t 0x0t
        0x0t 0x39t 0x0t 0x0t
        0xc1t 0xf9t 0x0t 0x0t
        0x81t 0xf8t 0x0t 0x0t
        0x40t 0x38t 0x0t 0x0t
        0x0t 0x28t 0x0t 0x0t
        0xc1t 0xe8t 0x0t 0x0t
        0x81t 0xe9t 0x0t 0x0t
        0x40t 0x29t 0x0t 0x0t
        0x1t 0xebt 0x0t 0x0t
        0xc0t 0x2bt 0x0t 0x0t
        0x80t 0x2at 0x0t 0x0t
        0x41t 0xeat 0x0t 0x0t
        0x1t 0xeet 0x0t 0x0t
        0xc0t 0x2et 0x0t 0x0t
        0x80t 0x2ft 0x0t 0x0t
        0x41t 0xeft 0x0t 0x0t
        0x0t 0x2dt 0x0t 0x0t
        0xc1t 0xedt 0x0t 0x0t
        0x81t 0xect 0x0t 0x0t
        0x40t 0x2ct 0x0t 0x0t
        0x1t 0xe4t 0x0t 0x0t
        0xc0t 0x24t 0x0t 0x0t
        0x80t 0x25t 0x0t 0x0t
        0x41t 0xe5t 0x0t 0x0t
        0x0t 0x27t 0x0t 0x0t
        0xc1t 0xe7t 0x0t 0x0t
        0x81t 0xe6t 0x0t 0x0t
        0x40t 0x26t 0x0t 0x0t
        0x0t 0x22t 0x0t 0x0t
        0xc1t 0xe2t 0x0t 0x0t
        0x81t 0xe3t 0x0t 0x0t
        0x40t 0x23t 0x0t 0x0t
        0x1t 0xe1t 0x0t 0x0t
        0xc0t 0x21t 0x0t 0x0t
        0x80t 0x20t 0x0t 0x0t
        0x41t 0xe0t 0x0t 0x0t
        0x1t 0xa0t 0x0t 0x0t
        0xc0t 0x60t 0x0t 0x0t
        0x80t 0x61t 0x0t 0x0t
        0x41t 0xa1t 0x0t 0x0t
        0x0t 0x63t 0x0t 0x0t
        0xc1t 0xa3t 0x0t 0x0t
        0x81t 0xa2t 0x0t 0x0t
        0x40t 0x62t 0x0t 0x0t
        0x0t 0x66t 0x0t 0x0t
        0xc1t 0xa6t 0x0t 0x0t
        0x81t 0xa7t 0x0t 0x0t
        0x40t 0x67t 0x0t 0x0t
        0x1t 0xa5t 0x0t 0x0t
        0xc0t 0x65t 0x0t 0x0t
        0x80t 0x64t 0x0t 0x0t
        0x41t 0xa4t 0x0t 0x0t
        0x0t 0x6ct 0x0t 0x0t
        0xc1t 0xact 0x0t 0x0t
        0x81t 0xadt 0x0t 0x0t
        0x40t 0x6dt 0x0t 0x0t
        0x1t 0xaft 0x0t 0x0t
        0xc0t 0x6ft 0x0t 0x0t
        0x80t 0x6et 0x0t 0x0t
        0x41t 0xaet 0x0t 0x0t
        0x1t 0xaat 0x0t 0x0t
        0xc0t 0x6at 0x0t 0x0t
        0x80t 0x6bt 0x0t 0x0t
        0x41t 0xabt 0x0t 0x0t
        0x0t 0x69t 0x0t 0x0t
        0xc1t 0xa9t 0x0t 0x0t
        0x81t 0xa8t 0x0t 0x0t
        0x40t 0x68t 0x0t 0x0t
        0x0t 0x78t 0x0t 0x0t
        0xc1t 0xb8t 0x0t 0x0t
        0x81t 0xb9t 0x0t 0x0t
        0x40t 0x79t 0x0t 0x0t
        0x1t 0xbbt 0x0t 0x0t
        0xc0t 0x7bt 0x0t 0x0t
        0x80t 0x7at 0x0t 0x0t
        0x41t 0xbat 0x0t 0x0t
        0x1t 0xbet 0x0t 0x0t
        0xc0t 0x7et 0x0t 0x0t
        0x80t 0x7ft 0x0t 0x0t
        0x41t 0xbft 0x0t 0x0t
        0x0t 0x7dt 0x0t 0x0t
        0xc1t 0xbdt 0x0t 0x0t
        0x81t 0xbct 0x0t 0x0t
        0x40t 0x7ct 0x0t 0x0t
        0x1t 0xb4t 0x0t 0x0t
        0xc0t 0x74t 0x0t 0x0t
        0x80t 0x75t 0x0t 0x0t
        0x41t 0xb5t 0x0t 0x0t
        0x0t 0x77t 0x0t 0x0t
        0xc1t 0xb7t 0x0t 0x0t
        0x81t 0xb6t 0x0t 0x0t
        0x40t 0x76t 0x0t 0x0t
        0x0t 0x72t 0x0t 0x0t
        0xc1t 0xb2t 0x0t 0x0t
        0x81t 0xb3t 0x0t 0x0t
        0x40t 0x73t 0x0t 0x0t
        0x1t 0xb1t 0x0t 0x0t
        0xc0t 0x71t 0x0t 0x0t
        0x80t 0x70t 0x0t 0x0t
        0x41t 0xb0t 0x0t 0x0t
        0x0t 0x50t 0x0t 0x0t
        0xc1t 0x90t 0x0t 0x0t
        0x81t 0x91t 0x0t 0x0t
        0x40t 0x51t 0x0t 0x0t
        0x1t 0x93t 0x0t 0x0t
        0xc0t 0x53t 0x0t 0x0t
        0x80t 0x52t 0x0t 0x0t
        0x41t 0x92t 0x0t 0x0t
        0x1t 0x96t 0x0t 0x0t
        0xc0t 0x56t 0x0t 0x0t
        0x80t 0x57t 0x0t 0x0t
        0x41t 0x97t 0x0t 0x0t
        0x0t 0x55t 0x0t 0x0t
        0xc1t 0x95t 0x0t 0x0t
        0x81t 0x94t 0x0t 0x0t
        0x40t 0x54t 0x0t 0x0t
        0x1t 0x9ct 0x0t 0x0t
        0xc0t 0x5ct 0x0t 0x0t
        0x80t 0x5dt 0x0t 0x0t
        0x41t 0x9dt 0x0t 0x0t
        0x0t 0x5ft 0x0t 0x0t
        0xc1t 0x9ft 0x0t 0x0t
        0x81t 0x9et 0x0t 0x0t
        0x40t 0x5et 0x0t 0x0t
        0x0t 0x5at 0x0t 0x0t
        0xc1t 0x9at 0x0t 0x0t
        0x81t 0x9bt 0x0t 0x0t
        0x40t 0x5bt 0x0t 0x0t
        0x1t 0x99t 0x0t 0x0t
        0xc0t 0x59t 0x0t 0x0t
        0x80t 0x58t 0x0t 0x0t
        0x41t 0x98t 0x0t 0x0t
        0x1t 0x88t 0x0t 0x0t
        0xc0t 0x48t 0x0t 0x0t
        0x80t 0x49t 0x0t 0x0t
        0x41t 0x89t 0x0t 0x0t
        0x0t 0x4bt 0x0t 0x0t
        0xc1t 0x8bt 0x0t 0x0t
        0x81t 0x8at 0x0t 0x0t
        0x40t 0x4at 0x0t 0x0t
        0x0t 0x4et 0x0t 0x0t
        0xc1t 0x8et 0x0t 0x0t
        0x81t 0x8ft 0x0t 0x0t
        0x40t 0x4ft 0x0t 0x0t
        0x1t 0x8dt 0x0t 0x0t
        0xc0t 0x4dt 0x0t 0x0t
        0x80t 0x4ct 0x0t 0x0t
        0x41t 0x8ct 0x0t 0x0t
        0x0t 0x44t 0x0t 0x0t
        0xc1t 0x84t 0x0t 0x0t
        0x81t 0x85t 0x0t 0x0t
        0x40t 0x45t 0x0t 0x0t
        0x1t 0x87t 0x0t 0x0t
        0xc0t 0x47t 0x0t 0x0t
        0x80t 0x46t 0x0t 0x0t
        0x41t 0x86t 0x0t 0x0t
        0x1t 0x82t 0x0t 0x0t
        0xc0t 0x42t 0x0t 0x0t
        0x80t 0x43t 0x0t 0x0t
        0x41t 0x83t 0x0t 0x0t
        0x0t 0x41t 0x0t 0x0t
        0xc1t 0x81t 0x0t 0x0t
        0x81t 0x80t 0x0t 0x0t
        0x40t 0x40t 0x0t 0x0t
    .end array-data
.end method

.method public static a(DI)D
    .locals 4

    const-wide/16 v0, 0x0

    :try_start_0
    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v2

    if-eqz v2, :cond_0

    :goto_0
    return-wide v0

    :cond_0
    invoke-static {p0, p1}, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;

    move-result-object v2

    sget-object v3, Ljava/math/RoundingMode;->HALF_DOWN:Ljava/math/RoundingMode;

    invoke-virtual {v2, p2, v3}, Ljava/math/BigDecimal;->setScale(ILjava/math/RoundingMode;)Ljava/math/BigDecimal;

    move-result-object v2

    invoke-virtual {v2}, Ljava/math/BigDecimal;->doubleValue()D
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    goto :goto_0

    :catch_0
    move-exception v2

    goto :goto_0
.end method

.method public static a(C)I
    .locals 2

    const/16 v0, 0x100

    const/16 v1, 0x41

    if-lt p0, v1, :cond_0

    const/16 v1, 0x5a

    if-gt p0, v1, :cond_0

    add-int/lit8 v0, p0, -0x41

    :cond_0
    const/16 v1, 0x61

    if-lt p0, v1, :cond_1

    const/16 v1, 0x7a

    if-gt p0, v1, :cond_1

    add-int/lit8 v0, p0, -0x61

    add-int/lit8 v0, v0, 0x40

    :cond_1
    const/16 v1, 0x30

    if-lt p0, v1, :cond_2

    const/16 v1, 0x39

    if-gt p0, v1, :cond_2

    add-int/lit16 v0, p0, 0x80

    add-int/lit8 v0, v0, -0x30

    :cond_2
    return v0
.end method

.method private static a(IIIIIII)Ljava/lang/String;
    .locals 7

    const v2, 0x7fffffff

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/high16 v4, 0x4661

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\"mcc\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ",\"mnc\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ",\"lac\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ",\"cellid\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    const-string v1, ",\"rss\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    if-eq p5, v2, :cond_0

    if-eq p6, v2, :cond_0

    const-string v1, ",\"stationLat\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "%.6f"

    new-array v2, v6, [Ljava/lang/Object;

    int-to-float v3, p5

    div-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ",\"stationLng\":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "%.6f"

    new-array v2, v6, [Ljava/lang/Object;

    int-to-float v3, p6

    div-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Lcom/tencent/b/b/e$a;)Ljava/lang/String;
    .locals 5

    invoke-virtual {p0}, Lcom/tencent/b/b/e$a;->b()Landroid/location/Location;

    move-result-object v0

    if-nez v0, :cond_0

    const-string v0, "{}"

    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/tencent/b/b/e$a;->b()Landroid/location/Location;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "{"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "\"latitude\":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v2, ",\"longitude\":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    const-string v2, ",\"additional\":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\""

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Landroid/location/Location;->getAltitude()D

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getAccuracy()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getBearing()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getSpeed()F

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v0, "}"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method

.method public static a(Lcom/tencent/b/b/f$b;)Ljava/lang/String;
    .locals 9

    const/4 v2, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/tencent/b/b/f$b;->a()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    const-string v0, "[]"

    :goto_0
    return-object v0

    :cond_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "["

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/tencent/b/b/f$b;->a()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/tencent/b/b/f$b;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gtz v0, :cond_3

    :cond_2
    const-string v0, "]"

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_3
    invoke-virtual {p0}, Lcom/tencent/b/b/f$b;->a()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v1, v2

    :cond_4
    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/ScanResult;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v3

    iget v7, v0, Landroid/net/wifi/ScanResult;->level:I

    const/4 v8, 0x6

    if-ge v3, v8, :cond_6

    const/16 v3, -0x5f

    :goto_2
    if-ge v7, v3, :cond_7

    move v3, v2

    :goto_3
    if-eqz v3, :cond_4

    if-lez v1, :cond_5

    const-string v3, ","

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_5
    const-string v3, "{\"mac\":\""

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v7, v0, Landroid/net/wifi/ScanResult;->BSSID:Ljava/lang/String;

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v7, "\","

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, "\"rssi\":"

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v0, v0, Landroid/net/wifi/ScanResult;->level:I

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    :cond_6
    const/16 v3, -0x5a

    goto :goto_2

    :cond_7
    const/4 v3, 0x1

    goto :goto_3

    :cond_8
    const-string v0, "]"

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method

.method public static a(Lcom/tencent/b/b/m$b;Ljava/util/List;)Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/tencent/b/b/m$b;",
            "Ljava/util/List",
            "<",
            "Landroid/telephony/NeighboringCellInfo;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    const/4 v8, 0x0

    if-nez p0, :cond_0

    const-string v1, "[]"

    :goto_0
    return-object v1

    :cond_0
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "["

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Lcom/tencent/b/b/m$b;->b:I

    iget v2, p0, Lcom/tencent/b/b/m$b;->c:I

    iget v3, p0, Lcom/tencent/b/b/m$b;->a:I

    iget v4, p0, Lcom/tencent/b/b/m$b;->d:I

    iget v5, p0, Lcom/tencent/b/b/m$b;->e:I

    invoke-static {v3, v1, v2, v4, v5}, Lcom/tencent/b/b/s;->a(IIIII)Z

    move-result v3

    if-eqz v3, :cond_1

    iget v3, p0, Lcom/tencent/b/b/m$b;->d:I

    iget v4, p0, Lcom/tencent/b/b/m$b;->e:I

    iget v5, p0, Lcom/tencent/b/b/m$b;->f:I

    iget v6, p0, Lcom/tencent/b/b/m$b;->g:I

    iget v7, p0, Lcom/tencent/b/b/m$b;->h:I

    invoke-static/range {v1 .. v7}, Lcom/tencent/b/b/s;->a(IIIIIII)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const/4 v8, 0x1

    :cond_1
    if-eqz p1, :cond_4

    :try_start_0
    const-string v3, "android.telephony.NeighboringCellInfo"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    const-string v4, "getLac"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Class;

    invoke-virtual {v3, v4, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v10

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Landroid/telephony/NeighboringCellInfo;

    move-object v5, v0

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v10, v5, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    iget v4, p0, Lcom/tencent/b/b/m$b;->a:I

    invoke-virtual {v5}, Landroid/telephony/NeighboringCellInfo;->getCid()I

    move-result v6

    invoke-static {v4, v1, v2, v3, v6}, Lcom/tencent/b/b/s;->a(IIIII)Z

    move-result v4

    if-eqz v4, :cond_5

    if-lez v8, :cond_2

    const-string v4, ","

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_2
    invoke-virtual {v5}, Landroid/telephony/NeighboringCellInfo;->getCid()I

    move-result v4

    invoke-virtual {v5}, Landroid/telephony/NeighboringCellInfo;->getRssi()I

    move-result v5

    shl-int/lit8 v5, v5, 0x1

    add-int/lit8 v5, v5, -0x71

    const v6, 0x7fffffff

    const v7, 0x7fffffff

    invoke-static/range {v1 .. v7}, Lcom/tencent/b/b/s;->a(IIIIIII)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v9, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    add-int/lit8 v3, v8, 0x1

    :goto_2
    move v8, v3

    goto :goto_1

    :catch_0
    move-exception v1

    :cond_3
    invoke-interface {p1}, Ljava/util/List;->clear()V

    :cond_4
    const-string v1, "]"

    invoke-virtual {v9, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    :cond_5
    move v3, v8

    goto :goto_2
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\"imei\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\",\"imsi\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\",\"phonenum\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\",\"roaming\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    const-string v1, "\",\"qq\":\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "\""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(IIIII)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    const v3, 0xffff

    const/4 v2, 0x2

    if-ne p0, v2, :cond_2

    if-ltz p1, :cond_0

    if-ltz p2, :cond_0

    if-ltz p3, :cond_0

    if-gt p3, v3, :cond_0

    if-ltz p4, :cond_0

    if-gt p4, v3, :cond_0

    if-nez p2, :cond_1

    if-nez p3, :cond_1

    if-nez p4, :cond_1

    :cond_0
    move v0, v1

    :cond_1
    :goto_0
    return v0

    :cond_2
    if-ltz p1, :cond_3

    if-ltz p2, :cond_3

    if-lez p3, :cond_3

    if-lt p3, v3, :cond_4

    :cond_3
    move v0, v1

    goto :goto_0

    :cond_4
    const v2, 0xfffffff

    if-eq p4, v2, :cond_5

    const v2, 0x7fffffff

    if-eq p4, v2, :cond_5

    const v2, 0x3040101

    if-eq p4, v2, :cond_5

    if-eq p4, v3, :cond_5

    const/16 v2, 0x8

    if-eq p4, v2, :cond_5

    const/16 v2, 0xa

    if-eq p4, v2, :cond_5

    const/16 v2, 0x21

    if-eq p4, v2, :cond_5

    if-gtz p4, :cond_1

    :cond_5
    move v0, v1

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)Z
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x20

    if-gt v1, v2, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x6

    if-ge v1, v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "[a-zA-Z0-9_]{6,32}"

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;)Z
    .locals 3

    const/4 v0, 0x0

    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x1d

    if-eq v1, v2, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const-string v1, "([A-Z2-7]{5}){1}(-[A-Z2-7]{5}){4}"

    invoke-static {v1}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static c(Ljava/lang/String;)Z
    .locals 6

    const/4 v1, 0x1

    const/4 v0, 0x0

    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v3, "latitude"

    invoke-virtual {p0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    move v4, v1

    :goto_0
    const-string v3, "cells"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    invoke-virtual {v3}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lez v3, :cond_3

    move v3, v1

    :goto_1
    const-string v5, "wifis"

    invoke-virtual {v2, v5}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v2

    invoke-virtual {v2}, Lorg/json/JSONArray;->length()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-lez v2, :cond_2

    move v2, v1

    :goto_2
    if-nez v4, :cond_0

    if-nez v3, :cond_0

    if-eqz v2, :cond_1

    :cond_0
    move v0, v1

    :cond_1
    :goto_3
    return v0

    :catch_0
    move-exception v1

    goto :goto_3

    :cond_2
    move v2, v0

    goto :goto_2

    :cond_3
    move v3, v0

    goto :goto_1

    :cond_4
    move v4, v0

    goto :goto_0
.end method
