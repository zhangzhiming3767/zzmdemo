package com.example.zzmdemo.utils;

import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Date;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2020 XXX, Inc. All rights reserved. <p>
 * Company: 阿里云<p>
 *
 * @author zhangzhiming
 * @since 2020/1/2 16:40
 */
public class LocalDateUtils {

    /**
     * @author :zhangzhiming
     * description :获取今天是周几
     * @date :Create in  2020/1/2 16:41
     */
    public static int getWeekDay(final Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekOfYear = c.get(Calendar.DAY_OF_WEEK);
        return weekOfYear - 1;
    }

    /**
     * @author :zhangzhiming
     * description :
     * @date :Create in  2020/1/2 16:35
     */
    public static String getWeekDayString(@NotEmpty Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekOfYear = c.get(Calendar.DAY_OF_WEEK)-1;
        return getdayForWeekName(weekOfYear);
    }

    public static String getdayForWeekName(Integer dayForWeek) {
        String weekName = "";
        switch (dayForWeek) {
            case 1:
                weekName = "星期一";
                break;
            case 2:
                weekName = "星期二";
                break;
            case 3:
                weekName = "星期三";
                break;
            case 4:
                weekName = "星期四";
                break;
            case 5:
                weekName = "星期五";
                break;
            case 6:
                weekName = "星期六";
                break;
            case 7:
                weekName = "星期天";
                break;
            default:
                weekName = null;
        }
        return weekName;
    }
}
