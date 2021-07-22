package com.sun.algorithm;


import java.util.Stack;

public class Interview30 {

    public static void main(String[] args) {

        StackWithMin<Integer> stack=new StackWithMin<>();
        stack.push(5);
        stack.push(6);
        stack.push(4);
        stack.push(7);
        stack.push(3);
        while (!stack.isEmpty()){
            Integer min = stack.min();
            System.out.println(min);
            stack.pop();
        }
    }

    public static class StackWithMin<E extends Comparable>{


        private Stack<E> stack;

        private Stack<E> min;


        public StackWithMin(){
            stack=new Stack<>();
            min=new Stack<>();
        }


        public void push(E val){

            stack.push(val);
            if(min.isEmpty()){
                min.push(val);
            }else {
                E peek = min.peek();
                if(peek.compareTo(val)>0){
                    min.push(val);
                }else {
                    min.push(peek);
                }
            }
        }
        public E pop(){
            assertNotEmpty();
            E pop = stack.pop();
            min.pop();
            return pop;
        }

        public E min(){
            assertNotEmpty();
           return min.peek();
        }

        public boolean isEmpty(){

            return stack.isEmpty();
        }

        private void assertNotEmpty(){
            if(this.isEmpty()){
                throw new RuntimeException("集合为空");
            }
        }
    }



}
