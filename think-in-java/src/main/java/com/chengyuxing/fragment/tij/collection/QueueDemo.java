package com.chengyuxing.fragment.tij.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import static com.chengyuxing.fragment.util.PrintUtils.print;
import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/13
 * Time: 下午4:49
 * Description:
 */
public class QueueDemo {
    public static void printQ(Queue queue){
        while(queue.peek() != null){
            print(queue.remove() + " ");
        }
        println("");
    }



    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for(char c : "Brontosaurus".toCharArray()){
            qc.offer(c);
        }
        printQ(qc);
    }
}
