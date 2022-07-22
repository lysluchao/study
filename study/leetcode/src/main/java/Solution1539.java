/**
 * @Description: 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。  请你找到这个数组里第 k 个缺失的正整数。
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-missing-positive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther: LuChao
 * @Date: 2022/7/21 13:41
 * @Version: v1.0
 */
public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        int max = arr[arr.length - 1];
        if (k >= max) {
            return k + arr.length;
        }

        int count = 0;
        //i代表1-max的数字
        for (int i = 1, j = 0; i < max; i++) {
            if (i != arr[j]) {
                //缺失数字+1
                if (++count == k) {
                    return i;
                }
            } else {
                //j移动到下一个数字
                j++;
            }
        }

        //在1-max间没有找到缺失数字
        return max + k - count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1539().findKthPositive(new int[]{ 2, 3, 4,7,11}, 5));
    }
}
