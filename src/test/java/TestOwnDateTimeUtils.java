import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.OwnDateTimeUtils;

import java.time.LocalDate;

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
}
