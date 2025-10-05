package com.yui.forumsystem.utils;

import org.springframework.util.DigestUtils;


/**
 * MD5工具类
 * 提供MD5加密相关的方法
 */
public class MD5Util {

    /**
     * 使用MD5算法对字符串进行加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的MD5字符串
     */
    public static String md5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 原始字符串与指定的key组合后进⾏MD5加密
     *
     * @param str 需要加密的字符串
     * @param key 加密密钥
     * @return 加密后的MD5字符串
     */
    public static String md5(String str, String key) {
        return DigestUtils.md5DigestAsHex((str + key).getBytes());
    }

    /**
     * 原始字符串加密后与扰动字符串组合再进⾏⼀次MD5加密
     *
     * @param str  需要加密的字符串
     * @param salt 盐值
     * @return 加密后的MD5字符串
     */
    public static String md5Salt(String str, String salt) {
        String first = DigestUtils.md5DigestAsHex(str.getBytes());
        return DigestUtils.md5DigestAsHex((first + salt).getBytes());
    }

    /**
     * 验证原始字符串与加密后的字符串是否匹配
     *
     * @param original   原始字符串
     * @param salt       盐值
     * @param ciphertext 加密后的字符串
     * @return 如果匹配返回true，否则返回false
     */
    public static boolean verifyOriginalAndCiphertext(String original, String salt, String ciphertext) {
        String md5text = md5Salt(original, salt);
        return md5text.equalsIgnoreCase(ciphertext);
    }
}
