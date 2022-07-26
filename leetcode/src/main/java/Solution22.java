import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 22 括号
 * @Auther: LuChao
 * @Date: 2022/7/26 17:08
 * @Version: v1.0
 */
class Solution22 {
    final String LEFT="(",RIGHT=")";
    private List<String> list=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder tmp=new StringBuilder();
        generate(0,n, tmp);
        return list;
    }

    private void generate(int count,int n,StringBuilder tmp){
        if(count>=n){
            if(isValidate(tmp.toString())){

            }
            return ;
        }

        generate(count+1,n,tmp.append(LEFT));
        generate(count+1,n,tmp.append(RIGHT));
    }

    private boolean isValidate(String str) {
        
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(3));
    }
}
