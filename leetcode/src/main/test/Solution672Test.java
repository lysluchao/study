import org.junit.Test;

public class Solution672Test {

    @Test
    public void flipLight() {
        Solution672 solution672 = new Solution672();
        assert solution672.flipLight(2, 1) == 3;
        assert solution672.flipLight(1, 1) == 2;
        assert solution672.flipLight(3, 1) == 4;
    }
}