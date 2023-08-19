package com.hzbank.link;

/**
 * @Description 链表
 * @Auther: fyd20
 * @Date: 2023/8/19 10:31
 * @Description: LikedNode
 * @Version 1.0.0
 */
public class LikedNode {

    public static void main(String[] args) {


        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1 = reservseSingleLinked(n1);
        while (n1 != null){
            System.out.println(n1.value);
            n1 = n1.next;
        }
        System.out.println("-----------");
        DoubleNode n4 = new DoubleNode(4);
        DoubleNode n5 = new DoubleNode(5);
        DoubleNode n6 = new DoubleNode(6);
        n4.setNext(n5);
        n5.setLast(n4);
        n5.setNext(n6);
        n6.setLast(n5);
//        while (n4 != null){
//            System.out.println(n4.value);
//            n4 = n4.next;
//        }
        System.out.println("=========");
        n4 = reservseDoubleNode(n4);

        while (n4 != null){
            System.out.println(n4.value);
            n4 = n4.next;
        }


    }

    public static Node reservseSingleLinked(Node head){
        Node pre = null;
        Node next = null;
        while (head != null){
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }
        return pre;

    }

    public static class Node{
        public int value;
        public Node next;
        public Node (int data){
            this.value = data;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    public static DoubleNode reservseDoubleNode(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null){
            next = head.getNext();
            head.setLast(next);
            head.setNext(pre);
            pre = head;
            head = next;
        }


        return pre;
    }

    public static class DoubleNode{
        private int value;
        // 前一个节点
        private DoubleNode last;
        // 后一个节点
        private DoubleNode next;
        public DoubleNode(int data){
            this.value = data;

        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public DoubleNode getLast() {
            return last;
        }

        public void setLast(DoubleNode last) {
            this.last = last;
        }

        public DoubleNode getNext() {
            return next;
        }

        public void setNext(DoubleNode next) {
            this.next = next;
        }
    }



}
