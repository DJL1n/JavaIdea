package util;

/**
 * 字符串工具类，提供对字符串的基础操作和检查功能。
 */
public class StrUtil {
    /**
     * 判断给定的字符串是否为空。
     * 字符串为空的定义为：null或者空字符串（""）。
     * @param str 需要检查的字符串。
     * @return 如果字符串为空，则返回true；否则返回false。
     */
    public static boolean isEmpty(String str){
        // 判断字符串是否为null或者空字符串，返回相应的布尔值
        return str == null || str.isEmpty();
    }
}
