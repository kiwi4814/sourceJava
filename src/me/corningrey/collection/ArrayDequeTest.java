package me.corningrey.collection;

import java.util.Deque;

public class ArrayDequeTest {
    public static void main(String[] args) {
        Deque deque = new ArrayDeque(3);//8
        Deque deque1 = new ArrayDeque(8);//16
        Deque deque2 = new ArrayDeque(10);//16
        Deque deque3 = new ArrayDeque(25);//32
    }
}
