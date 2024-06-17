package utils;

import org.apache.commons.lang3.StringUtils;

/**
 * String 共用函數
 */

public class OwnStringUtils extends StringUtils {
    /**
     * Give a default value ("") if the string is null.
     * @param str
     * @return
     */
    public static String defaultString(String str) {
        return StringUtils.defaultString(str, "");
    }

    /**
     * Check if the substring is contained within the string.
     * 檢查預期字串是否在另一個字串內部，若有則回傳true，否則回傳false
     * @param seq
     * @param searchSeq
     * @return
     */
    public static boolean contains(CharSequence seq, CharSequence searchSeq) {
        return StringUtils.contains(seq, searchSeq);
    }

    /**
     * Check if the string (cs1) is equal to another string (cs2).
     * It is case-sensitive.
     * @param cs1 待檢查的字串 (The string to be checked)
     * @param cs2 要比對的字串 (The string to be compared)
     * @return
     */
    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        return StringUtils.equals(cs1, cs2);
    }

    /**
     * Check if the string (cs1) is equal to another string (cs2).
     * It is case-insensitive.
     * @param cs1 待檢查的字串 (The string to be checked)
     * @param cs2 要比對的字串 (The string to be compared)
     * @return
     */
    public static boolean equalsIgnoreCase(CharSequence cs1, CharSequence cs2) {
        return StringUtils.equalsIgnoreCase(cs1, cs2);
    }

    /**
     * Check if the string is empty.
     *
     * @param cs
     * @return
     */
    public static boolean isEmpty(CharSequence cs) {
        // Whether the length of char sequence is 0 or it is null.
        return StringUtils.isEmpty(cs);
    }

    /**
     * Check if the string is Integer.
     * Return true if whole string is formed with Integers. Otherwise, return false.
     * Space 則代表遇到空格不會回傳false，因此使用isNumericSpace
     * isNumeric則是遇到空格會回傳false
     * @param cs 待檢查的字串
     * @return boolean 是否為數字
     */
    public static boolean isNumberSpace(CharSequence cs) {
        return StringUtils.isNumericSpace(cs);
    }

    /** Check if the string is alpha letter. (A-Z, a-z)
     * @param cs 待檢查的字串
     * @return boolean 是否為字母
     **/
    public static boolean isAlphaSpace(CharSequence cs) {
        return StringUtils.isAlphaSpace(cs);
    }

    /**
     * Check if the string is alpha-numeric. (A-Z, a-z, 0-9)
     * @param cs 待檢查的字串
     * @return boolean 是否為字母及數字
     */
    public static boolean isAlphaNumericSpace(CharSequence cs) {
        return StringUtils.isAlphanumericSpace(cs);
    }

    /**
     * Check if the character is full width. (判斷字元是否為全型及符號)
     * Java判断一个字符串是否有中文一般情况是利用Unicode编码(CJK统一汉字的编码区间：0x4e00–0x9fbb)的正则来做判断，但是其实这个区间来判断中文不是非常精确，因为有些中文的标点符号比如：，。等等是不能识别的。
     * Ref. http://www.micmiu.com/lang/java/java-check-chinese/
     * @param c char
     * @return boolean 該char是否為全型字元
     */
    public static boolean isFullWidth(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

    /**
     * Check if the character is half width. (判斷字元是否為半型)
     *
     */
    public static boolean isHalfWidth(char c) {
        return !isFullWidth(c);
    }

    /**
     * Convert the string to full width. (將字串轉換為全型字元)
     * Ref: https://malagege.github.io/blog/posts/%E7%A8%8B%E5%BC%8F%E5%8D%8A%E5%9E%8B%E8%BD%89%E5%85%A8%E5%9E%8B%E6%96%B9%E6%B3%95/
     * @param str 要轉換的字串
     * @return 轉換後的全型字串
     */
    public static String convertToFullWidth(String str) {
        // 判斷是否為空字串，若是則直接回傳
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int charValue = (int) arr[i];
            if (charValue >= 33 && charValue <= 126) {
                arr[i] = (char) (charValue + 65248);
            } else if (charValue == 32) {
                arr[i] = (char) 12288;
            }
        }
        return new String(arr);
    }

    /**
     * Convert the string to half width. (轉換成半型字串，平時用的字串都是半型字串，全型字串是指全角字符，占两个字符位置，如中文字符。
     * Ref: https://malagege.github.io/blog/posts/%E7%A8%8B%E5%BC%8F%E5%8D%8A%E5%9E%8B%E8%BD%89%E5%85%A8%E5%9E%8B%E6%96%B9%E6%B3%95/
     * @param str 要轉換的字串
     * @return 轉換後的半型字串
     */
    public static String convertToHalfWidth(String str) {
        // 判斷是否為空字串，若是則直接回傳
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int charValue = (int) arr[i];
            if (charValue >= 65281 && charValue <= 65374) {
                arr[i] = (char) (charValue - 65248);
            } else if (charValue == 12288) {
                arr[i] = (char) 32;
            }
        }
        return new String(arr);
    }

    /**
     * 左邊補滿字元(左墊法)
     * Ex. 若字串為"123"，size為5(代表字串固定長度為5)，padChar為'0'(若目前字串不為0，則補0)，則回傳"00123"
     * @param str 字串
     * @param size 字串長度
     * @param padChar 要補的字元
     * @return
     */
    public static String leftPad(String str, int size, char padChar) {
        return StringUtils.leftPad(str, size, padChar);
    }

    /**
     * Left Padding method without using StringUtils.leftPad
     public static String leftPad(String str, int size, String padStr) {
         String trimmedValue = value.trim();

         if(trimmedValue.length() == value.length()) {
            return value;
         }

         StringBuilder newValue = new StringBuilder(trimmedValue);

         IntStream.rangeClosed(1, value.length() - trimmedValue.length())
            .forEach(it -> newValue.insert(0, "0"));
         return newValue.toString();
     }
     */

    /**
     * Substring
     */
    public static String substring(String str, int start, int end) {
        return StringUtils.substring(str, start, end);
    }
}
