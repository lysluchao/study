import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] == 0) {
                continue;
            }

            move(i, asteroids);

        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                list.add(asteroid);
            }
        }

        int[] ans = new int[list.size()];
        AtomicInteger i = new AtomicInteger();
        list.forEach(e -> {
            if (e != 0) {
                ans[i.getAndIncrement()] = e;
            }
        });

        return ans;
    }

    private void move(int index, int[] asteroids) {
        int weight = Math.abs(asteroids[index]);

        //判断移动的方向
        int c = asteroids[index] > 0 ? 1 : -1;

        for (int i = index + c; i >= 0 && i < asteroids.length; i += c) {
            if (asteroids[i] == 0) {
                continue;
            }
            //看看是否碰撞
            if (weight > Math.abs(asteroids[i])) {
                asteroids[i] = 0;
            } else if (weight < Math.abs(asteroids[i])) {
                if (asteroids[i] * asteroids[index] < 0) {
                    asteroids[index] = 0;
                }
                //相同方向，i处移动比index快，不会碰撞,且i处质量更大，不必继续循环
                return;
            } else {
                if (asteroids[i] * asteroids[index] < 0) {
                    asteroids[index] = 0;
                    asteroids[i] = 0;
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        Solution735 solution = new Solution735();
        int[] ints = solution.asteroidCollision(new int[]{5, 10, -5,10,-5,-10,-11,-9});
        System.out.println(Arrays.toString(ints));
    }
}