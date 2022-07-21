package com.lc.io.nio;

import java.util.Arrays;

class Solution {
    public int[] countUnguarded(int num,int[] h,int[] w) {
        int[] ans=new int[num];
        for (int i = 0; i <num ; i++) {
            ans[i]=i+1;
        }

        for(int i=0;i<num;i++){
            for(int j=i+1;j<num;j++){
                //身高从低到高排序
                if(h[i]>h[j]){
                    swap(ans,i,j);
                }else if(h[i]==h[j]){
                    if(w[i]>w[j]){
                        swap(ans,i,j);
                    }
                }

            }
        }

        return ans;
    }

    private void swap(int[] ans, int i, int j) {
            int temp=ans[i];
            ans[i]=ans[j];
            ans[j]=temp;
    }

    public static void main(String[] args) {
        String a=new String("a");
        

        int[] h={100,100,120,130},w={40,30,60,50};
        int[] ans = new Solution().countUnguarded(4, h, w);
        System.out.println(Arrays.toString(ans));
    }
}