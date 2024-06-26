import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.OwnStringUtils;

@DisplayName("Unit Test for my own StringUtils")
public class TestOwnStringUtils {
    @Test
    @DisplayName("Test string utils - Contains (Positive)")
    void testContainsPositive() {
        // given
        String seq = "Hello World";
        String searchSeq = "World";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.contains(seq, searchSeq);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - Contains (Negative)")
    void testContainsNegative() {
        // given
        String seq = "Hello World";
        String searchSeq = "world";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.contains(seq, searchSeq);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - Equals (Positive)")
    void testEqualsPositive() {
        // given
        String cs1 = "Hello World";
        String cs2 = "Hello World";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.equals(cs1, cs2);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - Equals (Negative)")
    void testEqualsNegative() {
        // given
        String cs1 = "Hello World";
        String cs2 = "Hello world";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.equals(cs1, cs2);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - EqualsIgnoreCase (Positive)")
    void testEqualsIgnoreCasePositive() {
        // given
        String cs1 = "Hello World";
        String cs2 = "hello world";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.equalsIgnoreCase(cs1, cs2);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - EqualsIgnoreCase (Negative)")
    void testEqualsIgnoreCaseNegative() {
        // given
        String cs1 = "Hello World";
        String cs2 = "Hello aorld";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.equalsIgnoreCase(cs1, cs2);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isEmpty (Positive)")
    void testIsEmptyPositive() {
        // given
        String cs = "";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isEmpty(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isEmpty (Positive)")
    void testIsEmptyPositive2() {
        // given
        String cs = null;
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isEmpty(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isEmpty (Negative)")
    void testIsEmptyNegative() {
        // given
        String cs = "Hello World";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.isEmpty(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isNumber (Positive)")
    void testIsNumberPositive() {
        // given
        String cs = "123456";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isNumberSpace(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isNumber (Negative)")
    void testIsNumberNegative() {
        // given
        String cs = "123456a";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.isNumberSpace(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isAlphaSpace (Positive)")
    void testIsAlphaPositive() {
        // given
        String cs = "Hello World";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isAlphaSpace(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isFullWidth (Positive)")
    void testIsFullWidthPositive() {
        // given
        char cs = 'Ｈ';
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isFullWidth(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isFullWidth (Negative)")
    void testIsFullWidthNegative() {
        // given
        char cs = 'A';
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.isFullWidth(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - convertToFullWidth")
    void testConvertToFullWidth() {
        // given
        String cs = "Hello World!!!@";
        String expectedResult = "Ｈｅｌｌｏ Ｗｏｒｌｄ！！！＠";

        // when
        String result = OwnStringUtils.convertToFullWidth(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - convertToHalfWidth")
    void testConvertToHalfWidth() {
        // given
        String cs = "Ｈｅｌｌｏ Ｗｏｒｌｄ！！！＠";
        String expectedResult = "Hello World!!!@";

        // when
        String result = OwnStringUtils.convertToHalfWidth(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - convertToHalfWidth (Negative)")
    void testConvertToHalfWidthNegative() {
        // given
        String cs = "Hello World!!!@";
        String expectedResult = "Hello World!!!@";

        // when
        String result = OwnStringUtils.convertToHalfWidth(cs);

        // then
        Assertions.assertNotEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - leftPad")
    void testLeftPad() {
        // given
        String cs = "1";
        int size = 3;
        char padChar = '0';
        String expectedResult = "001";

        // when
        String actualResult = OwnStringUtils.leftPad(cs, size, padChar);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test string utils - isAlphaNumericSpace (Positive)")
    void testIsAlphaNumericSpacePositive() {
        // given
        String cs = "Hello World 123";
        boolean expectedResult = true;

        // when
        boolean result = OwnStringUtils.isAlphaNumericSpace(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - isAlphaNumericSpace (Negative)")
    void testIsAlphaNumericSpaceNegative() {
        // given
        String cs = "Hello World 123!";
        boolean expectedResult = false;

        // when
        boolean result = OwnStringUtils.isAlphaNumericSpace(cs);

        // then
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test string utils - defaultString")
    void testDefaultString() {
        // given
        String str = null;
        String expectedResult = "";

        // when
        String actualResult = OwnStringUtils.defaultString(str);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test string utils - substring")
    void testSubString() {
        // given
        String str = "Hello World";
        int start = 0;
        int end = 5;
        String expectedResult = "Hello";

        // when
        String actualResult = OwnStringUtils.substring(str, start, end);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test endsWith - Positive")
    void testEndsWithPositive() {
        // given
        String str = "AA12345678S";
        String suffix = "S";
        boolean expectedResult = true;

        // when
        boolean actualResult = OwnStringUtils.endsWith(str, suffix);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test endsWith - Negative")
    void testEndsWithNegative() {
        // given
        String str = "AA12345678S";
        String suffix = "s";
        boolean expectedResult = false;

        // when
        boolean actualResult = OwnStringUtils.endsWith(str, suffix);

        // then
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
