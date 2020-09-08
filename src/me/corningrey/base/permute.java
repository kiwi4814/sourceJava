package me.corningrey.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permute {
    private List<List<String>> resultList = new ArrayList<>();

    private void permutate(List<List<String>> originalList, List<String> tempList) {
        int size = originalList.size();
        if (1 == size) {
            for (String e : originalList.get(0)) {
                List<String> elist = new ArrayList<>(tempList);
                elist.add(e);
                resultList.add(elist);
            }
        } else {
            List<String> perms = new ArrayList<>(originalList.get(0));
            List<List<String>> now = new ArrayList<>(originalList);
            now.remove(0);
            for (String s : perms) {
                List<String> enlist = new ArrayList<>(tempList);
                enlist.add(s);
                permutate(now, enlist);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> originalList = new ArrayList<>();
        originalList.add(Arrays.asList("1,2,3"));
        originalList.add(Arrays.asList("4,5"));
        originalList.add(Arrays.asList("6,7,8"));
        originalList.add(Arrays.asList("9,10"));
        permute p = new permute();
        p.permutate(originalList, new ArrayList<>());

        System.out.println(p.resultList);

    }
}
