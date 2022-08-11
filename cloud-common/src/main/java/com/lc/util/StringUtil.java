package com.lc.util;

/**
 * @Description: 字符串工具类
 * @Auther: LuChao
 * @Date: 2022/8/11 15:10
 * @Version: v1.0
 */
public class StringUtil {
    public static boolean isBlank(String str) {
        return str == null || str.equals("");
    }

    public static String poll(String str,String... regs){
        String res=str;
        for (String reg : regs) {
            res= res.replace(reg,"");
        }
        return res;
    }
}
