// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import com.xiaomi.hm.bleservice.util.Helper;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public interface IMiLiProfile
{

    public static final int ALIAS_LEN = 10;
    public static final int NOTIFY_AUTHENTICATION_FAILED = 6;
    public static final int NOTIFY_AUTHENTICATION_SUCCESS = 5;
    public static final int NOTIFY_CONN_PARAM_UPDATE_FAILED = 3;
    public static final int NOTIFY_CONN_PARAM_UPDATE_SUCCESS = 4;
    public static final int NOTIFY_DEVICE_MALFUNCTION = 255;
    public static final int NOTIFY_FIRMWARE_UPDATE_FAILED = 1;
    public static final int NOTIFY_FIRMWARE_UPDATE_SUCCESS = 2;
    public static final int NOTIFY_FITNESS_GOAL_ACHIEVED = 7;
    public static final int NOTIFY_FW_CHECK_FAILED = 11;
    public static final int NOTIFY_FW_CHECK_SUCCESS = 12;
    public static final int NOTIFY_NORMAL = 0;
    public static final int NOTIFY_PAIR_CANCEL = 239;
    public static final int NOTIFY_RESET_AUTHENTICATION_FAILED = 9;
    public static final int NOTIFY_RESET_AUTHENTICATION_SUCCESS = 10;
    public static final int NOTIFY_SET_LATENCY_SUCCESS = 8;
    public static final int NOTIFY_STATUS_MOTOR_ALARM = 17;
    public static final int NOTIFY_STATUS_MOTOR_AUTH = 19;
    public static final int NOTIFY_STATUS_MOTOR_AUTH_SUCCESS = 21;
    public static final int NOTIFY_STATUS_MOTOR_CALL = 14;
    public static final int NOTIFY_STATUS_MOTOR_DISCONNECT = 15;
    public static final int NOTIFY_STATUS_MOTOR_GOAL = 18;
    public static final int NOTIFY_STATUS_MOTOR_NOTIFY = 13;
    public static final int NOTIFY_STATUS_MOTOR_SHUTDOWN = 20;
    public static final int NOTIFY_STATUS_MOTOR_SMART_ALARM = 16;
    public static final int NOTIFY_STATUS_MOTOR_TEST = 22;
    public static final int NOTIFY_UNKNOWN = -1;
    public static final UUID UUID_CHARACTERISTIC_ACTIVITY_DATA = Helper.UUID16("FF07");
    public static final UUID UUID_CHARACTERISTIC_BATTERY = Helper.UUID16("FF0C");
    public static final UUID UUID_CHARACTERISTIC_CONTROL_POINT = Helper.UUID16("FF05");
    public static final UUID UUID_CHARACTERISTIC_DATE_TIME = Helper.UUID16("FF0A");
    public static final UUID UUID_CHARACTERISTIC_DEVICE_INFO = Helper.UUID16("FF01");
    public static final UUID UUID_CHARACTERISTIC_DEVICE_NAME = Helper.UUID16("FF02");
    public static final UUID UUID_CHARACTERISTIC_FIRMWARE_DATA = Helper.UUID16("FF08");
    public static final UUID UUID_CHARACTERISTIC_LE_PARAMS = Helper.UUID16("FF09");
    public static final UUID UUID_CHARACTERISTIC_NOTIFICATION = Helper.UUID16("FF03");
    public static final UUID UUID_CHARACTERISTIC_REALTIME_STEPS = Helper.UUID16("FF06");
    public static final UUID UUID_CHARACTERISTIC_STATISTICS = Helper.UUID16("FF0B");
    public static final UUID UUID_CHARACTERISTIC_TEST = Helper.UUID16("FF0D");
    public static final UUID UUID_CHARACTERISTIC_USER_INFO = Helper.UUID16("FF04");
    public static final UUID UUID_SERVICE_MILI_SERVICE = Helper.UUID16("FEE0");
    public static final UUID UUID_SERVICE_MILI_SERVICE128 = Helper.UUID128("2c7de9fb-f2f1-4a72-9d6d-8922db3f1550");

    public abstract boolean authenticate(UserInfo userinfo);

    public abstract boolean enableRealtimeStepNotification(boolean flag, IRealtimeStepsChangedCB irealtimestepschangedcb);

    public abstract List getActivities();

    public abstract Progress getActivitySyncingProgress();

    public abstract DeviceInfo getDeviceInfo();

    public abstract Progress getFirmwareUpdatingProgress();

    public abstract int getRealtimeSteps();

    public abstract boolean setGoal(byte byte0, int i);

    public abstract boolean setTimer(byte byte0, byte byte1, Calendar calendar, byte byte2, byte byte3);

    public abstract boolean setUserInfo(UserInfo userinfo);

    public abstract boolean updateFirmware(int i, int j, int k, byte abyte0[]);

}
