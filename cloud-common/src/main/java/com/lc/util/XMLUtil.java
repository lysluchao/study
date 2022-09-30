package com.lc.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Arrays;
import java.util.List;

/**
 * Xml工具类
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/28 15:54
 */
public class XMLUtil {
    /**
     * 获取xml文本中其中一个节点的值
     *
     * @param xmlStr
     * @param tagPath
     * @return
     * @throws DocumentException
     */
    public static String element(String xmlStr, String tagPath) throws DocumentException {
        String[] paths = tagPath.split("\\.");
        //xml字符串转Document对象
        Document document = DocumentHelper.parseText(xmlStr);

        //获取根节点
        Element tmpElement = document.getRootElement();
        if (paths.length == 1) {
            return tmpElement.getStringValue();
        }

        paths = Arrays.copyOfRange(paths, 1, paths.length);
        for (String path : paths) {
            tmpElement = tmpElement.element(path);
            if (tmpElement == null) {
                return "";
            }
        }
        return tmpElement.getStringValue();
    }

    public static List<Element> elements(String xmlStr, String tagPath) throws DocumentException {
        String[] paths = tagPath.split("\\.");
        //xml字符串转Document对象
        Document document = DocumentHelper.parseText(xmlStr);
        //获取根节点
        Element tmpElement = document.getRootElement();
        Element preElement;

        for (int i = 1; i < paths.length; i++) {
            preElement=tmpElement;
            tmpElement = tmpElement.element(paths[i]);
            if (tmpElement == null) {
                return null;
            }
            if (i == paths.length - 1) {
                return preElement.elements(paths[i]);
            }
        }
        return null;
    }
}
