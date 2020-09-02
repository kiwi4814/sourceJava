package me.corningrey.base;

public class MagicIPlus2 {
    public static void main(String[] args) {
        int i = 5;
        i = i++;
        System.out.println(i);
    }
}

/**
 * 编译后的源代码为：
 * Compiled from "MagicIPlus2.java"
 * public class MagicIPlus2 {
 *   public MagicIPlus2();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: return
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: iconst_5
 *        1: istore_1
 *        2: iload_1
 *        3: iinc          1, 1
 *        6: istore_1
 *        7: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *       10: iload_1
 *       11: invokevirtual #3                  // Method java/io/PrintStream.println:(I)V
 *       14: return
 * }
 */

