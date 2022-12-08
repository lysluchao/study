import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.lc.bedc.model.RequestHead;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 浦发测试工具类
 *
 * @author luchao
 * @version v1.0
 * @date 2022/10/28 16:19
 */
public class BedcPostUtil {
    public static RequestHead initRequestHead(String serviceName) {
        RequestHead head = new RequestHead();
        head.setChannel("test");
        head.setReqDate(LocalDateTime.now().toString());
        head.setSeqNo(serviceName + System.currentTimeMillis());
        head.setService(serviceName);
        head.setOrgId("1010");
        return head;
    }

    public static void send(String serviceName, Object obj) {
        Map<String, Object> map = new HashMap<>();
        RequestHead head = initRequestHead(serviceName);
        map.put("head", head);
        map.put("body", obj);

        send(map);
    }

    public static void send(RequestHead head, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("head", head);
        map.put("body", obj);
        send(map);
    }

    private static void send(Map<String, Object> map) {
        String s = JSONUtil.toJsonStr(map);
        System.out.println(s);
        final int TIMEOUT_DEFAULT = 100000;
        final String BEDC_URL = "http://10.0.17.85:9004/bedc/inf.do";
        String result = HttpUtil.post(BEDC_URL, s, TIMEOUT_DEFAULT);
        System.out.println(result);
    }


}
