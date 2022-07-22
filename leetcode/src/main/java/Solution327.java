/**
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 * <p>
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0], lower = 0, upper = 0
 * 输出：1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution327 {
    /**
     * 应该使用动态规划,区间从1开始增长到n,求出所有区间和，符合条件时ans+1
     * 设n=nums.length,使用n*n的二维数组S存储区间和,S[i, j] 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
     * 状态转移方程为 S[i,j]=S[i,j-1]+nums[j](i<=j-1)
     * 最后得到的结果为一个上三角矩阵
     * <p>
     * N/A案例：
     * 考虑溢出的情况
     * 使用long类型
     * [-2147483647,0,-2147483647,2147483647]
     * -564
     * 3864
     * <p>
     * 内存超出限制
     * 使用一维数组
     *
     * 时间超出限制
     */
    public int countRangeSumNA1(int[] nums, int lower, int upper) {
        int n = nums.length, ans = 0;
        long[][] s = new long[n][n];

        for (int i = 0; i < n; i++) {
            s[i][i] = nums[i];
            if (s[i][i] >= lower && s[i][i] <= upper) {
                ans++;
                System.out.println(i + " " + i + " " + s[i][i]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int gap = 1; gap < n; gap++) {
                int j = i + gap;
                if (j >= n) {
                    break;
                }
                s[i][j] = s[i][j - 1] + nums[j];
                if (s[i][j] >= lower && s[i][j] <= upper) {
                    ans++;
                    System.out.println(i + " " + j + " " + s[i][j]);
                }
            }
        }

        return ans;
    }

    /**
     * 时间复杂度O(n^2),空间复杂度O(N)
     */
    public int countRangeSumNA2(int[] nums, int lower, int upper) {
        int n = nums.length, ans = 0;

        for (int i = 0; i < n; i++) {
            long[] s = new long[n];
            s[i] = nums[i];
            if (s[i] >= lower && s[i] <= upper) {
                ans++;
            }
            for (int gap = 1; gap < n; gap++) {
                int j = i + gap;
                if(j>=n){
                    break;
                }
                s[j] = s[j - 1] + nums[j];
                if (s[j] >= lower && s[j] <= upper) {
                    ans++;
                }
            }
        }

        return ans;
    }


    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length, ans = 0;



        return ans;
    }

    public static void main(String[] args) {
        Solution327 solution327 = new Solution327();
        System.out.println(solution327.countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));

    }
}
