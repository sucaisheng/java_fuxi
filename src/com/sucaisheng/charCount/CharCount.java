package com.sucaisheng.charCount;

import java.util.HashMap;
import java.util.Scanner;

public class CharCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入一串字符串:");
        String str = in.next();
        HashMap<Character,Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                Integer value = map.get(c);
                value++;
                map.put(c,value);
            }else{
                map.put(c,1);
            }
        }
        for (Character c : map.keySet()) {
            Integer value = map.get(c);
            System.out.println(c + "=" + value);
        }
    }
}
