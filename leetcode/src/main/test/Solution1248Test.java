import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Solution1248Test {
    Solution1248 solution1248;
    int ans1;
    int ans2;
    int ans3;

    @Before
    public void setUp() throws Exception {
        solution1248 = new Solution1248();
    }

    @After
    public void tearDown1() throws Exception {
        System.out.println(ans1);
        assert ans1 == 2;
    }

    @After
    public void tearDown2() throws Exception {
        System.out.println(ans2);
        assert ans2 == 0;
    }

    @After
    public void tearDown3() throws Exception {
        System.out.println(ans3);
        assert ans3 == 16;
    }

    @Test()
    public void numberOfSubarrays() {
        ans1 = solution1248.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
        ans2 = solution1248.numberOfSubarrays(new int[]{2, 4, 6}, 1);
        ans3 = solution1248.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2);

    }
}