package cn.school.thoughtworks.section2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeC {
    Map<String, Integer> countSameElements(List<String> collection1) {
        //实现练习要求，并改写该行代码。

        Map<String, Long> map = collection1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for (String key : map.keySet())
            map2.put(key, (int) (long) map.get(key));
        Map<String, Integer> map3 = new HashMap<String, Integer>();
        for (String key : map2.keySet()) {
            String str1 = key.replaceAll("[^a-z^A-Z]", "");
            String str2 = key.replaceAll("[^0-9]", "");
            if (map3.containsKey(str1))
                map3.put(str1, map3.get(str1) + (str2.equals("") ? 1 : Integer.parseInt(str2)));
            else
                map3.put(str1, str2.equals("") ? map2.get(key) : Integer.parseInt(str2));
        }
        return map3;
    }
}
