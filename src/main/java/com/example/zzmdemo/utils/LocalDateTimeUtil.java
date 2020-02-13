package com.example.zzmdemo.utils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**.
 * @author zhaor
 * @Description LocalDateTime工具类
 */
public class LocalDateTimeUtil {

    /**
     * 获取日期距今多久
     * @param time
     * @return
     */
    public static String getFromNow(LocalDateTime time) {
        LocalDateTime now = LocalDateTime.now();
        String result = null;
        if (null != time) {
            Duration between = Duration.between(time, now);
            long minutes = between.toMinutes();
            long hours = between.toHours();
            long days = between.toDays();
            if (days != 0) {
                result = days + "天前";
            } else if (hours != 0) {
                result = hours + "小时前";
            } else if (minutes != 0) {
                result = minutes + "分钟前";
            } else {
                result = "刚刚";
            }
        }

        return result;
    }

    public static int dayForWeek(String pTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(format.parse(pTime));
        int dayForWeek = 0;
        if(c.get(Calendar.DAY_OF_WEEK) == 1){
            dayForWeek = 7;
        }else{
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }

    public static String  getdayForWeekName(Integer dayForWeek){
        String  weekName = "";
        switch (dayForWeek){
            case 1 :
                weekName = "星期一";
                break;
            case 2 :
                weekName = "星期二";
                break;
            case 3 :
                weekName = "星期三";
                break;
            case 4 :
                weekName = "星期四";
                break;
            case 5 :
                weekName = "星期五";
                break;
            case 6 :
                weekName = "星期六";
                break;
            case 7 :
                weekName = "星期天";
                break;
        }
        return weekName;
    }

    /**
     * 获取今天是星期几
     * @param time
     * @return
     */
    public static String getWeekToName(String time){
        String weekName="";
        try {
            int week = LocalDateTimeUtil.dayForWeek(time);
            weekName = LocalDateTimeUtil.getdayForWeekName(week);
        } catch (Exception e){
            e.printStackTrace();
        }
        return weekName;
    }
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTimeUtil.getFromNow(LocalDateTime.parse("2019-01-01 11:30:30", df)));
    }
}
