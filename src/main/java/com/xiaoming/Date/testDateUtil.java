package com.xiaoming.Date;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class testDateUtil {
    public static void main(String[] args) {
//        LocalDateTime localDateTime=DateUtil.LocalDateTimePlus(DateUtil.getLocalDateTimeNow(), ChronoUnit.DAYS, 2);
//        LocalDate localDate=DateUtil.getLocalDateNow();
//        System.out.println(DateUtil.formatString(localDateTime,"yyyyMMdd"));
//        System.out.println(DateUtil.formatString(localDate,"yyyyMMdd"));
//        LocalDateTime localDateTime = DateUtil.getLocalDateTimeNow();
//
//        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));

        System.out.println(getTimeStamp());
    }


    public static String getTimeStamp() {
        long currentTimeMillis = System.currentTimeMillis();
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        Date dDate = null;
        try {
            dDate = format.parse(String.valueOf(DateUtil.formatString(DateUtil.getLocalDateTimeNow(), "yyyyMMddmmss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat format2 = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format2.format(dDate);
        return time;
    }

}
