import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author luchao
 * @version v1.0
 * @date 2022/9/29 16:24
 */
public class ClientDemo {
    public static void main(String[] args) throws IOException {

        String req="<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<root>\n" +
                "    <Head>\n" +
                "        <OpName>1001</OpName>\n" +
                "        <merch_id>530020170008</merch_id>\n" +
                "        <Outsys_Code>990000000001</Outsys_Code>\n" +
                "        <OpDate>20220929</OpDate>\n" +
                "    </Head>\n" +
                "    \n" +
                "<Param>\n" +
                "    <Query_Account>944004010001136187</Query_Account>\n" +
                "    <Currency>RMB</Currency>\n" +
                "    <Reserved1></Reserved1>\n" +
                "    <Reserved2></Reserved2>\n" +
                "    <Reserved3></Reserved3>\n" +
                "    <Reserved4></Reserved4>\n" +
                "</Param>\n" +
                "</root>\n" +
                "0046200000";
        //创建socket对象
        Socket s = new Socket("127.0.0.1", 53210);

        //获取输出流
        OutputStream os = s.getOutputStream();
        os.write(req.getBytes());

        //获取输入流
        InputStream is = s.getInputStream();
        byte[] datas = new byte[10240];
        int len = is.read(datas);
        System.out.println("Client:" + new String(datas, 0, len));

        //释放资源
        s.close();
    }
}
