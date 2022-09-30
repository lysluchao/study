import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author luchao
 * @version v1.0
 * @date 2022/9/29 16:25
 */
public class ServerDemo {


    public static void main(String[] args) throws IOException {

        String res = "POST / HTTP/1.1\n" +
                "User-Agent: Java/1.8.0_261\n" +
                "Host: localhost:53210\n" +
                "Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\n" +
                "Connection: keep-alive\n" +
                "Content-type: application/x-www-form-urlencoded\n" +
                "Content-Length: 472"+"<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
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

        //创建ServerSocket对象
        ServerSocket ss = new ServerSocket(53210);

        //监听客户端连接。返回客户端socket对象
        Socket s = ss.accept();

        //获取输入流，读取数据
        InputStream is = s.getInputStream();
        System.out.println("读取数据");
        byte[] datas = new byte[1024000];
        int len;
        len = is.read(datas);

        System.out.println(new String(datas, 0, len));


        //获取输出流，写出反馈
        OutputStream os = s.getOutputStream();
        os.write(res.getBytes());

        //释放资源
        s.close();
    }
}
