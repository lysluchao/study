import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个整数数组 asteroids，表示在同一行的行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * <p>
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * <p>
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/asteroid-collision
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution735 {


    public int[] asteroidCollision(int[] asteroids) {
        //当遇到同方向的行星，压栈处理
        Stack<Integer> stack = new Stack<>();
        //记录访问过的行星
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] == 0) {
                continue;
            }

            if (!stack.isEmpty()) {
                i = stack.pop();
            }
            if (!set.contains(i)) {
                set.add(i);
                i = move(i, asteroids, stack);
            }
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

    /**
     * @return 访问的位置
     */
    private int move(int index, int[] asteroids, Stack<Integer> stack) {
        int weight = Math.abs(asteroids[index]);

        //判断移动的方向
        int c = asteroids[index] > 0 ? 1 : -1;

        for (int i = index + c; i >= 0 && i < asteroids.length; i += c) {
            if (asteroids[i] == 0) {
                continue;
            }
            //看看是否碰撞
            if (weight > Math.abs(asteroids[i])) {
                if (asteroids[i] * asteroids[index] < 0) {
                    asteroids[i] = 0;
                } else {
                    //相同方向，压栈
                    stack.push(index);
                    return i - 1;
                }
            } else if (weight < Math.abs(asteroids[i])) {
                if (asteroids[i] * asteroids[index] < 0) {
                    //不同方向，index处行星质量较小
                    asteroids[index] = 0;
                } else {
                    //相同方向，压栈
                    stack.push(index);
                    return i - 1;
                }
            } else {
                //不同方向，质量相等
                if (asteroids[i] * asteroids[index] < 0) {
                    asteroids[index] = 0;
                    asteroids[i] = 0;
                    return index;
                }
            }
        }
        return index;
    }

    private int[] asteroidCollisionL(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean alive = true;
            //判断是否存活
            int c = asteroids[i] > 0 ? 1 : -1;
            for (int j = i + c; j >= 0 && j < asteroids.length; j = j + c) {
                if (asteroids[j] * asteroids[i] > 0) {
                    alive = true;
                    break;
                }

                if (Math.abs(asteroids[i]) <= Math.abs(asteroids[j])) {
                    alive = false;
                    break;
                }
            }


            if (alive) {
                stack.push(asteroids[i]);
            }
        }

        int[] ans = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            ans[i] = stack.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution735 solution = new Solution735();
        // int[] ints1 = solution.asteroidCollision(new int[]{5, 10, -5, 10, -5, -10, -11, -9});
        //int[] ints2 = solution.asteroidCollision(new int[]{-2, -2, -1, -2});
        //预期结果：
        //[10,1,2,10]
        int[] ints3 = solution.asteroidCollision(new int[]{10, -8, -9, 1,1,1,1,1,1,1,1,1,1,1,1,1, 8, 8, -9, 1, 2, 10});
        //System.out.println(Arrays.toString(ints1));
        //System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
        int[] ints4 = solution.asteroidCollisionL(new int[]{10, -8, -9, 1, 8, 8, -9, 1, 2, 10});
        System.out.println(Arrays.toString(ints4));
    }

    /**
     * 应该使用栈进行修改
     * asteroids = [10,2,-5]
     */
    private void moveNA1(int index, int[] asteroids) {
        int weight = Math.abs(asteroids[index]);

        //判断移动的方向
        int c = asteroids[index] > 0 ? 1 : -1;

        for (int i = index + c; i >= 0 && i < asteroids.length; i += c) {
            if (asteroids[i] == 0) {
                continue;
            }
            //看看是否碰撞
            if (weight > Math.abs(asteroids[i])) {
                if (asteroids[i] * asteroids[index] < 0) {
                    asteroids[i] = 0;
                }
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

}