// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaomi.hm.bleservice.profile;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Pair;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.GattPeripheral;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

// Referenced classes of package com.xiaomi.hm.bleservice.profile:
//            IMiLiProfile

public final class MiLiProfile extends GattPeripheral
    implements IMiLiProfile
{

    private static final String CLASS_NAME = com/xiaomi/hm/bleservice/profile/MiLiProfile.getSimpleName();
    private static final byte COMMAND_CONFIRM_ACTIVITY_DATA_TRANSFER_COMPLETE = 10;
    private static final byte COMMAND_FACTORY_RESET = 9;
    private static final byte COMMAND_FETCH_DATA = 6;
    private static final byte COMMAND_REBOOT = 12;
    private static final byte COMMAND_SEND_FIRMWARE_INFO = 7;
    private static final byte COMMAND_SEND_NOTIFICATION = 8;
    private static final byte COMMAND_SET_FITNESS_GOAL = 5;
    private static final byte COMMAND_SET_REALTIME_STEP = 16;
    private static final byte COMMAND_SET_REALTIME_STEPS_NOTIFICATION = 3;
    private static final byte COMMAND_SET_TIMER = 4;
    private static final byte COMMAND_STOP_SYNC_DATA = 17;
    private static final byte COMMAND_SYNC = 11;
    public static final byte CONNECTION_LATENCY_LEVEL_HIGH = 2;
    public static final byte CONNECTION_LATENCY_LEVEL_LOW = 0;
    public static final byte CONNECTION_LATENCY_LEVEL_MEDIUM = 1;
    public static final String INTENT_ACTION_AUTHENTICATION_FAILED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_AUTHENTICATION_FAILED").toString();
    public static final String INTENT_ACTION_AUTHENTICATION_SUCCESS = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_AUTHENTICATION_SUCCESS").toString();
    public static final String INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED").toString();
    public static final String INTENT_ACTION_DEVICE_STATUS_CHANGED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_DEVICE_STATUS_CHANGED").toString();
    public static final String INTENT_ACTION_INITIALIZATION_FAILED = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_INITIALIZATION_FAILED").toString();
    public static final String INTENT_ACTION_INITIALIZATION_SUCCESS = (new StringBuilder()).append(INTENT_PREFIX).append(".INTENT_ACTION_INITIALIZATION_SUCCESS").toString();
    private static final String INTENT_PREFIX = (new StringBuilder()).append(PACKAGE_NAME).append(".").append(CLASS_NAME).toString();
    public static final byte MODE_REGULAR_DATA_LEN_BYTE = 0;
    public static final byte MODE_REGULAR_DATA_LEN_MINITE = 1;
    private static final String PACKAGE_NAME = com/xiaomi/hm/bleservice/profile/MiLiProfile.getPackage().getName();
    public static final int PROFILE_STATE_AUTHENTICATION_FAILED = 4;
    public static final int PROFILE_STATE_AUTHENTICATION_SUCCESS = 3;
    public static final int PROFILE_STATE_INITIALIZATION_FAILED = 2;
    public static final int PROFILE_STATE_INITIALIZATION_SUCCESS = 1;
    public static final int PROFILE_STATE_UNKNOWN = 0;
    private static final byte TEST_NOTIFICATION = 3;
    private static final byte TEST_REMOTE_DISCONNECT = 1;
    private static final byte TEST_SELFTEST = 2;
    public static final String VERSION = "2.0.0.20140514";
    private final IMiLiProfile.Progress m_ActivitySyncingProgress = new IMiLiProfile.Progress();
    private IMiLiProfile.BatteryInfo m_CacheBatteryInfo;
    private BluetoothGattCharacteristic m_CharActivityData;
    private BluetoothGattCharacteristic m_CharBattery;
    private BluetoothGattCharacteristic m_CharControlPoint;
    private BluetoothGattCharacteristic m_CharDateTime;
    private BluetoothGattCharacteristic m_CharDeviceInfo;
    private BluetoothGattCharacteristic m_CharDeviceName;
    private BluetoothGattCharacteristic m_CharFirmwareData;
    private BluetoothGattCharacteristic m_CharLEParams;
    private BluetoothGattCharacteristic m_CharNotification;
    private BluetoothGattCharacteristic m_CharRealtimeSteps;
    private BluetoothGattCharacteristic m_CharStatistics;
    private BluetoothGattCharacteristic m_CharTest;
    private BluetoothGattCharacteristic m_CharUserInfo;
    private PipedInputStream m_DataSourceInputStream;
    private PipedOutputStream m_DataSourceOutputStream;
    private IMiLiProfile.DeviceInfo m_DeviceInfo;
    private final IMiLiProfile.Progress m_FirmwareUpdatingProgress = new IMiLiProfile.Progress();
    private int m_ProfileState;
    private boolean m_enableRealtimeStepNotification;
    private IMiLiProfile.IRealtimeStepsChangedCB m_onRealtimeStepsChangedCB;
    private int modeRegularDataType;

    public MiLiProfile(Context context, BluetoothDevice bluetoothdevice, Handler handler)
    {
        super(context, bluetoothdevice, handler);
        m_CharDeviceInfo = null;
        m_CharDeviceName = null;
        m_CharNotification = null;
        m_CharUserInfo = null;
        m_CharControlPoint = null;
        m_CharRealtimeSteps = null;
        m_CharActivityData = null;
        m_CharFirmwareData = null;
        m_CharLEParams = null;
        m_CharDateTime = null;
        m_CharStatistics = null;
        m_CharBattery = null;
        m_CharTest = null;
        m_DataSourceInputStream = null;
        m_DataSourceOutputStream = null;
        m_ProfileState = 0;
        m_DeviceInfo = null;
        modeRegularDataType = 0;
        m_CacheBatteryInfo = null;
        m_enableRealtimeStepNotification = false;
        m_onRealtimeStepsChangedCB = null;
        Debug.TRACE();
    }

    private static void _______________API_______________()
    {
    }

    private static void _______________TEST_______________()
    {
    }

    private boolean confirmActivityDataTransferComplete(Calendar calendar, int i)
    {
        Debug.TRACE();
        byte byte0 = (byte)(-2000 + calendar.get(1));
        byte byte1 = (byte)calendar.get(2);
        byte byte2 = (byte)calendar.get(5);
        byte byte3 = (byte)calendar.get(11);
        byte byte4 = (byte)calendar.get(12);
        byte byte5 = (byte)calendar.get(13);
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharControlPoint;
        byte abyte0[] = new byte[9];
        abyte0[0] = 10;
        abyte0[1] = byte0;
        abyte0[2] = byte1;
        abyte0[3] = byte2;
        abyte0[4] = byte3;
        abyte0[5] = byte4;
        abyte0[6] = byte5;
        abyte0[7] = (byte)(i & 0xff);
        abyte0[8] = (byte)(0xff & i >> 8);
        return write(bluetoothgattcharacteristic, abyte0);
    }

    private boolean initCharacteristics()
    {
        BluetoothGattService bluetoothgattservice;
        Debug.TRACE();
        bluetoothgattservice = getService(UUID_SERVICE_MILI_SERVICE);
        if (bluetoothgattservice == null)
        {
            bluetoothgattservice = getService(UUID_SERVICE_MILI_SERVICE128);
        }
        Debug.ASSERT_NOT_NULL(bluetoothgattservice);
        if (bluetoothgattservice != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_TEST) != null)
        {
            break; /* Loop/switch isn't completed */
        }
        Debug.WARN("LIMITED COMPATIBLE MODE, PRE 2.0 PROFILE VERSION.");
        m_CharDeviceInfo = bluetoothgattservice.getCharacteristic(Helper.UUID16("FF01"));
        Debug.ASSERT_NOT_NULL(m_CharDeviceInfo);
        if (m_CharDeviceInfo != null)
        {
            m_CharControlPoint = bluetoothgattservice.getCharacteristic(Helper.UUID16("FF03"));
            Debug.ASSERT_NOT_NULL(m_CharControlPoint);
            if (m_CharControlPoint != null)
            {
                m_CharFirmwareData = bluetoothgattservice.getCharacteristic(Helper.UUID16("FF05"));
                Debug.ASSERT_NOT_NULL(m_CharFirmwareData);
                if (m_CharFirmwareData != null)
                {
                    m_CharUserInfo = bluetoothgattservice.getCharacteristic(Helper.UUID16("FF07"));
                    Debug.ASSERT_NOT_NULL(m_CharUserInfo);
                    if (m_CharUserInfo != null)
                    {
                        boolean flag24 = registerNotification(m_CharDeviceInfo, new _cls1());
                        Debug.ASSERT_TRUE(flag24);
                        if (flag24)
                        {
                            return true;
                        }
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        m_CharDeviceInfo = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_DEVICE_INFO);
        Debug.ASSERT_NOT_NULL(m_CharDeviceInfo);
        if (m_CharDeviceInfo != null)
        {
            boolean flag;
            if ((2 & m_CharDeviceInfo.getProperties()) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Debug.ASSERT_TRUE(flag);
            m_CharDeviceName = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_DEVICE_NAME);
            Debug.ASSERT_NOT_NULL(m_CharDeviceName);
            if (m_CharDeviceName != null)
            {
                boolean flag1;
                boolean flag2;
                if ((2 & m_CharDeviceName.getProperties()) > 0)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                Debug.ASSERT_TRUE(flag1);
                if ((8 & m_CharDeviceName.getProperties()) > 0)
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                Debug.ASSERT_TRUE(flag2);
                m_CharNotification = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_NOTIFICATION);
                Debug.ASSERT_NOT_NULL(m_CharNotification);
                if (m_CharNotification != null)
                {
                    boolean flag3;
                    if ((0x10 & m_CharNotification.getProperties()) > 0)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    Debug.ASSERT_TRUE(flag3);
                    m_CharUserInfo = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_USER_INFO);
                    Debug.ASSERT_NOT_NULL(m_CharUserInfo);
                    if (m_CharUserInfo != null)
                    {
                        boolean flag4;
                        boolean flag5;
                        if ((2 & m_CharUserInfo.getProperties()) > 0)
                        {
                            flag4 = true;
                        } else
                        {
                            flag4 = false;
                        }
                        Debug.ASSERT_TRUE(flag4);
                        if ((8 & m_CharUserInfo.getProperties()) > 0)
                        {
                            flag5 = true;
                        } else
                        {
                            flag5 = false;
                        }
                        Debug.ASSERT_TRUE(flag5);
                        m_CharControlPoint = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_CONTROL_POINT);
                        Debug.ASSERT_NOT_NULL(m_CharControlPoint);
                        if (m_CharControlPoint != null)
                        {
                            boolean flag6;
                            if ((8 & m_CharControlPoint.getProperties()) > 0)
                            {
                                flag6 = true;
                            } else
                            {
                                flag6 = false;
                            }
                            Debug.ASSERT_TRUE(flag6);
                            m_CharRealtimeSteps = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_REALTIME_STEPS);
                            Debug.ASSERT_NOT_NULL(m_CharRealtimeSteps);
                            if (m_CharRealtimeSteps != null)
                            {
                                boolean flag7;
                                boolean flag8;
                                if ((2 & m_CharRealtimeSteps.getProperties()) > 0)
                                {
                                    flag7 = true;
                                } else
                                {
                                    flag7 = false;
                                }
                                Debug.ASSERT_TRUE(flag7);
                                if ((0x10 & m_CharRealtimeSteps.getProperties()) > 0)
                                {
                                    flag8 = true;
                                } else
                                {
                                    flag8 = false;
                                }
                                Debug.ASSERT_TRUE(flag8);
                                m_CharActivityData = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_ACTIVITY_DATA);
                                Debug.ASSERT_NOT_NULL(m_CharActivityData);
                                if (m_CharActivityData != null)
                                {
                                    boolean flag9;
                                    if ((0x20 & m_CharActivityData.getProperties()) > 0)
                                    {
                                        flag9 = true;
                                    } else
                                    {
                                        flag9 = false;
                                    }
                                    Debug.ASSERT_TRUE(flag9);
                                    m_CharFirmwareData = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_FIRMWARE_DATA);
                                    Debug.ASSERT_NOT_NULL(m_CharFirmwareData);
                                    if (m_CharFirmwareData != null)
                                    {
                                        boolean flag10;
                                        if ((4 & m_CharFirmwareData.getProperties()) > 0)
                                        {
                                            flag10 = true;
                                        } else
                                        {
                                            flag10 = false;
                                        }
                                        Debug.ASSERT_TRUE(flag10);
                                        m_CharLEParams = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_LE_PARAMS);
                                        Debug.ASSERT_NOT_NULL(m_CharLEParams);
                                        if (m_CharLEParams != null)
                                        {
                                            boolean flag11;
                                            boolean flag12;
                                            if ((2 & m_CharLEParams.getProperties()) > 0)
                                            {
                                                flag11 = true;
                                            } else
                                            {
                                                flag11 = false;
                                            }
                                            Debug.ASSERT_TRUE(flag11);
                                            if ((8 & m_CharLEParams.getProperties()) > 0)
                                            {
                                                flag12 = true;
                                            } else
                                            {
                                                flag12 = false;
                                            }
                                            Debug.ASSERT_TRUE(flag12);
                                            m_CharDateTime = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_DATE_TIME);
                                            Debug.ASSERT_NOT_NULL(m_CharDateTime);
                                            if (m_CharDateTime != null)
                                            {
                                                boolean flag13;
                                                boolean flag14;
                                                if ((2 & m_CharDateTime.getProperties()) > 0)
                                                {
                                                    flag13 = true;
                                                } else
                                                {
                                                    flag13 = false;
                                                }
                                                Debug.ASSERT_TRUE(flag13);
                                                if ((8 & m_CharDateTime.getProperties()) > 0)
                                                {
                                                    flag14 = true;
                                                } else
                                                {
                                                    flag14 = false;
                                                }
                                                Debug.ASSERT_TRUE(flag14);
                                                m_CharStatistics = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_STATISTICS);
                                                Debug.ASSERT_NOT_NULL(m_CharStatistics);
                                                if (m_CharStatistics != null)
                                                {
                                                    boolean flag15;
                                                    boolean flag16;
                                                    if ((2 & m_CharStatistics.getProperties()) > 0)
                                                    {
                                                        flag15 = true;
                                                    } else
                                                    {
                                                        flag15 = false;
                                                    }
                                                    Debug.ASSERT_TRUE(flag15);
                                                    if ((8 & m_CharStatistics.getProperties()) > 0)
                                                    {
                                                        flag16 = true;
                                                    } else
                                                    {
                                                        flag16 = false;
                                                    }
                                                    Debug.ASSERT_TRUE(flag16);
                                                    m_CharBattery = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_BATTERY);
                                                    Debug.ASSERT_NOT_NULL(m_CharBattery);
                                                    if (m_CharBattery != null)
                                                    {
                                                        boolean flag17;
                                                        boolean flag18;
                                                        if ((2 & m_CharBattery.getProperties()) > 0)
                                                        {
                                                            flag17 = true;
                                                        } else
                                                        {
                                                            flag17 = false;
                                                        }
                                                        Debug.ASSERT_TRUE(flag17);
                                                        if ((0x10 & m_CharBattery.getProperties()) > 0)
                                                        {
                                                            flag18 = true;
                                                        } else
                                                        {
                                                            flag18 = false;
                                                        }
                                                        Debug.ASSERT_TRUE(flag18);
                                                        m_CharTest = bluetoothgattservice.getCharacteristic(UUID_CHARACTERISTIC_TEST);
                                                        Debug.ASSERT_NOT_NULL(m_CharTest);
                                                        if (m_CharTest != null)
                                                        {
                                                            boolean flag19;
                                                            boolean flag20;
                                                            if ((8 & m_CharTest.getProperties()) > 0)
                                                            {
                                                                flag19 = true;
                                                            } else
                                                            {
                                                                flag19 = false;
                                                            }
                                                            Debug.ASSERT_TRUE(flag19);
                                                            flag20 = registerNotification(m_CharNotification, new _cls2());
                                                            Debug.ASSERT_TRUE(flag20);
                                                            if (flag20)
                                                            {
                                                                boolean flag21 = registerNotification(m_CharRealtimeSteps, new _cls3());
                                                                Debug.ASSERT_TRUE(flag21);
                                                                if (flag21)
                                                                {
                                                                    boolean flag22 = registerNotification(m_CharActivityData, new _cls4());
                                                                    Debug.ASSERT_TRUE(flag22);
                                                                    if (flag22)
                                                                    {
                                                                        boolean flag23 = registerNotification(m_CharBattery, new _cls5());
                                                                        Debug.ASSERT_TRUE(flag23);
                                                                        if (flag23)
                                                                        {
                                                                            return true;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void onRealtimeStepsChanged(int i)
    {
        Debug.TRACE();
        if (!m_enableRealtimeStepNotification || m_onRealtimeStepsChangedCB == null)
        {
            return;
        } else
        {
            m_onRealtimeStepsChangedCB.process(i);
            return;
        }
    }

    private IMiLiProfile.ActivityDataFragment parseActivityData()
    {
        Debug.TRACE();
        GregorianCalendar gregoriancalendar = new GregorianCalendar(2000 + m_DataSourceInputStream.read(), m_DataSourceInputStream.read(), m_DataSourceInputStream.read(), m_DataSourceInputStream.read(), m_DataSourceInputStream.read(), m_DataSourceInputStream.read());
        Debug.DEBUG((new StringBuilder()).append("timestamp: ").append(DateFormat.getDateTimeInstance().format(gregoriancalendar.getTime())).toString());
        int i = m_DataSourceInputStream.read();
        int j = m_DataSourceInputStream.read();
        int k = i & 0xff | (j & 0xff) << 8;
        if (modeRegularDataType == 1)
        {
            k *= 3;
        }
        Debug.DEBUG((new StringBuilder()).append("totalLen: ").append(k / 3).append(" minute(s)").toString());
        m_ActivitySyncingProgress.total = k;
        int l = m_DataSourceInputStream.read();
        int i1 = m_DataSourceInputStream.read();
        int j1 = l & 0xff | (i1 & 0xff) << 8;
        int k1;
        ArrayList arraylist;
        if (modeRegularDataType == 1)
        {
            k1 = j1 * 3;
        } else
        {
            k1 = j1;
        }
        Debug.DEBUG((new StringBuilder()).append("len: ").append(k1 / 3).append(" minute(s)").toString());
        arraylist = new ArrayList(k1 / 3);
        while (k1 > 0) 
        {
            byte byte0 = (byte)m_DataSourceInputStream.read();
            arraylist.add(new IMiLiProfile.ActivityData((byte)m_DataSourceInputStream.read(), (byte)m_DataSourceInputStream.read(), byte0));
            k1 -= 3;
            IMiLiProfile.Progress progress = m_ActivitySyncingProgress;
            progress.progress = 3 + progress.progress;
        }
        if (!confirmActivityDataTransferComplete(gregoriancalendar, j1))
        {
            return null;
        } else
        {
            return new IMiLiProfile.ActivityDataFragment(gregoriancalendar, arraylist);
        }
    }

    public boolean _factoryReset()
    {
        Debug.TRACE();
        return write(m_CharControlPoint, new byte[] {
            9
        });
    }

    public IMiLiProfile.BatteryInfo _getBatteryInfo()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharBattery);
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        boolean flag;
        byte byte0;
        GregorianCalendar gregoriancalendar;
        if (abyte0.length == 10)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        byte0 = abyte0[0];
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.set(1, 2000 + abyte0[1]);
        gregoriancalendar.set(2, abyte0[2]);
        gregoriancalendar.set(5, abyte0[3]);
        gregoriancalendar.set(11, abyte0[4]);
        gregoriancalendar.set(12, abyte0[5]);
        gregoriancalendar.set(13, abyte0[6]);
        m_CacheBatteryInfo = new IMiLiProfile.BatteryInfo(byte0, gregoriancalendar, 0xffff & (0xff & abyte0[7] | (0xff & abyte0[8]) << 8), abyte0[9]);
        return m_CacheBatteryInfo;
    }

    public Pair _getDateTime()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharDateTime);
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        boolean flag;
        GregorianCalendar gregoriancalendar;
        GregorianCalendar gregoriancalendar1;
        if (abyte0.length == 12)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        gregoriancalendar = new GregorianCalendar();
        gregoriancalendar1 = new GregorianCalendar();
        gregoriancalendar.set(1, 2000 + abyte0[0]);
        gregoriancalendar.set(2, abyte0[1]);
        gregoriancalendar.set(5, abyte0[2]);
        gregoriancalendar.set(11, abyte0[3]);
        gregoriancalendar.set(12, abyte0[4]);
        gregoriancalendar.set(13, abyte0[5]);
        gregoriancalendar1.set(1, 2000 + abyte0[6]);
        gregoriancalendar1.set(2, abyte0[7]);
        gregoriancalendar1.set(5, abyte0[8]);
        gregoriancalendar1.set(11, abyte0[9]);
        gregoriancalendar1.set(12, abyte0[10]);
        gregoriancalendar1.set(13, abyte0[11]);
        return new Pair(gregoriancalendar, gregoriancalendar1);
    }

    public String _getDeviceName()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharDeviceName);
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return new String(abyte0);
        }
    }

    public IMiLiProfile.LEParams _getLEParams()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharLEParams);
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        boolean flag;
        if (abyte0.length == 12)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        return new IMiLiProfile.LEParams(0xffff & (0xff & abyte0[0] | (0xff & abyte0[1]) << 8), 0xffff & (0xff & abyte0[2] | (0xff & abyte0[3]) << 8), 0xffff & (0xff & abyte0[4] | (0xff & abyte0[5]) << 8), 0xffff & (0xff & abyte0[6] | (0xff & abyte0[7]) << 8), 0xffff & (0xff & abyte0[8] | (0xff & abyte0[9]) << 8), 0xffff & (0xff & abyte0[10] | (0xff & abyte0[11]) << 8));
    }

    public IMiLiProfile.Usage _getUsage()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharStatistics);
        if (abyte0 == null)
        {
            return null;
        }
        boolean flag;
        if (abyte0.length == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        return new IMiLiProfile.Usage((int)((double)Helper.bytesToInt(abyte0, 0) / 1.6000000000000001D), Helper.bytesToInt(abyte0, 4), Helper.bytesToInt(abyte0, 8), Helper.bytesToInt(abyte0, 12), Helper.bytesToInt(abyte0, 16));
    }

    public IMiLiProfile.UserInfo _getUserInfo()
    {
        int i = 0;
        Debug.TRACE();
        byte abyte0[] = read(m_CharUserInfo);
        Debug.ASSERT_NOT_NULL(abyte0);
        if (abyte0 == null || abyte0.length == 0)
        {
            return null;
        }
        boolean flag;
        byte abyte1[];
        if (abyte0.length == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        abyte1 = new byte[19];
        for (int j = 0; j < 19; j++)
        {
            abyte1[j] = abyte0[j];
        }

        int k = Helper.CRC8(abyte1);
        String s = getDevice().getAddress();
        int l = Integer.decode((new StringBuilder()).append("0x").append(s.substring(-2 + s.length())).toString()).intValue();
        if (abyte0[19] != (byte)(k ^ l))
        {
            return null;
        }
        int i1 = Helper.bytesToInt(abyte0, 0);
        byte byte0 = abyte0[4];
        byte byte1 = abyte0[5];
        byte byte2 = abyte0[6];
        byte byte3 = abyte0[7];
        byte abyte2[];
        for (abyte2 = new byte[11]; i < abyte2.length; i++)
        {
            abyte2[i] = abyte0[i + 8];
        }

        return new IMiLiProfile.UserInfo(i1, byte0, byte1, byte2, byte3, abyte2);
    }

    public boolean _notify(byte byte0)
    {
        Debug.TRACE();
        return write(m_CharTest, new byte[] {
            3, byte0
        });
    }

    public boolean _reboot()
    {
        Debug.TRACE();
        return write(m_CharControlPoint, new byte[] {
            12
        });
    }

    public boolean _remoteDisconnect()
    {
        Debug.TRACE();
        return write(m_CharTest, new byte[] {
            1
        });
    }

    public boolean _resetBatteryInfo()
    {
        Debug.TRACE();
        return true;
    }

    public boolean _resetUsage()
    {
        Debug.TRACE();
        return true;
    }

    public boolean _selfTest()
    {
        Debug.TRACE();
        return write(m_CharTest, new byte[] {
            2
        });
    }

    public boolean _sendNotification(byte byte0)
    {
        Debug.TRACE();
        return write(m_CharControlPoint, new byte[] {
            8, byte0
        });
    }

    public boolean _setDateTime(Calendar calendar)
    {
        Debug.TRACE();
        byte byte0 = (byte)(-2000 + calendar.get(1));
        byte byte1 = (byte)calendar.get(2);
        byte byte2 = (byte)calendar.get(5);
        byte byte3 = (byte)calendar.get(11);
        byte byte4 = (byte)calendar.get(12);
        byte byte5 = (byte)calendar.get(13);
        return write(m_CharDateTime, new byte[] {
            byte0, byte1, byte2, byte3, byte4, byte5, -1, -1, -1, -1, 
            -1, -1
        });
    }

    public boolean _setDeviceName(String s)
    {
        Debug.TRACE();
        return write(m_CharDeviceName, s.getBytes());
    }

    public boolean _setLEParams(int i, int j, int k, int l, int i1)
    {
        Debug.TRACE();
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharLEParams;
        byte abyte0[] = new byte[12];
        abyte0[0] = (byte)(i & 0xff);
        abyte0[1] = (byte)(0xff & i >> 8);
        abyte0[2] = (byte)(j & 0xff);
        abyte0[3] = (byte)(0xff & j >> 8);
        abyte0[4] = (byte)(k & 0xff);
        abyte0[5] = (byte)(0xff & k >> 8);
        abyte0[6] = (byte)(l & 0xff);
        abyte0[7] = (byte)(0xff & l >> 8);
        abyte0[8] = 0;
        abyte0[9] = 0;
        abyte0[10] = (byte)(i1 & 0xff);
        abyte0[11] = (byte)(0xff & i1 >> 8);
        return write(bluetoothgattcharacteristic, abyte0);
    }

    public boolean _sync()
    {
        Debug.TRACE();
        return write(m_CharControlPoint, new byte[] {
            11
        });
    }

    public boolean _wirteMD5(byte abyte0[])
    {
        int i = 0;
        boolean flag;
        byte abyte1[];
        if (abyte0.length == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        abyte1 = new byte[17];
        abyte1[0] = 4;
        for (; i < 16; i++)
        {
            abyte1[i + 1] = abyte0[i];
        }

        return write(m_CharTest, abyte1);
    }

    public boolean authenticate(IMiLiProfile.UserInfo userinfo)
    {
        Debug.TRACE();
        boolean flag = setUserInfo(userinfo);
        Debug.ASSERT_TRUE(flag);
        if (flag)
        {
            boolean flag1 = _setDateTime(Calendar.getInstance());
            Debug.ASSERT_TRUE(flag1);
            if (flag1)
            {
                return true;
            }
        }
        return false;
    }

    public void cleanup()
    {
        Debug.TRACE();
        if (m_CharNotification != null)
        {
            unregisterNotification(m_CharNotification);
        }
        if (m_CharRealtimeSteps != null)
        {
            unregisterNotification(m_CharRealtimeSteps);
        }
        if (m_CharActivityData != null)
        {
            unregisterNotification(m_CharActivityData);
        }
        if (m_CharBattery != null)
        {
            unregisterNotification(m_CharBattery);
        }
        try
        {
            if (m_DataSourceInputStream != null && m_DataSourceOutputStream != null)
            {
                m_DataSourceInputStream.close();
                m_DataSourceOutputStream.close();
            }
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        m_ProfileState = 0;
        m_DeviceInfo = null;
    }

    public boolean enableRealtimeStepNotification(boolean flag, IMiLiProfile.IRealtimeStepsChangedCB irealtimestepschangedcb)
    {
        Debug.TRACE();
        m_enableRealtimeStepNotification = flag;
        m_onRealtimeStepsChangedCB = irealtimestepschangedcb;
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharControlPoint;
        byte abyte0[] = new byte[2];
        abyte0[0] = 3;
        int i = 0;
        if (flag)
        {
            i = 1;
        }
        abyte0[1] = (byte)i;
        return write(bluetoothgattcharacteristic, abyte0);
    }

    public List getActivities()
    {
        ArrayList arraylist;
        Debug.TRACE();
        arraylist = new ArrayList();
        boolean flag;
        try
        {
            if (m_DataSourceInputStream != null)
            {
                m_DataSourceInputStream.close();
            }
            if (m_DataSourceOutputStream != null)
            {
                m_DataSourceOutputStream.close();
            }
            m_DataSourceInputStream = new PipedInputStream();
            m_DataSourceOutputStream = new PipedOutputStream();
            m_DataSourceInputStream.connect(m_DataSourceOutputStream);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        flag = write(m_CharControlPoint, new byte[] {
            6
        });
        Debug.ASSERT_TRUE(flag);
        if (!flag)
        {
            return null;
        }
        m_ActivitySyncingProgress.total = -1;
        m_ActivitySyncingProgress.progress = 0;
_L2:
        int i;
        i = (byte)m_DataSourceInputStream.read();
        modeRegularDataType = i;
        if (i == 0 || i == 1)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("dataType: ");
        Object aobj[] = new Object[1];
        aobj[0] = Byte.valueOf(i);
        Debug.WARN(stringbuilder.append(String.format("%02x", aobj)).toString());
        break MISSING_BLOCK_LABEL_199;
        IMiLiProfile.ActivityDataFragment activitydatafragment = parseActivityData();
        arraylist.add(activitydatafragment);
        j = activitydatafragment.data.size();
        if (j != 0) goto _L2; else goto _L1
        if (i != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        int j;
        try
        {
            Debug.WARN("Unexpected 'EOF' detected...");
            break; /* Loop/switch isn't completed */
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
_L1:
        return arraylist;
    }

    public IMiLiProfile.Progress getActivitySyncingProgress()
    {
        Debug.TRACE();
        return m_ActivitySyncingProgress;
    }

    public IMiLiProfile.BatteryInfo getCachedBatteryInfo()
    {
        return m_CacheBatteryInfo;
    }

    public IMiLiProfile.DeviceInfo getCachedDeviceInfo()
    {
        Debug.TRACE();
        return m_DeviceInfo;
    }

    public IMiLiProfile.DeviceInfo getDeviceInfo()
    {
        Debug.TRACE();
        if (m_DeviceInfo != null)
        {
            return m_DeviceInfo;
        }
        byte abyte0[] = read(m_CharDeviceInfo);
        Debug.ASSERT_NOT_NULL(abyte0);
        if (abyte0 == null)
        {
            return null;
        }
        boolean flag;
        byte abyte1[];
        int i;
        boolean flag1;
        if (abyte0.length == 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        abyte1 = new byte[7];
        abyte1[0] = abyte0[0];
        abyte1[1] = abyte0[1];
        abyte1[2] = abyte0[2];
        abyte1[3] = abyte0[3];
        abyte1[4] = abyte0[4];
        abyte1[5] = abyte0[5];
        abyte1[6] = abyte0[6];
        i = Helper.CRC8(abyte1) ^ 0xff & abyte0[3];
        if (i == (0xff & abyte0[7]))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Debug.ASSERT_TRUE(flag1);
        if (i != (0xff & abyte0[7]))
        {
            Debug.WARN("DeviceInfo CRC verification failed");
            return null;
        } else
        {
            Object aobj[] = new Object[8];
            aobj[0] = Byte.valueOf(abyte0[0]);
            aobj[1] = Byte.valueOf(abyte0[1]);
            aobj[2] = Byte.valueOf(abyte0[2]);
            aobj[3] = Byte.valueOf(abyte0[3]);
            aobj[4] = Byte.valueOf(abyte0[4]);
            aobj[5] = Byte.valueOf(abyte0[5]);
            aobj[6] = Byte.valueOf(abyte0[6]);
            aobj[7] = Byte.valueOf(abyte0[7]);
            m_DeviceInfo = new IMiLiProfile.DeviceInfo(String.format("%02X%02X%02X%02X%02X%02X%02X%02X", aobj), Helper.bytesToInt(abyte0, 8), Helper.bytesToInt(abyte0, 12));
            return m_DeviceInfo;
        }
    }

    public IMiLiProfile.Progress getFirmwareUpdatingProgress()
    {
        Debug.TRACE();
        return m_FirmwareUpdatingProgress;
    }

    public int getProfileState()
    {
        return m_ProfileState;
    }

    public int getRealtimeSteps()
    {
        Debug.TRACE();
        byte abyte0[] = read(m_CharRealtimeSteps);
        Debug.ASSERT_NOT_NULL(abyte0);
        if (abyte0 == null || abyte0.length == 0)
        {
            return -1;
        }
        boolean flag;
        if (abyte0.length == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        return 0xff & abyte0[0] | (0xff & abyte0[1]) << 8;
    }

    public boolean init()
    {
        Debug.TRACE();
        m_DataSourceInputStream = new PipedInputStream();
        m_DataSourceOutputStream = new PipedOutputStream();
        boolean flag;
        try
        {
            m_DataSourceOutputStream.connect(m_DataSourceInputStream);
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        flag = initCharacteristics();
        Debug.ASSERT_TRUE(flag);
        if (flag);
        if (flag)
        {
            Debug.INFO("=================================================");
            Debug.INFO("============= INITIALIZATION SUCCESS ============");
            Debug.INFO("=================================================");
            m_ProfileState = 1;
            Intent intent1 = new Intent(INTENT_ACTION_INITIALIZATION_SUCCESS);
            intent1.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
            BLEService.getBroadcastManager().sendBroadcast(intent1);
            return true;
        } else
        {
            Debug.ERROR("=================================================");
            Debug.ERROR("============= INITIALIZATION FAILED =============");
            Debug.ERROR("=================================================");
            m_ProfileState = 2;
            Intent intent = new Intent(INTENT_ACTION_INITIALIZATION_FAILED);
            intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
            BLEService.getBroadcastManager().sendBroadcast(intent);
            return false;
        }
    }

    public void resetActivitySyncingProgress()
    {
        m_ActivitySyncingProgress.total = -1;
        m_ActivitySyncingProgress.progress = 0;
    }

    public void resetFirmwareUpdatingProgress()
    {
        m_FirmwareUpdatingProgress.total = -1;
        m_FirmwareUpdatingProgress.progress = 0;
    }

    public boolean sendFirmwareData(byte abyte0[])
    {
        int i;
        int j;
        int k;
        int l;
        Debug.TRACE();
        i = abyte0.length;
        j = i / 20;
        Debug.DEBUG((new StringBuilder()).append("totalPackets = ").append(j).toString());
        m_FirmwareUpdatingProgress.total = i;
        m_FirmwareUpdatingProgress.progress = 0;
        k = 0;
        l = 0;
_L5:
        if (k >= j) goto _L2; else goto _L1
_L1:
        boolean flag1;
        byte abyte2[] = new byte[20];
        for (int k1 = 0; k1 < 20; k1++)
        {
            abyte2[k1] = abyte0[k1 + k * 20];
        }

        flag1 = write(m_CharFirmwareData, abyte2);
        Debug.ASSERT_TRUE(flag1);
        if (flag1) goto _L4; else goto _L3
_L3:
        return false;
_L4:
        IMiLiProfile.Progress progress1 = m_FirmwareUpdatingProgress;
        progress1.progress = 20 + progress1.progress;
        int l1 = l + 20;
        Debug.DEBUG((new StringBuilder()).append("transferedPackets = ").append(l1).toString());
        if (l1 >= 1000)
        {
            _sync();
            l1 = 0;
        }
        k++;
        l = l1;
          goto _L5
_L2:
        if (i % 20 == 0)
        {
            _sync();
            Debug.DEBUG("transferFirmwareData: complete");
            return true;
        }
        byte abyte1[] = new byte[i % 20];
        for (int i1 = 0; i1 < i % 20; i1++)
        {
            abyte1[i1] = abyte0[i1 + j * 20];
        }

        boolean flag = write(m_CharFirmwareData, abyte1);
        Debug.ASSERT_TRUE(flag);
        if (flag)
        {
            IMiLiProfile.Progress progress = m_FirmwareUpdatingProgress;
            progress.progress = progress.progress + i % 20;
            int j1 = l + i % 20;
            Debug.DEBUG((new StringBuilder()).append("transferedPackets = ").append(j1).toString());
            _sync();
            Debug.DEBUG("transferFirmwareData: complete");
            return true;
        }
          goto _L3
    }

    public boolean sendFirmwareInfo(int i, int j, int k, int l)
    {
        Debug.TRACE();
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharControlPoint;
        byte abyte0[] = new byte[13];
        abyte0[0] = 7;
        abyte0[1] = (byte)i;
        abyte0[2] = (byte)(i >> 8);
        abyte0[3] = (byte)(i >> 16);
        abyte0[4] = (byte)(i >> 24);
        abyte0[5] = (byte)j;
        abyte0[6] = (byte)(j >> 8);
        abyte0[7] = (byte)(j >> 16);
        abyte0[8] = (byte)(j >> 24);
        abyte0[9] = (byte)k;
        abyte0[10] = (byte)(k >> 8);
        abyte0[11] = (byte)l;
        abyte0[12] = (byte)(l >> 8);
        return write(bluetoothgattcharacteristic, abyte0);
    }

    public boolean setColorTheme(byte byte0, byte byte1, byte byte2, byte byte3)
    {
        return write(m_CharControlPoint, new byte[] {
            14, byte0, byte1, byte2, byte3
        });
    }

    public boolean setGoal(byte byte0, int i)
    {
        Debug.TRACE();
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharControlPoint;
        byte abyte0[] = new byte[4];
        abyte0[0] = 5;
        abyte0[1] = byte0;
        abyte0[2] = (byte)(i & 0xff);
        abyte0[3] = (byte)(0xff & i >> 8);
        return write(bluetoothgattcharacteristic, abyte0);
    }

    public boolean setRealtimeSteps(int i)
    {
        Debug.TRACE();
        BluetoothGattCharacteristic bluetoothgattcharacteristic = m_CharControlPoint;
        byte abyte0[] = new byte[3];
        abyte0[0] = 16;
        abyte0[1] = (byte)(i & 0xff);
        abyte0[2] = (byte)(0xff & i >> 8);
        return write(bluetoothgattcharacteristic, abyte0);
    }

    public boolean setTimer(byte byte0, byte byte1, Calendar calendar, byte byte2, byte byte3)
    {
        Debug.TRACE();
        byte byte4 = (byte)(-2000 + calendar.get(1));
        byte byte5 = (byte)calendar.get(2);
        byte byte6 = (byte)calendar.get(5);
        byte byte7 = (byte)calendar.get(11);
        byte byte8 = (byte)calendar.get(12);
        byte byte9 = (byte)calendar.get(13);
        return write(m_CharControlPoint, new byte[] {
            4, byte0, byte1, byte4, byte5, byte6, byte7, byte8, byte9, byte2, 
            byte3
        });
    }

    public boolean setUserInfo(IMiLiProfile.UserInfo userinfo)
    {
        boolean flag = true;
        int i = 0;
        Debug.TRACE();
        byte abyte0[] = new byte[20];
        abyte0[0] = (byte)(0xff & userinfo.uid);
        abyte0[flag] = (byte)(0xff & userinfo.uid >> 8);
        abyte0[2] = (byte)(0xff & userinfo.uid >> 16);
        abyte0[3] = (byte)(0xff & userinfo.uid >> 24);
        abyte0[4] = userinfo.gender;
        abyte0[5] = userinfo.age;
        abyte0[6] = userinfo.height;
        abyte0[7] = userinfo.weight;
        abyte0[8] = userinfo.type;
        Debug.ASSERT_NOT_NULL(userinfo.alias);
        if (userinfo.alias.length > 10)
        {
            flag = false;
        }
        Debug.ASSERT_TRUE(flag);
        for (int j = 0; j < userinfo.alias.length; j++)
        {
            abyte0[j + 9] = userinfo.alias[j];
        }

        byte abyte1[] = new byte[19];
        for (; i < 19; i++)
        {
            abyte1[i] = abyte0[i];
        }

        int k = Helper.CRC8(abyte1);
        String s = getDevice().getAddress();
        abyte0[19] = (byte)(k ^ Integer.decode((new StringBuilder()).append("0x").append(s.substring(-2 + s.length())).toString()).intValue());
        return write(m_CharUserInfo, abyte0);
    }

    public boolean setWearLocation(byte byte0)
    {
        return write(m_CharControlPoint, new byte[] {
            15, byte0
        });
    }

    public void stopGetActivities()
    {
        try
        {
            if (m_DataSourceInputStream != null)
            {
                m_DataSourceInputStream.close();
            }
            if (m_DataSourceOutputStream != null)
            {
                m_DataSourceOutputStream.close();
            }
            return;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }

    public boolean stopSyncData()
    {
        Debug.TRACE();
        return write(m_CharControlPoint, new byte[] {
            17
        });
    }

    public boolean updateFirmware(int i, int j, int k, byte abyte0[])
    {
        Debug.TRACE();
        boolean flag = sendFirmwareInfo(i, j, abyte0.length, k);
        Debug.ASSERT_TRUE(flag);
        if (!flag)
        {
            return false;
        } else
        {
            boolean flag1 = sendFirmwareData(abyte0);
            Debug.ASSERT_TRUE(flag1);
            return flag1;
        }
    }

    static 
    {
        Debug.INFO((new StringBuilder()).append(com/xiaomi/hm/bleservice/profile/MiLiProfile.getSimpleName()).append(".VERSION: ").append("2.0.0.20140514").toString());
    }



    private class _cls1
        implements com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback
    {

        final MiLiProfile this$0;

        public void notify(byte abyte0[])
        {
            Debug.INFO("=================================================");
            Debug.INFO("============= DEVICE STATUS CHANGED =============");
            Debug.INFO("=================================================");
            Intent intent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
            intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
            intent.putExtra(BLEService.INTENT_EXTRA_PARAM, abyte0[16]);
            BLEService.getBroadcastManager().sendBroadcast(intent);
        }

        _cls1()
        {
            this$0 = MiLiProfile.this;
            super();
        }
    }


    private class _cls2
        implements com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback
    {

        final MiLiProfile this$0;

        public void notify(byte abyte0[])
        {
            boolean flag = true;
            Intent intent;
            if (abyte0.length != flag)
            {
                flag = false;
            }
            Debug.ASSERT_TRUE(flag);
            Debug.INFO("=================================================");
            Debug.INFO("========== NOTIFICATION STATUS CHANGED ==========");
            Debug.INFO("=================================================");
            intent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
            intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
            intent.putExtra(BLEService.INTENT_EXTRA_PARAM, abyte0[0]);
            BLEService.getBroadcastManager().sendBroadcast(intent);
        }

        _cls2()
        {
            this$0 = MiLiProfile.this;
            super();
        }
    }


    private class _cls3
        implements com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback
    {

        final MiLiProfile this$0;

        public void notify(byte abyte0[])
        {
            boolean flag;
            int i;
            if (abyte0.length == 2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Debug.ASSERT_TRUE(flag);
            i = 0xff & abyte0[0] | (0xff & abyte0[1]) << 8;
            Debug.DEBUG((new StringBuilder()).append("RealtimeSteps: ").append(i).toString());
            onRealtimeStepsChanged(i);
        }

        _cls3()
        {
            this$0 = MiLiProfile.this;
            super();
        }
    }


    private class _cls4
        implements com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback
    {

        final MiLiProfile this$0;

        public void notify(byte abyte0[])
        {
            try
            {
                m_DataSourceOutputStream.write(abyte0);
                return;
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        _cls4()
        {
            this$0 = MiLiProfile.this;
            super();
        }
    }


    private class _cls5
        implements com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback
    {

        final MiLiProfile this$0;

        public void notify(byte abyte0[])
        {
            byte byte0;
            int i;
            boolean flag;
            if (abyte0.length == 10)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Debug.ASSERT_TRUE(flag);
            byte0 = abyte0[9];
            i = 0xff & abyte0[0];
            byte0;
            JVM INSTR tableswitch 0 4: default 64
        //                       0 75
        //                       1 139
        //                       2 147
        //                       3 155
        //                       4 163;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            Debug.WARN(">>> UNEXPECTED <<<");
            return;
_L2:
            Debug.WARN(">>> UNEXPECTED <<<");
_L8:
            Intent intent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
            intent.putExtra(BLEService.INTENT_EXTRA_DEVICE, getDevice());
            intent.putExtra(BLEService.INTENT_EXTRA_PARAM, byte0);
            intent.putExtra(BLEService.INTENT_EXTRA_PARAM_EXT, i);
            BLEService.getBroadcastManager().sendBroadcast(intent);
            return;
_L3:
            Debug.DEBUG("Battery low");
            continue; /* Loop/switch isn't completed */
_L4:
            Debug.DEBUG("Battery charging");
            continue; /* Loop/switch isn't completed */
_L5:
            Debug.DEBUG("Battery full (charging)");
            continue; /* Loop/switch isn't completed */
_L6:
            Debug.DEBUG("Battery charger off");
            if (true) goto _L8; else goto _L7
_L7:
        }

        _cls5()
        {
            this$0 = MiLiProfile.this;
            super();
        }
    }

}
