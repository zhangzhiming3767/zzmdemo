package com.example.zzmdemo.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* @author :zhangzhiming
* description :
* @date :Create in  2020/2/13 17:07
*/
public class DateUtil {
    /***/
    private static final int THREE = 3;
    /***/
    private static final int FOUR = 4;
    /**
     * .
     **/
    private static final Log LOGGER = LogFactory.getLog(DateUtil.class);
    /**
     * .
     **/
    public static final String YYYYMMDD = "yyyy-MM-dd";
    /**
     * .
     * 中国周一是一周的第一天.
     */
    public static final int FIRST_DAY_OF_WEEK = Calendar.MONDAY;
    /**
     * 通用日期转换pattern
     */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * .
     *
     * @param strDate strDate
     * @return Date
     */
    public static Date parseDate(final String strDate) {
        return parseDate(strDate, null);
    }

    /**
     * .
     * parseDate
     *
     * @param strDate strDate
     * @param pattern pattern
     * @return Date
     */
    public static Date parseDate(final String strDate, final String pattern) {
        String pattern2 = pattern;
        Date date = null;
        try {
            if (pattern2 == null) {
                pattern2 = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern2);
            date = format.parse(strDate);
        } catch (Exception e) {
            LOGGER.error("parseDate error:" + e);
        }
        return date;
    }

    /**
     * .
     * format date
     *
     * @param date date
     * @return String
     */
    public static String formatDate(final Date date) {
        return formatDate(date, null);
    }

    /**
     * .
     * format date
     *
     * @param date    date
     * @param pattern pattern
     * @return String
     */
    public static String formatDate(final Date date, final String pattern) {
        String pattern2 = pattern;
        String strDate = null;
        try {
            if (pattern2 == null) {
                pattern2 = YYYYMMDD;
            }
            SimpleDateFormat format = new SimpleDateFormat(pattern2);
            strDate = format.format(date);
        } catch (Exception e) {
            LOGGER.error("formatDate error:", e);
        }
        return strDate;
    }

    /**
     * .
     * 取得日期：年
     *
     * @param date date
     * @return int
     */
    public static int getYear(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        return year;
    }

    /**
     * .
     * 取得日期：月
     *
     * @param date date
     * @return int
     */
    public static int getMonth(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        return month + 1;
    }

    /**
     * .
     * 取得日期：日
     *
     * @param date date
     * @return int
     */
    public static int getDay(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int da = c.get(Calendar.DAY_OF_MONTH);
        return da;
    }

