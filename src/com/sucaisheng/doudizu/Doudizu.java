package com.sucaisheng.doudizu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doudizu {
    public static void main(String[] args) {
        List<String> puke = new ArrayList<>();
        puke.add("大王");
        puke.add("小王");
        String[] colors = {"♠","♥","♣","♦"};
        String[] number = {"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String color : colors) {
            for (String num : number) {
                puke.add(color+num);
            }
        }
        //System.out.println(puke);
        Collections.shuffle(puke);
        List<String> diPai = new ArrayList<>();
        List<String> play01 = new ArrayList<>();
        List<String> play02 = new ArrayList<>();
        List<String> play03 = new ArrayList<>();
        for (int i = 0; i < puke.size(); i++){
            if(i >= 51){
                diPai.add(puke.get(i));
            }
            else if (i % 3 == 0){
                play01.add(puke.get(i));
            }
            else if (i % 3 == 1){
                play02.add(puke.get(i));
            }
            else play03.add(puke.get(i));
        }
        System.out.println("play01" + play01);
        System.out.println("play02" + play02);
        System.out.println("play03" + play03);
        System.out.println("diPai" + diPai);
    }
}
