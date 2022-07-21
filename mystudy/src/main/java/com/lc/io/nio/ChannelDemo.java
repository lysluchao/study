package com.lc.io.nio;

import java.util.ArrayList;
import java.util.Scanner;

public class ChannelDemo {
    public static void main(String[] args) {

        int[] h=new int[1000];
        int i=0,x;
        Scanner scanner=new Scanner(System.in);

        String a;
        while((a=scanner.nextLine())!=null){
            h[i++]=Integer.parseInt(a);
        }



        ArrayList<Integer> objects = new ArrayList<>();
        objects= (ArrayList<Integer>) objects.subList(0,2);
        System.out.println(h);
    }
}