    /**
     * .
     * 取得当天日期是周几
     *
     * @param date date
     * @return int
     */
    public static int getWeekDay(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekOfYear = c.get(Calendar.DAY_OF_WEEK);
        return weekOfYear - 1;
    }
    /**
    * @author :zhangzhiming
    * description :取得当天日期是周几 返回例：星期一
    * @date :Create in  2020/1/2 16:35
    */
    public static String getWeekDayString(final String date) {
        if(date==null){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(YYYYMMDD);
        Date newDate= null;
        try {
            newDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(newDate==null){
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(newDate);
        int weekOfYear = c.get(Calendar.DAY_OF_WEEK);
        return LocalDateTimeUtil.getdayForWeekName(weekOfYear-1);
    }

    /**
     * .
     * 取得一年的第几周
     *
     * @param date date
     * @return int
     */
    public static int getWeekOfYear(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
        return weekOfYear;
    }

    /**
     * .
     * getWeekBeginAndEndDate
     *
     * @param date    date
     * @param pattern pattern
     * @return String
     */
    public static String getWeekBeginAndEndDate(
            final Date date, final String pattern) {
        Date monday = getMondayOfWeek(date);
        Date sunday = getSundayOfWeek(date);
        return formatDate(monday, pattern) + " - "
                + formatDate(sunday, pattern);
    }

    /**
     * .
     * 根据日期取得对应周周一日期
     *
     * @param date date
     * @return Date
     */
    public static Date getMondayOfWeek(final Date date) {
        Calendar monday = Calendar.getInstance();
        monday.setTime(date);
        monday.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        monday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return monday.getTime();
    }

    /**
     * .
     * 根据日期取得对应周周日日期
     *
     * @param date date
     * @return Date
     */
    public static Date getSundayOfWeek(final Date date) {
        Calendar sunday = Calendar.getInstance();
        sunday.setTime(date);
        sunday.setFirstDayOfWeek(FIRST_DAY_OF_WEEK);
        sunday.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return sunday.getTime();
    }

    /**
     * .
     * 取得月的剩余天数
     *
     * @param date date
     * @return int
     */
    public static int getRemainDayOfMonth(final Date date) {
        int dayOfMonth = getDayOfMonth(date);
        int day = getPassDayOfMonth(date);
        return dayOfMonth - day;
    }

    /**
     * .
     * 取得月已经过的天数
     *
     * @param date date
     * @return int
     */
    public static int getPassDayOfMonth(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * .
     * 取得月天数
     *
     * @param date date
     * @return int
     */
    public static int getDayOfMonth(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * .
     * 取得月第一天
     *
     * @param date date
     * @return Date
     */
    public static Date getFirstDateOfMonth(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * .
     * 取得月最后一天
     *
     * @param date date
     * @return Date
     */
    public static Date getLastDateOfMonth(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }
    /**
     * 获取当年的最后时间戳
     *
     * @param timeStamp 毫秒级时间戳
     * @param timeZone  如 GMT+8:00
     * @return
     */
    public static Date getYearEndTime(Long timeStamp, String timeZone) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTimeZone(TimeZone.getTimeZone(timeZone));
        calendar.setTimeInMillis(timeStamp);
        int year = calendar.get(Calendar.YEAR);
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }
    /**
    * @author :zhangzhiming
    * description :获取今天的开始时间
    * @date :Create in  2020/2/13 17:22
    */
    public static Date getStartTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY,0);
        todayStart.set(Calendar.MINUTE,0);
        todayStart.set(Calendar.SECOND,0);
        todayStart.set(Calendar.MILLISECOND,0);
        return todayStart.getTime();
    }
    /**
    * @author :zhangzhiming
    * description :获取当前月 or 前几个月-  后几个月+  的开始时间
    * @date :Create in  2020/2/13 18:02
    */
    public static Date getLastMothStartTime(int delta){
        Calendar todayStart = Calendar.getInstance();
        todayStart.add(Calendar.MONTH,delta);
        todayStart.set(Calendar.DATE,1);
        todayStart.set(Calendar.HOUR_OF_DAY,0);
        todayStart.set(Calendar.MINUTE,0);
        todayStart.set(Calendar.SECOND,0);
        todayStart.set(Calendar.MILLISECOND,0);
        return todayStart.getTime();
    }
    /**
     * @author :zhangzhiming
     * description :获取今天的结束时间
     * @date :Create in  2020/2/13 17:22
     */
    public static Date getEndTime(){
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY,23);
        todayStart.set(Calendar.MINUTE,59);
        todayStart.set(Calendar.SECOND,59);
        todayStart.set(Calendar.MILLISECOND,999);
        return todayStart.getTime();
    }
    /**
     * @author :zhangzhiming
     * description :获取当前月 or 前几个月-  后几个月+  的开始时间
     * @date :Create in  2020/2/13 18:02
     */
    public static Date getLastMothEndTime(int delta){
        Date todayStart=getLastMothStartTime(delta);
        todayStart=getLastDateOfMonth(todayStart);
        Calendar date = Calendar.getInstance();
        date.setTime(todayStart);
        date.set(Calendar.HOUR_OF_DAY,23);
        date.set(Calendar.MINUTE,59);
        date.set(Calendar.SECOND,59);
        date.set(Calendar.MILLISECOND,999);
        return date.getTime();
    }


    /**
     * .
     * 取得季度第一天
     *
     * @param date date
     * @return Date
     */
    public static Date getFirstDateOfSeason(final Date date) {
        return getFirstDateOfMonth(getSeasonDate(date)[0]);
    }

    /**
     * .
     * 取得季度最后一天
     *
     * @param date date
     * @return Date
     */
    public static Date getLastDateOfSeason(final Date date) {
        return getLastDateOfMonth(getSeasonDate(date)[2]);
    }

    /**
     * .
     * 取得季度天数
     *
     * @param date date
     * @return int
     */
    public static int getDayOfSeason(final Date date) {
        int day = 0;
        Date[] seasonDates = getSeasonDate(date);
        for (Date date2 : seasonDates) {
            day += getDayOfMonth(date2);
        }
        return day;
    }

    /**
     * .
     * 取得季度剩余天数
     *
     * @param date date
     * @return int
     */
    public static int getRemainDayOfSeason(final Date date) {
        return getDayOfSeason(date) - getPassDayOfSeason(date);
    }

    /**
     * .
     * 取得季度已过天数
     *
     * @param date date
     * @return int
     */
    public static int getPassDayOfSeason(final Date date) {
        int day = 0;

        Date[] seasonDates = getSeasonDate(date);

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);

        if (month == Calendar.JANUARY || month == Calendar.APRIL
                || month == Calendar.JULY
                || month == Calendar.OCTOBER) { // 季度第一个月
            day = getPassDayOfMonth(seasonDates[0]);
        } else if (month == Calendar.FEBRUARY || month == Calendar.MAY
                || month == Calendar.AUGUST || month == Calendar.NOVEMBER) {
            // 季度第二个月
            day = getDayOfMonth(seasonDates[0])
                    + getPassDayOfMonth(seasonDates[1]);
        } else if (month == Calendar.MARCH || month == Calendar.JUNE
                || month == Calendar.SEPTEMBER || month == Calendar.DECEMBER) {
            // 季度第三个月
            day = getDayOfMonth(seasonDates[0]) + getDayOfMonth(seasonDates[1])
                    + getPassDayOfMonth(seasonDates[2]);
        }
        return day;
    }

    /**
     * .
     * 取得季度月
     *
     * @param date date
     * @return Date[]
     */
    public static Date[] getSeasonDate(final Date date) {
        Date[] season = new Date[THREE];

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int nSeason = getSeason(date);
        int one = 1, two = 2, three = THREE, four = FOUR;
        // 第一季度
        if (nSeason == one) {
            c.set(Calendar.MONTH, Calendar.JANUARY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.FEBRUARY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MARCH);
            season[2] = c.getTime();
            // 第二季度
        } else if (nSeason == two) {
            c.set(Calendar.MONTH, Calendar.APRIL);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.MAY);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.JUNE);
            season[2] = c.getTime();
            // 第三季度
        } else if (nSeason == three) {
            c.set(Calendar.MONTH, Calendar.JULY);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.AUGUST);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);
            season[2] = c.getTime();
        } else if (nSeason == four) {
            // 第四季度
            c.set(Calendar.MONTH, Calendar.OCTOBER);
            season[0] = c.getTime();
            c.set(Calendar.MONTH, Calendar.NOVEMBER);
            season[1] = c.getTime();
            c.set(Calendar.MONTH, Calendar.DECEMBER);
            season[2] = c.getTime();
        }
        return season;
    }

    /**
     * .
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
     *
     * @param date date
     * @return int
     */
    public static int getSeason(final Date date) {

        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = THREE;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = FOUR;
                break;
            default:
                break;
        }
        return season;
    }

    public static Date utcToDate(String utcDate) {
        utcDate = utcDate.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        Date date = null;
        try {
            date = format.parse(utcDate);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    /**
     * 切割時間段
     *
     * @param dateType 交易類型 M/D/H/N -->每月/每天/每小時/每分鐘
     * @param start    yyyy-MM-dd HH:mm:ss
     * @param end      yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static List<String> cutDate(String dateType, String start, String end) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dBegin = sdf.parse(start);
            Date dEnd = sdf.parse(end);
            return findDates(dateType, dBegin, dEnd);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<String> findDates(String dateType, Date dBegin, Date dEnd) throws Exception {
        List<String> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        while (calEnd.after(calBegin)) {
            switch (dateType) {
                case "M":
                    calBegin.add(Calendar.MONTH, 1);
                    break;
                case "D":
                    calBegin.add(Calendar.DAY_OF_YEAR, 1);
                    break;
                case "H":
                    calBegin.add(Calendar.HOUR, 1);
                    break;
                case "N":
                    calBegin.add(Calendar.SECOND, 1);
                    break;
                default:
                    break;
            }
            if (calEnd.after(calBegin)) {
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calBegin.getTime()));
            } else {
                listDate.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calEnd.getTime()));
            }
        }
        return listDate;
    }

    /**
     * 获取当前日期字符串
     * 不传pattern默认yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentDateStr(String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(StringUtils.isNotEmpty(pattern) ? pattern : DEFAULT_PATTERN);
        return format.format(new Date());
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static String getSysYear() {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return year;

    }

    public static boolean after(String date1, String date2) throws ParseException {
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        c1.setTime(format1.parse(date1));
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format1.parse(date2));
        return c2.after(c1);
    }

    /**
     * 比较日期
     *
     * @param date1
     * @param date2
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static boolean after(String date1, String date2, String pattern) throws ParseException {
        DateFormat format1 = null;
        if (StringUtils.isNotBlank(pattern)) {
            format1 = new SimpleDateFormat(pattern);
        } else {
            format1 = new SimpleDateFormat(DEFAULT_PATTERN);
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(format1.parse(date1));
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format1.parse(date2));
        return c2.after(c1);
    }

    /**
     * 比较日期
     *
     * @param date1
     * @param date2
     * @param pattern
     * @param minute  时间像前后推的分钟数，负数为向前， 正数为向后
     * @return
     * @throws ParseException
     */
    public static boolean after(String date1, String date2, String pattern, final int minute) throws ParseException {
        DateFormat format1 = null;
        if (StringUtils.isNotBlank(pattern)) {
            format1 = new SimpleDateFormat(pattern);
        } else {
            format1 = new SimpleDateFormat(DEFAULT_PATTERN);
        }
        Calendar c1 = Calendar.getInstance();
        c1.setTime(format1.parse(date1));
        c1.set(Calendar.MINUTE, minute);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(format1.parse(date2));
        return c2.after(c1);
    }

    /**
    * @author :zhangzhiming
    * description :计算年龄
    * @date :Create in  2019/12/9 16:50
    */
    public static int getAgeByBirth(Date birthday) {
        int age = 0;
        try {
            Calendar now = Calendar.getInstance();
            now.setTime(new Date());
            Calendar birth = Calendar.getInstance();
            birth.setTime(birthday);
            //如果传入的时间，在当前时间的后面，返回0岁
            if (birth.before(now)) {
                age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
                if (now.get(Calendar.DAY_OF_YEAR) > birth.get(Calendar.DAY_OF_YEAR)) {
                    age += 1;
                }
            }
            return age;
        } catch (Exception e) {
            return 0;
        }
    }
    /**
    * @author :zhangzhiming
    * description :计算年龄
    * @date :Create in  2019/12/9 16:55
    */
    public static int getAgeByBirth(String birthday){
        if (StringUtils.isEmpty(birthday)) {
            return 0;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        try {
            return getAgeByBirth(format.parse(birthday));
        } catch (ParseException e) {
           return 0;
        }
    }

}
