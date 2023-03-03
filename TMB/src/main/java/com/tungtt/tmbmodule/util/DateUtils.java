package com.tungtt.tmbmodule.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    @Retention(RetentionPolicy.SOURCE)
    public @interface DATE_FORMAT {
        String YMD = "yyyy-mm-dd";
        String DMY = "dd/mm/yyyy";
    }

    public static String stringToString(String dateStr,
                                        @DATE_FORMAT String currentFormatStr,
                                        @DATE_FORMAT String destinationFormatStr) {
        try {
            Date date = stringToDate(dateStr, currentFormatStr);
            return dateToString(date, destinationFormatStr);
        } catch (Exception e) {
            return dateStr;
        }
    }

    public static Date stringToDate(String dateStr,
                                    @DATE_FORMAT String formatStr) throws ParseException {
        return new SimpleDateFormat(formatStr).parse(dateStr);
    }

    public static String dateToString(Date date,
                                      @DATE_FORMAT String formatStr) {
        return new SimpleDateFormat(formatStr).format(date);
    }
}
