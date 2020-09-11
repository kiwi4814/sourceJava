package me.corningrey.collection;

public class ArrayQueueTest {
    public static void main(String[] args) {
        /**
         * 内部数组的实际容量要大1
         */
        ArrayQueue<Integer> a = new ArrayQueue<>(10);
        a.add(0);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.remove(0);
        a.remove(0);
        a.remove(0);
        a.remove(0);
        a.resize(6);
        System.out.println(a.get(2));

    }
}
