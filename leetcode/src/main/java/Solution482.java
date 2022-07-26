import java.util.Stack;

/**
 * 482密钥格式化
 */
public class Solution482 {
    public String licenseKeyFormatting(String s, int k) {
        s = s.trim();
        Stack<Character> stack = new Stack<>();
        int count=0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char item = s.charAt(i);

            if(count==k){
                stack.push('-');
                count=0;
            }
            if (item != '-') {
                stack.push(item);
                count++;
            }
        }

        StringBuilder stringBuilder=new StringBuilder();
        while (!stack.empty()){
            stringBuilder.append(stack.pop().toString().toUpperCase());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution482 solution482=new Solution482();
        //"5F3Z-2E9W"
        System.out.println(solution482.licenseKeyFormatting("5F3Z-2e-9-w",4));
        //"2-5G-3J"
        System.out.println(solution482.licenseKeyFormatting("2-5g-3-J",2));
    }
}
