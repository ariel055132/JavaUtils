package utils;

import org.apache.commons.lang3.time.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期共用函數
 */

public class OwnDateTimeUtils extends DateUtils {
    // Pre-defined DateTime String
    public static String S_YYYYMMDD = "yyyyMMDD";

    // Pre-defined DateTimeFormatter
    // 先定義好，並compile一些常用的日期/時間格式，避免Performance問題
    public static final DateTimeFormatter YYYYMMDD = DateTimeFormatter.ofPattern(S_YYYYMMDD);

    public static LocalDateTime nowLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 將字串轉換成LocalDate
     * Convert String to LocalDate
     * @param dateString 日期字串 (String
     * @param pattern    日期格式 (String)
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String dateString, String pattern) {
        if (dateString == null || pattern == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    public static LocalDate stringToLocalDate(String dateString, DateTimeFormatter pattern) {
        if (dateString == null || pattern == null) {
            return null;
        }
        return LocalDate.parse(dateString, pattern);
    }

    private OwnDateTimeUtils() {
    }
}
