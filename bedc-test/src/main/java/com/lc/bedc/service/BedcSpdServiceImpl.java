package com.lc.bedc.service;

import cn.hutool.http.HttpUtil;
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
public class BedcSpdServiceImpl implements BedcSpdService {
    private final HashMap<String, String> resMap = new HashMap<>();
    final String TRANSCODE_1902 = "1902";
    final String RES_1902 = "<?xml version=\"1.0\" encoding=\"gb2312\"?>\n" +
            "<packet>\n" +
            "\t<head>\n" +
            "\t\t<transCode>1902</transCode>\n" +
            "\t\t<signFlag>0</signFlag>\n" +
            "\t\t<returnCode>AAAAAAA</returnCode>\n" +
            "\t\t<packetID></packetID>\n" +
            "\t\t<timeStamp>2022-10-22 06:20:15</timeStamp>\n" +
            "\t</head>\n" +
            "\t<body>\n" +
            "\t\t<transInfoDescribe>认购成功</transInfoDescribe>\n" +
            "\t\t<ifAppointment>0</ifAppointment>\n" +
            "\t\t<poundage>0</poundage>\n" +
            "\t\t<productEndDate>20341111</productEndDate>\n" +
            "\t\t<coreDate>20341002</coreDate>\n" +
            "\t\t<transCategory>0</transCategory>\n" +
            "\t\t<jnlSeqNo>LC1007970172</jnlSeqNo>\n" +
            "\t\t<transAmnt>1000</transAmnt>\n" +
            "\t\t<incomeStartDate>20210708 </incomeStartDate>\n" +
            "\t\t<transDate>20201023</transDate>\n" +
            "\t\t<reserve1>r1</reserve1>\n" +
            "\t\t<reserve2>r2</reserve2>\n" +
            "\t\t<reserve3>r3</reserve3>\n" +
            "\t\t<customerName>浦发2644609206</customerName>\n" +
            "\t\t<timeLimit>20210708</timeLimit>\n" +
            "\t\t<coreSerialNo>999700980001</coreSerialNo>\n" +
            "\t<subscribeDate>20201026</subscribeDate>\n" +
            "\t\t<maySubscribeLimit>maySubscribeLimit</maySubscribeLimit>\n" +
            "\t\t<customerNo>2644609206</customerNo>\n" +
            "\t</body>\n" +
            "</packet>\n";
    final String ERR_RES = "XXXX";
    String transCodePath = "packet.head.transCode";

    @PostConstruct
    public void initRes() {
        resMap.put(TRANSCODE_1902, RES_1902);
    }

    @Override
    public String test(String msg) {
        try {
            String opName = XMLUtil.element(msg, transCodePath);
            return resMap.get(opName);

        } catch (DocumentException e) {
            e.printStackTrace();
            return ERR_RES;
        }
    }
}
