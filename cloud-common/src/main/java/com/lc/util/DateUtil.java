package com.lc.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

/**
 * 时间工具类
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/21 14:47
 */
public class DateUtil {
    public static String yesterdayStr() {
        return LocalDate.now().minusDays(1).toString();
    }

}
