import java.util.ArrayList;
import java.util.List;

/**
 * 交换数字
 *
 * @author luchao
 * @version v1.0
 * @date 2022/9/13 10:10
 */
public class Solution670 {

    short[] bits;
    List<Short> sortedBits = new ArrayList<>();

    public int a(int num) {
        initBits(num);

        //如果遍历的数字是所有位最大的，继续遍历；否则将其与后续位的最大值交换后返回
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == sortedBits.get(0)) {
                sortedBits.remove(0);
            } else {
                return swap(i);
            }
        }
        return countBits();
    }

    private boolean remainingContainsMax(int beginIndex) {
        for (int i = beginIndex; i < bits.length; i++) {
            if (bits[i] == sortedBits.get(0)) {
                return true;
            }
        }
        return false;
    }

    private int swap(int beginIndex) {
        short max = sortedBits.get(0);
        for (int i = beginIndex; i < bits.length; i++) {
            if (bits[i] == max && !remainingContainsMax(i + 1)) {
                short tmp = bits[beginIndex];
                bits[beginIndex] = bits[i];
                bits[i] = tmp;
                break;
            }
        }

        return countBits();
    }

    private int countBits() {
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res += bits[i] * Math.pow(10, bits.length - 1 - i);
        }
        return res;
    }

    private void initBits(int num) {
        int bitNum = 0, tmp = num;

        while (tmp > 0) {
            tmp /= 10;
            bitNum++;
        }

        bits = new short[bitNum];

        tmp = num;
        for (int i = bitNum - 1; i >= 0; i--, tmp /= 10) {
            bits[i] = (short) (tmp % 10);
            sortedBits.add(bits[i]);
        }

        //从大到小排列
        sortedBits.sort((o1, o2) -> o2 - o1);
    }

}
