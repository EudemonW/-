package com.jinhang.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String Date2String()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format( new Date());
    }
}
