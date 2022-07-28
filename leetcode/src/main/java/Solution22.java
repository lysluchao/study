import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 22 括号
 * @Auther: LuChao
 * @Date: 2022/7/26 17:08
 * @Version: v1.0
 */
class Solution22 {
    final String LEFT = "(", RIGHT = ")";
    private List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        String tmp = "";
        generate(0, 0, 0, n * 2, tmp);
        return list;
    }

    private void generate(int count, int leftCount, int rightCount, int n, String tmp) {
        if (leftCount > n / 2) {
            return;
        }

        if (rightCount > n / 2) {
            return;
        }

        if (count >= n) {
            if (isValidate(tmp)) {
                list.add(tmp);
            }
            return;
        }

        generate(count + 1, leftCount + 1, rightCount, n, tmp + LEFT);
        generate(count + 1, leftCount, rightCount + 1, n, tmp + RIGHT);
    }

    private boolean isValidate(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.empty() && str.charAt(i) == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(str.charAt(i));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(8));
    }
}
