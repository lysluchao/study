package com.lc.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void poll() {
        System.out.println(StringUtil.poll("中国工商行股份有限公司北京中环广场支行", "工商","中国"));
    }
}