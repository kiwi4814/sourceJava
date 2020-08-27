package me.corningrey.generics;

import me.corningrey.generics.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComplexMethod {
    private <E extends Comparable<? super E>> E max(List<? extends E> e1) {
        if (e1 == null) {
            return null;
        }
        Iterator<? extends E> iterator = e1.iterator();
        E result = iterator.next();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.compareTo(result) > 0) {
                result = next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 52));
        students.add(new Student("李四", 51));
        students.add(new Student("王五", 48));
        students.add(new Student("赵六", 45));
        students.add(new Student("刘七", 35));
        students.add(new Student("周八", 26));
        ComplexMethod complexMethod = new ComplexMethod();
        System.out.println(complexMethod.max(students).toString());
    }

    /**
     * 上述代码中的类型参数 E 的范围是<E extends Comparable<? super E>>，我们可以分步查看：
     * <p>
     * 要进行比较，所以 E 需要是可比较的类，因此需要 extends Comparable<…>（注意这里不要和继承的 extends 搞混了，不一样）
     * <p>
     * Comparable< ? super E> 要对 E 进行比较，即 E 的消费者，所以需要用 super
     * <p>
     * 而参数 List< ? extends E> 表示要操作的数据是 E 的子类的列表，指定上限，这样容器才够大
     * <p>
     * 多个限制用&
     */



}
