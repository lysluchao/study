/**
 * @Description: 诡计多端
 * @Auther: LuChao
 * @Date: 2022/8/3 15:22
 * @Version: v1.0
 */
class Solution283 {
    public void moveZeroes(int[] nums) {
        int length = nums.length, temp = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                //将i处的0与后面的非0交换
                int j = Math.max(i + 1, temp);
                for (; j < length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        //在j处前的值为0，下次从j+1开始找
                        temp = j;
                        break;
                    }
                }
                //后面都是0了，退出循环
                if (j >= length) {
                    break;
                }
            }

        }
    }

}
