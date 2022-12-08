/**
 * @author luchao
 * @version v1.0
 * @date 2022/11/30 09:17
 */
public class Demo {
    private int v=0;
    public int t(){
        v+=10;
        return v;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.t());
        System.out.println(demo.t());
    }
}
