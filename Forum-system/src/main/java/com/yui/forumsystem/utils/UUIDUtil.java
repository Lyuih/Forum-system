package com.yui.forumsystem.utils;

import java.util.UUID;

/**
 * UUID工具类
 * 用于生成唯一标识符
 */
public class UUIDUtil {

    /**
     * 生成36位UUID字符串，包含连字符
     * @return 36位UUID字符串
     */
    public static String UUID_36() {
        return UUID.randomUUID().toString();
    }

    /**
     * 生成32位UUID字符串，不包含连字符
     * @return 32位UUID字符串
     */
    public static String UUID_32() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
