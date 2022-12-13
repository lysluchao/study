import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.lc.bedc.model.RequestHead;
import org.apache.commons.lang.StringUtils;

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

        send(map, null);
    }

    public static void send(RequestHead head, Object obj) {
        Map<String, Object> map = new HashMap<>();
        map.put("head", head);
        map.put("body", obj);
        send(map, null);
    }

    public static void send(RequestHead head, Object obj, String ip) {
        Map<String, Object> map = new HashMap<>();
        map.put("head", head);
        map.put("body", obj);
        send(map, ip);
    }

    private static void send(Map<String, Object> map, String ip) {
        String s = JSONUtil.toJsonStr(map);
        System.out.println(s);
        final int TIMEOUT_DEFAULT = 100000;
        String bedcUrl;
        if (StringUtils.isNotBlank(ip)) {
            bedcUrl = "http://" + ip + ":9004/bedc/inf.do";
        } else {
            bedcUrl = "http://127.0.0.1:9004/bedc/inf.do";
        }
        String result = HttpUtil.post(bedcUrl, s, TIMEOUT_DEFAULT);
        System.out.println(result);
    }


}
