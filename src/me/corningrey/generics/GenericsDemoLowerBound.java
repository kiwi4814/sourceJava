package me.corningrey.generics;

class InfoLower<T> {
    private T var;        // 定义泛型变量

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return this.var;
    }

    public String toString() {    // 直接打印
        return this.var.toString();
    }
}

public class GenericsDemoLowerBound {
    public static void main(String args[]) {
        InfoLower<String> i1 = new InfoLower<String>();        // 声明String的泛型对象
        InfoLower<Object> i2 = new InfoLower<Object>();        // 声明Object的泛型对象
        i1.setVar("hello");
        i2.setVar(new Object());
        fun(i1);
        fun(i2);
    }

    // 只能接收String或Object类型的泛型，String类的父类只有Object类
    public static void fun(InfoLower<? super String> temp) {
        System.out.print(temp + ", ");
    }
}
 