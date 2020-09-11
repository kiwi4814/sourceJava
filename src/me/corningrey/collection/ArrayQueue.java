/*
 * Copyright (c) 2003, 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package me.corningrey.collection;

import java.util.AbstractList;
import java.util.Arrays;

public class ArrayQueue<T> extends AbstractList<T> {
    /**
     * 初始化一个容量为（capacity+1）的Queue
     *
     * @param capacity 容量
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        this.queue = newArray(capacity + 1);
        this.head = 0;
        this.tail = 0;
    }

    public void resize(int newCapacity) {
        // 获取队列的实际元素数量，resize的参数不能小于这个数量
        int size = size();
        if (newCapacity < size)
            throw new IndexOutOfBoundsException("Resizing would lose data");
        // 内部数组的容量永远比定义的容量大1，如果和原有容量相等，直接返回
        newCapacity++;
        if (newCapacity == this.capacity)
            return;
        // 初始化一个新的数组并赋值
        T[] newQueue = newArray(newCapacity);
        for (int i = 0; i < size; i++)
            newQueue[i] = get(i);
        this.capacity = newCapacity;
        this.queue = newQueue;
        this.head = 0;
        this.tail = size;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }


    /**
     * 在队列的尾部增加新的元素
     *
     * @param o 要增加的元素
     * @return
     */
    public boolean add(T o) {
        // 将数组尾部设为要添加的元素
        queue[tail] = o;
        // 确保queue的size不超过其容量
        int newTail = (tail + 1) % capacity;
        // 判断队列是否已经满了
        if (newTail == head)
            throw new IndexOutOfBoundsException("Queue full");
        tail = newTail;
        System.out.println("head：" + head + "##tail" + tail + "##size" + size());
        return true; // we did add something
    }

    /**
     * 移除数组的头部元素
     *
     * @param i 数组下标，不能为0且队列不能为空
     * @return
     */
    public T remove(int i) {
        if (i != 0)
            throw new IllegalArgumentException("Can only remove head of queue");
        if (head == tail)
            throw new IndexOutOfBoundsException("Queue empty");
        T removed = queue[head];
        queue[head] = null;
        // head递增1（不超过队列容量）
        head = (head + 1) % capacity;
        System.out.println("head：" + head + "##tail" + tail + "##size" + size());
        Arrays.asList(queue).stream().forEach(t -> {
            System.out.print(t + ",");
        });
        System.out.println("");
        return removed;
    }

    public T get(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            final String msg = "Index " + i + ", queue size " + size;
            throw new IndexOutOfBoundsException(msg);
        }
        /**
         * 获取元素的实际下标
         */
        int index = (head + i) % capacity;
        return queue[index];
    }

    /**
     * 获取队列的实际大小
     *
     * @return
     */
    public int size() {
        // Can't use % here because it's not mod: -3 % 2 is -1, not +1.
        int diff = tail - head;
        if (diff < 0)
            diff += capacity;
        return diff;
    }

    private int capacity;
    private T[] queue;
    private int head;
    private int tail;
}
