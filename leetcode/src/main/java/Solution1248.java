import java.util.Arrays;

/**
 * 以包含k个奇数序列向后搜索
 */
class Solution1248 {
    public int numberOfSubarraysErr(int[] nums, int k) {
        int length = nums.length, ans = 0, count = 0, nextIndex = 0;


        //先看看第一个最美子序列
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 1) {
                count++;
            }
            if (count == k) {
                ans++;
                nextIndex = i + 1;
            }
        }

        if (ans == 0) {
            return 0;
        }

        /*
            k个数序列即将去除的第一个数和即将添加的第一个数分情况讨论
            奇奇 序列是否为最美子序列不变
            奇偶 序列是否为最美子序列改变
            偶奇 序列是否为最美子序列改变
            偶偶 序列是否为最美子序列不变
         */

        //j指向序列的第一个元素
        boolean flag = true;
        for (int i = nextIndex, j = 0; i < length; i++, j++) {
            if (nums[j] % 2 == 1 && nums[i] % 2 == 1 && flag) {
                ans++;
            }
            if (nums[j] % 2 == 1 && nums[i] % 2 == 0) {
                flag = !flag;
                if (flag) {
                    ans++;
                }
            }
            if (nums[j] % 2 == 0 && nums[i] % 2 == 1) {
                flag = !flag;
                if (flag) {
                    ans++;
                }
            }
            if (nums[j] % 2 == 0 && nums[i] % 2 == 0 && flag) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 滑动窗口
     */
    public int numberOfSubarraysErr2(int[] nums, int k) {
        System.out.println(Arrays.toString(nums));
        int length = nums.length, ans = 0;
        boolean[] isOdd = new boolean[length];

        //找到第一个最美子序列，并设置窗口的起始值
        int begin = 0, end = 0;
        end = initWindow(nums, k, isOdd);
        if (begin != end) {
            ans++;
        }


        while (begin < length && end < length - 1 && begin <= end) {
            if (!isOdd[end + 1]) {
                ans++;
                end++;
                System.out.println(begin + " " + end);
            } else {
                while (begin < length && !isOdd[begin]) {
                    begin++;
                }
                if (begin < length) {
                    ans++;
                    System.out.println(begin + " " + end);
                }
            }
        }

        return ans;
    }

    private int initWindow(int[] nums, int k, boolean[] isOdd) {
        int count = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                isOdd[i] = true;
                count++;
                if (count == k) {
                    end = i;
                }
            }
        }
        return end;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0, length = nums.length, nextIndex = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            //从上次搜索的最后一个奇数后一位开始搜
            for (int j = nextIndex; j < length; j++) {
                if (nums[j] % 2 == 1) {
                    count++;
                    if (count == k) {
                        nextIndex = j + 1;
                    }
                }
                if (count == k) {
                    ans++;
                }
                if (count > k) {
                    count--;
                    break;
                }
            }
            if (nums[i] % 2 == 1) {
                count--;
            }

            if (count == k && nums[i] % 2 == 0) {
                ans++;
            }
            if (ans == 0) {
                return 0;
            }
        }

        return ans;
    }

}