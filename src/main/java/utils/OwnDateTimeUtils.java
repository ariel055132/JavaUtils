package utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 日期共用函數
 */

public class OwnDateTimeUtils extends DateUtils {
    // Pre-defined DateTime String
    public static String S_YYYY_MM_DD = "yyyyMMDD";
    public static String S_YYYY_MM_DD_DASH = "yyyy-MM-dd";
    public static String S_YYYY_MM_DD_SLASH = "yyyy/MM/dd";
    public static String S_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static String S_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    // Pre-defined DateTimeFormatter
    // 先定義好，並compile一些常用的日期/時間格式，避免Performance問題
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern(S_YYYY_MM_DD);
    public static final DateTimeFormatter YYYY_MM_DD_DASH = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_DASH);
    public static final DateTimeFormatter YYYY_MM_DD_SLASH = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_SLASH);
    public static final DateTimeFormatter YYYY_MM_DD_HH_MM_SS = DateTimeFormatter.ofPattern(S_YYYY_MM_DD_HH_MM_SS);

    public static LocalDateTime nowLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 使用自定義的日期格式，將日期字串轉換成LocalDate
     * @param dateString 日期字串 (String)
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

    /**
     * 使用DateTimeFormatter，將字串轉換成LocalDate
     * Convert String to LocalDate
     * @param dateString String
     * @param pattern DateTimeFormatter
     * @return LocalDate
     */
    public static LocalDate stringToLocalDate(String dateString, DateTimeFormatter pattern) {
        if (StringUtils.isEmpty(dateString) || ObjectUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDate.parse(dateString, pattern);
    }

    /**
     * 使用DateTimeFormatter，將字串轉換成LocalDateTime
     * Convert String to LocalDateTime
     * @param localDateTime String
     * @param pattern DateTimeFormatter
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String localDateTime, DateTimeFormatter pattern) {
        if (StringUtils.isEmpty(localDateTime) || ObjectUtils.isEmpty(pattern)) {
            return null;
        }
        return LocalDateTime.parse(localDateTime, pattern);
    }

    /**
     * 使用自定義的日期格式，將日期字串轉換成LocalDateTime
     * @param localDateTime String
     * @param pattern String
     * @return LocalDateTime
     */
    public static LocalDateTime stringToLocalDateTime(String localDateTime, String pattern) {
        if (StringUtils.isEmpty(localDateTime) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }

    /**
     * 將LocalDate(日期)轉換成字串
     * Convert LocalDate to String with given formatter
     * @param localDate LocalDate 日期
     * @param formatter DateTimeFormatter 日期格式
     * @return String
     */
    public static String localDateToString(LocalDate localDate, DateTimeFormatter formatter) {
        if (ObjectUtils.isEmpty(localDate)|| ObjectUtils.isEmpty(formatter)) {
            return StringUtils.EMPTY;
        }
        return localDate.format(formatter);
    }

    /**
     * 計算兩個日期之間的差距
     * Get difference between dateFrom and dateTo as days
     * @param dateFrom LocalDate
     * @param dateTo LocalDate
     * @return Long
     */
    public static Long getDateDifferenceAsDays(LocalDate dateFrom, LocalDate dateTo) {
        return ChronoUnit.DAYS.between(dateFrom, dateTo);
    }

    /**
     * 計算年齡
     * 例如：若使用者生日為1990-01-01，今天是2021-01-01，則年齡為31歲；但若今天是2020-12-31，則年齡為30歲
     * Calculate age.
     * For example: if the user's birthday is January 1, 1990, and today is January 1, 2021, the age is 31 years old; but if today is December 31, 2020, the age is 30 years old.
     * @param birthDay LocalDate 生日
     * @return Long 年齡
     */
    public static Long getAge(LocalDate birthDay) {
        if (ObjectUtils.isEmpty(birthDay)) {
            return null;
        }
        // Current date
        LocalDate now = LocalDate.now();
        // Calculate Age
        int age = Period.between(birthDay, now).getYears();
        return (long) age;
    }

    /**
     * 根據年份及月份取得該年該月的天數
     * Retrieve the number of days in a specific month of the year based on input conditions
     * @param year int 年份
     * @param month int 月份
     * @return int 天數
     */
    public static int getLengthOfDaysInMonth(int year, int month) {
        // Null check
        if (ObjectUtils.isEmpty(year) || ObjectUtils.isEmpty(month)) {
            return 0;
        }
        YearMonth yearMonth = YearMonth.of(year, month);
        return yearMonth.lengthOfMonth();
    }

    /**
     * 根據幾年幾月，計算除總共月數
     * @param year BigDecimal 年份
     * @param month BigDecimal 月份
     * @return BigDecimal 總共月數
     */
    public static BigDecimal getTotalMonthsWithYearAndMonth(BigDecimal year, BigDecimal month) {
        if (ObjectUtils.isEmpty(year) || ObjectUtils.isEmpty(month)) {
            return BigDecimal.ZERO;
        }
        return year.multiply(BigDecimal.valueOf(12)).add(month);
    }

    // Constructor only
    private OwnDateTimeUtils() {
    }
}
