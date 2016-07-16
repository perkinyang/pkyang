package com.jbb.util;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * 'yyyy-MM-dd HH:mm:ss' style data format 例：1988-11-14 10:10:10
     */
    public static final String DATESTYLEA = "yyyy-MM-dd HH:mm:ss";

    /**
     * 'yyyy-MM-dd' style data format 例：1988-11-14
     */
    public static final String DATESTYLEA_A = "yyyy-MM-dd";

    /**
     * 'yyyy-MM-dd HH:mm' style data format 例：1988-11-14 10:10
     */
    public static final String DATESTYLEA_B = "yyyy-MM-dd HH:mm";

    /**
     * 'yyyy-MM-dd HH:mm:ss.SSS' style data format 例：1988-11-14 10:10:10.222
     */
    public static final String DATESTYLEA_C = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 'yyyy/MM/dd HH:mm:ss' style data format 例：1988/11/14 10:10:10
     */
    public static final String DATESTYLEB = "yyyy/MM/dd HH:mm:ss";

    /**
     * 'yyyy/MM/dd' style data format 例：1988/11/14
     */
    public static final String DATESTYLEB_A = "yyyy/MM/dd";

    /**
     * 'yyyy/MM/dd HH:mm' style data format 例：1988/11/14 10:10
     */
    public static final String DATESTYLEB_B = "yyyy/MM/dd HH:mm";

    /**
     * 'yyyy/MM/dd HH:mm:ss.SSS' style data format 例：1988/11/14 10:10:10.222
     */
    public static final String DATESTYLEB_C = "yyyy/MM/dd HH:mm:ss.SSS";

    /**
     * 'yyyy/MM/dd/HH' style data format 例：1988/11/14/10
     */
    public static final String DATESTYLEB_D = "yyyy/MM/dd/HH";

    /**
     * 'yyyy年MM月dd日 HH时mm分ss秒' style data format 例：1988年11月14日 10时10分10秒
     */
    public static final String DATESTYLEC = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 'yyyy年MM月dd日' style data format 例：1988年11月14日
     */
    public static final String DATESTYLEC_A = "yyyy年MM月dd日";

    /**
     * 'yyyy年MM月dd日 HH时mm分' style data format 例：1988年11月14日 10时10分
     */
    public static final String DATESTYLEC_B = "yyyy年MM月dd日 HH时mm分";

    /**
     * 'yyyy年MM月dd日 HH时mm分ss秒.SSS' style data format 例：1988年11月14日 10时10分10秒.222
     */
    public static final String DATESTYLEC_C = "yyyy年MM月dd日 HH时mm分ss秒.SSS";

    /**
     * 'yyyy年MM月dd日 HH时' style data format 例：1988年11月14日 10时
     */
    public static final String DATESTYLEC_D = "yyyy年MM月dd日 HH时";

    /**
     * 'yyyy年MM月dd日 HH时mm分ss秒SSS' style data format 例：1988年11月14日 10时10分10秒222
     */
    public static final String DATESTYLEC_E = "yyyy年MM月dd日 HH时mm分ss秒SSS";

    /**
     * 'yyyyMMddHHmmss' style data format 例：19881114101010
     */
    public static final String DATESTYLED = "yyyyMMddHHmmss";

    /**
     * 'yyyyMMdd' style data format 例：19881114
     */
    public static final String DATESTYLED_A = "yyyyMMdd";

    /**
     * 'yyyyMMddHHmm' style data format 例：198811141010
     */
    public static final String DATESTYLED_B = "yyyyMMddHHmm";

    /**
     * 'yyyyMMddHHmmssSSS' style data format 例：19881114101010222
     */
    public static final String DATESTYLED_C = "yyyyMMddHHmmssSSS";

    /**
     * 'yyyyMMddHH' style data format 例：1988111410
     */
    public static final String DATESTYLED_D = "yyyyMMddHH";

    /**
     * 'yyyyMM' style data format 例：198811
     */
    public static final String DATESTYLEA_F = "yyyyMM";

    /**
     * 'HH:mm:ss' style data format 例：10:10:10
     */
    public static final String DATESTYLEO = "HH:mm:ss";

    /**
     * 'HH时mm分ss秒' style data format 例：10时10分10秒
     */
    public static final String DATESTYLEO_A = "HH时mm分ss秒";

    /**
     * 'yy年MM月dd日' style data format 例：88年11月14日
     */
    public static final String DATESTYLEO_B = "yy年MM月dd日";

    /**
     * 'HH/mm/ss' style data format 例：10/10/10
     */
    public static final String DATESTYLEO_C = "HH/mm/ss";

    /**
     * 'yyMMddHHmmssSSS' style data format 例：881114101010222
     */
    public static final String DATESTYLEO_D = "yyMMddHHmmssSSS";

    /**
     * 'HH:mm:ss' style data format 例：10:10:10
     */
    public static final String DATESTYLET = "HH:mm";

    /**
     * get current date object
     */
    public static Date nowDate() {
        return new Date();
    }

    /**
     * convert the date type to java.sql.Timestamp class
     */
    public static Timestamp convertToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return new Timestamp(date.getTime());
        }
    }

    /**
     * get current time string yyyy means year MM means month dd means date HH means hour mm means minute ss means
     * second SS means million second 'E' - DAY_OF_WEEK 'G' - ERA 'k' - HOUR_OF_DAY: 1-based. eg, 23:59 + 1 hour =>>
     * 24:59 'a' - AM_PM 'F' - DAY_OF_WEEK_IN_MONTH 'w' - WEEK_OF_YEAR 'W' - WEEK_OF_MONTH 'K' - HOUR: 0-based. eg, 11PM
     * + 1 hour =>> 0 AM
     * 
     * @param style the style string like 'yyyyMMdd'
     * @return current time string in style mode
     */
    public static String getCurrentTimeStr(String style) {
        if (style == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(style, new DateFormatSymbols());
        return sdf.format(new Date());
    }

    /**
     * 根据unix时间转换成string
     * 
     * @param unixTime UNIX时间
     * @param style
     * @return
     */
    public static String getUnixTimeStirng(long unixTime, String style) {
        SimpleDateFormat sdf = new SimpleDateFormat(style, new DateFormatSymbols());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(unixTime * 1000);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当前的UNIX时间戳
     * 
     * @return
     */
    public static long getCurrentUnixTime() {
        long now = System.currentTimeMillis() / 1000L;
        return now;
    }

    public static Date unixTimeToDate(int unixTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(Long.valueOf(unixTime) * 1000);
        return cal.getTime();
    }

    public static int getHourOfUnixTime(long unixTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(Long.valueOf(unixTime) * 1000);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getCurrentHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * format date to string
     * 
     * @param date the date
     * @param format the format
     * @return the formatted string
     */
    public static String formatDateToStr(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, new DateFormatSymbols());
            return sdf.format(date);
        } catch (Exception e) {
            return format;
        }
    }

    /**
     * parse string to date format
     * 
     * @param dateStr the date string
     * @param format the format string
     * @return date object or null
     */
    public static Date parseStrToDate(String dateStr, String format) {
        if (dateStr == null || format == null) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, new DateFormatSymbols());
            return sdf.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Converts a <code>String</code> object in JDBC timestamp escape format to a <code>Timestamp</code> value.
     * 
     * @param timeStr timestamp in format yyyy-MM-dd hh:mm:ss[.f...]. The fractional seconds may be omitted.
     * @return corresponding <code>Timestamp</code> value
     * @exception java.lang.IllegalArgumentException if the given argument does not have the format
     *                <code>yyyy-MM-dd hh:mm:ss[.f...]</code>
     */
    public static Timestamp parseStrToTimestamp(String timeStr) {
        if (timeStr == null) {
            return null;
        }
        try {
            return Timestamp.valueOf(timeStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * get the last day of the given month
     * 
     * @param year Year
     * @param month Month from 1 to 12
     * @return the last day of given month
     */
    public static int getLastDayInMonth(int year, int month) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        // month: 1~12
        c.set(Calendar.MONTH, month - 1);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取n天前的时间 格式yyyy-MM-dd,n如果为负表示n天后的时间
     * 
     * @param n
     * @return
     */
    public static String getNdayAgo(int n) {
        return getNdayAgo(n, DATESTYLEA_A);
    }

    public static String getNdayAgoByDATESTYLEDA(int n) {
        return getNdayAgo(n, DATESTYLED_A);
    }

    public static String getNdayAgo(Date currentDay, int n, String formatStr) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        cal.add(Calendar.DAY_OF_MONTH, -n);
        return formatDateToStr(cal.getTime(), formatStr);
    }

    public static Date getNdayAfter(Date currentDay, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        cal.add(Calendar.DAY_OF_MONTH, n);
        return cal.getTime();
    }

    /**
     * 获取n天前的时间 格式自定义
     * 
     * @param n
     * @param formatStr
     * @return
     */
    public static String getNdayAgo(int n, String formatStr) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        return formatDateToStr(cal.getTime(), formatStr);
    }

    /**
     * 获取n秒前的时间 格式yyyy-MM-dd,n如果为负表示n秒后的时间
     */
    public static Date getDNSecondAgo(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, -n);
        return cal.getTime();
    }

    /**
     * 获取nmiao前的时间 格式yyyy-MM-dd,n如果为负表示n天后的时间
     */
    public static Date getDNdayAgo(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        return cal.getTime();
    }

    /**
     * 获取nmiao前的时间 格式yyyy-MM-dd,n如果为负表示n天后的时间
     */
    public static int getDNdayAgoForUnixTime(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        return (int) (cal.getTime().getTime() / 1000L);
    }

    /**
     * 获取n小时前的时间 格式yyyy-MM-dd,n如果为负表示n小时后的时间
     */
    public static Date getDNHourAgo(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -n);
        return cal.getTime();
    }

    public static int getDNHourAgoForUnixTime(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, -n);
        return (int) (cal.getTime().getTime() / 1000L);
    }

    public static String getDNHourAfter(int n, Date date, String formatStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, n);
        return format.format(cal.getTime());
    }

    public static Date getDNHourAfter(int n, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, n);
        return cal.getTime();
    }

    public static Date getDNHourAgoSharp(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, -n);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();

    }

    /**
     * 获取n小时前的时间 格式yyyy-MM-dd,n如果为负表示n小时后的时间
     */
    public static Date getDNMinuteAgo(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -n);
        return cal.getTime();
    }

    public static String getDNMinuteAfter(int n, Date date, String formatStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return format.format(cal.getTime());
    }

    public static String getDNMonthAgo(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -n);
        return formatDateToStr(cal.getTime(), DATESTYLEA_F);
    }

    public static Date getDNdayAgoSharp(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDNdayAfterSharp(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, n);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static int getDNdayAgoSharpForUnixTime(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -n);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTime().getTime() / 1000L);
    }

    public static Date getFirstDayOfNWeek(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, -n);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    public static Date getLastDayOfNWeek(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, -n);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return cal.getTime();
    }

    public static Date getFirstDayOfNMonth(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -n);
        cal.set(Calendar.DATE, 1);
        return cal.getTime();
    }

    public static Date getLastDayOfNMonth(int n) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -(n - 1));
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }
    
    public static void main(String[] args) {
        System.out.println(DateUtils.formatDateToStr(DateUtils.getDNdayAgoSharp(0 - 1), DateUtils.DATESTYLEA_A));
        String    startDate =
                DateUtils.formatDateToStr(DateUtils.getDNHourAfter(-1, DateUtils.getDNdayAgoSharp(0 - 1)),
                        DateUtils.DATESTYLEB_D);
        System.out.println(startDate);
    }

}
