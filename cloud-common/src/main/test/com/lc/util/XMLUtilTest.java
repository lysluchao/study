package com.lc.util;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import java.util.List;

public class XMLUtilTest {

    @Test
    public void element() throws DocumentException {
        String xml ="%3Fxml+version=%221.0%22+encoding%3D%22GBK%22%3F%3E%0D%0A%3Croot%3E%0D%0A++++%3CHead%3E%0D%0A++++++++%3COpName%3E1002%3C%2FOpName%3E%0D%0A++++++++%3Cmerch_id%3E530020170008%3C%2Fmerch_id%3E%0D%0A++++++++%3COutsys_Code%3E990000000001%3C%2FOutsys_Code%3E%0D%0A++++++++%3COpDate%3E20220929%3C%2FOpDate%3E%0D%0A++++%3C%2FHead%3E%0D%0A++++%0D%0A%3CParam%3E%0D%0A%3CQuery_Account%3E944004010001136187%3C%2FQuery_Account%3E%0D%0A%3CBegin_Date%3E20220201%3C%2FBegin_Date%3E%0D%0A%3CCurrency%3ERMB%3C%2FCurrency%3E%0D%0A%3CReserved1%3E%3C%2FReserved1%3E%0D%0A%3CReserved2%3E%3C%2FReserved2%3E%0D%0A%3CReserved3%3E%3C%2FReserved3%3E%0D%0A%3CReserved4%3E%3C%2FReserved4%3E%0D%0A%3C%2FParam%3E%0D%0A%3C%2Froot%3E\n";
        String param = XMLUtil.element(xml, "root.Head.OpRetCode");
        //String param = XMLUtil.element(xml, "//root/Param/Query_Account");
        System.out.println(param);

    }

    @Test
    public void elements() throws DocumentException {
        String xml ="<?xml version=\"1.0\" encoding=\"GBK\"?>"+
                "<root>\n" +
                        "    \n" +
                        "<Param>\n" +
                        "    <Query_Account>944004010001136187</Query_Account>\n" +
                        "    <Currency>RMB</Currency>\n" +
                        "    <Reserved1></Reserved1>\n" +
                        "    <Reserved2></Reserved2>\n" +
                        "    <Reserved3></Reserved3>\n" +
                        "    <Reserved4></Reserved4>\n" +
                        "</Param>\n" +
                        "<Param>\n" +
                        "    <Query_Account>9440040100011361822222</Query_Account>\n" +
                        "    <Currency>RMB</Currency>\n" +
                        "    <Reserved1></Reserved1>\n" +
                        "    <Reserved2></Reserved2>\n" +
                        "    <Reserved3></Reserved3>\n" +
                        "    <Reserved4></Reserved4>\n" +
                        "</Param>\n" +
                        "</root>";
        List<Element> elements = XMLUtil.elements(xml, "root.Param");
        assert elements != null;
        for (Element element : elements) {
            System.out.println(element.getStringValue());
        }
    }
}