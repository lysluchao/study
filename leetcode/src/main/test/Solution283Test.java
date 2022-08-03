import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution283Test {
    Solution283 solution283=new Solution283();

    @Test
    public void moveZeroes() {
        int[] nums = {0, 0, 2, 8, 3,0,0,1};
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}