package com.lc.bedc.service;

import com.lc.util.XMLUtil;
import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * 银企测试服务实现类
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/30 10:17
 */
@Service
public class BedcPsbcServiceImpl implements BedcPsbcService {
    private final HashMap<String, String> resMap = new HashMap<>();
    final String OP_1001 = "1001";
    final String RES_1001 = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
            "<root>\n" +
            "    <Head>\n" +
            "        <OpName>1001</OpName>\n" +
            "        <OpRetCode>000000</OpRetCode>\n" +
            "        <OpRetMsg>交易成功:A2006341935</OpRetMsg>\n" +
            "    </Head>\n" +
            "    <Param>\n" +
            "        <Balance>0085993114969</Balance>\n" +
            "        <Usable_Balance>0085993114969</Usable_Balance>\n" +
            "        <Reserved1>0085993114969</Reserved1>\n" +
            "        <Reserved2>0000000000000</Reserved2>\n" +
            "        <Reserved3></Reserved3>\n" +
            "        <Reserved4></Reserved4>\n" +
            "    </Param>\n" +
            "</root>";
    final String OP_1002 = "1002";
    final String RES_1002 = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
            "<root>\n" +
            "    <Head>\n" +
            "        <OpName>1002</OpName>\n" +
            "        <OpRetCode>000000</OpRetCode>\n" +
            "        <OpRetMsg>SUCCESS:1002B2006341935</OpRetMsg>\n" +
            "    </Head>\n" +
            "    <Param>\n" +
            "        <Balance>0085993114969</Balance>\n" +
            "        <Usable_Balance>0085993114969</Usable_Balance>\n" +
            "        <Amt2>0085993114969</Amt2>\n" +
            "        <Amt3>0085993114969</Amt3>\n" +
            "        <Reserved1>0085993114969</Reserved1>\n" +
            "        <Reserved2>0000000000000</Reserved2>\n" +
            "        <Reserved3></Reserved3>\n" +
            "        <Reserved4></Reserved4>\n" +
            "    </Param>\n" +
            "</root>";
    final String OP_1010 = "1010";
    final String RES_1010 = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
            "<root>\n" +
            "\t<Head>\n" +
            "\t\t<OpName>1010</OpName>\n" +
            "\t\t<OpRetCode>000000</OpRetCode>\n" +
            "\t\t<OpRetMsg>SUCCESS:1010B2006341935</OpRetMsg>\n" +
            "\t</Head>\n" +
            "\t<Param>\n" +
            "\t\t<RecordSet>\n" +
            "\t\t\t<account>1000</account>\n" +
            "\t\t\t<accountname>测试顶顶顶顶</accountname>\n" +
            "\t\t\t<bankdocname>天地银行</bankdocname>\n" +
            "\t\t\t<acctype>21123</acctype>\n" +
            "\t\t\t<dfbanktypename>dfbanktypename</dfbanktypename>\n" +
            "\t\t\t<dfaccount>dfaccount</dfaccount>\n" +
            "\t\t\t<dfaccountname>dfaccountname</dfaccountname>\n" +
            "\t\t\t<advisef>advisef</advisef>\n" +
            "\t\t\t<direction>direction</direction>\n" +
            "\t\t\t<itransmode>itransmode</itransmode>\n" +
            "\t\t\t<dbegindate>dbegindate</dbegindate>\n" +
            "\t\t\t<rate>rate</rate>\n" +
            "\t\t\t<iperiods>iperiods</iperiods>\n" +
            "\t\t\t<cperiodunit>cperiodunit</cperiodunit>\n" +
            "\t\t\t<currtypename>currtypename</currtypename>\n" +
            "\t\t\t<amount>12323</amount>\n" +
            "\t\t\t<trantime>trantime</trantime>\n" +
            "\t\t\t<use>use</use>\n" +
            "\t\t</RecordSet>\n" +
            "\t\t<RecordSet>\n" +
            "\t\t\t<account>1001</account>\n" +
            "\t\t\t<accountname>测试顶顶顶顶</accountname>\n" +
            "\t\t\t<bankdocname>天地银行2</bankdocname>\n" +
            "\t\t\t<acctype>21123</acctype>\n" +
            "\t\t\t<dfbanktypename>dfbanktypename</dfbanktypename>\n" +
            "\t\t\t<dfaccount>dfaccount</dfaccount>\n" +
            "\t\t\t<dfaccountname>dfaccountname</dfaccountname>\n" +
            "\t\t\t<advisef>advisef</advisef>\n" +
            "\t\t\t<direction>direction</direction>\n" +
            "\t\t\t<itransmode>itransmode1</itransmode>\n" +
            "\t\t\t<dbegindate>dbegindate1</dbegindate>\n" +
            "\t\t\t<rate>rate</rate>\n" +
            "\t\t\t<iperiods>iperiods</iperiods>\n" +
            "\t\t\t<cperiodunit>cperioduni1t</cperiodunit>\n" +
            "\t\t\t<currtypename>currtypename1</currtypename>\n" +
            "\t\t\t<amount>12323</amount>\n" +
            "\t\t\t<trantime>trantime</trantime>\n" +
            "\t\t\t<use>use</use>\n" +
            "\t\t</RecordSet>\n" +
            "\t</Param>\n" +
            "</root>";
    final String ERR_RES = "XXXX";
    String opNamePath = "root.Head.OpName";

    @PostConstruct
    public void initRes() {
        resMap.put(OP_1001, RES_1001);
        resMap.put(OP_1002, RES_1002);
        resMap.put(OP_1010, RES_1010);
    }

    @Override
    public String test(String msg) {
        try {
            String opName = XMLUtil.element(msg, opNamePath);
            return resMap.get(opName);
        } catch (DocumentException e) {
            e.printStackTrace();
            return ERR_RES;
        }
    }
}



