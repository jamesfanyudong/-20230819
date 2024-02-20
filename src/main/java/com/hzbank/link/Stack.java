package com.hzbank.link;

/**
 * @Description
 * @Auther: fyd20
 * @Date: 2023/8/21 20:54
 * @Description: Stack
 * @Version 1.0.0
 */
public class Stack {
    public static class Node<V>{
        public V value;
        public Node<V> next;
        public Node(V v){
            this.value = v;
            next = null;
        }
    }
    public static class MyStack<V>{
        private Node<V> head;
        private int size;

        public MyStack(){
            this.head = null;
            this.size = 0;
        }



    }
}
