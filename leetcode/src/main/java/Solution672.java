import java.util.HashSet;
import java.util.Set;

/**
 * 灯泡开关
 * <p>
 * 使用位运算
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/16 16:42
 */
public class Solution672 {
    /**
     * 二进制灯，1开0关，序号为从右向左
     */
    int lights;
    int s1 = 0, s2 = 0, s3 = 0, s4 = 0, n = 0;

    public int flipLight(int n, int presses) {
        init(n);
        this.n = n;
        //执行搜索
        return search(presses);
    }

    private int search(int presses) {
        Set<Integer> ansSet = new HashSet<>();
        ansSet.add(lights);

        for (int i = 0; i < presses; i++) {
            Set<Integer> tmpSet = new HashSet<>();
            for (Integer tmpStatus : ansSet) {
                tmpSet.add(tmpStatus ^ s1);
                tmpSet.add(tmpStatus ^ s2);
                tmpSet.add(tmpStatus ^ s3);
                tmpSet.add(tmpStatus ^ s4);
            }
            ansSet = tmpSet;
        }

        return ansSet.size();
    }

    /**
     * 初始化灯和开关
     *
     * @param n 灯的数量
     */
    private void init(int n) {
        for (int i = 0; i < n; i++) {
            lights += 1 << i;
            //开关1
            s1 += 1 << i;
            if (i % 2 == 1) {
                //开关2
                s2 += 1 << i;
            }
            if (i % 2 == 0) {
                //开关3
                s3 += 1 << i;
            }
            if (i % 3 == 0) {
                //开关4
                s4 += 1 << i;
            }
        }
    }
}
