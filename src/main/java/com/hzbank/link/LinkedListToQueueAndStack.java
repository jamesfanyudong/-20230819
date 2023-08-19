package com.hzbank.link;

/**
 * @Description  单链表实现队列和栈
 * @Auther: fyd20
 * @Date: 2023/8/19 15:46
 * @Description: LinkedListToQueueAndStack
 * @Version 1.0.0
 */
public class LinkedListToQueueAndStack {
    public static class Node<V>{
        public V value;
        public Node<V> next;
        public Node(V v){
            this.value = v;
            next = null;
        }
    }

    public static class MyQueue<V>{
        private Node<V> head;
        private Node<V> tail;
        private int size;

        public MyQueue(){
            head = null;
            tail = null;
            size = 0;
        }
        public boolean isEmpity(){
            return size == 0;
        }
        public int size(){
            return size;
        }

    }




}
