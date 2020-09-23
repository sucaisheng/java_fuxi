package com.sucaisheng.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * streamDemo练习
 *   1、对集合进行操作
 *   2、对第一个集合筛选姓张的人
 *   3、筛选出来后只要前三个人
 *   4、第二个集合不要前两个
 *   5、合并两个集合、
 *   6、将集合装换成person类
 */
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三丰");
        list.add("张翠山");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张无忌");
        Stream<String> stream = list.stream().filter(name -> name.startsWith("张")).limit(3);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("喜洋洋");
        list1.add("懒洋洋");
        list1.add("美羊羊");
        list1.add("灰太狼");
        list1.add("红太狼");
        Stream<String> stream1 = list1.stream().skip(2);
        Stream<Person> personStream = Stream.concat(stream, stream1).map(name -> new Person(name));
        personStream.forEach(p-> System.out.println(p));
    }
}
