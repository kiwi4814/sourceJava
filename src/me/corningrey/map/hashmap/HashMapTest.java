package me.corningrey.map.hashmap;

import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(1);
        map.put("1", null);// 经历了两次扩容
        //map.putIfAbsent("1", "2");// 即使指定了不覆盖，如果value为null的话也会强制覆盖掉
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "2");
        map.put("5", "2");
        map.put("6", "2");
        map.put("7", "2");
        map.put("8", "2");
        map.put("9", "2");
        System.out.println(111);
    }

    final Map resize() {
        int threshold = 12;
        final float loadFactor = 0.75f;
        int length = 9;
        Map nowHash = new me.corningrey.map.hashmap.HashMap();
        int x = length;
        int y = threshold;
        int x1 = 0, y1 = 0;
        if (x >= 1073741824) {
            threshold = Integer.MAX_VALUE;
            return nowHash;
        }
        if (x > 0) {
            if (2 * x < 1073741824 && x >= 16) {
                y1 = 2 * y;
            }
            if (x > 0 && y == 0) {
                y1 = 0;
            }
            if (x < 16 || x > 1 << 29) {
                y1 = 0;
            }
            x1 = 2 * x;
        } else if (y > 0) {//x=0但是y>0
            x1 = y;
            y1 = 0;
        } else {// x=0并且y=0的时候
            x1 = 16;
            y1 = 12;
        }
        if (y1 == 0) {
            float ft = (float) x1 * loadFactor;
            y1 = (x1 < 1073741824 && ft < 1073741824 ? (int) ft : Integer.MAX_VALUE);
        }
        return nowHash;
    }
}
