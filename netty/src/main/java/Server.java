import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 服务器
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/27 17:36
 */
public class Server {
    ServerSocket serverSocket = new ServerSocket(53210);

    String res = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
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

    public Server() throws IOException {
    }

    public void start() throws IOException {
        Socket s = serverSocket.accept();
        InputStream inputStream = s.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }


        OutputStream outputStream = s.getOutputStream();
        outputStream.write(res.getBytes(StandardCharsets.UTF_8));

        inputStream.close();
        bufferedReader.close();
        outputStream.close();
        s.close();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start();
    }
}
