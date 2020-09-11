package me.corningrey.collection;

import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> grow1 = new ArrayList<>();
        grow1.add("1");
        // grow1.remove(0);
        grow1.add("2");
        grow1.add("3");
        grow1.add("4");
        grow1.add("5");
        grow1.add("6");
        grow1.add("7");
        grow1.add("8");
        grow1.add("9");
        grow1.add("10");
        grow1.add("11");
        // grow1.add(3, "11");
        grow1.add("12");
        grow1.add("13");
        grow1.add("14");
        grow1.add("15");
        grow1.add("16");
        grow1.get(3);
        int i = 5, j = 5;
        /**
         * 第一组
         */
        System.out.println("第一组，i的初始值为" + i);
        i = i++;
        System.out.println(i);//5，先赋值给i，然后i加1，然后再将数据栈顶的值赋值给i
        i = i--;
        System.out.println(i);//5
        i = --i;
        System.out.println(i);//4
        i = ++i;
        System.out.println(i);//5
        /**
         * 第二组
         */
        System.out.println("第二组，i的初始值为" + i);
        int a = i++;
        System.out.println("a=" + a);//5【先赋值5给a，再++】
        System.out.println(i);// 6
        int b = i--;
        System.out.println("b=" + b);//6【先赋值6给b，再--】
        System.out.println(i);//5
        int c = --i;
        System.out.println("c=" + c);//4【先--变成4，然后赋值给c】
        System.out.println(i);//4
        int d = ++i;
        System.out.println("d=" + d);//5【先++变成5，然后赋值给d】
        System.out.println(i);//5

        int k = 1;
        System.out.println("k==" + ((++k) + (++k)));
        /*System.out.println(grow1.get(--i));
        System.out.println(grow1.get(j--));
        System.out.println(grow1.get(5));
        System.out.println(i);
        System.out.println(j);
        String text = grow1.set(10, "15");
        System.out.println("text:" + text);*/
    }

    /**
     * 复制指定源数组src到目标数组dest，System.arraycopy使用的是内存复制，省去了大量的数组寻址访问等时间
     *
     * @param src     源数组
     * @param srcPos  源数组要复制的起始位置
     * @param dest    目标数组
     * @param destPos 目标数组要放置的起始位置
     * @param length  复制的长度
     */
    public static native void arraycopy(Object src, int srcPos,
                                        Object dest, int destPos,
                                        int length);
}
