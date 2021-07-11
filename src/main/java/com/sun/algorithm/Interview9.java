package com.sun.algorithm;

import java.util.Stack;

public class Interview9 {


    public static void main(String[] args) {


        Queue<Integer> queue=new Queue<>();

        for (int i=0;i<10;i++){
            queue.appendTail(i);
        }
        while (!queue.isEmpty()){
            Integer integer = queue.deleteHead();
            System.out.println(integer);
        }

    }


    public static class Queue<T>{

        private Stack<T> stack1;

        private Stack<T> stack2;

        public Queue() {
            stack1=new Stack<>();
            stack2=new Stack<>();
        }

        public void appendTail(T e){

            stack1.add(e);
        }

        public boolean isEmpty(){

            return stack1.isEmpty()&&stack2.isEmpty();
        }

        public T deleteHead(){
            if(stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    T val = stack1.pop();
                    stack2.add(val);
                }
            }
           return stack2.pop();
        }
    }

}
