import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.OwnDateTimeUtils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DisplayName("Unit Test for my own DateTimeUtils")
public class TestOwnDateTimeUtils {
    @Test
    @DisplayName("Test date utils - stringToLocalDate")
    void testStringToLocalDate() {
        // given
        String dateString = "2021-01-01";
        String pattern = "yyyy-MM-dd";
        LocalDate expectedResult = LocalDate.of(2021, 1, 1);

        // when
        LocalDate actualResult = OwnDateTimeUtils.stringToLocalDate(dateString, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDate with null dateString")
    void testStringToLocalDateWithNullInput() {
        // given
        String dateString = null;
        String pattern = "yyyy-MM-dd";
        LocalDate expectedResult = null;

        // when
        LocalDate actualResult = OwnDateTimeUtils.stringToLocalDate(dateString, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDate with null pattern (String)")
    void testStringToLocalDateWithNullPatternString() {
        // given
        String dateString = "2021-01-01";
        String pattern = null;
        LocalDate expectedResult = null;

        // when
        LocalDate actualResult = OwnDateTimeUtils.stringToLocalDate(dateString, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDate with DateTimeFormatter")
    void testStringToLocalDateWithDateTimeFormatter() {
        // given
        String dateString = "2021-01-01";
        LocalDate expectedResult = LocalDate.of(2021, 1, 1);

        // when
        LocalDate actualResult = OwnDateTimeUtils.stringToLocalDate(dateString, OwnDateTimeUtils.YYYY_MM_DD_DASH);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDate with null input")
    void testStringToLocalDateWithNullInputDateTimeFormatter() {
        // given
        String dateString = "2021-01-01";
        DateTimeFormatter pattern = null;
        LocalDate expectedResult = null;

        // when
        LocalDate actualResult = OwnDateTimeUtils.stringToLocalDate(dateString, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDateTime with DateTimeFormatter")
    void testStringToLocalDateTimeWithDateTimeFormatter() {
        // given
        String localDateTime = "2021-01-01 12:00:00";
        LocalDateTime expectedResult = LocalDateTime.of(2021, 1, 1, 12, 0, 0);

        // when
        LocalDateTime actualResult = OwnDateTimeUtils.stringToLocalDateTime(localDateTime, OwnDateTimeUtils.YYYY_MM_DD_HH_MM_SS);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDateTime with null localDateTime")
    void testStringToLocalDateTimeWithNullDateTimeFormatter() {
        // given
        String localDateTime = null;
        DateTimeFormatter pattern = OwnDateTimeUtils.YYYY_MM_DD_HH_MM_SS;
        LocalDateTime expectedResult = null;

        // when
        LocalDateTime actualResult = OwnDateTimeUtils.stringToLocalDateTime(localDateTime, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDateTime with null pattern")
    void testStringToLocalDateTimeWithNullPattern() {
        // given
        String localDateTime = "2021-01-01 12:00:00";
        DateTimeFormatter pattern = null;
        LocalDateTime expectedResult = null;

        // when
        LocalDateTime actualResult = OwnDateTimeUtils.stringToLocalDateTime(localDateTime, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDateTime with self-defined pattern")
    void testStringToLocalDateTimeWithSelfDefinedPattern() {
        // given
        String localDateTime = "2021-01-01 12:30:45";
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime expectedResult = LocalDateTime.of(2021, 1, 1, 12, 30, 45);

        // when
        LocalDateTime actualResult = OwnDateTimeUtils.stringToLocalDateTime(localDateTime, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - stringToLocalDateTime with null pattern (String)")
    void testStringToLocalDateTimeWithNullPatternString() {
        // given
        String localDateTime = "2021-01-01 12:00:00";
        String pattern = null;
        LocalDateTime expectedResult = null;

        // when
        LocalDateTime actualResult = OwnDateTimeUtils.stringToLocalDateTime(localDateTime, pattern);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - localDateToString")
    void testLocalDateToString() {
        // given
        LocalDate localDate = LocalDate.of(2021, 1, 1);
        String expectedResult = "2021-01-01";

        // when
        String actualResult = OwnDateTimeUtils.localDateToString(localDate, OwnDateTimeUtils.YYYY_MM_DD_DASH);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getDateDifferenceAsDays")
    void testGetDateDifferenceAsDays() {
        // given
        LocalDate dateFrom = LocalDate.of(2021, 1, 1);
        LocalDate dateTo = LocalDate.of(2021, 1, 10);
        Long expectedResult = 9L;

        // when
        Long actualResult = OwnDateTimeUtils.getDateDifferenceAsDays(dateFrom, dateTo);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getAge1")
    void testGetAge1() {
        // given
        LocalDate dateOfBirth = LocalDate.of(1990, 1, 1);
        int expectedResult = 34;

        // when
        Long actualResult = OwnDateTimeUtils.getAge(dateOfBirth);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getAge2")
    void testGetAge2() {
        // given
        LocalDate dateOfBirth = LocalDate.of(1998, 12, 14);
        int expectedResult = 25;

        // when
        Long actualResult = OwnDateTimeUtils.getAge(dateOfBirth);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getLengthOfDaysInMonth (normal case)")
    void testGetLengthOfDaysInMonth() {
        // given
        int year = 2024;
        int month = 6;
        int expectedResult = 30;

        // when
        int actualResult = OwnDateTimeUtils.getLengthOfDaysInMonth(year, month);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getLengthOfDaysInMonth (leap year case)")
    void testGetLengthOfDaysInMonthLeapYear() {
        // given
        int year = 2020;
        int month = 2;
        int expectedResult = 29;

        // when
        int actualResult = OwnDateTimeUtils.getLengthOfDaysInMonth(year, month);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getLengthOfDaysInMonth (not leap year input)")
    void testGetLengthOfDaysInMonthNotLeapYear() {
        // given
        int year = 2021;
        int month = 2;
        int expectedResult = 28;

        // when
        int actualResult = OwnDateTimeUtils.getLengthOfDaysInMonth(year, month);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getTotalMonthsWithYearAndMonth")
    void testGetTotalMonthsWithYearAndMonth() {
        // given
        BigDecimal year = BigDecimal.valueOf(2);
        BigDecimal month = BigDecimal.valueOf(3);
        BigDecimal expectedResult = BigDecimal.valueOf(27);

        // when
        BigDecimal actualResult = OwnDateTimeUtils.getTotalMonthsWithYearAndMonth(year, month);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test date utils - getTotalMonthsWithYearAndMonth with null input")
    void testGetTotalMonthsWithYearAndMonthWithNullInput() {
        // given
        BigDecimal year = null;
        BigDecimal month = null;
        BigDecimal expectedResult = BigDecimal.ZERO;

        // when
        BigDecimal actualResult = OwnDateTimeUtils.getTotalMonthsWithYearAndMonth(year, month);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
