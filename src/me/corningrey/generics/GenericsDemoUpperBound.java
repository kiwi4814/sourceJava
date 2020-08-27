package me.corningrey.generics;

/**
 * 泛型上限
 */
public class GenericsDemoUpperBound {
    public static void main(String args[]) {
        InfoUpper<Integer> i1 = new InfoUpper<Integer>();        // 声明Integer的泛型对象
    }
}

class InfoUpper<T extends Number> {    // 此处泛型只能是数字类型
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
