package com.ssm.common.util;


/**
 * @Description: 种子数据 
 * @author harry.zhang
 * @CreateDate:	2017年7月10日
 * @version 1.0
 */
public class NumericUtils {

    // 随机字符集
    public static final int max_num = 32;

    /**
     * 在进制表示中的字符集合。
     */
    public static final char[] digits_32 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                             'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 
                                             'M', 'N', 'P', 'Q', 'R', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    
    /**
     * 将十进制的数字转换为指定进制的字符串。
     * @param i 十进制的数字。
     * @param shift 位移操作 指定的进制，常见的2/8/16。
     * @return 转换后的字符串。
     */
    public static String toUnsignedString(int i, int shift) {
        char[] buf = new char[32];
        int charPos = 32;
        int radix = 1 << shift;
        int mask = radix - 1;
        do {
            buf[--charPos] = digits_32[i & mask];
            i >>>= shift;
        } while (i != 0);
        return new String(buf, charPos, (32 - charPos));
       }
    
    /**
     * 将其它进制的数字（字符串形式）转换为十进制的数字。
     * @param s 其它进制的数字（字符串形式）
     * @param system 指定的进制，常见的2/8/16/32。
     * @return 转换后的数字。
     */
    public static int toCustomNumeric(String s, int system) {
        char[] buf = new char[s.length()];
        s.getChars(0, s.length(), buf, 0);
        long num = 0;
        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < digits_32.length; j++) {
                if (digits_32[j] == buf[i]) {
                    num += j * Math.pow(system, buf.length - i - 1);
                    break;
                }
            }
        }
        return (int) num;
    }
}
