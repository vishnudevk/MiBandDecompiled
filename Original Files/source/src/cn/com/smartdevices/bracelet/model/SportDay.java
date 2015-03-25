// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.com.smartdevices.bracelet.model;

import android.content.Context;
import cn.com.smartdevices.bracelet.BraceletApp;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SportDay
    implements Serializable
{

    private static final int ISO_FIRST_DAY_OF_WEEK = 2;
    private static final int ISO_MINIMAL_DAYS_IN_FIRST_WEEK = 4;
    private static final int US_FIRST_DAY_OF_WEEK = 1;
    private static final int US_MINIMAL_DAYS_IN_FIRST_WEEK = 1;
    private static int sFirstDayOfWeek = 0;
    private static int sMinimalDaysInFirstWeek = 0;
    private static final long serialVersionUID = 1L;
    public Calendar calendar;
    public int day;
    public int mon;
    public int year;

    public SportDay()
    {
        this(Calendar.getInstance());
    }

    public SportDay(int i, int j, int k)
    {
        year = i;
        mon = j;
        day = k;
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.setFirstDayOfWeek(sFirstDayOfWeek);
        calendar1.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
        calendar1.setTimeZone(TimeZone.getTimeZone((new StringBuilder()).append("GMT+").append(calendar1.get(15) / 1000 / 60 / 60).toString()));
        calendar = calendar1;
    }

    public SportDay(SportDay sportday)
    {
        this(sportday.year, sportday.mon, sportday.day);
    }

    public SportDay(Calendar calendar1)
    {
        year = calendar1.get(1);
        mon = calendar1.get(2);
        day = calendar1.get(5);
        calendar1.setFirstDayOfWeek(sFirstDayOfWeek);
        calendar1.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
        calendar1.setTimeZone(TimeZone.getTimeZone((new StringBuilder()).append("GMT+").append(calendar1.get(15) / 1000 / 60 / 60).toString()));
        calendar = calendar1;
    }

    public static SportDay fromString(String s)
    {
        SportDay sportday;
        try
        {
            String as[] = s.split("-");
            sportday = new SportDay(Integer.parseInt(as[0]), -1 + Integer.parseInt(as[1]), Integer.parseInt(as[2]));
        }
        catch (Exception exception)
        {
            return new SportDay();
        }
        return sportday;
    }

    public static Calendar toCalenday(String s)
    {
        Calendar calendar1 = Calendar.getInstance();
        try
        {
            String as[] = s.split("-");
            int i = Integer.parseInt(as[0]);
            int j = -1 + Integer.parseInt(as[1]);
            int k = Integer.parseInt(as[2]);
            calendar1.clear();
            calendar1.set(i, j, k);
        }
        catch (Exception exception)
        {
            return calendar1;
        }
        return calendar1;
    }

    public SportDay addDay(int i)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.add(6, i);
        return new SportDay(calendar1);
    }

    public SportDay addMonth(int i)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.add(2, i);
        return new SportDay(calendar1);
    }

    public SportDay addWeek(int i)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.add(3, i);
        return new SportDay(calendar1);
    }

    public SportDay addYear(int i)
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.add(1, i);
        return new SportDay(calendar1);
    }

    public boolean after(SportDay sportday)
    {
        while (year > sportday.year || year == sportday.year && (mon > sportday.mon || mon == sportday.mon && day > sportday.day)) 
        {
            return true;
        }
        return false;
    }

    public boolean before(SportDay sportday)
    {
        while (year < sportday.year || year == sportday.year && (mon < sportday.mon || mon == sportday.mon && day < sportday.day)) 
        {
            return true;
        }
        return false;
    }

    public int compare(SportDay sportday)
    {
        if (year <= sportday.year)
        {
            if (year < sportday.year)
            {
                return -1;
            }
            if (mon <= sportday.mon)
            {
                if (mon < sportday.mon)
                {
                    return -1;
                }
                if (day <= sportday.day)
                {
                    return day >= sportday.day ? 0 : -1;
                }
            }
        }
        return 1;
    }

    public boolean equals(int i, int j, int k)
    {
        return day == k && mon == j && year == i;
    }

    public boolean equals(SportDay sportday)
    {
        return day == sportday.day && mon == sportday.mon && year == sportday.year;
    }

    public boolean equals(Calendar calendar1)
    {
        return equals(calendar1.get(1), calendar1.get(2), calendar1.get(5));
    }

    public String formatString()
    {
        Date date = new Date();
        date.setYear(-1900 + year);
        date.setMonth(mon);
        date.setDate(day);
        return (new SimpleDateFormat(BraceletApp.getContext().getString(0x7f0d005d))).format(date);
    }

    public String formatStringDay()
    {
        Date date = new Date();
        date.setYear(-1900 + year);
        date.setMonth(mon);
        date.setDate(day);
        return (new SimpleDateFormat(BraceletApp.getContext().getString(0x7f0d0055))).format(date);
    }

    public String formatStringDayShort()
    {
        return (new StringBuilder()).append(1 + mon).append("/").append(day).toString();
    }

    public String getKey()
    {
        return toString();
    }

    public SportDay getMonthEndDay()
    {
        SportDay sportday = getMonthStartDay();
        SportDay sportday1 = null;
        int i = 1;
        do
        {
label0:
            {
                if (i <= 4)
                {
                    sportday1 = sportday.addDay(31 - i);
                    if (sportday1.year != year || sportday1.mon != mon)
                    {
                        break label0;
                    }
                }
                return sportday1;
            }
            i++;
        } while (true);
    }

    public SportDay getMonthStartDay()
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        calendar1.set(5, 1);
        return new SportDay(calendar1);
    }

    public int getWeek()
    {
        int i = calendar.get(7);
        if (i == 1)
        {
            return 6;
        } else
        {
            return i - 2;
        }
    }

    public SportDay getWeekStartDay()
    {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(year, mon, day);
        int i = calendar1.get(7) - sFirstDayOfWeek;
        if (i < 0)
        {
            i += 7;
        }
        calendar1.add(6, -i);
        return new SportDay(calendar1);
    }

    public int offsetDay(SportDay sportday)
    {
        Calendar calendar1 = calendar;
        Calendar calendar2 = sportday.calendar;
        if (year == sportday.year)
        {
            return calendar1.get(6) - calendar2.get(6);
        } else
        {
            Calendar calendar3 = (Calendar)calendar1.clone();
            Calendar calendar4 = (Calendar)calendar2.clone();
            calendar3.clear(11);
            calendar3.clear(12);
            calendar3.clear(13);
            calendar3.clear(14);
            calendar4.clear(11);
            calendar4.clear(12);
            calendar4.clear(13);
            calendar4.clear(14);
            return (int)((calendar3.getTimeInMillis() - calendar4.getTimeInMillis()) / 0x5265c00L);
        }
    }

    public int offsetMonth(SportDay sportday)
    {
        if (year == sportday.year)
        {
            return mon - sportday.mon;
        } else
        {
            return 12 * (year - sportday.year) + (mon - sportday.mon);
        }
    }

    public int offsetWeek(SportDay sportday)
    {
        Calendar calendar1 = calendar;
        Calendar calendar2 = sportday.calendar;
        if (year == sportday.year)
        {
            return calendar1.get(3) - calendar2.get(3);
        } else
        {
            return getWeekStartDay().offsetDay(sportday.getWeekStartDay()) / 7;
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(year).append("-");
        if (1 + mon < 10)
        {
            stringbuilder.append(0);
        }
        stringbuilder.append(1 + mon).append("-");
        if (day < 10)
        {
            stringbuilder.append(0);
        }
        stringbuilder.append(day);
        return stringbuilder.toString();
    }

    static 
    {
        sFirstDayOfWeek = 2;
        sMinimalDaysInFirstWeek = 4;
    }
}
