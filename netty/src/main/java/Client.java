import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * 客户端
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/29 14:01
 */
public class Client {

    public Client() throws IOException {
    }

    public void sendAndRcv(String msg) throws IOException {
        URL url = new URL(this.getAddr());
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        initConnection(httpURLConnection);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.append(msg);
        outputStreamWriter.flush();

        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        do {
            line = bufferedReader.readLine();
            System.out.println(line);
        } while (line != null);
    }

    private String getAddr() {
        return "http://localhost:53210";
    }

    private void initConnection(HttpURLConnection httpURLConnection) {
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(2000);
    }

    public void socketSendAndRcv(String msg) throws IOException {
        //创建socket对象
        Socket s = new Socket("127.0.0.1", 53210);

        //获取输出流
        OutputStream os = s.getOutputStream();
        os.write("Hello TCP".getBytes());

        //获取输入流
        InputStream is = s.getInputStream();
        byte[] datas = new byte[1024];
        int len = is.read(datas);
        System.out.println("Client:"+new String(datas, 0, len));

        //释放资源
        s.close();

    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.socketSendAndRcv("sadwwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
